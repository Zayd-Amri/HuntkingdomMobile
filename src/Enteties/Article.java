/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enteties;

import java.util.Objects;

/**
 *
 * @author FOCUS
 */
public class Article  {
     private int id;
    private float prix;
    private String titre;
    private String categorie;
    private String gouvernorat;
    private String ville;
    private String description ;
    private int numtel;
    private String image_ev;
    private Integer user_id;
    public Article() {
    }

    public Article(float prix, String titre, String categorie, String gouvernorat, String ville, String description, int numtel, String image_ev, Integer user_id) {
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
        this.numtel = numtel;
        this.image_ev = image_ev;
        this.user_id = user_id;
    }

    public Article(int id, float prix, String titre, String categorie, String gouvernorat, String ville, String description, int numtel, String image_ev, Integer user_id) {
        this.id = id;
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
        this.numtel = numtel;
        this.image_ev = image_ev;
        this.user_id = user_id;
    }

    public Article(int id, String titre, String categorie, String gouvernorat, String ville, String description, int numtel) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
        this.numtel = numtel;
    }

    public Article(int id, float prix, String titre, String categorie) {
        this.id = id;
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
    }

    public Article(int id, String titre, String categorie, String gouvernorat, String ville, String description) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
    }

    public Article(int id, String image_ev) {
        this.id = id;
        this.image_ev = image_ev;
    }

    public Article(int id, String titre, String categorie) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
    }

    public Article(String titre, String categorie) {
        this.titre = titre;
        this.categorie = categorie;
    }

    public Article(float prix, String titre, String categorie, String gouvernorat, String ville, String description, int numtel) {
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
        this.numtel = numtel;
    }

    public Article(int id, float prix, String titre, String categorie, String description, String gouvernorat, String ville, int numtel) {
        this.id = id;
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.numtel = numtel;
    }

    public Article(String gouvernorat, String ville, int numtel) {
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.numtel = numtel;
    }

   

   

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (this.numtel != other.numtel) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.gouvernorat, other.gouvernorat)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image_ev, other.image_ev)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        return true;
    }

    public Article(String titre, String categorie, String description, String gouvernorat, String ville, int numtel) {
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.numtel = numtel;
    }

    public Article(String titre, String categorie, String gouvernorat, String ville, String description) {
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
    }



   
    
    
    public String toString2(){
        return ("gouvernorat="+gouvernorat+" ,ville="+ville);
 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public Article(int id, float prix, String titre, String categorie, String gouvernorat, String ville, String description, int numtel, String image_ev) {
        this.id = id;
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
        this.numtel = numtel;
        this.image_ev = image_ev;
    }

    public Article(float prix, String titre, String categorie, String gouvernorat, String ville, String description, int numtel, String image_ev) {
        this.prix = prix;
        this.titre = titre;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.description = description;
        this.numtel = numtel;
        this.image_ev = image_ev;
    }

    public Article(String image_ev) {
        this.image_ev = image_ev;
    }

    public String getImage_ev() {
        return image_ev;
    }

    public void setImage_ev(String image_ev) {
        this.image_ev = image_ev;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", prix=" + prix + ", titre=" + titre + ", categorie=" + categorie + ", gouvernorat=" + gouvernorat + ", ville=" + ville + ", description=" + description + ", numtel=" + numtel + ", image_ev=" + image_ev + '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    
       
  



}