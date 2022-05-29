/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ServiceUser;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author AmineMissaoui
 */
public class Home {

    Form f;
    SpanLabel lb;
  
    public Home() {
        
        f = new Form("Home",BoxLayout.y());
        lb = new SpanLabel("");
        f.add(lb);
        f.getToolbar().addCommandToLeftSideMenu("Home", null, (evtPageOne) -> {
        
        });
        f.getToolbar().addCommandToLeftSideMenu("Events", null, (evtPageOne) -> {
        
        });
        f.getToolbar().addCommandToLeftSideMenu("Annonce", null, (evtPageOne) -> {
        
        });
        f.getToolbar().addCommandToLeftSideMenu("Groups", null, (evtPageOne) -> {
        
        });
        f.getToolbar().addCommandToLeftSideMenu("Calendar", null, (evtPageOne) -> {
        
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
