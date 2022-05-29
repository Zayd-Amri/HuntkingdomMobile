/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enteties.User;
import Utils.PublicVars;
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
 * @author AmineMissaoui
 */
public class ServiceUser {
    private boolean resultOK;
    public static ServiceUser instance;
    private ConnectionRequest req;
    User userConnected = new User();
    public ServiceUser(){
    req=new ConnectionRequest();
    }
    public static ServiceUser getInstance(){
        if (instance==null){
        instance=new ServiceUser();}
        return instance;
    }

    ArrayList<User> listUsers;

    public boolean addUser(User u) {
        String Url = PublicVars.ipAdress + "addUser?users_first_name=" + u.getFirst_name()+ "&users_last_name=" + u.getLast_name()+ 
                "&users_username=" + u.getUsername()+"&users_username=" + u.getUsername()+"&users_password=" + u.getPassword()+
                "&users_email=" + u.getEmail()+"&users_birthdate=" + u.getBirthdate()+"&users_adress=" + u.getAdress()
                +"&users_state" + u.getState() + "&users_city" + u.getCity() + "&users_role" + u.getActive();
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

    public ArrayList<User> parseUsers(String json) {
        System.out.println(json);
        ArrayList<User> listUsers = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> userUsername = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) userUsername.get("root");

            for (Map<String, Object> obj : list) {
                User u = new User();
                float id = Float.parseFloat(obj.get("users_id").toString());
                System.out.println(id);
                u.setId((int) id);
                u.setFirst_name(obj.get("users_first_name").toString());
                u.setLast_name(obj.get("users_last_name").toString());
                u.setUsername(obj.get("users_username").toString());
                u.setEmail(obj.get("users_password").toString());
                u.setPassword(obj.get("users_password").toString());
                u.setBirthdate(obj.get("users_birthdate").toString());
                u.setAdress(obj.get("users_adress").toString());
                u.setState(obj.get("users_state").toString());
                u.setCity(obj.get("users_city").toString());
                u.setRole(obj.get("users_role").toString());
                System.out.println(u);
                listUsers.add(u);
            }

        } catch (IOException ex) {
        }
        return listUsers;

    }
    public User getByUsername(String username){
        req.setUrl(PublicVars.ipAdress+"getByUsername?users_username="+username);  
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                User u=new User();
                userConnected = instance.parseUserByName(new String(req.getResponseData()));
                if(req.getResponseCode()!=200){
                    System.out.println("rani ma cx");
                }
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return userConnected;
    }
     public ArrayList<User> getUsers(){
        listUsers = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(PublicVars.ipAdress); 
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceUser ser = new ServiceUser();
                System.out.println(new String(con.getResponseData()));
                listUsers = ser.parseUsers(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUsers;
    }
     
     
     public User parseUserByName(String json) {
        System.out.println(json);
        
User u = new User();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> userMap = (List<Map<String, Object>>) tasks.get("root");

            Map<String, Object> obj = userMap.get(0);
                //for(Map<String, Object> obj:userMap){
                float id = Float.parseFloat(obj.get("users_id").toString());
                System.out.println(id);
                u.setId((int) id);
                u.setFirst_name(obj.get("users_first_name").toString());
                u.setLast_name(obj.get("users_last_name").toString());
                u.setUsername(obj.get("users_username").toString());
                u.setEmail(obj.get("users_password").toString());
                u.setPassword(obj.get("users_password").toString());
                u.setBirthdate(obj.get("users_birthdate").toString());
                u.setAdress(obj.get("users_adress").toString());
                u.setState(obj.get("users_state").toString());
                u.setCity(obj.get("users_city").toString());
                u.setRole(obj.get("users_role").toString());
                System.out.println(u);
               // listUsers.add(u);
              //  }

        } catch (IOException ex) {
            System.out.println("lenna el mochkel");
        }
        return u;

    }
}
