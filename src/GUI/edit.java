/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Enteties.Article;
import Services.ServiceAnnonce;
import Services.ServiceAnnonce;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.table.TableLayout;

/**
 *
 * @author FOCUS
 */
public class edit {
    
    
    Form f;
    TextField title;
    TextField price;
    TextField cat;
    TextField gouv;
    TextField vi;
    TextField desc;
    TextField num;


     Container c1 = new Container(BoxLayout.x());
     
     public edit(){
         
          TableLayout tl;
int spanButton = 2;
if(Display.getInstance().isTablet()) {
    tl = new TableLayout(14, 8);
} else {
    tl = new TableLayout(20, 5);
    spanButton = 1;
}
tl.setGrowHorizontally(true);
           f = new Form("Update Annonce");
            Container c = new Container(BoxLayout.x());
                     Services.ServiceAnnonce serviceTask=new ServiceAnnonce();
        ArrayList<Article> lis=serviceTask.getArticle();
       // Container namehotelc = new Container(BoxLayout.x());
       
         price = new TextField("price");
       f.add(price);
         title = new TextField("title");
       f.add(title);
        cat = new TextField("cat");
       f.add(cat);
        gouv = new TextField("gouv");
       f.add(gouv);
        vi = new TextField("vi");
       f.add(vi);
        desc = new TextField("desc");
       f.add(desc);
       num = new TextField("num");
       f.add(num);
        for (Article E : lis){
        Label fff = new Label("Prix :" +E.getPrix());
        Container DetailsEvent = new Container(BoxLayout.y());
         f.add(ComponentGroup.enclose(fff,new Label("Titre :" +E.getTitre()),new Label("Categorie :" +E.getCategorie()),new Label("Gouvernorat :" +E.getGouvernorat())
         ,new Label("Ville :" +E.getVille()),new Label("Description :" +E.getDescription()),new Label("Numtel :" +E.getNumtel())));
           Button b =new Button("UPDATE");
         // f.add(b);
        Button bs =new Button("SET");
       //   f.add(bs);
       DetailsEvent.addAll(b,bs);
       f.add(DetailsEvent);
          /// SET 
            bs.addActionListener((e) -> {
         
         price.setText(String.valueOf(E.getPrix()));
         title.setText(E.getTitre());
         cat.setText(E.getCategorie());

         gouv.setText(E.getGouvernorat());
         vi.setText(E.getVille());
         desc.setText(E.getDescription());
         num.setText(String.valueOf(E.getNumtel()));

        f.refreshTheme();
    });
                        Toolbar tb = f.getToolbar();

tb.addMaterialCommandToLeftBar(" Back", FontImage.MATERIAL_BACKSPACE, e -> {
    GUI.Display a =new GUI.Display();
        a.getFF().show();
}); 
         //edit   
    b.addActionListener((e) -> {
           Services.ServiceAnnonce prod=new ServiceAnnonce();
           
              String pri = price.getText()+"\n";
              String titre = title.getText();
              String champ = cat.getText();
              String g = desc.getText();
              String v =gouv.getText();                          
              String d =vi.getText();
              String n = num.getText();
              
              float ff =Float.parseFloat(pri);
              int nn =Integer.parseInt(n);

         Article ar = new  Article(E.getId(),ff,titre,champ,g,v,d,nn);
          prod.updateProduit(ar);
          System.out.println( ar);
        f.refreshTheme();
    });
    
   
          
     }
       /*  f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             HomeForm h=new HomeForm();
          h.getF().show();
          });*/
    
}

  public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
     
     
     
}
