package shapegame.etat;

import shapegame.action.DeplacementAction;
import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;
import shapegame.modele.forme.Point2D;

/**
 * Classe abstraite représentant l'état de déplacement d'une forme
 */
public class EtatDeplacement extends Etat {

    private Forme forme;

    public EtatDeplacement(Jeu jeu) {

        super(jeu);

    }

    @Override

    public void gererPremierClic(double x, double y) {

        for (Forme forme : jeu.getFormes()) {

            if (forme.estDedans(new Point2D(x, y))) {

                this.forme = forme;

                return;

            }

    

        }

    }

    @Override

    public void gererDeuxiemeClic(double x, double y) {

        if (this.forme != null) {

            this.jeu.faireAction(new DeplacementAction(jeu, forme, new Point2D(x, y)));

            this.forme = null;

        }

    }

}
