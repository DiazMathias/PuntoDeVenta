package com.mathias.puntodeventa.controller.menu;

import com.mathias.puntodeventa.controller.puntodeventa.PuntoDeVentaController;
import com.mathias.puntodeventa.view.menu.FrmMenu;
import com.mathias.puntodeventa.view.puntodeventa.FrmPuntoDeVenta;

public class MenuController {

    private final FrmMenu vista;

    public MenuController(FrmMenu vista) {
        this.vista = vista;

        configurarListeners();
    }

    private void configurarListeners() {
        this.vista.getBtnPuntoVenta().addActionListener(e -> abrirFormPuntoDeVenta());
    }

    private void abrirFormPuntoDeVenta() {
        FrmPuntoDeVenta vista = new  FrmPuntoDeVenta();

        PuntoDeVentaController controlador =  new PuntoDeVentaController(vista);

        controlador.mostrar();
    }

    public void mostrar() {
        this.vista.mostrar();
    }

    public static void main(String[] args) {
        FrmMenu vista = new FrmMenu();
        MenuController controlador = new MenuController(vista);
        controlador.mostrar();
    }

}