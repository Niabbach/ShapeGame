package shapegame.modele;

import java.util.Stack;

import shapegame.action.Action;

/**
 * Classe représentant l'historique des actions
 */
public class Historique {

    Stack<Action> undoStack;
    Stack<Action> redoStack;

    public Historique() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    /**
     * Méthode permettant d'ajouter une action à l'historique
     * @param action l'action à ajouter
     */
    public void ajouterAction(Action action) {
        undoStack.push(action.getActionUndo());
    }

    /**
     * Méthode permettant d'annuler la dernière action
     */
    public void undo() {
        if(undoStack.isEmpty()) {
            return;
        }
        Action action = this.undoStack.pop();
        action.executer();
        this.redoStack.push(action.getActionUndo());
    }

    /**
     * Méthode permettant de refaire la dernière action annulée
     */
    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Action action = this.redoStack.pop();
        action.executer();
        this.undoStack.push(action.getActionUndo());
    }


}