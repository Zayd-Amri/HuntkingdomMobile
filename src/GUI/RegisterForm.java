/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Enteties.User;
import Services.ServiceUser;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author AmineMissaoui
 */
public class RegisterForm {
    Form f;
    
    public RegisterForm(){
        f = new Form("Register", BoxLayout.y());
        Container wrapper = new Container(BoxLayout.y());
        Label Title = new Label("Register");
        TextField tfFirstName = new TextField("", "First name");
        TextField tfLastName = new TextField("", "Last name");
        TextField tfUsername = new TextField("", "Username");
        TextField tfPassword = new TextField("", "Password");
        tfPassword.setConstraint(TextField.PASSWORD);
        TextField tfEmail = new TextField("", "Email");
        tfEmail.setConstraint(tfEmail.EMAILADDR);
        Picker birthDate = new Picker();
        TextArea adress = new TextArea("Adress");
        TextField tfSate = new TextField("", "State");
        TextField tfCity = new TextField("", "City");
        Button register = new Button("Register");
        wrapper.addAll(Title,tfFirstName,tfLastName,tfUsername,tfPassword,tfEmail,birthDate,adress,tfSate,tfCity,register);
        register.addActionListener((evt) -> {
            ServiceUser se = new ServiceUser();
            if((tfFirstName.getText().equals(""))||(tfLastName.getText().equals(""))||(tfUsername.getText().equals("")
                    || (tfPassword.getText().equals("")) || (tfEmail.getText().equals("")))){
                Dialog.show("Error", "Please fill the form correctly", "OK", null);
            }else{
            User u = new User(tfFirstName.getText(),tfLastName.getText(),tfUsername.getText(),tfPassword.getText(),
            tfEmail.getText(),birthDate.getValue().toString(),adress.getText(),tfSate.getText(),tfCity.getText() );
            se.addUser(u);  
            }
        });
        f.add(wrapper);      
        
    }
        public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
