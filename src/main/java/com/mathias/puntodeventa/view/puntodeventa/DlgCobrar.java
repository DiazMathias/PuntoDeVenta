package com.mathias.puntodeventa.view.puntodeventa;

import javax.swing.*;
import java.awt.*;

public class DlgCobrar extends JDialog {

    private JTextField txtMontoRecibido;
    private JLabel lblMontoTotal, lblMontoVuelto;
    private JButton btnConfirmar, btnCancelar;

    public DlgCobrar(JFrame parent) {
        super(parent, true);

        inicializarVentana();

        JPanel panelPrincipal = crearPanelPrincipal();
        add(panelPrincipal);

        añadirComponentesPanelPrincipal(panelPrincipal);
    }

    private void inicializarVentana() {
        setTitle("Cobrar");
        setSize(370, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(44, 62, 80));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        return panelPrincipal;
    }

    private void añadirComponentesPanelPrincipal(JPanel panelPrincipal) {
        añadirTitulo(panelPrincipal);

        panelPrincipal.add(Box.createVerticalStrut(5));

        añadirInstrucciones(panelPrincipal);

        panelPrincipal.add(Box.createVerticalStrut(25));

        añadirSeccionMontos(panelPrincipal);

        panelPrincipal.add(Box.createVerticalStrut(25));

        añadirSeccionBotones(panelPrincipal);
    }

    private void añadirTitulo(JPanel panelPrincipal) {
        JLabel lblTitulo = new JLabel("CONFIRMAR VENTA");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(lblTitulo);
    }

    private void añadirInstrucciones(JPanel panelPrincipal) {
        JLabel lblInstrucciones = new JLabel("Complete los datos para finalizar");
        lblInstrucciones.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblInstrucciones.setForeground(new Color(200, 200, 200));
        lblInstrucciones.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(lblInstrucciones);
    }

    private void añadirSeccionMontos(JPanel panelPrincipal) {
        añadirSeccionMontoTotal(panelPrincipal);
        panelPrincipal.add(Box.createVerticalStrut(25));
        añadirSeccionMontoRecibido(panelPrincipal);
        panelPrincipal.add(Box.createVerticalStrut(25));
        añadirSeccionMontoVuelto(panelPrincipal);
    }

    private void añadirSeccionMontoTotal(JPanel panelPrincipal) {
        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new BoxLayout(panelTotal, BoxLayout.X_AXIS));
        panelTotal.setOpaque(false);
        panelTotal.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblTextoTotal = new JLabel("TOTAL:");
        lblTextoTotal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTextoTotal.setForeground(Color.WHITE);

        lblMontoTotal = new JLabel("$ 0,00");
        lblMontoTotal.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblMontoTotal.setForeground(new Color(46, 204, 113));

        panelTotal.add(lblTextoTotal);
        panelTotal.add(Box.createHorizontalGlue());
        panelTotal.add(lblMontoTotal);
        panelPrincipal.add(panelTotal);
    }

    private void añadirSeccionMontoRecibido(JPanel panelPrincipal) {
        JLabel lblMontoPagado = new JLabel("MONTO RECIBIDO");
        lblMontoPagado.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMontoPagado.setForeground(Color.WHITE);
        lblMontoPagado.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtMontoRecibido = new JTextField();
        txtMontoRecibido.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtMontoRecibido.setBackground(new Color(52, 73, 94));
        txtMontoRecibido.setForeground(Color.WHITE);
        txtMontoRecibido.setCaretColor(Color.WHITE);
        txtMontoRecibido.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        txtMontoRecibido.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(72, 93, 114)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txtMontoRecibido.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelPrincipal.add(lblMontoPagado);
        panelPrincipal.add(Box.createVerticalStrut(8));
        panelPrincipal.add(txtMontoRecibido);
    }

    private void añadirSeccionMontoVuelto(JPanel panelPrincipal) {
        JPanel panelVuelto = new JPanel();
        panelVuelto.setLayout(new BoxLayout(panelVuelto, BoxLayout.X_AXIS));
        panelVuelto.setOpaque(false);
        panelVuelto.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblTextoVuelto = new JLabel("VUELTO:");
        lblTextoVuelto.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTextoVuelto.setForeground(Color.WHITE);

        lblMontoVuelto = new JLabel("$ 0,00");
        lblMontoVuelto.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblMontoVuelto.setForeground(new Color(46, 204, 113));

        panelVuelto.add(lblTextoVuelto);
        panelVuelto.add(Box.createHorizontalGlue());
        panelVuelto.add(lblMontoVuelto);
        panelPrincipal.add(panelVuelto);
    }

    private void añadirSeccionBotones(JPanel panelPrincipal) {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.setOpaque(false);
        panelBotones.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnCancelar = new JButton("CANCELAR");
        configurarBoton(btnCancelar);
        btnCancelar.setBackground(Color.RED);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));

        btnConfirmar = new JButton("COBRAR");
        configurarBoton(btnConfirmar);
        btnConfirmar.setBackground(Color.GREEN);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 16));

        panelBotones.add(btnCancelar);
        panelBotones.add(Box.createHorizontalGlue());
        panelBotones.add(btnConfirmar);

        panelPrincipal.add(panelBotones);
    }

    // métodos auxiliares

    private void configurarBoton(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // main para probar la interfaz

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DlgCobrar c = new DlgCobrar(frame);
        c.setVisible(true);
    }

}