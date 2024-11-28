package com.ConcursoUTP.pe.Service.Inter.Impl;

import com.ConcursoUTP.pe.Dao.CRUD;
import com.ConcursoUTP.pe.Dao.HistorialDao;
import com.ConcursoUTP.pe.Dao.HistorialDaoImpl;
import com.ConcursoUTP.pe.Dao.PlantaDao;
import com.ConcursoUTP.pe.Dao.PlantaDaoImpl;
import com.ConcursoUTP.pe.Dao.PuertoDao;
import com.ConcursoUTP.pe.Dao.PuertoDaoImpl;
import com.ConcursoUTP.pe.Desing.DesingImpl;
import com.ConcursoUTP.pe.Desing.IDesing;
import com.ConcursoUTP.pe.Desing.MessagesConfirm;
import com.ConcursoUTP.pe.Desing.MessagesNotification;
import com.ConcursoUTP.pe.Desing.RenderTablet;
import com.ConcursoUTP.pe.Model.Planta;
import com.ConcursoUTP.pe.Service.Inter.IPlantas;
import com.ConcursoUTP.pe.View.Index;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PlantasImpl implements IPlantas {

    //====================== Class =====================
    //======================================================
    private final MessagesNotification mn = new MessagesNotification();
    private final MessagesConfirm mc = new MessagesConfirm();
    private TableRowSorter filtro;

    //====================== Invoker =====================
    //======================================================
    @Override
    public void GoControlPanelPlanta(Index index) {
        tabla(index);
        index.JTabbetDasboad.setSelectedIndex(0);
    }

    @Override
    public void GoNewPlanta(Index index) {
        index.JTabbetDasboad.setSelectedIndex(1);
        limpiar(index);
    }

    @Override
    public void GoEditPlanta(Index index, int id) {
        rellenarPlanta(index, id);
        index.JTabbetDasboad.setSelectedIndex(2);
    }

    @Override
    public void SelectFoto(Index index, String opcion) {

        switch (opcion) {
            case "new" -> {
                SelectImg(index.ContenedorPlantasNuevo, index.FotoSeleccionadaPlanta, index.UrlFotoPlanta);
            }
            case "edit" -> {
                SelectImg(index.ContenedorPlantasNuevo, index.FotoSeleccionadaPlanta1, index.UrlFotoPlanta1);
            }
            default ->
                throw new AssertionError();
        }

    }

    @Override
    public void addPlanta(Index index) {
        addNewPlanta(index);
    }

    @Override
    public void editPlanta(Index index) {
        editar(index);

    }

    @Override
    public void delatePlanta(Index index, int id) {
        deletePlant(index, id);
    }

    @Override
    public void TablePlanta(Index index) {
        tabla(index);
    }

    @Override
    public void SearchPlanta(Index index) {
        busqueda(index);
    }

    @Override
    public void validacionPlanta(String opcion, JTextField text) {
        validadcion(opcion, text);
    }
    //====================== Extension =====================
    //======================================================
    private void limpiar(Index index) {
        index.input_NombrePlanta.setText("");
        index.jtextAreaDescripcion.setText("");
        index.FotoSeleccionadaPlanta.setIcon(null);
        index.UrlFotoPlanta.setText("");
    }

    private void SelectImg(JPanel panel, JLabel icon, JLabel url) {
        FileNameExtensionFilter fef = new FileNameExtensionFilter("jpg", "png");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(fef);
        int load = fileChooser.showOpenDialog(panel);
        if (load == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            url.setText(path);
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
            icon.setIcon(new ImageIcon(img));
        }
    }

    private void addNewPlanta(Index index) {
        if (index.input_NombrePlanta.getText().isEmpty() || index.jtextAreaDescripcion.getText().isEmpty()
                || index.FotoSeleccionadaPlanta.getIcon() == null) {
            mn.MessageOption(index.ContenedorPlantasNuevo, 1, "fdatos");
        } else {
            PlantaDao pdao = new PlantaDaoImpl();
            if (pdao.Repeticion(index.input_NombrePlanta.getText())) {
                mn.MessageOption(index.ContenedorPlantasNuevo, 1, "rdatos");
            } else {
                try {
                    CRUD dao = new PlantaDaoImpl();
                    Planta p = new Planta();
                    File foto = new File(index.UrlFotoPlanta.getText());
                    p.setNombre(index.input_NombrePlanta.getText());
                    p.setDescripcion(index.jtextAreaDescripcion.getText());
                    p.setFotoInput(foto);
                    dao.registra(p);
                } catch (Exception ex) {
                    Logger.getLogger(PlantasImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                tabla(index);
                index.JTabbetDasboad.setSelectedIndex(0);
            }
        }
    }

    private void tabla(Index index) {
        try {
            IDesing design = new DesingImpl();
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            CRUD dao = new PlantaDaoImpl();
            String[] Columna = {"#", "Nombre", "Descripcion", "Editar", "Eliminar"};
            List<Planta> Plantas = dao.listarTodos();
            JButton editPlanta = new JButton();
            JButton deletePlanta = new JButton();
            editPlanta.setName("editPlanta");
            deletePlanta.setName("deletePlanta");
            model.setColumnIdentifiers(Columna);
            for (Planta Planta : Plantas) {
                model.addRow(new Object[]{
                    Planta.getId(),
                    Planta.getNombre(),
                    Planta.getDescripcion(),
                    editPlanta,
                    deletePlanta
                });
            }
            index.Jtablet.setModel(model);
            index.Jtablet.setRowHeight(30);
            index.Jtablet.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int[] anchos = {80, 200, 466, 70, 70};
            for (int i = 0; i < index.Jtablet.getColumnCount(); i++) {
                index.Jtablet.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            index.Jtablet.getTableHeader().setReorderingAllowed(false);
            index.Jtablet.getTableHeader().setResizingAllowed(false);
            RenderTablet rt = new RenderTablet();
            rt.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < index.Jtablet.getColumnCount(); i++) {
                index.Jtablet.getColumnModel().getColumn(i).setCellRenderer(rt);
            }
            index.Jtablet.setDefaultRenderer(Object.class, rt);
            design.tableButtos("edit", editPlanta);
            design.tableButtos("delete", deletePlanta);
        } catch (Exception ex) {
            Logger.getLogger(PlantasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void deletePlant(Index index, int id) {
        String op = String.valueOf(id);
        if (mc.MessageOption(op, "dplanta", index.ContenedorPlanta)) {
            try {
                CRUD dao = new PlantaDaoImpl();
                PuertoDao puerto = new PuertoDaoImpl();
                HistorialDao historial = new HistorialDaoImpl();
                List<Integer> IDS_puerto = puerto.listaIDPuerto(id);
                for (Integer idpuerto : IDS_puerto) {
                    historial.eliminarporPuerto(idpuerto);
                }
                puerto.eliminarPlantaPuerto(id);
                dao.eliminar(id);
                tabla(index);
            } catch (Exception ex) {
                Logger.getLogger(PlantasImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void rellenarPlanta(Index index, int id) {
        try {
            CRUD dao = new PlantaDaoImpl();
            Planta planta = (Planta) dao.objet(id);
            index.outputIdPlanta.setText(String.valueOf(planta.getId()));
            index.input_NombrePlanta1.setText(planta.getNombre());
            index.jtextAreaDescripcion1.setText(planta.getDescripcion());
            ImageIcon imagen = new ImageIcon(planta.getFotoOuput());
            Image img = imagen.getImage().getScaledInstance(
                    index.FotoSeleccionadaPlanta1.getWidth(), index.FotoSeleccionadaPlanta1.getHeight(),
                    Image.SCALE_SMOOTH);
            index.FotoSeleccionadaPlanta1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            Logger.getLogger(PlantasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void busqueda(Index index) {
        index.input_BusquedaPlantas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtro.setRowFilter(RowFilter.regexFilter(index.input_BusquedaPlantas.getText(), 1));
            }
        });
        filtro = new TableRowSorter(index.Jtablet.getModel());
        index.Jtablet.setRowSorter(filtro);
    }

    private void editar(Index index) {
        if (index.input_NombrePlanta1.getText().isEmpty() || index.jtextAreaDescripcion1.getText().isEmpty()) {
            mn.MessageOption(index.ContenedorPlantasNuevo, 1, "fdatos");
        } else {
            PlantaDao pdao = new PlantaDaoImpl();
            if (pdao.RepeticionEdit(index.input_NombrePlanta1.getText(), Integer.parseInt(index.outputIdPlanta.getText()))) {
                mn.MessageOption(index.ContenedorPlantasNuevo, 1, "rdatos");
            } else {
                String op = index.outputIdPlanta.getText();
                if (mc.MessageOption(op, "eplanta", index.ContenedorPlantasModificar)) {
                    CRUD dao = new PlantaDaoImpl();
                    Planta p = new Planta();
                    p.setId(Integer.parseInt(index.outputIdPlanta.getText()));
                    p.setNombre(index.input_NombrePlanta1.getText());
                    p.setDescripcion(index.jtextAreaDescripcion1.getText());
                    if (index.UrlFotoPlanta1.getText().isEmpty()) {
                        try {
                            dao.modificar(p, "sinFoto");
                        } catch (Exception ex) {
                            Logger.getLogger(PlantasImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            File foto = new File(index.UrlFotoPlanta1.getText());
                            p.setFotoInput(foto);
                            dao.modificar(p, "conFoto");
                        } catch (Exception ex) {
                            Logger.getLogger(PlantasImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    tabla(index);
                    index.JTabbetDasboad.setSelectedIndex(0);
                }
            }
        }
    }

    private void validadcion(String opcion, JTextField text) {
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (opcion) {
                    case "n" -> {
                        char validar = e.getKeyChar();
                        if ((validar < '1' || validar > '9')) {
                            e.consume();
                        }
                        if (text.getText().length() >= 2) {
                            e.consume();
                        }
                    }
                    case "l" -> {
                        char validar = e.getKeyChar();
                        if ((validar < 'a' || validar > 'z') && (validar < 'A' || validar > 'Z') && validar > ' ') {
                            e.consume();
                        }
                    }
                }
            }
        });
    }
    
}
