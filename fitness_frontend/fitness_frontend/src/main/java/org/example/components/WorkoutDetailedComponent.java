package org.example.components;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.controllers.WorkoutDetailedComponentController;
import org.example.models.Workout;

public class WorkoutDetailedComponent extends VBox
{
        private TextField workoutName;
        private TextField workoutDate;

        private Button editButton = new Button("Edit");
        private Button saveButton = new Button("Save");
        private Button deleteButton = new Button("Delete");

        private Workout workout;

        private HBox buttonBox;

        public WorkoutDetailedComponent()
        {
                super(10);
                getStyleClass().addAll("bg-gray-600", "p-4", "rounded-md");

                workoutName = new TextField("Select a workout...");
                workoutName.setEditable(false);
                workoutName.getStyleClass().addAll("text-size-md", "text-white", "font-bold", "field-background");

                workoutDate = new TextField();
                workoutDate.setEditable(false);
                workoutDate.getStyleClass().addAll("text-size-sm", "text-light-gray", "field-background");

                buttonBox = new HBox(10);

                editButton.getStyleClass().addAll("bg-light-blue", "text-size-md");
                saveButton.getStyleClass().addAll("bg-light-yellow", "text-size-md");
                deleteButton.getStyleClass().addAll("bg-light-red", "text-size-md");

                editButton.managedProperty().bind(editButton.visibleProperty());
                saveButton.managedProperty().bind(saveButton.visibleProperty());
                deleteButton.managedProperty().bind(deleteButton.visibleProperty());

                buttonBox.getChildren().addAll(editButton, saveButton, deleteButton);

                getChildren().addAll(workoutName, workoutDate, buttonBox);

                editButton.setVisible(false);
                saveButton.setVisible(false);
                deleteButton.setVisible(false);

                new WorkoutDetailedComponentController(this);
        }

        public void setWorkout(Workout workout)
        {
                this.workout = workout;

                if (workout == null) {
                        workoutName.setText("Select a workout...");
                        workoutDate.setText("");
                        editButton.setVisible(false);
                        saveButton.setVisible(false);
                        deleteButton.setVisible(false);
                        return;
                }

                workoutName.setText(workout.GetName());
                workoutDate.setText(workout.GetWorkoutDateTime().toString());

                editButton.setVisible(true);
                saveButton.setVisible(false);
                deleteButton.setVisible(true);
        }

        public TextField GetWorkoutNameField() { return workoutName; }
        public TextField GetWorkoutDateField() { return workoutDate; }

        public Button GetEditButton() { return editButton; }
        public Button GetSaveButton() { return saveButton; }
        public Button GetDeleteButton() { return deleteButton; }

        public Workout GetWorkout() { return workout; }
}
