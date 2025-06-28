package shapegame.modele;



import java.util.ArrayList;
import java.util.List;

import shapegame.action.Action;
import shapegame.modele.forme.Forme;
import shapegame.modele.joueur.Joueur;
import shapegame.observateur.ModeleEcoutable;
import shapegame.strategie.CalculScoreStrategie;
import shapegame.strategie.InitObstaclesStrategie;
import shapegame.strategie.Obstacle;

/**
 * Classe représentant le jeu ShapeGame
 */
public class Jeu extends ModeleEcoutable {

    private Joueur joueur;
    private int largeurPanel;
    private int longueurPanel;
    private List<Forme> formes;    
    private Historique historique;
    private InitObstaclesStrategie strategieObstacles;
    private CalculScoreStrategie strategieScore;
    private int obstaclesDetectes;
    private int formesCreees;
    private List<Forme> formesJoueur; 

    public Jeu(Joueur joueur, int largeurPanel, int longueurPanel) {
        super();
        this.joueur = joueur;
        this.largeurPanel = largeurPanel;
        this.longueurPanel = longueurPanel;
        this.formes = new ArrayList<>();
        this.historique = new Historique();
        this.obstaclesDetectes = 0;
        this.formesCreees = 0;
        this.formesJoueur = new ArrayList<>();
    }
    
    /**
     * Méthode permettant de faire une action
     * @param action l'action à faire
     */
    public void faireAction(Action action) {
        action.executer();
        this.historique.ajouterAction(action);
        notifier();
    }

    /**
     * Méthode permettant d'annuler une action
     */
    public void annulerAction() {
        this.historique.undo();
        notifier();
    }

    /**
     * Méthode permettant de refaire une action
     */
    public void refaireAction() {
        this.historique.redo();
        notifier();
    }

    /**
     * Méthode permettant de définir la stratégie d'initialisation des obstacles
     * @param strategie la stratégie d'initialisation des obstacles
     */
    public void setStrategieObstacles(InitObstaclesStrategie strategie) {
        this.strategieObstacles = strategie;
    }

    /**
     * Méthode permettant de définir la stratégie de calcul du score
     * @param strategie la stratégie de calcul du score
     */
    public void setStrategieScore(CalculScoreStrategie strategie) {
        this.strategieScore = strategie;
    }

    /**
     * Méthode permettant d'initialiser le jeu
     * @return la liste des obstacles
     */
    public List<Forme> initialiserJeu() {
        List<Forme> obstacles = null;
        if (strategieObstacles != null) {
            obstacles = strategieObstacles.initialiserObstacles();
            this.formes.addAll(obstacles);
            notifier();
        }
        return obstacles;
    }

    /**
     * Méthode permettant de calculer le score
     * @return le score
     */
    public double calculerScore() {
        double surfaceTotale = 0;
        for (Forme forme : formesJoueur) {
            surfaceTotale += forme.getSurface();
        }
        return surfaceTotale / (longueurPanel*largeurPanel); // Calcul du score selon la formule donnée
    }

    /**
     * Méthode permettant d'ajouter une forme
     * @param forme la forme à ajouter
     */
    public void ajouterForme(Forme forme) {
    	if (formesCreees < 4) {
	        this.formes.add(forme);
	        this.formesJoueur.add(forme);
	        formesCreees++;
	        notifier();
    	}
    }

    /**
     * Méthode permettant de retirer une forme
     * @param forme la forme à retirer
     */
    public void retirerForme(Forme forme) {
        this.formes.remove(forme);
        this.formesJoueur.remove(forme);
        formesCreees--;
        notifier();
    }

    /**
     * Méthode permettant de détecter les obstacles évités
     * @param formeJoueur la forme du joueur
     * @param obstacles la liste des obstacles
     * @param autresFormes la liste des autres formes
     */
    public void detecterObstaclesEvites(Forme formeJoueur, List<Obstacle> obstacles,List<Forme> autresFormes) {

        for (Obstacle obstacle : obstacles) {
            if (formeJoueur.collisionAvec(obstacle)) {
                obstaclesDetectes++;
                break; 
            }
        }
        for (Forme forme : autresFormes) {
            if (formeJoueur != forme && formeJoueur.collisionAvec(forme)) {
                obstaclesDetectes++;
                break; 
            }
        }
    }

    /**
     * Méthode permettant de récupérer le joueur
     * @return le joueur
     */
    public Joueur getJoueur() {
        return this.joueur;
    }


    public int getLongueurPanel() {
        return this.longueurPanel;
    }

    public int getLargeurPanel() {
        return this.largeurPanel;
    }

    /**
     * Méthode permettant de récupérer les formes
     * @return la liste des formes
     */
    public List<Forme> getFormes() {
        return this.formes;
    }
}
