package org.example.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator
{
        private static Stage mainStage;

        public static void SetMainStage(Stage stage)
        {
                mainStage = stage;
        }

        public static void SwitchView(Scene scene)
        {
                if (mainStage != null)
                {
                        mainStage.setScene(scene);
                        mainStage.show();
                }
        }
}
