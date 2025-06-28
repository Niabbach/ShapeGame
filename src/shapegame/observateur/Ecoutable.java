package shapegame.observateur;

/**
 * Interface définissant un objet écoutable
 */
public interface Ecoutable {
    
    /**
     * Méthode permettant d'ajouter un écouteur
     * @param ecouteur l'écouteur à ajouter
     */
    void ajouterEcouteur(Ecouteur ecouteur);

    /**
     * Méthode permettant de supprimer un écouteur
     * @param ecouteur l'écouteur à supprimer
     */
    void supprimerEcouteur(Ecouteur ecouteur);

    /**
     * Méthode permettant de notifier les écouteurs
     */
    void notifier();
}
