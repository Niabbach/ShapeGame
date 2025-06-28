package shapegame.strategie;

/**
 * Classe permettant de calculer le score en fonction du nombre d'obstacles détectés
 */
public class ScoreBaseNombreObstaclesDetectes implements CalculScoreStrategie {

    @Override
    public void appliquerStrategie() {
    }

    @Override
    public int calculerScoreFormes(int nbreformescreees) {
        return 0;
    }

    @Override
    public int calculerScoreObstacles(int nbreobstaclesdetectes) {
        int score = nbreobstaclesdetectes * 10;
        return score;
    }
}
