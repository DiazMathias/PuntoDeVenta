package com.mathias.puntodeventa.view.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FrmMenu extends JFrame {

    private JButton btnPuntoVenta, btnInventario;

    public FrmMenu() {
        inicializarVentana();

        JPanel panelPrincipal = crearPanelPrincipal();
        this.add(panelPrincipal);

        añadirComponentesPanelPrincipal(panelPrincipal);
    }

    private void inicializarVentana() {
        this.setTitle("Lo de Marta");
        this.setSize(450, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(44, 62, 80));
        panel.setBorder(new EmptyBorder(40, 40, 40, 40));
        return panel;
    }

    private void añadirComponentesPanelPrincipal(JPanel panel) {
        añadirTitulo(panel);

        panel.add(Box.createVerticalStrut(10));

        añadirSubtitulo(panel);

        panel.add(Box.createVerticalStrut(50));

        this.btnPuntoVenta = new JButton("PUNTO DE VENTA");
        configurarBoton(this.btnPuntoVenta);
        panel.add(this.btnPuntoVenta);

        panel.add(Box.createVerticalStrut(20));

        this.btnInventario = new JButton("INVENTARIO");
        configurarBoton(this.btnInventario);
        panel.add(this.btnInventario);
    }

    private void añadirTitulo(JPanel panel) {
        JLabel lblTitulo = new JLabel("LO DE MARTA");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(new Color(52, 152, 219));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTitulo);
    }

    private static void añadirSubtitulo(JPanel panel) {
        JLabel lblSubtitulo = new JLabel("Sistema de Gestión");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(Color.WHITE);
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblSubtitulo);
    }

    private void configurarBoton(JButton btn) {
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        btn.setBackground(new Color(52, 73, 94));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(72, 93, 114)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    // métodos del controlador

    public JButton getBtnPuntoVenta() {
        return this.btnPuntoVenta;
    }

    public JButton getBtnInventario() {
        return this.btnInventario;
    }

    public void mostrar() {
        this.setVisible(true);
    }

}