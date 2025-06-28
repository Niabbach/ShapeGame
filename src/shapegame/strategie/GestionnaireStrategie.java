package shapegame.strategie;

/**
 * Classe permettant de gérer les stratégies
 */
public class GestionnaireStrategie {
    private InitObstaclesStrategie strategie;

    /**
     * Constructeur de la classe GestionnaireStrategie
     * @param strategie la stratégie à utiliser
     */
    public void setStrategie(InitObstaclesStrategie strategie) {
        this.strategie = strategie;
    }

    /**
     * Méthode permettant d'appliquer la stratégie
     */
    public void appliquerStrategie() {
        if (strategie != null) {
            strategie.appliquerStrategie();
        }
    }
}

