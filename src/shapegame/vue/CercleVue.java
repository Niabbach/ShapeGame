package shapegame.vue;

import java.awt.Graphics;


import java.awt.Color;

import shapegame.modele.forme.Cercle;

/**
    * Classe représentant la vue d'un cercle
    */
public class CercleVue implements Vue{

    private Cercle cercle;

    CercleVue(Cercle cercle) {
        this.cercle = cercle;
    }

    @Override
    public void paint(Graphics g) {
       
        int x = (int) cercle.getPointPosition().getX();
        int y = (int) cercle.getPointPosition().getY();
        int rayon = (int) cercle.getRayon();
        
        
        Color couleur = cercle.getColor();

        
        g.setColor(couleur);
        g.fillOval(x - rayon, y - rayon, 2 * rayon, 2 * rayon);
    }


   
}
