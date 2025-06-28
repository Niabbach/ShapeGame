package shapegame.modele.joueur;

/**
 * Classe abstraite représentant un joueur
 */
public abstract class Joueur {

    private String nom;

    public Joueur(String nom) {
        this.nom = nom;
    }
    
    /**
     * Méthode permettant de jouer
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode permettant de récupérer le nom du joueur
     * @return le nom du joueur
     */
    public String getNom() {
        return this.nom;
    }
}
