package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;

public class Handle {
    private Handle() {
    }

    public static void error(String error) {
        System.err.println(error);
        Ui.popup(error, "An error has occurred", JOptionPane.WARNING_MESSAGE);
    }
}
