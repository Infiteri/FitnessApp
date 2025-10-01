package org.example.controllers;

import com.google.gson.JsonObject;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import org.example.utils.SqlUtils;
import org.example.utils.Utils;
import org.example.views.LoginView;
import org.example.views.SignUpView;

public class SignUpController
{
        private SignUpView view;

        public SignUpController(SignUpView view)
        {
                this.view = view;
                Init();
        }

        private void Init()
        {
                view.GetSingupButton().setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                        @Override
                        public void handle(MouseEvent mouseEvent)
                        {
                                if (!ValidateData()) return;


                                JsonObject user = new JsonObject();
                                user.addProperty("name", view.GetNameTextField().getText());
                                user.addProperty("phoneNumber", view.GetPhoneNumberTextField().getText());
                                user.addProperty("password", view.GetPasswordField().getText());
                                if(SqlUtils.PostCreateUser(user)) {
                                        Utils.ShowAlertDialog(Alert.AlertType.CONFIRMATION, "YEY");
                                } else {
                                        Utils.ShowAlertDialog(Alert.AlertType.ERROR, "NO");
                                }
                        }
                });

                view.GetLoginLabelBottom().setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent)
                        {
                                new LoginView().Show();
                        }
                });
        }

        private boolean ValidateData() {
                if(view.GetNameTextField().getText().isEmpty()) return false;
                if(view.GetPasswordField().getText().isEmpty()) return false;
                if(view.GetRePasswordField().getText().isEmpty()) return false;
                if(view.GetPhoneNumberTextField().getText().isEmpty()) return false;
                if(!view.GetPasswordField().getText().equals(view.GetRePasswordField().getText())) return false;

                if(!Utils.ValidatePhoneNumber(view.GetPhoneNumberTextField().getText())) return false;

                return true;
        }
}
