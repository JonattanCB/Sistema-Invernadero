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
import com.ConcursoUTP.pe.Model.Puerto;
import com.ConcursoUTP.pe.Service.Inter.IArduino;
import com.ConcursoUTP.pe.Service.Inter.IPuertos;
import com.ConcursoUTP.pe.View.Index;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PuertosImpl implements IPuertos {

    //====================== Class =====================
    //======================================================
    private final MessagesNotification mn = new MessagesNotification();
    private final MessagesConfirm mc = new MessagesConfirm();
    private TableRowSorter filtro;

    //====================== Invoker =====================
    //======================================================
    @Override
    public void GoControlPanelPuerto(Index index) {
        table(index);
        index.JTabbetDasboad.setSelectedIndex(3);
    }

    @Override
    public void GoNewPuerto(Index index) {
        limpiar(index);
        SeleccionPlanta(index, "new");
        SeleccionCOM(index, "new", 0);
        index.JTabbetDasboad.setSelectedIndex(4);
    }

    @Override
    public void GoEditPuerto(Index index, int id) {
        SeleccionPlanta(index, "edit");
        SeleccionCOM(index, "edit", id);
        rellenarDatos(index, id);
        index.JTabbetDasboad.setSelectedIndex(5);
    }

    @Override
    public void addNewPuerto(Index index) {
        addPuerto(index);
    }

    @Override
    public void tablePuerto(Index index) {
        table(index);
    }

    @Override
    public void SearchPuerto(Index index) {
        busqueda(index);
    }

    @Override
    public void DeletePuerto(Index index, int id) {
        deletePuert(index, id);
    }

    @Override
    public void EditPuerto(Index index) {
        editPuert(index);
    }

    @Override
    public void validacionPuerto(String opcion, JTextField text) {
        validadcion(opcion, text);
    }

    //====================== Extension =====================
    //======================================================
    private void limpiar(Index index) {
        index.input_NombrePuerto.setText("");
        index.jtextAreaDescripcionPuerto.setText("");
        index.input_Temperatura_Suelo.setText("");
    }

    private String extraerNumero(String cadena) {
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cadena);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    private void seleccionarElementoPorNumero(JComboBox comboBox, String numero) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            String elemento = (String) comboBox.getItemAt(i);
            if (elemento != null && elemento.contains(numero)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionCOM(Index index, String opcion, int id) {
        PuertoDao dao = new PuertoDaoImpl();
        IArduino arduino = new ArduinoImpl();
        List<String> puertos;
        switch (opcion) {
            case "new" -> {
                index.jCBNuevoPuertoCOM.removeAllItems();
                puertos = arduino.PuertosCom();
                for (String puerto : puertos) {
                    if (dao.Repeticion(puerto)) {
                    } else {
                        index.jCBNuevoPuertoCOM.addItem(puerto);
                    }
                }
            }
            case "edit" -> {
                index.jCBNuevoPuertoCOM1.removeAllItems();
                puertos = arduino.PuertosCom();
                for (String puerto : puertos) {
                    if (dao.RepeticionEdit(puerto, id)) {
                    } else {
                        index.jCBNuevoPuertoCOM1.addItem(puerto);
                    }
                }
            }
            default ->
                throw new AssertionError();
        }

    }

    private void SeleccionPlanta(Index index, String opcion) {
        switch (opcion) {
            case "new" -> {
                index.jCBNuevoPuertoPlanta.removeAllItems();
                PlantaDao dao = new PlantaDaoImpl();
                List<Planta> plantas = dao.getNombres();
                for (Planta planta : plantas) {
                    index.jCBNuevoPuertoPlanta.addItem(planta.getId() + ".-" + planta.getNombre());
                }
            }
            case "edit" -> {
                index.jCBNuevoPuertoPlanta1.removeAllItems();
                PlantaDao dao = new PlantaDaoImpl();
                List<Planta> plantas = dao.getNombres();
                for (Planta planta : plantas) {
                    index.jCBNuevoPuertoPlanta1.addItem(planta.getId() + ".-" + planta.getNombre());
                }
            }
            default ->
                throw new AssertionError();
        }

    }

    private void addPuerto(Index index) {
        if (index.input_NombrePuerto.getText().isEmpty() || index.jtextAreaDescripcionPuerto.getText().isEmpty()
                || index.input_Temperatura_Suelo.getText().isEmpty()) {
            mn.MessageOption(index.ContenedorPlantasNuevo, 1, "fdatos");
        } else {
            try {
                CRUD dao = new PuertoDaoImpl();
                Puerto puerto = new Puerto();
                int IdPlant = Integer.parseInt(extraerNumero(index.jCBNuevoPuertoPlanta.getItemAt(index.jCBNuevoPuertoPlanta.getSelectedIndex())));
                puerto.setNombre(index.input_NombrePuerto.getText());
                puerto.setDescripcion(index.jtextAreaDescripcionPuerto.getText());
                puerto.setCOM(index.jCBNuevoPuertoCOM.getItemAt(index.jCBNuevoPuertoCOM.getSelectedIndex()));
                puerto.setId_planta(IdPlant);
                puerto.setTem_humedad(Integer.parseInt(index.input_Temperatura_Suelo.getText()));
                dao.registra(puerto);
            } catch (Exception ex) {
                Logger.getLogger(PuertosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            table(index);
            index.JTabbetDasboad.setSelectedIndex(3);
        }
    }

    private void table(Index index) {
        try {
            IDesing design = new DesingImpl();
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            CRUD dao = new PuertoDaoImpl();
            String[] Columna = {"#", "Planta", "Nombre", "COM", "Datos", "Editar", "Eliminar"};
            List<Puerto> Puertos = dao.listarTodos();
            JButton dataPuerto = new JButton();
            JButton editPuerto = new JButton();
            JButton deletePuerto = new JButton();
            dataPuerto.setName("dataPuerto");
            editPuerto.setName("editPuerto");
            deletePuerto.setName("deletePuerto");
            model.setColumnIdentifiers(Columna);
            for (Puerto Puerto : Puertos) {
                model.addRow(new Object[]{
                    Puerto.getId(),
                    Puerto.getN_Planta(),
                    Puerto.getNombre(),
                    Puerto.getCOM(),
                    dataPuerto,
                    editPuerto,
                    deletePuerto
                });
            }
            index.Jtablet1.setModel(model);
            index.Jtablet1.setRowHeight(30);
            index.Jtablet1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int[] anchos = {80, 200, 200, 200, 70, 70, 70};
            for (int i = 0; i < index.Jtablet1.getColumnCount(); i++) {
                index.Jtablet1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            index.Jtablet1.getTableHeader().setReorderingAllowed(false);
            index.Jtablet1.getTableHeader().setResizingAllowed(false);
            RenderTablet rt = new RenderTablet();
            rt.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < index.Jtablet1.getColumnCount(); i++) {
                index.Jtablet1.getColumnModel().getColumn(i).setCellRenderer(rt);
            }
            index.Jtablet1.setDefaultRenderer(Object.class, rt);
            design.tableButtos("data", dataPuerto);
            design.tableButtos("edit", editPuerto);
            design.tableButtos("delete", deletePuerto);
        } catch (Exception ex) {
            Logger.getLogger(PuertosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void busqueda(Index index) {
        index.input_BusquedaPuerto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtro.setRowFilter(RowFilter.regexFilter(index.input_BusquedaPuerto.getText(), 2));
            }
        });
        filtro = new TableRowSorter(index.Jtablet1.getModel());
        index.Jtablet1.setRowSorter(filtro);
    }

    private void deletePuert(Index index, int id) {
        String op = String.valueOf(id);
        if (mc.MessageOption(op, "dplanta", index.ContenedorPuerto)) {
            try {
                CRUD dao = new PuertoDaoImpl();
                HistorialDao historial = new HistorialDaoImpl();
                historial.eliminarporPuerto(id);
                dao.eliminar(id);
                table(index);
            } catch (Exception ex) {
                Logger.getLogger(PlantasImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void rellenarDatos(Index index, int id) {
        try {
            CRUD dao = new PuertoDaoImpl();
            Puerto p = (Puerto) dao.objet(id);
            index.outputIdPuerto.setText(String.valueOf(p.getId()));
            index.input_NombrePuerto1.setText(p.getNombre());
            index.jtextAreaDescripcionPuerto1.setText(p.getDescripcion());
            index.input_Temperatura_Suelo1.setText(String.valueOf(p.getTem_humedad()));
            seleccionarElementoPorNumero(index.jCBNuevoPuertoPlanta1, String.valueOf(p.getId_planta()));
            index.jCBNuevoPuertoCOM1.setSelectedItem(p.getCOM());
        } catch (Exception ex) {
            Logger.getLogger(PuertosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editPuert(Index index) {
        if (index.input_NombrePuerto1.getText().isEmpty() || index.jtextAreaDescripcionPuerto1.getText().isEmpty()
                || index.input_Temperatura_Suelo1.getText().isEmpty()) {
            mn.MessageOption(index.ContenedorPlantasNuevo, 1, "fdatos");
        } else {

            String op = index.outputIdPuerto.getText();
            if (mc.MessageOption(op, "epuerto", index.ContenedorPlantasModificar)) {
                try {
                    CRUD dao = new PuertoDaoImpl();
                    Puerto p = new Puerto();
                    int idPlant = Integer.parseInt(extraerNumero(index.jCBNuevoPuertoPlanta1.getItemAt(index.jCBNuevoPuertoPlanta1.getSelectedIndex())));
                    p.setId_planta(idPlant);
                    p.setNombre(index.input_NombrePuerto1.getText());
                    p.setDescripcion(index.jtextAreaDescripcionPuerto1.getText());
                    p.setCOM(index.jCBNuevoPuertoCOM1.getItemAt(index.jCBNuevoPuertoCOM1.getSelectedIndex()));
                    p.setTem_humedad(Integer.parseInt(index.input_Temperatura_Suelo1.getText()));
                    p.setId(Integer.parseInt(index.outputIdPuerto.getText()));
                    dao.modificar(p, null);
                } catch (Exception ex) {
                    Logger.getLogger(PuertosImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                index.JTabbetDasboad.setSelectedIndex(3);
                table(index);
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
