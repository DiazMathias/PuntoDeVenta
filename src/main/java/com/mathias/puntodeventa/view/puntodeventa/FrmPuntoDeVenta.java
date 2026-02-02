package com.mathias.puntodeventa.view.puntodeventa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmPuntoDeVenta extends JFrame {

    private JTable tablaVenta;
    private JTextField txtCodigo, txtDescripcion, txtPrecio;
    private JButton btnCobrar, btnVaciarCarrito, btnAñadirManual;
    private JLabel lblTotalVender, lblProductos;

    private String[] columnas_tabla = {"Descripción", "Precio Unitario", "Cantidad", "Total"};

    public FrmPuntoDeVenta() {
        inicializarVentana();

        JPanel panelPrincipal = crearPanelPrincipal();
        this.add(panelPrincipal);

        añadirComponentesPanelPrincipal(panelPrincipal);
    }

    private void inicializarVentana() {
        this.setTitle("Punto de Venta");
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        return panelPrincipal;
    }

    private void añadirComponentesPanelPrincipal(JPanel panelPrincipal) {
        añadirPanelSuperior(panelPrincipal);
        añadirPanelDerecho(panelPrincipal);
        añadirPanelCentral(panelPrincipal);
    }

    private void añadirPanelSuperior(JPanel panelPrincipal) {
        JPanel panelSuperior = crearPanelSuperior();
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        añadirComponentesPanelSuperior(panelSuperior);
    }

    private JPanel crearPanelSuperior() {
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(52, 152, 219));
        panelSuperior.setPreferredSize(new Dimension(0, 60));
        return panelSuperior;
    }

    private void añadirComponentesPanelSuperior(JPanel panelSuperior) {
        JLabel lblTitulo = crearLabel("PUNTO DE VENTA", 22, Font.BOLD);
        panelSuperior.add(lblTitulo);
    }

    private void añadirPanelDerecho(JPanel panelPrincipal) {
        JPanel panelDerecho = crearPanelDerecho();
        panelPrincipal.add(panelDerecho, BorderLayout.EAST);

        añadirComponentesPanelDerecho(panelDerecho);
    }

    private JPanel crearPanelDerecho() {
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBackground(new Color(44, 62, 80));
        panelDerecho.setPreferredSize(new Dimension(380, 0));
        panelDerecho.setBorder(new EmptyBorder(25, 25, 25, 25));
        return panelDerecho;
    }

    private void añadirComponentesPanelDerecho(JPanel panelDerecho) {
        añadirSeccionEscanear(panelDerecho);
        panelDerecho.add(Box.createVerticalStrut(30));

        añadirSeccionIngresoManual(panelDerecho);
        panelDerecho.add(Box.createVerticalGlue());

        añadirSeccionCobrar(panelDerecho);
        panelDerecho.add(Box.createVerticalStrut(15));

        btnVaciarCarrito = new JButton("VACIAR CARRITO");
        configurarBoton(btnVaciarCarrito);
        btnVaciarCarrito.setBackground(Color.RED);
        btnVaciarCarrito.setForeground(Color.WHITE);
        btnVaciarCarrito.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panelDerecho.add(btnVaciarCarrito);
    }

    private void añadirSeccionEscanear(JPanel panelDerecho) {
        JLabel lblEscanear = crearLabel("ESCANEAR PRODUCTO", 16, Font.BOLD);
        panelDerecho.add(lblEscanear);
        panelDerecho.add(Box.createVerticalStrut(10));

        txtCodigo = crearTextField();
        panelDerecho.add(txtCodigo);
    }

    private void añadirSeccionIngresoManual(JPanel panelDerecho) {
        panelDerecho.add(crearLabel("INGRESO MANUAL", 16, Font.BOLD));
        panelDerecho.add(Box.createVerticalStrut(15));

        panelDerecho.add(crearLabel("Descripción", 13, Font.PLAIN));
        txtDescripcion = crearTextField();
        panelDerecho.add(txtDescripcion);
        panelDerecho.add(Box.createVerticalStrut(10));

        panelDerecho.add(crearLabel("Precio", 13, Font.PLAIN));
        txtPrecio = crearTextField();
        panelDerecho.add(txtPrecio);
        panelDerecho.add(Box.createVerticalStrut(15));

        btnAñadirManual = new JButton("Añadir al carrito");
        configurarBoton(btnAñadirManual);
        btnAñadirManual.setBackground(new Color(52, 73, 94));
        btnAñadirManual.setForeground(Color.WHITE);
        btnAñadirManual.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelDerecho.add(btnAñadirManual);
    }

    private void añadirSeccionCobrar(JPanel panel) {
        lblProductos = crearLabel("Items seleccionados: 0", 14, Font.PLAIN);
        panel.add(lblProductos);
        panel.add(Box.createVerticalStrut(10));

        lblTotalVender = crearLabel("TOTAL: $0", 35, Font.BOLD);
        lblTotalVender.setForeground(new Color(46, 204, 113));
        panel.add(lblTotalVender);
        panel.add(Box.createVerticalStrut(20));

        btnCobrar = new JButton("COBRAR");
        configurarBoton(btnCobrar);
        btnCobrar.setBackground(new Color(46, 204, 113));
        btnCobrar.setForeground(Color.WHITE);
        btnCobrar.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panel.add(btnCobrar);
    }

    private void añadirPanelCentral(JPanel panel) {
        JPanel panelCentral = crearPanelCentral();
        panel.add(panelCentral, BorderLayout.CENTER);

        añadirComponentesPanelCentral(panelCentral);
    }

    private static JPanel crearPanelCentral() {
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setBorder(new EmptyBorder(25, 25, 25, 25));
        return panelCentral;
    }

    private void añadirComponentesPanelCentral(JPanel panelCentral) {
        tablaVenta = new JTable(new DefaultTableModel(columnas_tabla, 0));
        tablaVenta.setRowHeight(45);
        tablaVenta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tablaVenta.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablaVenta.setGridColor(new Color(240, 240, 240));

        JScrollPane scroll = new JScrollPane(tablaVenta);
        panelCentral.add(scroll, BorderLayout.CENTER);
    }

    // métodos auxiliares

    private JLabel crearLabel(String texto, int size, int style) {
        JLabel lbl = new JLabel(texto);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Segoe UI", style, size));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lbl;
    }

    private JTextField crearTextField() {
        JTextField txt = new JTextField();
        txt.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txt.setBackground(new Color(52, 73, 94));
        txt.setForeground(Color.WHITE);
        txt.setCaretColor(Color.WHITE);
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txt.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(72, 93, 114)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txt.setAlignmentX(Component.LEFT_ALIGNMENT);
        return txt;
    }

    private void configurarBoton(JButton btn) {
        btn.setMinimumSize(new Dimension(Integer.MAX_VALUE, 35));
        btn.setPreferredSize(new Dimension(Integer.MAX_VALUE, 35));
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    // métodos del controlador

    public JButton getBtnCobrar() {
        return this.btnCobrar;
    }

    public void mostrar() {
        this.setVisible(true);
    }

    // main para probar la interfaz

    public static void main(String[] args) {
        FrmPuntoDeVenta p = new FrmPuntoDeVenta();
        p.mostrar();
    }

}