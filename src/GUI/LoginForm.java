/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Enteties.User;
import Services.ServiceUser;
import Utils.UserSession;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author AmineMissaoui
 */

public class LoginForm extends Form{
    User u=new User();
    Form f;
    public LoginForm() {
        f = new Form("Login", new FlowLayout(CENTER, CENTER));
        Container wrapper = new Container(BoxLayout.y());
        //ImageViewer logo = new ImageViewer(theme.getImage("hk.png"));
        Label Title = new Label("Login");
        TextField tfLogin = new TextField("", "Username");
        TextField tfPassword = new TextField("", "Password");
        tfPassword.setConstraint(TextField.PASSWORD);
        Button btnLogin = new Button("Login");
        Label register = new Label("register");
        wrapper.addAll(Title,tfLogin,tfPassword,btnLogin,register);
        btnLogin.addActionListener((evt) -> {
            Home h=new Home();
        h.getF().show();
        });
        register.addPointerPressedListener((evt) -> {
            RegisterForm r = new RegisterForm();
            r.getF().show();
        });
        f.add(wrapper);
        btnLogin.addActionListener((evt) -> {
            
            u=ServiceUser.getInstance().getByUsername(tfLogin.getText());
            UserSession.setInstance(u);
                    new HomeHuntkingdom(u).show();
            
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
