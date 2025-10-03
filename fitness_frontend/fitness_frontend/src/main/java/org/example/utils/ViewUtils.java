package org.example.utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewUtils
{
        public static void StyleField(TextField textField, String placeHolder)
        {
                textField.getStyleClass().addAll("field-background", "text-light-gray", "text-size-lg", "rounded-border");
                textField.setPromptText(placeHolder);
                textField.setMaxWidth(473);
        }


        public static void StyleButton(Button button)
        {
                button.getStyleClass().addAll("text-size-lg", "bg-light-blue", "text-white", "text-weight-700", "rounded-border");
                button.setMaxWidth(473);
        }

        public static void StyleButton(Button button, String bgColor)
        {
                button.getStyleClass().addAll("text-size-lg", bgColor, "text-white", "text-weight-700", "rounded-border");
                button.setMaxWidth(473);
        }

        public static void StyleLinkLabel(Label label) {
                label.getStyleClass().addAll("text-size-md", "text-light-gray", "link-text");
        }
}
