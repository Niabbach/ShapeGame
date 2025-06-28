package shapegame.modele.forme;
import shapegame.strategie.Obstacle;
import java.awt.Color;

/**
 * Classe représentant un cercle
 */
public class Cercle extends Forme {
    
    public Cercle(Point2D pointPosition, Point2D pointDimension, Color couleur) {
        super(pointPosition, pointDimension, couleur);
    }

    @Override
    public double getSurface() {
        double rayon = this.getRayon();
        return Math.PI*rayon*rayon;
    }
    
    /*
     * Méthode pour obtenir le rayon du cercle
     * @return le rayon du cercle
     */
    public double getRayon() {
        return Math.sqrt(Math.pow(this.pointDimension.getX() - this.pointPosition.getX(), 2) + Math.pow(this.pointDimension.getY() - this.pointPosition.getY(), 2));
    }
   
    @Override
    public boolean collisionAvec(Forme autreForme) {
        if (autreForme instanceof Cercle) {
            Cercle autreCercle = (Cercle) autreForme;
            
            // Calcul de la distance entre les centres des deux cercles
            double distanceCentres = Math.sqrt(Math.pow(this.pointPosition.getX() - autreCercle.pointPosition.getX(), 2) + Math.pow(this.pointPosition.getY() - autreCercle.pointPosition.getY(), 2));
           // Voir si la distance entre les centres est inférieure ou égale à la somme des rayons
            return distanceCentres <= this.getRayon() + autreCercle.getRayon();
        } else if (autreForme instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) autreForme;
           // Trouve le point le plus proche du cercle au rectangle
            double pointPlusProcheX = Math.max(rectangle.pointPosition.getX(), Math.min(this.pointPosition.getX(), rectangle.pointPosition.getX() + rectangle.getLongueur()));
            double pointPlusProcheY = Math.max(rectangle.pointPosition.getY(), Math.min(this.pointPosition.getY(), rectangle.pointPosition.getY() + rectangle.getLargeur()));
           // Calcul de la distance entre ce point et le centre du cercle 
            double distance = Math.sqrt(Math.pow(pointPlusProcheX - this.pointPosition.getX(), 2) + Math.pow(pointPlusProcheY - this.pointPosition.getY(), 2));
            
          // Vérifie si la distance est inférieure ou égale au rayon du cercle
            return distance <= this.getRayon();
        }
        return false;
    }

    @Override
    public boolean collisionAvec(Obstacle obstacle) {
        return obstacle.collisionAvec(this);
    }
    @Override
    public boolean estDedans(Point2D point) {
        // Calcul de la distance entre le point (x, y) et le centre du cercle (centerX, centerY)
        double distance = Math.sqrt(Math.pow(point.getX() - this.getPointPosition().getX(), 2) + Math.pow(point.getY() - this.getPointPosition().getY(), 2));
        
        // Si la distance est inférieure ou égale au rayon du cercle, le point est à l'intérieur
        return distance <= this.getRayon();
        
    }
}
