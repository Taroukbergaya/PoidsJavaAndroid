package com.example.poids.modele;
public class Client {
    // déclarer des constantes
    private static final Integer minF = 15; // maigre si en dessous
    private static final Integer maxF = 30; // gros si au dessus
    private static final Integer minH = 10; // maigre si en dessous
    private static final Integer maxH = 25; // gros si au dessus
    // identifier les propriétés
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer genre;
    private String message;
    private float img;
    public Client(Integer poids, Integer taille, Integer age, Integer genre) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.genre = genre;
        this.calculIMG();
        this.resuIMG();
    }
    public Integer getPoids() {
        return poids;
    }
    public Integer getTaille() {
        return taille;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getGenre() {
        return genre;
    }
    public String getMessage() {
        return message;
    }
    public float getImg() {
        return img;
    }
    private void calculIMG()
    {
        float tailleM = ((float)taille)/100;
        this.img= (float) (1.2*poids / (tailleM*tailleM) + (0.23*age) - (10.83*genre) -5.4);
    }
    private void resuIMG()
    {
        Integer min;
        Integer max;
        if (genre ==0){
            min = minF;
            max = maxF;
        }else {
            min = minH;
            max = maxH;
        }
        message="normal";
        if (img<min){
            message = "trop faible";
        }else {
            if (img>max){
                message = "trop élvée";
            }
        }
    }
}
