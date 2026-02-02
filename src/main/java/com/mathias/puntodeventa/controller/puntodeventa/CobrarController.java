package com.mathias.puntodeventa.controller.puntodeventa;

import com.mathias.puntodeventa.view.puntodeventa.DlgCobrar;

public class CobrarController {

    private final DlgCobrar vista;

    public CobrarController(DlgCobrar vista) {
        this.vista = vista;

        configurarListeners();
    }

    private void configurarListeners() {
        // TODO
    }

    public void mostrar() {
        this.vista.mostrar();
    }

}
