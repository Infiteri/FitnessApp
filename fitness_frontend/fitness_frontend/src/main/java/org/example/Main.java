package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.utils.Utils;
import org.example.utils.ViewNavigator;
import org.example.views.LoginView;

public class Main extends Application
{
        @Override
        public void start(Stage stage)
        {
                stage.setTitle("Fitness Frontend");
                stage.setResizable(true);

                ViewNavigator.SetMainStage(stage);

                new LoginView().Show();
        }
}
