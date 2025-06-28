package shapegame.modele.forme;

import shapegame.strategie.Obstacle;
import java.awt.Color;
import shapegame.observateur.ModeleEcoutable;

/**
 * Classe abstraite représentant une forme
 */
public abstract class Forme extends ModeleEcoutable {


    protected Point2D pointPosition;
    protected Point2D pointDimension;
    protected Color couleur;

    public Forme(Point2D pointPosition, Point2D pointDimension, Color couleur) {
        super();
        this.pointPosition = pointPosition;
        this.pointDimension = pointDimension;
        this.couleur = couleur;
    }

    /*
     * Méthode permettant de récupérer la couleur de la forme
     * @return la couleur de la forme
     */
    public Color getColor() {
        return couleur;
    }

    /*
     * Méthode permettant de modifier la couleur de la forme
     * @param couleur la nouvelle couleur de la forme
     */
    public void setColor(Color couleur) {
        this.couleur = couleur;
    }
   
    /**
     * Méthode permettant de récupérer le point de la position de la forme
     * @return la position de la forme
     */
    public Point2D getPointPosition() {
        return this.pointPosition;
    }

    /**
     * Méthode permettant de récupérer le point de la dimension de la forme
     * @return la dimension de la forme
     */
    public Point2D getPointDimension() {
        return this.pointDimension;
    }

    /**
     * Méthode permettant de déplacer la forme
     * @param point le point de la nouvelle position
     */
    public void deplacer(Point2D point) {
        double nouvelX = point.getX() - pointPosition.getX();
        double nouvelY = point.getY() - pointPosition.getY();
        this.pointPosition = point;
        this.pointDimension = new Point2D(this.pointDimension.getX()+nouvelX, this.pointDimension.getY()+nouvelY);
        notifier(); 
    }

    /**
     * Méthode permettant de redimensionner la forme
     * @param point le point de la nouvelle dimension
     */
    public void redimensionner(Point2D point) {
        this.pointDimension = point;
        notifier();
    }

    /**
     * Méthode permettant de récupérer la surface de la forme
     * @return la surface de la forme
     */
    public abstract double getSurface();

    /**
     * Méthode permettant de savoir si un point est à l'intérieur de la forme
     * @param point le point à tester
     * @return vrai si le point est à l'intérieur, faux sinon
     */
    public abstract boolean estDedans(Point2D point);

    /**
     * Méthode permettant de savoir si la forme est en collision avec une autre forme
     * @param autreForme l'autre forme
     * @return vrai si les deux formes sont en collision, faux sinon
     */
    public abstract boolean collisionAvec(Forme autreForme);

    /**
     * Méthode permettant de savoir si la forme est en collision avec un obstacle
     * @param obstacle l'obstacle
     * @return vrai si la forme est en collision avec l'obstacle, faux sinon
     */
    public abstract boolean collisionAvec(Obstacle obstacle);

}

