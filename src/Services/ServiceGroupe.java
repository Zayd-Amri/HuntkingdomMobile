/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enteties.Group;
import Enteties.User;
import Utils.PublicVars;
import Utils.UserSession;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Me
 */
public class ServiceGroupe {
     private boolean resultOK;
    public static ServiceGroupe instance;
    private ConnectionRequest req;
    User userConnected = new User();
    public ServiceGroupe(){
    req=new ConnectionRequest();
    }
    public static ServiceGroupe getInstance(){
        if (instance==null){
        instance=new ServiceGroupe();}
        return instance;
    }
    ArrayList<Group> result;

     public boolean addGroup(Group g) {
        String Url = PublicVars.ipAdress + "addGroup?nom="+g.getNom()+"&description="+g.getDescription()+"&creator_id="+UserSession.getInstance().getId();
        req.setUrl(Url);
        req.setPost(false);
        req.addResponseListener((e) -> {
            resultOK= req.getResponseCode()==200;
            String str = new String(req.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
 public ArrayList<Group> getByGroup(int creator_id){
    
        req.setUrl(PublicVars.ipAdress+"getGroup?creator_id="+creator_id);  
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                System.out.println(new String(req.getResponseData()));
                result = instance.parseGroups(new String(req.getResponseData()));
                if(req.getResponseCode()!=200){
                    System.out.println("errrr");
                }
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }
 
 
 public ArrayList<Group> parseGroups(String json) {
        System.out.println(json);
        ArrayList<Group> listGroups = new ArrayList<>();
Group g = new Group();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> Mygroups = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> GroupMap = (List<Map<String, Object>>) Mygroups.get("root");

                for(Map<String, Object> obj:GroupMap){
                float id = Float.parseFloat(obj.get("group_id").toString());
                float id_c = Float.parseFloat(obj.get("creator_id").toString());

                g.setId((int) id);
                g.setCreator_id((int) id_c);
                g.setDescription(obj.get("description").toString());
                g.setNom(obj.get("nom").toString());
                System.out.println(g);
                listGroups.add(g);
               }

        } catch (IOException ex) {
            System.out.println("lenna el mochkel");
        }
        return listGroups;

    }
    
}
