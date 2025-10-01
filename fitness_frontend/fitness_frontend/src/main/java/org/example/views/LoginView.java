package org.example.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.controllers.LoginController;
import org.example.utils.Utils;
import org.example.utils.ViewNavigator;
import org.example.utils.ViewUtils;

public class LoginView
{
        private Label loginLabel = new Label("Fitness :)");
        private TextField phoneNumberTextField = new TextField();
        private PasswordField passwordField = new PasswordField();
        private Button loginButton = new Button("Login");
        private Label signupLabel = new Label("Signup if you need to :)");

        public void Show()
        {
                Scene scene = CreateScene();
                scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

                ViewNavigator.SwitchView(scene);

                new LoginController(this);
        }


        private Scene CreateScene()
        {
                VBox root = new VBox(72);
                root.setAlignment(Pos.TOP_CENTER);
                root.getStyleClass().addAll("main-background");

                // style
                {
                        loginLabel.getStyleClass().addAll("text-white", "header");

                        ViewUtils.StyleField(phoneNumberTextField, "Enter Phone Number...");
                        ViewUtils.StyleField(passwordField, "Enter Password...");

                        ViewUtils.StyleButton(loginButton);

                        ViewUtils.StyleLinkLabel(signupLabel);
                }

                root.getChildren().addAll(loginLabel, phoneNumberTextField, passwordField, loginButton, signupLabel);

                return new Scene(root, Utils.APP_WIDTH, Utils.APP_HEIGHT);
        }

        public Label GetLoginLabel()
        {
                return loginLabel;
        }

        public void SetLoginLabel(Label loginLabel)
        {
                this.loginLabel = loginLabel;
        }

        public TextField GetPhoneNumberTextField()
        {
                return phoneNumberTextField;
        }

        public void SetPhoneNumberTextField(TextField phoneNumberTextField)
        {
                this.phoneNumberTextField = phoneNumberTextField;
        }

        public PasswordField GetPasswordField()
        {
                return passwordField;
        }

        public void SetPasswordField(PasswordField passwordField)
        {
                this.passwordField = passwordField;
        }

        public Button GetLoginButton()
        {
                return loginButton;
        }

        public void SetLoginButton(Button loginButton)
        {
                this.loginButton = loginButton;
        }

        public Label GetSignupLabel()
        {
                return signupLabel;
        }

        public void SetSignupLabel(Label signupLabel)
        {
                this.signupLabel = signupLabel;
        }
}
