package com.mathias.puntodeventa.controller.puntodeventa;

import com.mathias.puntodeventa.view.puntodeventa.DlgCobrar;
import com.mathias.puntodeventa.view.puntodeventa.FrmPuntoDeVenta;

public class PuntoDeVentaController {

    private final FrmPuntoDeVenta vista;

    public PuntoDeVentaController(FrmPuntoDeVenta vista) {
        this.vista = vista;

        configurarListeners();
    }

    private void configurarListeners() {
        this.vista.getBtnCobrar().addActionListener(e -> abrirDialogCobrar());
    }

    private void abrirDialogCobrar() {
        DlgCobrar vista = new DlgCobrar(this.vista);

        CobrarController controlador = new CobrarController(vista);

        controlador.mostrar();
    }

    public void mostrar() {
        this.vista.mostrar();
    }

}
