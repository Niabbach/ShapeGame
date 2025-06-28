package shapegame.strategie;

import java.util.List;
import shapegame.modele.forme.Forme;

/**
 * Interface représentant une stratégie d'initialisation des obstacles
 */
public interface InitObstaclesStrategie {

    /**
     * Méthode permettant d'appliquer la stratégie
     */
    void appliquerStrategie();

    /**
     * Méthode permettant d'initialiser les obstacles
     * @return la liste des obstacles
     */
    List<Forme> initialiserObstacles();
}
