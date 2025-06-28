package shapegame.modele.forme;

/**
 * Classe représentant un point 2D
 */
public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retourne la coordonnée x du point
     * @return la coordonnée x du point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Retourne la coordonnée y du point
     * @return la coordonnée y du point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Déplace le point aux coordonnées x et y
     * @param x la nouvelle coordonnée x
     * @param y la nouvelle coordonnée y
     */
    public void deplacer(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calcule la distance entre ce point et un autre point
     * @param point le point avec lequel calculer la distance
     * @return la distance entre ce point et le point passé en paramètre
     */
    public double distance(Point2D point) {
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }
}
