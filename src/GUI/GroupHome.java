/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Enteties.Group;
import Enteties.User;
import Services.ServiceGroupe;
import Services.ServiceUser;
import Utils.UserSession;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author Me
 */
public class GroupHome extends Form{
    ArrayList<Group> myGroups;
    
     public GroupHome(User u,Form previous) {
                     UserSession.setInstance(u);

         Button btnGroup = new Button("New Group");
         add(btnGroup);
         btnGroup.addActionListener((evt) -> {
             addGroup addg=new addGroup(u,this);
             addg.show();
         });
         myGroups=ServiceGroupe.getInstance().getByGroup(u.getId());

        setTitle("Groups Of "+u.getFirst_name()+" "+u.getLast_name());
        setLayout(BoxLayout.y());
        Toolbar tb =getToolbar();
        for(Group g:myGroups){
        Container hb=new Container();
        hb.add(new Label(g.getNom()));
        hb.add(new Label(g.getDescription()));
       add(hb);
        }


tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, (evt) -> {
    previous.show();
})    ;
       
        
        
        
        
        
    }
}
