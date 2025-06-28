package shapegame.strategie;

/**
 * Classe permettant de calculer le score en fonction du nombre de formes créées
 */
public class ScoreBaseNombreFormesCreees implements CalculScoreStrategie {

    @Override
    public void appliquerStrategie() {
    }
    
    @Override
    public int calculerScoreObstacles(int nbreobstaclesdetectes) {
        return 0;
    }

    @Override
    public int calculerScoreFormes(int nbreformescreees) {
        int score = nbreformescreees * 20;
        return score;
    }
}
