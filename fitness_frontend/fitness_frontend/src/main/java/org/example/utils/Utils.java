package org.example.utils;

import javafx.scene.control.Alert;

public class Utils
{
        public static final int APP_WIDTH = 1280;
        public static final int APP_HEIGHT = 720;

        public static void ShowAlertDialog(Alert.AlertType alertType, String message)
        {
                Alert alert = new Alert(alertType);
                alert.setContentText(message);
                alert.showAndWait();
        }

        public static boolean ValidatePhoneNumber(String phone)
        {
                if (phone.isEmpty()) return false;
                if (!phone.startsWith("+")) return false;
                if (!phone.matches("^\\+[0-9]+$")) return false;

                return true;
        }

        public static String FormatPhoneNumber(String phone)
        {
                return phone.replaceFirst("\\+", "%2B");
        }

}


