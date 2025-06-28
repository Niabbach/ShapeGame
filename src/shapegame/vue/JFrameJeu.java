package shapegame.vue;


import javax.swing.JFrame;

import shapegame.modele.Jeu;

/**
 * Classe JFrameJeu
 * Représente la fenêtre du jeu
 */
public class JFrameJeu extends JFrame {

    public JFrameJeu(Jeu jeu) {
        super("ShapeGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.add(new InterfaceGraphique(jeu));
        this.setResizable(false);
        this.setVisible(true);

    }
}
