package com.example.utils.menuUtils;

import com.example.controllers.menu.AddDishToMenuController;
import com.example.controllers.menu.RemoveDishFromMenuController;
import com.example.controllers.menu.UpdateDishFromMenuController;
import com.example.utils.consoleUtils.ConsoleUtils;

public class ManageMenuUtils {
    private final AddDishToMenuController addDishToMenuController;
    private final RemoveDishFromMenuController removeDishFromMenuController;
    private final UpdateDishFromMenuController updateDishFromMenuController;
    private final ConsoleUtils console;

    public ManageMenuUtils(AddDishToMenuController addDishToMenuController, RemoveDishFromMenuController removeDishFromMenuController, UpdateDishFromMenuController updateDishFromMenuController, ConsoleUtils console) {
        this.addDishToMenuController = addDishToMenuController;
        this.removeDishFromMenuController = removeDishFromMenuController;
        this.updateDishFromMenuController = updateDishFromMenuController;
        this.console = console;
    }

    public void manageMenu() {
        System.out.println("Opciones del Menú:");
        System.out.println("1. Agregar Plato");
        System.out.println("2. Eliminar Plato");
        System.out.println("3. Actualizar Plato");
        System.out.println("0. Volver");
        int menuChoice = console.getInteger("Elige una opción: ");
        switch (menuChoice) {
            case 1 -> addDishToMenuController.addDishToMenu();
            case 2 -> removeDishFromMenuController.removeDishFromMenu();
            case 3 -> updateDishFromMenuController.updateDishFromMenu();
            case 0 -> {
            }
            default -> System.out.println("Opción no válida.");
        }
    }
}