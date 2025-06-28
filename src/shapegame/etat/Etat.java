package shapegame.etat;

import shapegame.modele.Jeu;

/**
 * Classe abstraite représentant un état de l'interface graphique
 */
public abstract class Etat {

    protected Jeu jeu;

    public Etat(Jeu jeu) {
        this.jeu = jeu;
    }

    /**
     * Méthode permettant de gérer le premier clic de souris
     * @param x la coordonnée x du clic
     * @param y la coordonnée y du clic
     */
	public abstract void gererPremierClic(double x, double y);

    /**
     * Méthode permettant de gérer le deuxième clic de souris
     * @param x la coordonnée x du clic
     * @param y la coordonnée y du clic
     */
    public abstract void gererDeuxiemeClic(double x, double y);
} 
