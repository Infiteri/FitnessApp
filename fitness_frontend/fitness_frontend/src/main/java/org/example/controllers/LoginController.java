package org.example.controllers;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import org.example.models.User;
import org.example.utils.SqlUtils;
import org.example.utils.Utils;
import org.example.views.DashboardView;
import org.example.views.LoginView;
import org.example.views.SignUpView;

public class LoginController
{
        private LoginView view;

        public LoginController(LoginView loginView)
        {
                this.view = loginView;
                Init();
        }

        private void Init()
        {

                view.GetLoginButton().setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                        @Override
                        public void handle(MouseEvent mouseEvent)
                        {
                                if (!ValidateUser())
                                        return;

                                String phone = Utils.FormatPhoneNumber(view.GetPhoneNumberTextField().getText());
                                String password = view.GetPasswordField().getText();

                                if (!SqlUtils.PostLoginUser(phone, password))
                                {
                                        Utils.ShowAlertDialog(Alert.AlertType.ERROR, "Couldn't Login In, Invalid Credentials :(");
                                } else
                                {
                                        User user = SqlUtils.GetUserByPhoneNumber(phone);
                                        new DashboardView(user).Show();
                                }
                        }
                });

                view.GetSignupLabel().setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                        @Override
                        public void handle(MouseEvent mouseEvent)
                        {
                                new SignUpView().Show();
                        }
                });

        }

        private boolean ValidateUser()
        {
                if (view.GetPasswordField().getText().isEmpty()) return false;

                // validate phone
                String phone = view.GetPhoneNumberTextField().getText();
                if (!Utils.ValidatePhoneNumber(phone)) return false;

                return true;
        }
}
