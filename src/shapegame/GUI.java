package shapegame;

import shapegame.modele.Jeu;
import shapegame.modele.joueur.Joueur;
import shapegame.modele.joueur.JoueurHumain;
import shapegame.strategie.InitObstaclesAleatoires;
import shapegame.strategie.InitObstaclesStrategie;
import shapegame.vue.JFrameJeu;

/**
 * Classe GUI
 * Représente l'interface graphique
 */
public class GUI {
    
    /**
     * Méthode principale pour lancer l'interface graphique sur le Jeu
     */
    public static void lancerJeu() {
        Joueur joueur = new JoueurHumain("Humain");
        Jeu jeu = new Jeu(joueur,300, 300);

        InitObstaclesStrategie strategieObstacles = new InitObstaclesAleatoires();
        jeu.setStrategieObstacles(strategieObstacles);
        JFrameJeu jframe = new JFrameJeu(jeu);
        jeu.initialiserJeu();
    } 
}
