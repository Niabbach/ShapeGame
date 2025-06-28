package shapegame.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


import shapegame.etat.Etat;
import shapegame.modele.Jeu;
import shapegame.modele.forme.Cercle;
import shapegame.modele.forme.Rectangle;
import shapegame.observateur.Ecouteur;

/**
 * Classe représentant le conteneur de vues
 */
public class VueConteneur extends JPanel implements Ecouteur {
    
    private List<Vue> vues;
    private Jeu jeu;
    private Etat etat;
    private int nombreClics;


    public VueConteneur(Jeu jeu) {
        super();
        this.vues = new ArrayList<>();
        this.jeu = jeu;
        this.nombreClics = 0;
        this.etat = null;
        this.jeu.ajouterEcouteur(this);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(jeu.getLongueurPanel(), jeu.getLargeurPanel()));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (etat != null) {
                    nombreClics++;
                    if (nombreClics == 1) {
                        etat.gererPremierClic(e.getX(), e.getY());
                    } else {
                        etat.gererDeuxiemeClic(e.getX(), e.getY());
                        nombreClics = 0;
                    }
                }
            }
        });
    }

    /**
     * Ajoute une vue au conteneur
     * @param vue la vue à ajouter
     */
    public void ajouterVue(Vue vue) {  
        this.vues.add(vue);
    }

    /**
     * Retire une vue du conteneur
     * @param vue la vue à retirer
     */
    public void retirerVue(Vue vue) {
        this.vues.remove(vue);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vue vue : vues) {
            vue.paint(g);
        }
    }

    /**
     * Change l'état du conteneur
     * @param etat le nouvel état
     */
    public void changerEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public void mettreAJour() {
        this.vues.clear();
        this.jeu.getFormes().forEach(forme -> {
            if (forme instanceof Cercle) {
                this.ajouterVue(new CercleVue((Cercle) forme));
            } else if (forme instanceof Rectangle) {
                this.ajouterVue(new RectangleVue((Rectangle) forme));
            }
        });
        repaint();
    }
    
}
