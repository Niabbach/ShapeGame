package shapegame.etat;

import javax.swing.JOptionPane;

import shapegame.action.RedimensionnementAction;
import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;
import shapegame.modele.forme.Point2D;

/**
 * Classe abstraite représentant l'état de redimensionnement d'une forme
 */
public class EtatRedimensionnement extends Etat {

    private Forme forme;

    public EtatRedimensionnement(Jeu jeu) {

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

            this.jeu.faireAction(new RedimensionnementAction(jeu, forme, new Point2D(x, y)));

            this.forme = null;

        }

    }

}
