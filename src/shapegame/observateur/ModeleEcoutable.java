package shapegame.observateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant un modèle écoutable
 */
public abstract class ModeleEcoutable implements Ecoutable {
    
    protected List<Ecouteur> ecouteurs;

    public ModeleEcoutable() {
        this.ecouteurs = new ArrayList<>();
    }

    /*
     * Méthode permettant d'ajouter un écouteur
     */
    public void ajouterEcouteur(Ecouteur ecouteur) {
        this.ecouteurs.add(ecouteur);
    }

    /*
     * Méthode permettant de supprimer un écouteur
     */
    public void supprimerEcouteur(Ecouteur ecouteur) {
        this.ecouteurs.remove(ecouteur);
    }

    /*
     * Méthode permettant de notifier les écouteurs
     */
    public void notifier() {
        for (Ecouteur ecouteur : ecouteurs) {
            ecouteur.mettreAJour();
        }
    }

}
