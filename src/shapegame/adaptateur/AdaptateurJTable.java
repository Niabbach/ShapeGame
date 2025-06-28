package shapegame.adaptateur;

import javax.swing.*;
import java.util.List;
import shapegame.modele.forme.Forme;

/**
 * Classe permettant d'adapter une JTable à un modèle de données
 */
public class AdaptateurJTable {
    private JTable table;
    private FormeTableModel modeleTable;

    public AdaptateurJTable(List<Forme> donnees,JTable table) {
    	this.table = table;
        this.modeleTable = new FormeTableModel(donnees, table);
        this.table.setModel(modeleTable);
    }

    /**
     * Méthode permettant de créer un JPanel contenant la JTable
     * @return le JPanel contenant la JTable
     */
    public JPanel creationTablePanel() {
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        return panel;
    }

    /**
     * Méthode permettant de récupérer le modèle de la JTable
     * @return le modèle de la JTable
     */
    public FormeTableModel getFormeTableModel() {
        return modeleTable;
    }

    /**
     * Méthode permettant de mettre à jour le modèle de la JTable
     * @param donnees les nouvelles données
     */
    public void mettreAJourModele(List<Forme> donnees) {
        modeleTable.setFormes(donnees);
    }
}

