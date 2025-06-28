package shapegame.strategie;

/**
 * Interface définissant une stratégie de calcul de score
 */
public interface CalculScoreStrategie {
    /**
     * Méthode permettant d'appliquer la stratégie
     */
    void appliquerStrategie();

    /**
     * Méthode permettant de calculer le score
     * @param nbreformescreees le nombre de formes créées
     * @return le score
     */
    int calculerScoreFormes(int nbreformescreees);

    /**
     * Méthode permettant de calculer le score
     * @param nbreobstaclesdetectes le nombre d'obstacles détectés
     * @return le score
     */
    int calculerScoreObstacles(int nbreobstaclesdetectes);
}

