package com.ConcursoUTP.pe.Desing;

import com.ConcursoUTP.pe.View.Index;
import com.ConcursoUTP.pe.View.Infcom;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.icons.FlatSearchIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class DesingImpl implements IDesing {

    //========================  class ===============================
    //===============================================================
    @Override
    public void init(Index index) {
        panels(index);
        inputs(index);
        butts(index);
        initInicio(index);
        validation(index);
        index.setTitle("Sistema de Riego");
    }

    @Override
    public void getLookandFell() {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void tableButtos(String Option, JButton btn) {
        switch (Option) {
            case "edit" -> {
                EditButtonTablet(btn);
            }
            case "delete" ->{
                DeleteButtonTablet(btn);
            }
            case "data" -> {
                dataButtonTablet(btn);
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    public void initInfCOM(Infcom infcom) {
        PanelContorno2(infcom.Contendor_Dialogo);
        panelDasboard(infcom.ContendedorInfcom);
        panelDasboard(infcom.Contenedor_Menu);
        panelDasboard(infcom.Contenedor_Tem_Humedad);
        panelDasboard(infcom.Contenedor_input);
        panelDasboard(infcom.Contenedor_Hist_Riego);
        panelDasboard(infcom.ContenedorInfoPuerto);
        inputTexto2(infcom.input_Busqueda, "Fecha y Hora");
        jtabbetComponet(infcom.jTabbedControlador);
        jbuttonCerrar(infcom.iconXPuerto, infcom.Contenedor_Salir);
        panelDasboard(infcom.Contenedor_input19);
        panelDasboard(infcom.Contenedor_input13);
        panelDasboard(infcom.Contenedor_input14);
        panelDasboard(infcom.Contenedor_input17);
        panelContorno(infcom.ContornoFoto3);
        panelDasboard(infcom.ContornoFoto4);
        panelDasboard(infcom.Contenedor_input20);
    }
    
    

    //========================  General =============================
    //===============================================================
    private void panels(Index index) {
        menuDasboard(index);
        panelDasboard(index.ContenedorPlanta);
        panelDasboard(index.Contenedor_input);
        panelDasboard(index.ContenedorPlantasNuevo);
        panelDasboard(index.Contenedor_input1);
        panelDasboard(index.Contenedor_input2);
        panelContorno(index.ContornoFoto1);
        panelDasboard(index.ContornoFoto2);
        panelDasboard(index.Contenedor_input3);
        panelDasboard(index.ContenedorPlantasModificar);
        panelDasboard(index.Contenedor_input4);
        panelDasboard(index.Contenedor_input5);
        panelDasboard(index.Contenedor_input6);
        panelContorno(index.ContornoFoto3);
        panelDasboard(index.ContornoFoto4);
        panelDasboard(index.ContenedorPuerto);
        panelDasboard(index.Contenedor_input7);
        panelDasboard(index.ContenedorPuertoNuevo);
        panelDasboard(index.Contenedor_input8);
        panelDasboard(index.Contenedor_input9);
        panelDasboard(index.Contenedor_input10);
        panelDasboard(index.Contenedor_input11);
        panelDasboard(index.Contenedor_input12);
        panelDasboard(index.ContenedorPuertoModificar);
        panelDasboard(index.Contenedor_input17);
        panelDasboard(index.Contenedor_input16);
        panelDasboard(index.Contenedor_input15);
        panelDasboard(index.Contenedor_input13);
        panelDasboard(index.Contenedor_input14);
        panelDasboard(index.Contenedor_input18);
        panelDasboard(index.Contenedor_input19);
        panelDasboard(index.contenedorCosasPuero);
    }

    private void inputs(Index index) {
        inputTexto2(index.input_BusquedaPlantas, "Nombre de la Planta");
        inputTexto(index.input_NombrePlanta, "");
        inputTexto(index.input_NombrePlanta1, "");
        inputTexto2(index.input_BusquedaPuerto, "Nombre del Puerto");
        inputTexto(index.input_NombrePuerto, "");
        inputTexto(index.input_Temperatura_Suelo, "");
        inputTexto(index.input_NombrePuerto1, "");
        inputTexto(index.input_Temperatura_Suelo1, "");
    }

    private void butts(Index index) {
        irSeleccion(index.irPlantas, index.ContenedorIrPlantas);
        irSeleccion(index.irPuertos, index.ContenedorIrPuerto);
        jbuttonSeleccionar(index.jButtonSeleccionFotoPlanta);
        jbuttonNuevo(index.JbuttonNuevo);
        jbuttonNuevo(index.jbuttonGuardarPlanta);
        jbuttonSeleccionar(index.jButtonSeleccionFotoPlanta1);
        jbuttonEditar(index.jbuttonEditarPlanta);
        jbuttonNuevo(index.JbuttonNuevo1);
        jbuttonNuevo(index.jbuttonGuardarPuerto);
        jbuttonEditar(index.jbuttonEditarPuerto);

    }
    //======================== extensions  ==========================
    //===============================================================

    private void initInicio(Index index) {
        index.jProgressBar.setForeground(new Color(0, 153, 102));
    }

    private void validation(Index index) {
        index.setVisible(true);
        index.setLocationRelativeTo(null);
        index.setResizable(false);
        index.jProgressBar.setVisible(false);
        index.txtCargador.setVisible(false);
        index.iconCargador.setVisible(false);
    }

    private void menuDasboard(Index index) {
        index.Contenedor_Menu.setBackground(new Color(0, 153, 102));
    }

    private void irSeleccion(JLabel label, JPanel panel) {
        panel.setBackground(new Color(0, 153, 102));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(new Color(0 + 30, 153 + 30, 102 + 30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(new Color(0, 153, 102));
            }

        });
    }

    private void jbuttonNuevo(JButton button) {
        button.setBackground(new Color(89, 180, 89));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(89 + 30, 180 + 30, 89 + 30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(89, 180, 89));
            }
        });
    }

    private void jbuttonSeleccionar(JButton button) {
        button.setBackground(new Color(50, 120, 179));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(50 + 30, 120 + 30, 179 + 30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(50, 120, 179));
            }
        });
    }

    private void jbuttonEditar(JButton button) {
        button.setBackground(new Color(239, 168, 68));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(239 + 10, 168 + 10, 68 + 10));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(239, 168, 68));
            }
        });
    }

    private void inputTexto(JTextField input, String text) {
        input.putClientProperty("JTextField.placeholderText", text);
        input.setBackground(new Color(255, 255, 255));
        input.setBorder(null);
    }


    private void inputTexto2(JTextField input, String text) {
        input.putClientProperty( "JTextField.leadingIcon",new FlatSearchIcon());
        input.putClientProperty("JTextField.placeholderText", text);
        input.setBackground(new Color(255, 255, 255));
        input.setBorder(new EmptyBorder(2, 2, 2, 2));
    }
    
    private void panelDasboard(JPanel panel) {
        panel.setBackground(new Color(255, 255, 255));
    }

    private void panelContorno(JPanel panel) {
        panel.setBackground(new Color(89, 180, 89));
    }

    private void PanelContorno2(JPanel panel){
        panel.setBackground(new Color(89, 180, 89));
        panel.putClientProperty("arc", 30);
    }
    
    private void EditButtonTablet(JButton button) {
        ImageIcon ii = new ImageIcon("src/com/ConcursoUTP/pe/img/editar.png");
        button.setIcon(ii);
        button.setBackground(new Color(239, 168, 68));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
    }

    private void DeleteButtonTablet(JButton button){
        ImageIcon ii = new ImageIcon("src/com/ConcursoUTP/pe/img/eliminar.png");
        button.setIcon(ii);
        button.setBackground(new Color(202,60,56));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
    }
    
    private void dataButtonTablet(JButton button){
        ImageIcon ii = new ImageIcon("src/com/ConcursoUTP/pe/img/Datos.png");
        button.setIcon(ii);
        button.setBackground(new Color(79,187,219));
        button.setForeground(new Color(255, 255, 255));
        button.setFocusPainted(false);
    }
    
    private void jtabbetComponet(JTabbedPane tabbet){
        tabbet.setBackground(new Color(255,255,255));
        tabbet.putClientProperty("JTabbedPane.tabType", "card");
        tabbet.putClientProperty("JTabbedPane.hasFullBorder", true);
        tabbet.putClientProperty("JTabbedPane.tabHeight", 32);
    }
    
    private void jbuttonCerrar(JLabel exit , JPanel panel){
        panel.setBackground(new Color(255,255,255));
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               panel.setBackground(new Color(202,60,56));
               exit.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               panel.setBackground(new Color(255,255,255));
               exit.setForeground(new Color(102,102,102));
            }
            
        });
    }
    
}
