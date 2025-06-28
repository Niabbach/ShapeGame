package shapegame.action;

import shapegame.modele.forme.Point2D;
import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;

/**
 * Classe abstraite représentant l'action de déplacer une forme
 */
public class DeplacementAction extends Action {

	private Point2D ancienPointPosition;
    private Point2D nouveauPointPosition;

    public DeplacementAction(Jeu jeu, Forme forme, Point2D nouveauPointPosition) {
        super(jeu, forme);
        this.ancienPointPosition = forme.getPointPosition();
        this.nouveauPointPosition = nouveauPointPosition;
    }

    @Override
    public void executer() {
    	forme.deplacer(nouveauPointPosition);
    }

    @Override
    public Action getActionUndo() {
    	 return new DeplacementAction(jeu, forme, ancienPointPosition);
    }
    
}
