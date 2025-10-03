package org.example.views;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.example.components.WorkoutComponent;
import org.example.components.WorkoutDetailedComponent;
import org.example.models.User;
import org.example.models.Workout;
import org.example.utils.SqlUtils;
import org.example.utils.Utils;
import org.example.utils.ViewNavigator;

public class DashboardView
{
        private Label workoutsLabel = new Label("Workouts");

        private Workout selectedWorkout = null;
        private User user;

        private WorkoutDetailedComponent detailPane;

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
                SplitPane root = new SplitPane();
                root.getStyleClass().addAll("main-background");

                VBox left = new VBox(30);
                workoutsLabel.getStyleClass().addAll("header", "text-white");
                left.getChildren().addAll(workoutsLabel, CreateWorkoutsView());

                ScrollPane leftScroll = new ScrollPane(left);
                leftScroll.setFitToWidth(true);

                detailPane = new WorkoutDetailedComponent();
                root.getItems().addAll(leftScroll, detailPane);
                root.setDividerPositions(0.4);

                return new Scene(root, Utils.APP_WIDTH, Utils.APP_HEIGHT);
        }

        private VBox CreateWorkoutsView()
        {
                VBox root = new VBox(30);
                root.getStyleClass().addAll("main-background");

                var workouts = SqlUtils.GetWorkoutsByUserId(user.GetId());
                for (Workout w : workouts) {
                        WorkoutComponent comp = new WorkoutComponent(w);

                        // === add behaviour: click updates detail panel ===
                        comp.setOnMouseClicked(e -> {
                                selectedWorkout = w;
                                detailPane.setWorkout(w);
                        });

                        root.getChildren().add(comp);
                }

                return root;
        }
}
