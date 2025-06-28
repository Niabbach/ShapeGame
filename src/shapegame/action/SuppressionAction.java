package shapegame.action;

import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;

/**
    * Classe abstraite représentant l'action de supprimer une forme
    */
public class SuppressionAction extends Action {

    public SuppressionAction(Jeu jeu, Forme forme) {
        super(jeu, forme);
    }

    @Override
    public void executer() {
        this.jeu.retirerForme(forme);
    }

    @Override
    public Action getActionUndo() {
        return new CreationAction(jeu, forme);
    }
    
}
