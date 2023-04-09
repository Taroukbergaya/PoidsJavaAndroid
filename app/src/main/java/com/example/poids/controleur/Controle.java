package com.example.poids.controleur;

import com.example.poids.modele.Client;

public class Controle {
    private static Controle instance = null;
    private Client client;
    private Controle()
    {
        super();
    }
    // creation d'une instance
    // retrun instance
    public  static final Controle getInstance(){
        if (Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }
    // creation de client
    //1 piur homme et 0 pour femme
    public void createClient (Integer poids , Integer taille , Integer age , Integer genre){
        client = new Client(poids , taille , age , genre);
    }
    // recupuration img de client
    // return img
    public float getImg(){
        return client.getImg();
    }
    // recupuration message de client
    // return message
    public String getMessage(){
        return client.getMessage();
    }


}
