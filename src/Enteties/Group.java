/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enteties;


/**
 *
 * @author Me
 */
public class Group {
    private int id,creator_id;
    private String nom,description;
    public Group(){}
    public Group (int id, String nom,String description){
    this.id=id;
    this.description=description;
    this.nom=nom;
    
    }

                public Group ( String nom,String description,int creator_id){
                    this.creator_id=creator_id;
    this.description=description;
    this.nom=nom;

    }


    /**
     * @return the id
     */
    public int getId() {
        
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
    return "id= "+id+" nom= "+nom+" description ="+description;
    }

    /**
     * @return the imageFile
     */
   

    /**
     * @return the creator_id
     */
    public int getCreator_id() {
        return creator_id;
    }

    /**
     * @param creator_id the creator_id to set
     */
    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }
    
}
