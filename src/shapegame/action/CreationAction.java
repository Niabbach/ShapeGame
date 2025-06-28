package shapegame.action;

import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;

/**
 * Classe abstraite représentant l'action de créer une forme
 */
public class CreationAction extends Action {

    public CreationAction(Jeu jeu, Forme forme) {
        super(jeu, forme);
    }

    @Override
    public void executer() {
        jeu.ajouterForme(forme);
    }

    @Override
    public Action getActionUndo() {
        return new SuppressionAction(jeu, forme);
    }
    
}
