package org.example.views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.example.components.WorkoutComponent;
import org.example.models.User;
import org.example.models.Workout;
import org.example.utils.SqlUtils;
import org.example.utils.Utils;
import org.example.utils.ViewNavigator;

public class DashboardView
{
        private Label workoutsLabel = new Label("Workouts");

        private User user;

        public DashboardView(User user)
        {
                this.user = user;
        }

        public void Show()
        {
                Scene scene = CreateScene();
                scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

                ViewNavigator.SwitchView(scene);
        }

        private Scene CreateScene()
        {
                VBox root = new VBox();
                root.getStyleClass().addAll("main-background");

                // this root specific
                {
                        workoutsLabel.getStyleClass().addAll("header", "text-white");
                }

                root.getChildren().addAll(workoutsLabel,CreateWorkoutsView());

                return new Scene(root, Utils.APP_WIDTH, Utils.APP_HEIGHT);
        }

        private VBox CreateWorkoutsView()
        {
                VBox root = new VBox(30);

                var workouts = SqlUtils.GetWorkoutsByUserId(user.GetId());
                for (Workout w : workouts)
                        root.getChildren().addAll(new WorkoutComponent(w));

                return root;
        }
}
