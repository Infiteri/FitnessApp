package org.example.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.models.Workout;

public class WorkoutComponent extends HBox
{
        private Label workoutName, workoutDateTime;
        private Workout workout;

        public WorkoutComponent(Workout workout)
        {
                super();
                this.workout = workout;
                Init();
        }

        private void Init()
        {
                if (workout == null) return;

                // name label
                workoutName = new Label(workout.GetName());
                workoutName.getStyleClass().addAll("text-size-md", "text-white", "text-weight-700");

                // datetime label
                workoutDateTime = new Label(workout.GetWorkoutDateTime().toString());
                workoutDateTime.getStyleClass().addAll("text-size-sm", "text-light-gray");

                // vertical container for labels
                VBox textContainer = new VBox(workoutName, workoutDateTime);
                textContainer.setSpacing(5);

                // apply styling to WorkoutComponent itself
                getStyleClass().addAll(
                        "bg-gray-600",
                        "border-2",
                        "border-gray-800",
                        "rounded-md",
                        "cursor-pointer",
                        "hover:bg-gray-500"
                ); // todo: Fix hover


                setSpacing(15);
                setPadding(new Insets(10));
                getChildren().add(textContainer);
        }
}
