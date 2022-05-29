/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Enteties.Group;
import Enteties.User;
import Services.ServiceGroupe;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;

/**
 *
 * @author Me
 */
public class addGroup extends Form{
   public addGroup(User u ,Form previous){
       Label nom=new Label("nom");
              Label description=new Label("Description");
              TextField tfnom=new TextField();
                            TextField tfdescription=new TextField();
Button ok=new Button("Create");

       addAll(nom,tfnom,description,tfdescription,ok);
       ok.addActionListener((evt) -> {
                  Group g=new Group(nom.getText(), description.getText(), u.getId());
ServiceGroupe.getInstance().addGroup(g);

       });
   Toolbar tb =getToolbar();
   tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
    previous.show();
})    ;
   }
    
}
