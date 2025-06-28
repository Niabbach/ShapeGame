package shapegame.vue;

import shapegame.modele.Jeu;
import shapegame.vue.composant.Bouton;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import shapegame.adaptateur.AdaptateurJTable;
import shapegame.etat.EtatCreationCercle;
import shapegame.etat.EtatCreationRectangle;
import shapegame.etat.EtatDeplacement;
import shapegame.etat.EtatRedimensionnement;
import shapegame.etat.EtatSuppression;

public class InterfaceGraphique extends Panel {

    private Bouton boutonCercle;
    private Bouton boutonRectangle;
    private Bouton boutonDeplacement;
    private Bouton boutonRedimensionnement;
    private Bouton boutonSuppression;
    private Bouton boutonUndo;
    private Bouton boutonRedo;
    private Jeu jeu;
    private VueConteneur vueConteneur;
    private JTable formeTable;
    private JScrollPane tableScrollPane;
    private AdaptateurJTable adaptateurJTable;
    private JLabel labelScore;
   

    public InterfaceGraphique(Jeu jeu) {
        this.jeu = jeu;
        this.vueConteneur = new VueConteneur(jeu);
        this.boutonCercle = new Bouton("Cercle");
        this.boutonRectangle = new Bouton("Rectangle");
        this.boutonDeplacement = new Bouton("Deplacement");
        this.boutonRedimensionnement = new Bouton("Redimensionnement");
        this.boutonSuppression = new Bouton("Suppression");
        this.boutonUndo = new Bouton("Undo");
        this.boutonRedo = new Bouton("Redo");
        
        this.labelScore = new JLabel("Score: 0");

        // Création du modèle de tableau
        formeTable = new JTable();
        adaptateurJTable = new AdaptateurJTable(jeu.getFormes(), formeTable);
        tableScrollPane = new JScrollPane(formeTable);

        // Organisation des composants dans la fenêtre
        setLayout(new BorderLayout());
        add(vueConteneur, BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        boutonsPanel.add(boutonCercle);
        boutonsPanel.add(boutonRectangle);
        boutonsPanel.add(boutonDeplacement);
        boutonsPanel.add(boutonRedimensionnement);
        boutonsPanel.add(boutonSuppression);
        boutonsPanel.add(boutonUndo);
        boutonsPanel.add(boutonRedo);
        boutonsPanel.add(labelScore); 
        add(boutonsPanel, BorderLayout.NORTH);

        add(tableScrollPane, BorderLayout.SOUTH);

        // Configuration des actions des boutons
        boutonUndo.addActionListener(e -> {
            jeu.annulerAction();
            adaptateurJTable.getFormeTableModel().setFormes(jeu.getFormes());
            mettreAJourScore();
        });
        boutonRedo.addActionListener(e -> {
            jeu.refaireAction();
            adaptateurJTable.getFormeTableModel().setFormes(jeu.getFormes());
            mettreAJourScore();
        });
        boutonCercle.addActionListener(e -> {
            vueConteneur.changerEtat(new EtatCreationCercle(jeu));
            adaptateurJTable.getFormeTableModel().setFormes(jeu.getFormes());
            mettreAJourScore();
        });
        boutonRectangle.addActionListener(e -> {
            vueConteneur.changerEtat(new EtatCreationRectangle(jeu));
            adaptateurJTable.getFormeTableModel().setFormes(jeu.getFormes());
            mettreAJourScore();
        });
        boutonSuppression.addActionListener(e -> {
            vueConteneur.changerEtat(new EtatSuppression(jeu));
            adaptateurJTable.getFormeTableModel().setFormes(jeu.getFormes());
            mettreAJourScore();
        });
        boutonDeplacement.addActionListener(e -> {
            vueConteneur.changerEtat(new EtatDeplacement(jeu));
            adaptateurJTable.getFormeTableModel().setFormes(jeu.getFormes());
            mettreAJourScore();
        });
        boutonRedimensionnement.addActionListener(e -> {
            vueConteneur.changerEtat(new EtatRedimensionnement(jeu));
            adaptateurJTable.getFormeTableModel().setFormes(jeu.getFormes());
            mettreAJourScore();
        });
    }

    private void mettreAJourScore() {
        double score = jeu.calculerScore();
        labelScore.setText("Score: " + score);
    }
}
