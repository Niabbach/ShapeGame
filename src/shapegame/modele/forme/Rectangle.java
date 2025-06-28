package shapegame.modele.forme;
import shapegame.strategie.Obstacle;
import java.awt.Color;

/**
 * Classe représentant un Rectangle
 */
public class Rectangle extends Forme {
    
    public Rectangle(Point2D pointPosition, Point2D pointDimension, Color couleur) {
        super(pointPosition, pointDimension, couleur); 
   }

    @Override
    public double getSurface() {
        return this.getLongueur()*this.getLargeur();
    }
    
    /*
     * Méthode pour obtenir la longueur du rectangle
     * @return la longueur du rectangle
     */
    public double getLongueur() {
        return Math.abs(this.pointDimension.getX() - this.pointPosition.getX());
    }

    /**
     * Méthode pour obtenir la largeur du rectangle
     * @return la largeur du rectangle
     */
    public double getLargeur() {
        return Math.abs(this.pointDimension.getY() - this.pointPosition.getY());
    }
    
    @Override
    public boolean collisionAvec(Forme autreForme) {
        if (autreForme instanceof Rectangle) {
            Rectangle autreRectangle = (Rectangle) autreForme;
            
            // Voir s'il y a une intersection entre les deux rectangles
            return this.pointPosition.getX() < autreRectangle.pointPosition.getX() + autreRectangle.getLongueur() &&
                   this.pointPosition.getX() + this.getLongueur() > autreRectangle.pointPosition.getX() &&
                   this.pointPosition.getY() < autreRectangle.pointPosition.getY() + autreRectangle.getLargeur() &&
                   this.pointPosition.getY() + this.getLargeur() > autreRectangle.pointPosition.getY();
        } else if (autreForme instanceof Cercle) {
            Cercle cercle = (Cercle) autreForme;
            
            // Calcul du point le plus proche du rectangle au centre du cercle
            double pointPlusProcheX = Math.max(this.pointPosition.getX(), Math.min(cercle.pointPosition.getX(), this.pointPosition.getX() + this.getLongueur()));
            double pointPlusProcheY = Math.max(this.pointPosition.getY(), Math.min(cercle.pointPosition.getY(), this.pointPosition.getY() + this.getLargeur()));
            
         // Calcul de la distance entre ce point et le centre du cercle
            double distance = Math.sqrt(Math.pow(pointPlusProcheX - cercle.pointPosition.getX(), 2) + Math.pow(pointPlusProcheY - cercle.pointPosition.getY(), 2));
           
         // Voir si la distance est inférieure ou égale au rayon du cercle
            return distance <= cercle.getRayon();
        }
        return false;
    }

    @Override
    public boolean collisionAvec(Obstacle obstacle) {
        return obstacle.collisionAvec(this);
    }

    @Override
    public boolean estDedans(Point2D point) {
        return point.getX() >= this.pointPosition.getX() && point.getX() <= this.pointPosition.getX() + this.getLongueur() && point.getY() >= this.pointPosition.getY() && point.getY() <= this.pointPosition.getY() + this.getLargeur();
    }
}
