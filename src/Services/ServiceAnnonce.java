/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enteties.Article;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Utils.PublicVars;

/**
 *
 * @author sana
 */
public class ServiceAnnonce {
    
ArrayList<Article> listProduits;
   public void ajoutProduit(Article p) {
        ConnectionRequest con = new ConnectionRequest();
        
        String Url = PublicVars.ipAdress+"/add?titre="+p.getTitre()+"&prix=" +p.getPrix()+"&categorie=" + p.getCategorie()
                +"&gouvernorat=" + p.getGouvernorat()+"&ville=" + p.getVille()+"&description=" + p.getDescription()+"&numtel=" + p.getNumtel()+"&image_ev=" + p.getImage_ev();
        con.setUrl(Url);
        con.setPost(false);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     public void updateProduit(Article p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = PublicVars.ipAdress+"/UPDATE?prix="+p.getPrix()+"&titre="+p.getTitre()+"&categorie="+ p.getCategorie()+"&gouvernorat="+ p.getGouvernorat()+"&ville="+ p.getVille()+"&description="+ p.getDescription()+"&numtel="+ p.getNumtel()+"&id="+p.getId();
        con.setUrl(Url);
        con.setPost(false);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<Article> parseProducts(String json) {
        System.out.println(json);
        ArrayList<Article> listProduits = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> obj : list) {
               Article e = new Article();
               
               float id = Float.parseFloat(obj.get("id").toString());
               e.setId((int) id);
               
               float prix = Float.parseFloat(obj.get("prix").toString());
               e.setPrix((Float)prix);
               
             
                e.setTitre(obj.get("titre").toString());
                e.setCategorie(obj.get("categorie").toString());
           e.setGouvernorat(obj.get("gouvernorat").toString());
            e.setVille(obj.get("ville").toString());
             e.setDescription(obj.get("description").toString());
 float numtel = Float.parseFloat(obj.get("numtel").toString());
               e.setNumtel((int) numtel);
               e.setImage_ev(obj.get("image_ev").toString());
                System.out.println(e);
                listProduits.add(e);
            }

        } catch (IOException ex) {
        }
        catch(NullPointerException cc){
            
        }
        return listProduits;

    }
    
     public ArrayList<Article> getArticle(){
        listProduits = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(PublicVars.ipAdress+"/article");  
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAnnonce ser = new ServiceAnnonce();
                listProduits = ser.parseProducts(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
        
    }

      public ArrayList<Article> parseListTaskJson(String json) {

        ArrayList<Article> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
             
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()))    ;
                       /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Article e = new Article(); 
               // float id = Float.parseFloat(obj.get("id").toString());
               // e.setId((int) id);
                //e.setEtat(obj.get("state").toString());
                //e.setNom(obj.get("name").toString());
                e.setDescription(obj.get("description").toString());
                
                 System.out.println("lista ");
                System.out.println(e);
                listTasks.add(e);
            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        */
        System.out.println(listTasks);
        return listTasks;
   }
   
   
   
    public void deletearticle(int id){
          ConnectionRequest con = new ConnectionRequest();
      String Url=(PublicVars.ipAdress+"/delete?id="+id); 
       con.setUrl(Url);
        con.setPost(false);
       
   
   con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
                NetworkManager.getInstance().addToQueue(con);
            }
    /* public void updateProduit(Article p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = PublicVars.ipAdress+"/UPDATE?prix="+p.getPrix()+"&titre="+p.getTitre()+"&categorie="+ p.getCategorie()+"&gouvernorat="+ p.getGouvernorat()+"&ville="+ p.getVille()+"&description="+ p.getDescription()+"&numtel="+ p.getNumtel()+"&id="+p.getId();
        con.setUrl(Url);
        con.setPost(false);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);*/
    }


