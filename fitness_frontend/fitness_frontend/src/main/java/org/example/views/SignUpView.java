package org.example.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.controllers.SignUpController;
import org.example.utils.Utils;
import org.example.utils.ViewNavigator;
import org.example.utils.ViewUtils;

public class SignUpView
{
        private Label loginLabel = new Label("Fitness :)");
        private TextField nameTextField = new TextField();
        private TextField phoneNumberTextField = new TextField();
        private PasswordField passwordField = new PasswordField();
        private PasswordField rePasswordField = new PasswordField();
        private Button singupButton = new Button("Sign Up");
        private Label loginLabelBottom = new Label("Login if you have account :)");

        public void Show()
        {
                Scene scene = CreateScene();
                scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

                ViewNavigator.SwitchView(scene);
                new SignUpController(this)
                ;
        }

        private Scene CreateScene()
        {
                VBox root = new VBox(70);
                root.setAlignment(Pos.TOP_CENTER);
                root.getStyleClass().addAll("main-background");

                // style
                {
                        loginLabel.getStyleClass().addAll("text-white", "header");

                        ViewUtils.StyleField(nameTextField, "Enter Name...");
                        ViewUtils.StyleField(phoneNumberTextField, "Enter Phone Number...");
                        ViewUtils.StyleField(passwordField, "Enter Password...");
                        ViewUtils.StyleField(rePasswordField, "Reenter Password...");

                        ViewUtils.StyleButton(singupButton);

                        ViewUtils.StyleLinkLabel(loginLabelBottom);
                }

                root.getChildren().addAll(loginLabel, nameTextField, phoneNumberTextField, passwordField, rePasswordField, singupButton, loginLabelBottom);

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

        public TextField GetNameTextField()
        {
                return nameTextField;
        }

        public void SetNameTextField(TextField nameTextField)
        {
                this.nameTextField = nameTextField;
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

        public PasswordField GetRePasswordField()
        {
                return rePasswordField;
        }

        public void SetRePasswordField(PasswordField rePasswordField)
        {
                this.rePasswordField = rePasswordField;
        }

        public Button GetSingupButton()
        {
                return singupButton;
        }

        public void SetSingupButton(Button singupButton)
        {
                this.singupButton = singupButton;
        }

        public Label GetLoginLabelBottom()
        {
                return loginLabelBottom;
        }

        public void SetLoginLabelBottom(Label loginLabelBottom)
        {
                this.loginLabelBottom = loginLabelBottom;
        }
}
