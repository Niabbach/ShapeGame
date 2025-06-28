package shapegame.action;

import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;
import shapegame.modele.forme.Point2D;

/**
* Classe abstraite représentant l'action de redimensionner une forme
*/
public class RedimensionnementAction extends Action {

	private Point2D ancienPointDimension;
    private Point2D nouveauPointDimension;

    public RedimensionnementAction(Jeu jeu, Forme forme, Point2D nouveauPointDimension) {
        super(jeu, forme);
        this.ancienPointDimension = forme.getPointDimension();
        this.nouveauPointDimension = nouveauPointDimension;
    }

    @Override
    public void executer() {
    	forme.redimensionner(nouveauPointDimension);
    }

    @Override
    public Action getActionUndo() {
    	return new RedimensionnementAction(jeu, forme, ancienPointDimension);
    }
    
}
