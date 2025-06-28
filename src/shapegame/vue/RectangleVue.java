package shapegame.vue;

import java.awt.Graphics;

import java.awt.Color;

import shapegame.modele.forme.Rectangle;

/**
    * Classe représentant la vue d'un rectangle
    */
public class RectangleVue implements Vue {

    private Rectangle rectangle;

    RectangleVue(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void paint(Graphics g) {
        int x = (int) rectangle.getPointPosition().getX();
        int y = (int) rectangle.getPointPosition().getY();
        int largeur = (int) rectangle.getLargeur();
        int longueur = (int) rectangle.getLongueur();

        Color couleur = rectangle.getColor();

        g.setColor(couleur);
        g.fillRect(x, y, longueur, largeur);
    }
}
