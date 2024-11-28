package com.ConcursoUTP.pe.View;

import java.awt.Color;

public class Infcom extends javax.swing.JDialog {

    public Infcom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contendor_Dialogo = new javax.swing.JPanel();
        ContendedorInfcom = new javax.swing.JPanel();
        Contenedor_Menu = new javax.swing.JPanel();
        Contenedor_Salir = new javax.swing.JPanel();
        iconXPuerto = new javax.swing.JLabel();
        jTabbedControlador = new javax.swing.JTabbedPane();
        Contenedor_Tem_Humedad = new javax.swing.JPanel();
        Contenedor_Hierba = new javax.swing.JPanel();
        icon_Hierba2 = new javax.swing.JLabel();
        icon_Hierba = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Humedad = new javax.swing.JLabel();
        txt_estado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ContenedorInfoPuerto = new javax.swing.JPanel();
        Contenedor_input19 = new javax.swing.JPanel();
        jSeparator23 = new javax.swing.JSeparator();
        outputIdPuerto = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Contenedor_input14 = new javax.swing.JPanel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Contenedor_input13 = new javax.swing.JPanel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        outputNombre = new javax.swing.JLabel();
        Contenedor_input17 = new javax.swing.JPanel();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        ContornoFoto3 = new javax.swing.JPanel();
        ContornoFoto4 = new javax.swing.JPanel();
        FotoSeleccionadaPlanta1 = new javax.swing.JLabel();
        NombreFotoPlanta = new javax.swing.JLabel();
        Contenedor_input20 = new javax.swing.JPanel();
        jSeparator24 = new javax.swing.JSeparator();
        outputPuertoCom = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Contenedor_Hist_Riego = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        TablaRiego = new javax.swing.JTable();
        Contenedor_input = new javax.swing.JPanel();
        jSeparator = new javax.swing.JSeparator();
        input_Busqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        ContendedorInfcom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconXPuerto.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        iconXPuerto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconXPuerto.setText("X");

        javax.swing.GroupLayout Contenedor_SalirLayout = new javax.swing.GroupLayout(Contenedor_Salir);
        Contenedor_Salir.setLayout(Contenedor_SalirLayout);
        Contenedor_SalirLayout.setHorizontalGroup(
            Contenedor_SalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contenedor_SalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(iconXPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Contenedor_SalirLayout.setVerticalGroup(
            Contenedor_SalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contenedor_SalirLayout.createSequentialGroup()
                .addComponent(iconXPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout Contenedor_MenuLayout = new javax.swing.GroupLayout(Contenedor_Menu);
        Contenedor_Menu.setLayout(Contenedor_MenuLayout);
        Contenedor_MenuLayout.setHorizontalGroup(
            Contenedor_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contenedor_MenuLayout.createSequentialGroup()
                .addContainerGap(379, Short.MAX_VALUE)
                .addComponent(Contenedor_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        Contenedor_MenuLayout.setVerticalGroup(
            Contenedor_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contenedor_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContendedorInfcom.add(Contenedor_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 0, 410, 30));

        Contenedor_Hierba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_Hierba2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ConcursoUTP/pe/img/Pasto.jpg"))); // NOI18N
        Contenedor_Hierba.add(icon_Hierba2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 570, 150));

        icon_Hierba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ConcursoUTP/pe/img/Pasto.jpg"))); // NOI18N
        Contenedor_Hierba.add(icon_Hierba, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, -20, 400, 130));

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Humedad del Suelo:");

        txt_Humedad.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        txt_Humedad.setForeground(new java.awt.Color(170, 170, 170));
        txt_Humedad.setText("#humeda");

        txt_estado.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        txt_estado.setForeground(new java.awt.Color(170, 170, 170));
        txt_estado.setText("#estado");

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Estado de regado   :");

        javax.swing.GroupLayout Contenedor_Tem_HumedadLayout = new javax.swing.GroupLayout(Contenedor_Tem_Humedad);
        Contenedor_Tem_Humedad.setLayout(Contenedor_Tem_HumedadLayout);
        Contenedor_Tem_HumedadLayout.setHorizontalGroup(
            Contenedor_Tem_HumedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contenedor_Hierba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Contenedor_Tem_HumedadLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(Contenedor_Tem_HumedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Contenedor_Tem_HumedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Humedad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Contenedor_Tem_HumedadLayout.setVerticalGroup(
            Contenedor_Tem_HumedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contenedor_Tem_HumedadLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(Contenedor_Tem_HumedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Humedad))
                .addGap(18, 18, 18)
                .addGroup(Contenedor_Tem_HumedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(Contenedor_Hierba, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedControlador.addTab("Temperatura de Humedad", Contenedor_Tem_Humedad);

        Contenedor_input19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Contenedor_input19.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 10));

        outputIdPuerto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        outputIdPuerto.setForeground(new java.awt.Color(102, 102, 102));
        outputIdPuerto.setText("#ID");
        Contenedor_input19.add(outputIdPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -20, 100, 70));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("ID:");
        Contenedor_input19.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 70, 70));

        Contenedor_input14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Contenedor_input14.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 10));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Descripcion:");
        Contenedor_input14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        Contenedor_input14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 350, 100));

        Contenedor_input13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Contenedor_input13.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Nombre:");
        Contenedor_input13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 70, 70));

        outputNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        outputNombre.setForeground(new java.awt.Color(102, 102, 102));
        outputNombre.setText("#NOMBRE");
        Contenedor_input13.add(outputNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, -20, 250, 70));

        Contenedor_input17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Contenedor_input17.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 10));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Temperatura del Suelo:");
        Contenedor_input17.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 170, 70));

        ContornoFoto3.setForeground(new java.awt.Color(60, 63, 65));

        javax.swing.GroupLayout ContornoFoto4Layout = new javax.swing.GroupLayout(ContornoFoto4);
        ContornoFoto4.setLayout(ContornoFoto4Layout);
        ContornoFoto4Layout.setHorizontalGroup(
            ContornoFoto4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoSeleccionadaPlanta1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );
        ContornoFoto4Layout.setVerticalGroup(
            ContornoFoto4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoSeleccionadaPlanta1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContornoFoto3Layout = new javax.swing.GroupLayout(ContornoFoto3);
        ContornoFoto3.setLayout(ContornoFoto3Layout);
        ContornoFoto3Layout.setHorizontalGroup(
            ContornoFoto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContornoFoto3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContornoFoto4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ContornoFoto3Layout.setVerticalGroup(
            ContornoFoto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContornoFoto3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContornoFoto4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        NombreFotoPlanta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NombreFotoPlanta.setForeground(new java.awt.Color(102, 102, 102));
        NombreFotoPlanta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Contenedor_input20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Contenedor_input20.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 10));

        outputPuertoCom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        outputPuertoCom.setForeground(new java.awt.Color(102, 102, 102));
        outputPuertoCom.setText("#PuertoCOM");
        Contenedor_input20.add(outputPuertoCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -20, 160, 70));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Puerto COM:");
        Contenedor_input20.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 90, 70));

        javax.swing.GroupLayout ContenedorInfoPuertoLayout = new javax.swing.GroupLayout(ContenedorInfoPuerto);
        ContenedorInfoPuerto.setLayout(ContenedorInfoPuertoLayout);
        ContenedorInfoPuertoLayout.setHorizontalGroup(
            ContenedorInfoPuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ContenedorInfoPuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                        .addComponent(Contenedor_input19, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(Contenedor_input17, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                        .addGroup(ContenedorInfoPuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Contenedor_input14, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Contenedor_input13, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Contenedor_input20, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(ContenedorInfoPuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ContornoFoto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreFotoPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        ContenedorInfoPuertoLayout.setVerticalGroup(
            ContenedorInfoPuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(ContenedorInfoPuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                        .addComponent(Contenedor_input19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Contenedor_input13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Contenedor_input14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                        .addComponent(Contenedor_input17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContornoFoto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ContenedorInfoPuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(NombreFotoPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenedorInfoPuertoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Contenedor_input20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedControlador.addTab("Informacion del Puerto", ContenedorInfoPuerto);

        TablaRiego.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(TablaRiego);

        Contenedor_input.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Contenedor_input.add(jSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 10));
        Contenedor_input.add(input_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, 280, 30));

        javax.swing.GroupLayout Contenedor_Hist_RiegoLayout = new javax.swing.GroupLayout(Contenedor_Hist_Riego);
        Contenedor_Hist_Riego.setLayout(Contenedor_Hist_RiegoLayout);
        Contenedor_Hist_RiegoLayout.setHorizontalGroup(
            Contenedor_Hist_RiegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contenedor_Hist_RiegoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Contenedor_Hist_RiegoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Contenedor_input, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Contenedor_Hist_RiegoLayout.setVerticalGroup(
            Contenedor_Hist_RiegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contenedor_Hist_RiegoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Contenedor_input, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jTabbedControlador.addTab("Historial de Riego", Contenedor_Hist_Riego);

        ContendedorInfcom.add(jTabbedControlador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 390));

        javax.swing.GroupLayout Contendor_DialogoLayout = new javax.swing.GroupLayout(Contendor_Dialogo);
        Contendor_Dialogo.setLayout(Contendor_DialogoLayout);
        Contendor_DialogoLayout.setHorizontalGroup(
            Contendor_DialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contendor_DialogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContendedorInfcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Contendor_DialogoLayout.setVerticalGroup(
            Contendor_DialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contendor_DialogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContendedorInfcom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor_Dialogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor_Dialogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Infcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Infcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Infcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Infcom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Infcom dialog = new Infcom(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel ContendedorInfcom;
    public javax.swing.JPanel Contendor_Dialogo;
    public javax.swing.JPanel ContenedorInfoPuerto;
    private javax.swing.JPanel Contenedor_Hierba;
    public javax.swing.JPanel Contenedor_Hist_Riego;
    public javax.swing.JPanel Contenedor_Menu;
    public javax.swing.JPanel Contenedor_Salir;
    public javax.swing.JPanel Contenedor_Tem_Humedad;
    public javax.swing.JPanel Contenedor_input;
    public javax.swing.JPanel Contenedor_input13;
    public javax.swing.JPanel Contenedor_input14;
    public javax.swing.JPanel Contenedor_input17;
    public javax.swing.JPanel Contenedor_input19;
    public javax.swing.JPanel Contenedor_input20;
    public javax.swing.JPanel ContornoFoto3;
    public javax.swing.JPanel ContornoFoto4;
    public javax.swing.JLabel FotoSeleccionadaPlanta1;
    public javax.swing.JLabel NombreFotoPlanta;
    public static javax.swing.JTable TablaRiego;
    public javax.swing.JLabel iconXPuerto;
    private javax.swing.JLabel icon_Hierba;
    private javax.swing.JLabel icon_Hierba2;
    public javax.swing.JTextField input_Busqueda;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator;
    public javax.swing.JSeparator jSeparator17;
    public javax.swing.JSeparator jSeparator18;
    public javax.swing.JSeparator jSeparator21;
    public javax.swing.JSeparator jSeparator23;
    public javax.swing.JSeparator jSeparator24;
    public javax.swing.JTabbedPane jTabbedControlador;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel outputIdPuerto;
    public javax.swing.JLabel outputNombre;
    public static javax.swing.JLabel outputPuertoCom;
    public static javax.swing.JLabel txt_Humedad;
    public static javax.swing.JLabel txt_estado;
    // End of variables declaration//GEN-END:variables
}
