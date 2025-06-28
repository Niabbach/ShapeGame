package shapegame.etat;

import java.awt.Color;
import javax.swing.JOptionPane;

import shapegame.action.CreationAction;
import shapegame.modele.Jeu;
import shapegame.modele.forme.Point2D;
import shapegame.modele.forme.Rectangle;

/**
 * Classe représentant l'état de création d'un rectangle
 */
public class EtatCreationRectangle extends Etat {
    private double coinSuperieurGaucheX;

    private double coinSuperieurGaucheY;

    public EtatCreationRectangle(Jeu jeu) {

        super(jeu);

    }

    

    @Override

    public void gererPremierClic(double x, double y) {

        this.coinSuperieurGaucheX = x;

        this.coinSuperieurGaucheY = y;

    }

    @Override

    public void gererDeuxiemeClic(double x, double y) {

        if(coinSuperieurGaucheX == x && coinSuperieurGaucheY == y) {

            return;

        }

        jeu.faireAction(new CreationAction(jeu, new Rectangle(new Point2D(coinSuperieurGaucheX, coinSuperieurGaucheY), new Point2D(x, y), Color.BLUE)));

    }

}
