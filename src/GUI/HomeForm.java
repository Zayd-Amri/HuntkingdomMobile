/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Enteties.Article;
import Enteties.User;
import Services.ServiceAnnonce;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.LEFT;
import static com.codename1.ui.CN.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author sana
 */
public class HomeForm extends Form{
    Form f;
     Picker imgpicker;
    TextField ttitre;
    TextField tcategorie;
    TextField tgouv;
    TextField tville;
    TextField tdesc;
    TextField tnumtel;
    TextField tprix;
    Label l ;
    Label lprix ;
    Label ltitre ;
    Label lcat ;
    Label lgouv ;
    Label lville ;
    Label ldesc;
    Label lnum ;
    Container pri;
    Button btnajout,btnaff,btnupdate;
    Button btn ;
    
    
    public HomeForm() {
              pri = new Container(BoxLayout.y());
                          Container tit = new Container(BoxLayout.y());
                                                    Container tit1 = new Container(BoxLayout.x());

             Container cat = new Container(BoxLayout.y());
                          Container cat1 = new Container(BoxLayout.x());

             Container gouv = new Container(BoxLayout.y());
                          Container gouv1 = new Container(BoxLayout.x());

             Container vi = new Container(BoxLayout.y());

             Container desc = new Container(BoxLayout.y());


             Container num = new Container(BoxLayout.y());
                          Container num1 = new Container(BoxLayout.x());

                          Container butt = new Container(BoxLayout.x());

lprix = new Label("prix", "");
ltitre = new Label("Titre","");
lcat = new Label("Categorie","");
lgouv = new Label("Gouvernorat","");
lville = new Label("Ville","");
ldesc = new Label("Description","");
lnum = new Label("Numtel","");

 Image img;
     String ulr1 ="http://localhost/img/";
     imgpicker = new Picker();
           this.imgpicker.setType(Display.PICKER_TYPE_STRINGS);
               imgpicker.setStrings("alaba","dog","elephant","lazy","lion");
                 imgpicker.setSelectedString("lazy");
                 
           
           
           
        f = new Form("Add annonce",new FlowLayout(CENTER,LEFT));
        
       // l= new Label("Ajouter une annonce","");
        tprix= new TextField("","Prix",10,10);
        ttitre = new TextField("","Titre",10,10);
        tcategorie = new TextField("","Categorie",10,10);
                tgouv = new TextField("","Gouvernorat",10,10);
        tville = new TextField("","Ville",10,10);
        tdesc = new TextField("","Description",10,10);
        tnumtel = new TextField("","Numtel",10,10);

        btnajout = new Button("Ajouter");
        btnaff=new Button("Affichage");
                btnupdate = new Button("modifier");
                        btn=new Button("Display");

                pri.addAll(lprix,tprix);
                tit.addAll(ltitre,ttitre);

                cat.addAll(lcat,tcategorie);
                gouv.addAll(lgouv,tgouv);
                vi.addAll(lville,tville);
                desc.addAll(ldesc,tdesc);
                
                num.addAll(lnum,tnumtel);
                
            //    f.add(imgpicker);
                
butt.addAll(btnajout,btn);
                tit1.addAll(pri,tit);
                cat1.addAll(cat,desc);
                gouv1.addAll(gouv,vi);
                num1.addAll(num,imgpicker);

     //   f.add(l);
       
     f.add(tit1);
     f.addAll(cat1);
     f.addAll(gouv1);
     f.add(num1);
     f.add(butt);
      //  f.add(btnajout);
      //  f.add(btnaff);
          //     f.add(btnupdate);
        btnajout.addActionListener((e) -> {
            
            ServiceAnnonce ser = new ServiceAnnonce();
            Article A = new Article();
            // String zzz = tprix.getText();
           // float yyy = Float.parseFloat(zzz);



  if (tprix.getText().equals("")| ttitre.getText().equals("")| tcategorie.getText().equals("")
          | tgouv.getText().equals("")| tville.getText().equals("")| tdesc.getText().equals("")| tnumtel.getText().equals("")){
                           Dialog.show("Champs vide"," Veuillez remplir tous les champs ","Ok",null);

}
           else{
   String imgpickervalue= imgpicker.getText();
  
             float fa = Float.parseFloat(tprix.getText());
            String g = tnumtel.getText();
            int fz = Integer.parseInt(g);
            Article t = new Article(fa,ttitre.getText(), tcategorie.getText(),
                    tdesc.getText(),tgouv.getText(), tville.getText(),fz,imgpickervalue.concat(".jpg"));
          ser.ajoutProduit(t);
  }
        });
      /*  btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });*/
        btn.addActionListener((e)->{
        GUI.Display a=new GUI.Display();
        a.getFF().show();
        });
      
      Toolbar tb = f.getToolbar();

//tb.addMaterialCommandToSideMenu("Ajout", FontImage.MATERIAL_HOME, e -> {}); 
//tb.addMaterialCommandToSideMenu("display", FontImage.MATERIAL_WEB, e -> {});
//tb.addMaterialCommandToSideMenu("delete", FontImage.MATERIAL_SETTINGS, e -> {
//deletearticle a=new deletearticle();
  //      a.getF().show();
//});

tb.addMaterialCommandToLeftBar(" Back", FontImage.MATERIAL_BACKSPACE, e -> {
    GUI.Display a =new GUI.Display();
        a.getFF().show();
});
/*tb.addMaterialCommandToSideMenu("About", FontImage.MATERIAL_INFO, e -> {});
           btnupdate.addActionListener((e) -> {
            ServiceProduit ser = new ServiceProduit();
            Article t = new Article(ttitre.getText(), tcategorie.getText());
          ser.updateProduit(t);
        });*/
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return ttitre;
    }

    public void setTnom(TextField tnom) {
        this.ttitre = tnom;
    }

    public TextField getTcategorie() {
        return tcategorie;
    }

    public void setTcategorie(TextField tcategorie) {
        this.tcategorie = tcategorie;
    }

    public TextField getTgouv() {
        return tgouv;
    }

    public void setTgouv(TextField tgouv) {
        this.tgouv = tgouv;
    }

    public TextField getTville() {
        return tville;
    }

    public void setTville(TextField tville) {
        this.tville = tville;
    }

    public TextField getTdesc() {
        return tdesc;
    }

    public void setTdesc(TextField tdesc) {
        this.tdesc = tdesc;
    }

    public TextField getTnumtel() {
        return tnumtel;
    }

    public void setTnumtel(TextField tnumtel) {
        this.tnumtel = tnumtel;
    }

    public TextField getTprix() {
        return tprix;
    }

    public void setTprix(TextField tprix) {
        this.tprix = tprix;
    }

   

}
