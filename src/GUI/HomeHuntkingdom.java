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
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author Me
 */
public class HomeHuntkingdom extends Form{
    public HomeHuntkingdom(User u) {
        
        System.out.println("GUI.HomeHuntkingdom.<init>()");
        setTitle("welcome "+u.getFirst_name()+" "+u.getLast_name());
        setLayout(BoxLayout.y());
        Toolbar tb =getToolbar();
        Label Title = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
"Pellentesque id ante ultricies nisi volutpat viverra sit amet sit amet dolor.\n" +
"Morbi sit amet tellus viverra, suscipit ante sit amet, accumsan felis.\n" +
"Etiam a erat condimentum, dictum felis nec, vulputate diam.\n" +
"Cras porta mauris non augue sodales consequat eget vitae tel");
        Label userName =new Label(u.getUsername());
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {}); 
tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_EVENT, e -> {});
tb.addMaterialCommandToSideMenu("Groups", FontImage.MATERIAL_GROUP, e -> {new GroupHome(u, this).show();});
tb.addMaterialCommandToSideMenu("E-shop", FontImage.MATERIAL_SHOP, e -> {});
tb.addMaterialCommandToSideMenu("About", FontImage.MATERIAL_INFO, e -> {});

add(userName);
    
        add(Title);
    }
    
}
