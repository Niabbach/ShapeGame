package shapegame.strategie;

import shapegame.modele.forme.*;

/**
 * Classe représentant un obstacle
 */
public class Obstacle {
    private double x;
    private double y;

    public Obstacle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode permettant de récupérer la position de l'obstacle
     * @return la position de l'obstacle
     */
    public boolean collisionAvec(Forme forme) {
        if (forme instanceof Cercle) {
            Cercle cercle = (Cercle) forme;
            double distance = Math.sqrt(Math.pow(this.x - cercle.getPointPosition().getX(), 2) + Math.pow(this.y - cercle.getPointPosition().getY(), 2));
            return distance <= cercle.getRayon();
        } else if (forme instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) forme;
            return this.x >= rectangle.getPointPosition().getX() && this.x <= rectangle.getPointPosition().getX() + rectangle.getLongueur() &&
                   this.y >= rectangle.getPointPosition().getY() && this.y <= rectangle.getPointPosition().getY() + rectangle.getLargeur();
        }
        return false;
    }
}

