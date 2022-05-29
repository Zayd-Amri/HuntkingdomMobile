/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Enteties.Article;
import Services.ServiceAnnonce;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import java.util.ArrayList;

/**
 *
 * @author SAIFOUN
 */
public class deletearticle {
    
    Form f;
    SpanLabel sb;
   
    Button btnaffimage;
    
    
       //TextArea lb;
    Container c = new Container(BoxLayout.x());
    
  
    public deletearticle() {   
         f = new Form("Delete Annonce");

      
      
        btnaffimage=new Button("DISPLAY");
         Services.ServiceAnnonce serviceTask=new ServiceAnnonce();
        ArrayList<Article> lista=serviceTask.getArticle();
        //Container c0 = new Container(BoxLayout.x());
        //c0.add(new Label("Nom Events"));
     
       // Container namehotelc = new Container(BoxLayout.x());
                   
        for (Article E : lista){
       
        Label fff = new Label("Prix :" +E.getPrix());

f.add(ComponentGroup.enclose(fff,new Label("Titre :" +E.getTitre()),new Label("Categorie :" +E.getCategorie()),new Label("Gouvernorat :" +E.getGouvernorat())
         ,new Label("Ville :" +E.getVille()),new Label("Description :" +E.getDescription()),new Label("Numtel :" +E.getNumtel())));          Button b =new Button("DELETE");
          f.add(b);
         
    b.addActionListener((e) -> {
            ServiceAnnonce ser = new ServiceAnnonce();
           ser.deletearticle(E.getId());
    });
             Toolbar tb = f.getToolbar();

tb.addMaterialCommandToLeftBar(" Back", FontImage.MATERIAL_BACKSPACE, e -> {
    Display a =new Display();
        a.getFF().show();
});
      
        
        
    
    }
    }
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
}
