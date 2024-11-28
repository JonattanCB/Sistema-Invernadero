package com.ConcursoUTP.pe.Controllers;

import com.ConcursoUTP.pe.Desing.IDesing;
import com.ConcursoUTP.pe.Desing.DesingImpl;
import com.ConcursoUTP.pe.Service.FabricaServicio;
import com.ConcursoUTP.pe.Service.Inter.IArduino;
import com.ConcursoUTP.pe.Service.Inter.IInicio;
import com.ConcursoUTP.pe.Service.Inter.IPlantas;
import com.ConcursoUTP.pe.Service.Inter.IPuertos;
import com.ConcursoUTP.pe.Service.Inter.ServicioFabrica;
import com.ConcursoUTP.pe.View.Index;
import com.ConcursoUTP.pe.View.Infcom;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class IndexControllers {

    //======================== Class ==========================
    //=========================================================
    private final Index view;

    private final IDesing desing;

    private Infcom infcom;

    public ServicioFabrica servicioArduino = FabricaServicio.getFactors("arduino");
    public IArduino ia = servicioArduino.getArduino();

    public IndexControllers() {
        desing = new DesingImpl();
        desing.getLookandFell();
        view = new Index();

    }

    //======================== Init ===========================
    //=========================================================
    public void init() {
        desing.init(view);
        controllsButts();
        jtablets();
        inputSearchs();
        Validacion();
        Arduino();

    }

    //========================  General  ======================
    //=========================================================
    private void controllsButts() {
        GoControlPanel();
        Navegation();
        SelectTabletPlanta();
        NewPlanta();
        editPlant();
        NewPuerto();
        SelectTabletPuerto();
        editPuerto();
    }

    private void jtablets() {
        TablePlanta();
        TablePuerto();
    }

    private void inputSearchs() {
        inputBusquedaPlanta();
        inputBusquedaPuerto();
    }

    private void Validacion() {
        validacionDatosPlanta();
        validacionDatosPuerto();
    }

    //======================== Extension ======================
    //=========================================================
    //========== INICIO
    private void GoControlPanel() {
        view.Contenedor_Login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("inicio");
                IInicio ii = servicio.getInicio();
                ii.initDasboard(view);
                view.Contenedor_Login.removeMouseListener(this);
            }

        });
    }

    private void Navegation() {
        view.irPlantas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                IPlantas ip = servicio.getPlantas();
                ip.GoControlPanelPlanta(view);
            }
        });

        view.irPuertos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
                IPuertos ip = servicio.getPuerto();
                ip.GoControlPanelPuerto(view);
            }
        });

        view.JbuttonNuevo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                IPlantas ip = servicio.getPlantas();
                ip.GoNewPlanta(view);
            }
        });

        view.JbuttonNuevo1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
                IPuertos ip = servicio.getPuerto();
                ip.GoNewPuerto(view);
            }
        });
    }

    //========== PLANTA
    private void TablePlanta() {
        ServicioFabrica servicio = FabricaServicio.getFactors("planta");
        IPlantas ip = servicio.getPlantas();
        ip.TablePlanta(view);
    }

    private void inputBusquedaPlanta() {
        view.input_BusquedaPlantas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                IPlantas ip = servicio.getPlantas();
                ip.SearchPlanta(view);
            }
        });
    }

    private void SelectTabletPlanta() {
        view.Jtablet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = view.Jtablet.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / view.Jtablet.getRowHeight();
                if (row < view.Jtablet.getRowCount() && row >= 0 && column < view.Jtablet.getColumnCount() && column >= 0) {
                    Object value = view.Jtablet.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;
                        if (boton.getName().equals("editPlanta")) {
                            int filaSeleccionada = view.Jtablet.getSelectedRow();
                            int id = (int) view.Jtablet.getValueAt(filaSeleccionada, 0);
                            ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                            IPlantas ip = servicio.getPlantas();
                            ip.GoEditPlanta(view, id);
                        }
                        if (boton.getName().equals("deletePlanta")) {
                            int filaSeleccionada = view.Jtablet.getSelectedRow();
                            int id = (int) view.Jtablet.getValueAt(filaSeleccionada, 0);
                            ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                            IPlantas ip = servicio.getPlantas();
                            ip.delatePlanta(view, id);
                        }
                    }
                }
            }
        });
    }

    private void NewPlanta() {
        view.jButtonSeleccionFotoPlanta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                IPlantas ip = servicio.getPlantas();
                ip.SelectFoto(view, "new");
            }

        });

        view.jbuttonGuardarPlanta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                IPlantas ip = servicio.getPlantas();
                ip.addPlanta(view);
                TablePlanta();
            }
        });
    }

    private void editPlant() {
        view.jButtonSeleccionFotoPlanta1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                IPlantas ip = servicio.getPlantas();
                ip.SelectFoto(view, "edit");
            }
        });

        view.jbuttonEditarPlanta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("planta");
                IPlantas ip = servicio.getPlantas();
                ip.editPlanta(view);
            }
        });

    }

    private void validacionDatosPlanta() {
        ServicioFabrica servicio = FabricaServicio.getFactors("planta");
        IPlantas ip = servicio.getPlantas();
        ip.validacionPlanta("l", view.input_BusquedaPlantas);
        ip.validacionPlanta("l", view.input_NombrePlanta);
        ip.validacionPlanta("l", view.input_NombrePlanta1);
    }

    //========== PUERTO
    private void TablePuerto() {
        ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
        IPuertos ip = servicio.getPuerto();
        ip.tablePuerto(view);
    }

    private void NewPuerto() {
        view.jbuttonGuardarPuerto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
                IPuertos ip = servicio.getPuerto();
                ip.addNewPuerto(view);
            }
        });
    }

    private void inputBusquedaPuerto() {
        view.input_BusquedaPuerto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
                IPuertos ip = servicio.getPuerto();
                ip.SearchPuerto(view);
            }
        });
    }

    private void SelectTabletPuerto() {
        view.Jtablet1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = view.Jtablet1.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / view.Jtablet1.getRowHeight();

                if (row < view.Jtablet1.getRowCount() && row >= 0 && column < view.Jtablet1.getColumnCount() && column >= 0) {
                    Object value = view.Jtablet1.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;
                        if (boton.getName().equals("dataPuerto")) {
                            int filaSeleccionada = view.Jtablet1.getSelectedRow();
                            int id = (int) view.Jtablet1.getValueAt(filaSeleccionada, 0);
                            ia.GoInfCom(infcom, view, desing, id);
                        }
                        if (boton.getName().equals("editPuerto")) {
                            int filaSeleccionada = view.Jtablet1.getSelectedRow();
                            int id = (int) view.Jtablet1.getValueAt(filaSeleccionada, 0);
                            ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
                            IPuertos ip = servicio.getPuerto();
                            ip.GoEditPuerto(view, id);
                        }
                        if (boton.getName().equals("deletePuerto")) {
                            int filaSeleccionada = view.Jtablet1.getSelectedRow();
                            int id = (int) view.Jtablet1.getValueAt(filaSeleccionada, 0);
                            ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
                            IPuertos ip = servicio.getPuerto();
                            ip.DeletePuerto(view, id);
                        }
                    }
                }
            }
        });
    }

    private void editPuerto() {
        view.jbuttonEditarPuerto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
                IPuertos ip = servicio.getPuerto();
                ip.EditPuerto(view);
            }
        });
    }

    private void validacionDatosPuerto() {
        ServicioFabrica servicio = FabricaServicio.getFactors("puerto");
        IPuertos ip = servicio.getPuerto();
        ip.validacionPuerto("l", view.input_BusquedaPuerto);
        ip.validacionPuerto("l", view.input_NombrePuerto);
        ip.validacionPuerto("l", view.input_NombrePuerto1);
        ip.validacionPuerto("n", view.input_Temperatura_Suelo);
        ip.validacionPuerto("n", view.input_Temperatura_Suelo1);
    }

    //arduino 
    private void Arduino() {
        ia.regadadorAutomatico();
    }

}
