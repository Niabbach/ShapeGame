package shapegame.action;

import shapegame.modele.Jeu;
import shapegame.modele.forme.Forme;

/**
 * Classe abstraite représentant une action
 */
public abstract class Action {
    
    protected Jeu jeu;
    protected Forme forme;

    Action(Jeu jeu, Forme forme) {
        this.jeu = jeu;
        this.forme = forme;
    }

    /*
     * Méthode permettant d'exécuter l'action
     */
    public abstract void executer();

    /*
     * Méthode permettant d'annuler l'action
     * @return l'action inverse
     */
    public abstract Action getActionUndo();
}