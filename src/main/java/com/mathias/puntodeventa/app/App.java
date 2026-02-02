package com.mathias.puntodeventa.app;

import com.mathias.puntodeventa.controller.menu.MenuController;
import com.mathias.puntodeventa.view.menu.FrmMenu;

public class App {

    public static void main(String[] args) {
        // 1. Inicializamos la vista.
        FrmMenu vista = new FrmMenu();

        // 2. Inicializamos el controlador de la vista.
        MenuController controlador = new MenuController(vista);

        // 3. Mostramos la vista.
        controlador.mostrar();
    }

}
