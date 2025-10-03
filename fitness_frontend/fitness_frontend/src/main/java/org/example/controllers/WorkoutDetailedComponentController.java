package org.example.controllers;

import org.example.components.WorkoutDetailedComponent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WorkoutDetailedComponentController
{
        private WorkoutDetailedComponent comp;

        public WorkoutDetailedComponentController(WorkoutDetailedComponent comp)
        {
                this.comp = comp;
                Init();
        }

        private void Init()
        {
                // initially, save button is hidden
                comp.GetSaveButton().setVisible(false);

                comp.GetEditButton().setOnAction(e -> {
                        comp.GetEditButton().setVisible(false);
                        comp.GetSaveButton().setVisible(true);

                        comp.GetWorkoutNameField().setDisable(false);
                        comp.GetWorkoutDateField().setDisable(false);
                });

                comp.GetSaveButton().setOnAction(e -> {
                        comp.GetEditButton().setVisible(true);
                        comp.GetSaveButton().setVisible(false);

                        comp.GetWorkoutNameField().setDisable(true);
                        comp.GetWorkoutDateField().setDisable(true);
                });
        }

}
