/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Enteties.Article;
import Services.ServiceAnnonce;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;


/**
 *
 * @author SAIFOUN
 */



public class Display {
    Form hi = new Form("Annonces", new BorderLayout());
  Button gofor =new Button("go");
 
  
   private Map<String, Object> createListEntry(String name, String name2,String gofor,String imagename, String coverURL) {
    Map<String, Object> entry = new HashMap<>();
    entry.put("Line1", name);
    entry.put("Line2", name2);
    entry.put("Line3", gofor);
    // entry.put("Line5", imagename);
      
    entry.put("icon_URLImage", coverURL);
    entry.put("icon_URLImageName", imagename);
    
    return entry;
            }
 
 

     public Display(){
         
                  Style s = UIManager.getInstance().getComponentStyle("Title");
         TextField searchField = new TextField("", "Toolbar Search");
         searchField.getAllStyles().setAlignment(Component.LEFT);
           // f1.add(searchField);
          /* hi.getToolbar().setTitleComponent(searchField);
        FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
        searchField.addDataChangeListener((i1, i2) -> {
            String t = searchField.getText();
            if (t.length() < 1) {
                for (Component cmp : hi.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
            } else {
                t = t.toLowerCase();
                for (Component cmp : hi.getContentPane()) {
                    String val = null;
                    if (cmp instanceof MultiList) {
                        val = ((MultiList) cmp).getInlineAllStyles();}
                    else if (cmp instanceof TextArea) {
                        val = ((TextArea) cmp).getText();
                    } else {
                        val = (String) cmp.getPropertyValue("text");
                    }
                    boolean show = val != null && val.toLowerCase().indexOf(t)
                            > -1;
                    cmp.setHidden(!show);
                    cmp.setVisible(show);
                }
            }
            hi.getContentPane().animateLayout(250);
        });
        hi.getToolbar().addCommandToRightBar( "", searchIcon,(f) -> {
            searchField.startEditingAsync();
        });*/
        ////
        hi.getToolbar().addSearchCommand(e -> {
    String text = (String)e.getSource();
    if(text == null || text.length() == 0) {
        // clear search
        for(Component cmp : hi.getContentPane()) {
            cmp.setHidden(false);
            cmp.setVisible(true);
        }
        hi.getContentPane().animateLayout(150);
    } else {
        text = text.toLowerCase();
        for(Component cmp : hi.getContentPane()) {
            MultiList mb = (MultiList)cmp;
            String line1 = mb.getName();
            boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1;
            mb.setHidden(!show);
            mb.setVisible(show);
        }
        hi.getContentPane().animateLayout(150);
    }
}, 4);
        Style ss = UIManager.getInstance().getComponentStyle("Button");
FontImage pp = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, ss);
EncodedImage placeholder555 = EncodedImage.createFromImage(pp.scaled(pp.getWidth() * 3, pp.getHeight() * 3), false);
  
   


ArrayList<Map<String, Object>> data = new ArrayList<>();

         ServiceAnnonce serviceTask1=new ServiceAnnonce();
         ArrayList<Article> arr2 =serviceTask1.getArticle();
         Toolbar tb = hi.getToolbar();

tb.addMaterialCommandToSideMenu("AJOUT", FontImage.MATERIAL_ADD, e -> {
    HomeForm a =new HomeForm();
        a.getF().show();
}); 
tb.addMaterialCommandToSideMenu("DELETE", FontImage.MATERIAL_DELETE, e -> {
    deletearticle a =new deletearticle();
        a.getF().show();
});
tb.addMaterialCommandToSideMenu("UPDATE", FontImage.MATERIAL_UPDATE, e -> {
    edit a =new edit();
        a.getF().show();
});
   for (Article temp : arr2) {
System.out.println(temp.getImage_ev());

data.add(createListEntry(
        "Titre:"+temp.getTitre(),
       " Cat: "+temp.getCategorie(),
        "Gouv :".concat(temp.getGouvernorat()),
        
        temp.getImage_ev(),
        "http://localhost/img/"+temp.getImage_ev()));
// data.add(createListEntry("A Game of Thrones", "1996",null));
DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
MultiList m1 = new MultiList(model);
m1.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form hi2 = new Form(BoxLayout.yCenter());
    //                hi2.add(ComponentGroup.encloseIn(BoxLayout.yCenter(),new Label("Prix :" +temp.getPrix()),new Label("Titre :" +temp.getTitre()),new Label("Categorie :" +temp.getCategorie()),new Label("Gouvernorat :" +temp.getGouvernorat())
     //    ,new Label("Ville :" +temp.getVille()),new Label("Description :" +temp.getDescription()),new Label("Numtel :" +temp.getNumtel())));
                //   Container c = new Container(new FlowLayout(LEFT, CENTER));
                                     // Container cc = new Container(new FlowLayout(RIGHT, CENTER));
                  // Container ccc = new Container(BoxLayout.x());
                  // Container global = new Container(new FlowLayout(CENTER));

                    SpanLabel tit = new SpanLabel("Titre:   "+temp.getTitre());
                    Label pr = new Label("Prix:   "+String.valueOf(temp.getPrix()));
                    Label cate = new Label("Categorie:   "+temp.getCategorie());
                    Label gou = new Label("Gouvernorat:   "+temp.getGouvernorat());
                    Label vil = new Label("Ville:   "+temp.getVille());
                    Label des = new Label("Description:   "+temp.getDescription());
                    Label nu = new Label("Numtel:   "+String.valueOf(temp.getNumtel()));
                   
                    
//global.getStyle().
//c.addAll(pr,tit);
//cc.addAll(cate,gou);
//ccc.addAll(vil,des);
hi2.addAll(pr,tit,cate,gou,vil,des,nu);
//hi2.add(global);
                    //Image imag2;
                    //                        imag2 = Image.createImage(arr.getImage_ev());
                    // ImageViewer iv2 = new ImageViewer(imag2);
                 //   SpanLabel s1 = new SpanLabel("World cup 2022 ! ");
                    // hi2.add(iv2);
                    //hi2.addAll(pr,tit,cate,gou,vil,des,nu);
                   // hi2.add(s1);
                   
                   
                   
                   
                   
                   
                    hi2.getToolbar().addCommandToLeftBar("Back",null,new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            hi.showBack();
                        }
                    }
                    );
                    hi2.show();
                    
                }
            });
m1.getUnselectedButton().setIconName("icon_URLImage");
m1.getSelectedButton().setIconName("icon_URLImage");
m1.getUnselectedButton().setIcon(placeholder555);
m1.getSelectedButton().setIcon(placeholder555);


hi.add(BorderLayout.CENTER, m1);
  }

hi.show();

        //Sign f = new Sign();
       
       // f.getF().show();
        
      
   //   hi.show();
    }
      
    public Form getFF() {
        return hi;
    }

    public void setFF(Form f) {
        this.hi = f;
    }

    
}
