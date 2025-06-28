package shapegame.adaptateur;

import shapegame.modele.forme.Forme;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import javax.swing.JTable;

/**
 * Classe permettant d'adapter une JTable à un modèle de données
 */
public class FormeTableModel extends AbstractTableModel {
    private List<Forme> formes;
    private final String[] entetes = {"Forme", "Position X", "Position Y", "Surface"};
    private JTable table;

    public FormeTableModel(List<Forme> formes, JTable table) {
        this.formes = formes;
        this.table = table;
    }

    @Override
    public int getRowCount() {
        return formes.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Forme forme = formes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return forme.getClass().getSimpleName();
            case 1:
                return forme.getPointPosition().getX();
            case 2:
                return forme.getPointPosition().getY();
            case 3:
                return forme.getSurface();
            default:
                return null;
        }
    }

    /**
     * Méthode permettant de récupérer la liste des formes
     * @return la liste des formes
     */
    public void setFormes(List<Forme> formes) {
        this.formes = formes;
        fireTableDataChanged();
        if (table != null) {
            table.revalidate();
            table.repaint();
        }
    }
}
