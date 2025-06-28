package shapegame.etat;

import java.awt.Color;
import shapegame.action.CreationAction;
import shapegame.modele.Jeu;
import shapegame.modele.forme.Cercle;
import shapegame.modele.forme.Point2D;

/**
 * Classe représentant l'état de création d'un cercle
 */
public class EtatCreationCercle extends Etat {
    private double centreX;

    private double centreY;

    

   public EtatCreationCercle(Jeu jeu) {

        super(jeu);

    }

    @Override

    public void gererPremierClic(double x, double y) {

        this.centreX = x;

        this.centreY = y;

    }

    @Override

    public void gererDeuxiemeClic(double x, double y) {

        if(centreX == x && centreY == y) {

            return;

        }

        this.jeu.faireAction(new CreationAction(this.jeu, new Cercle(new Point2D(centreX, centreY), new Point2D(x, y), Color.BLUE)));

    }

}
