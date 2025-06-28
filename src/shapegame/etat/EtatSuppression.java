package shapegame.etat;

import shapegame.action.SuppressionAction;
import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;
import shapegame.modele.forme.Point2D;

/**
 * Classe représentant l'état de suppression
 */
public class EtatSuppression extends Etat {
    public EtatSuppression(Jeu jeu) {

        super(jeu);

    }

    @Override

    public void gererPremierClic(double x, double y) {

        for (Forme forme : jeu.getFormes()) {

            if (forme.estDedans(new Point2D(x, y))) {

                jeu.faireAction(new SuppressionAction(jeu, forme));

                return;

            }

    

        }

    }

    @Override

    public void gererDeuxiemeClic(double x, double y) {

        for (Forme forme : jeu.getFormes()) {

            if (forme.estDedans(new Point2D(x, y))) {

                jeu.faireAction(new SuppressionAction(jeu, forme));

                return;

            }

    

        }

    }


    
}
