package com.ConcursoUTP.pe.Service.Inter.Impl;

import com.ConcursoUTP.pe.Dao.CRUD;
import com.ConcursoUTP.pe.Dao.HistorialDao;
import com.ConcursoUTP.pe.Dao.HistorialDaoImpl;
import com.ConcursoUTP.pe.Dao.PuertoDao;
import com.ConcursoUTP.pe.Dao.PuertoDaoImpl;
import com.ConcursoUTP.pe.Desing.IDesing;
import com.ConcursoUTP.pe.Desing.RenderTablet;
import com.ConcursoUTP.pe.Model.Historial;
import com.ConcursoUTP.pe.Model.InformePuerto;
import com.ConcursoUTP.pe.Service.Inter.IArduino;
import com.ConcursoUTP.pe.View.Index;
import com.ConcursoUTP.pe.View.Infcom;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ArduinoImpl implements IArduino {

    //=============================== Class ===================
    //=========================================================
    private TableRowSorter filtro;

    public Map<String, String> temperaturas = new HashMap<>();

    public Map<String, String> acciones = new HashMap<>();

    //====================== Invoker =====================
    //======================================================
    @Override
    public void regadadorAutomatico() {
        try {
            Automatic();
        } catch (Exception ex) {
            Logger.getLogger(ArduinoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void GoInfCom(Infcom infcom, Index index, IDesing desing, int p) {
        newInfCOM(infcom, index, desing, p);
    }

    @Override
    public List<String> PuertosCom() {
        List<String> lst = new ArrayList<>();
        SerialPort[] serialPorts = SerialPort.getCommPorts();
        for (SerialPort serialPort : serialPorts) {
            lst.add(serialPort.getSystemPortName());
        }
        return lst;
    }

    //====================== Extension =====================
    //======================================================
    //Maps
    private void addTemperaturas(String cod, String tempe) {
        temperaturas.put(cod, tempe);
    }

    private String Temperatura(String cod) {
        return temperaturas.get(cod);
    }

    private void addAcciones(String code, String accion) {
        acciones.put(code, accion);
    }

    private String accion(String cod) {
        return acciones.get(cod);
    }

    // Enviar
    private void newInfCOM(Infcom infcom, Index index, IDesing design, int p) {
        design.getLookandFell();
        infcom = new Infcom(index, true);
        infPuerto(infcom, p);
        tabla(p);
        inputBusqueda(infcom);
        cerrar(infcom);
        infcom.setLocationRelativeTo(index.contenedorCosasPuero);
        design.initInfCOM(infcom);
        infcom.setVisible(true);
        enviarVisualizacion();
    }

    private void infPuerto(Infcom infom, int id) {
        PuertoDao dao = new PuertoDaoImpl();
        InformePuerto ip = dao.setPuerto(id);
        infom.outputIdPuerto.setText(String.valueOf(ip.getId()));
        infom.outputNombre.setText(ip.getNombre());
        infom.jTextArea1.setText(ip.getDescripcion());
        infom.NombreFotoPlanta.setText(ip.getNombrePlanta());
        infom.outputPuertoCom.setText(ip.getCOM());
        ImageIcon imagen = new ImageIcon(ip.getFotoOuput());
        Image img = imagen.getImage().getScaledInstance(
                infom.FotoSeleccionadaPlanta1.getWidth(), infom.FotoSeleccionadaPlanta1.getHeight(),
                Image.SCALE_SMOOTH);
        infom.FotoSeleccionadaPlanta1.setIcon(new ImageIcon(img));
        infom.jTextArea1.setFocusable(false);
        infom.jTextArea1.setEditable(false);
        infom.jTextArea1.setBackground(new Color(255, 255, 255));
        infom.jTextArea1.setBorder(null);
    }

    private void tabla(int id) {
        if (Infcom.TablaRiego != null) {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            HistorialDao dao = new HistorialDaoImpl();
            String[] Columna = {"#", "Fecha", "Hora", "Humedad"};
            List<Historial> lst = dao.listar(id);
            model.setColumnIdentifiers(Columna);
            for (Historial historial : lst) {
                model.addRow(new Object[]{
                    historial.getId(),
                    historial.getFecha(),
                    historial.getHora(),
                    historial.getHumedad()
                });
            }
            Infcom.TablaRiego.setModel(model);
            Infcom.TablaRiego.setRowHeight(30);
            Infcom.TablaRiego.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int[] anchos = {105, 235, 235, 235};
            for (int i = 0; i < Infcom.TablaRiego.getColumnCount(); i++) {
                Infcom.TablaRiego.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            Infcom.TablaRiego.getTableHeader().setReorderingAllowed(false);
            Infcom.TablaRiego.getTableHeader().setResizingAllowed(false);
            RenderTablet rt = new RenderTablet();
            rt.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < Infcom.TablaRiego.getColumnCount(); i++) {
                Infcom.TablaRiego.getColumnModel().getColumn(i).setCellRenderer(rt);
            }
            Infcom.TablaRiego.setDefaultRenderer(Object.class, rt);
        }
    }

    private void inputBusqueda(Infcom infom) {
        infom.input_Busqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                busqueda(infom);
            }
        });

    }

    private void busqueda(Infcom infom) {
        infom.input_Busqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtro.setRowFilter(RowFilter.regexFilter(infom.input_Busqueda.getText(), 1));
            }
        });
        filtro = new TableRowSorter(infom.TablaRiego.getModel());
        infom.TablaRiego.setRowSorter(filtro);
    }

    private void cerrar(Infcom infcom) {
        infcom.iconXPuerto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                infcom.setModal(false);
                infcom.dispose();
            }
        });
    }

    // Data
    private void arrancarMotor(SerialPort serial, String option) {
        if (serial.openPort()) {
            serial.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
            byte[] enviado = option.getBytes();
            serial.writeBytes(enviado, enviado.length);
        }
    }

    private void enviarVisualizacion() {
        SwingUtilities.invokeLater(() -> {
            if (Infcom.outputPuertoCom != null) {
                Infcom.txt_Humedad.setText(Temperatura(Infcom.outputPuertoCom.getText()));
                Infcom.txt_estado.setText(accion(Infcom.outputPuertoCom.getText()));
            }
        });
    }

    private String fechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formatter);
        return fechaFormateada;
    }

    private String horaActual() {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = horaActual.format(formatter);
        return horaFormateada;
    }

    private void Automatic() throws Exception {
        PuertoDao dao = new PuertoDaoImpl();
        CRUD historial = new HistorialDaoImpl();
        while (true) {
            try {
                Thread.sleep(500);
                List<String> puertos = dao.PuertosCom();
                if (puertos.isEmpty()) {
                    System.out.println("No hay puertos...");
                }else{
                    System.out.println("Automatico...");
                    for (String puerto : puertos) {
                    PuertoDao ip = new PuertoDaoImpl();
                    SerialPort serialPort = SerialPort.getCommPort(puerto);
                    if (serialPort.openPort()) {
                        System.out.println("Entra aca");
                        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
                        Scanner scn = new Scanner(serialPort.getInputStream());
                        String wa =scn.nextLine();
                        System.out.println(wa);
                        int TempeObtenido = Integer.parseInt(wa);
                         byte[] enviado = "y".getBytes();
                         serialPort.writeBytes(enviado, enviado.length);
                        if (TempeObtenido <= 50) {
                            int idPuerto = dao.setIdPuerto(puerto);
                            
                            addAcciones(puerto, "Activado");
                            Historial h = new Historial();
                            h.setId_puerto(idPuerto);
                            h.setFecha(fechaActual());
                            h.setHora(horaActual());
                            h.setHumedad(TempeObtenido);
                            historial.registra(h);
                            Thread.sleep(500);
                            tabla(idPuerto);
                        } else {
                            addAcciones(puerto, "Desactivado");
                        }
                        addTemperaturas(puerto, String.valueOf(TempeObtenido));
                        enviarVisualizacion();
                    }else{
                        System.out.println("Puerto false");
                    }
                    serialPort.closePort();
                    }
                }
            } catch (SerialPortInvalidPortException | InterruptedException | NumberFormatException e) {
                System.out.println("ERROR: " + e);
            }
        }
    }

}
