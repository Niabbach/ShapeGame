package shapegame.strategie;

import shapegame.modele.forme.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant la stratégie d'initialisation des obstacles aléatoires
 */
public class InitObstaclesAleatoires implements InitObstaclesStrategie {

    @Override
    public void appliquerStrategie() {
    }

    @Override
    public List<Forme> initialiserObstacles() {
        List<Forme> obstacles = new ArrayList<>();
        int nombreObstacles = 15;
        int largeurEcran = 600; // Largeur maximale du panel
        int hauteurEcran = 400; // Hauteur maximale du panel
        int rayonMax = 25; // Rayon maximal pour les cercles

        for (int i = 0; i < nombreObstacles; i++) {
            boolean chevauchement;
            do {
                chevauchement = false;

                // Génération aléatoire des coordonnées de la forme
                int x = (int) (Math.random() * largeurEcran);
                int y = (int) (Math.random() * hauteurEcran);

                // Déterminer si la forme doit être à gauche ou à droite
                boolean gauche = x < largeurEcran / 2;

                // Génération aléatoire du type de forme (cercle ou rectangle)
                if (Math.random() < 0.5) {
                    int rayon = (int) (Math.random() * rayonMax) + 5;
                    Cercle cercle = new Cercle(new Point2D(x, y), new Point2D(rayon, rayon), Color.RED);
                    if (cercle.estDedans(new Point2D(x, y)) && (cercle.getPointPosition().getX() + cercle.getRayon() <= largeurEcran)
                            && (cercle.getPointPosition().getY() + cercle.getRayon() <= hauteurEcran)) {
                        for (Forme obstacle : obstacles) {
                            if (obstacle.collisionAvec(cercle)) {
                                chevauchement = true;
                                break;
                            }
                        }
                        if (!chevauchement && ((gauche && x + cercle.getRayon() <= largeurEcran / 2) || (!gauche && x + cercle.getRayon() >= largeurEcran / 2))) {
                            obstacles.add(cercle);
                        }
                    }
                } else {
                    int largeur = (int) (Math.random() * 50);
                    int longueur = (int) (Math.random() * 50);
                    Rectangle rectangle = new Rectangle(new Point2D(x, y), new Point2D(x + largeur, y + longueur), Color.RED);
                    if (rectangle.estDedans(new Point2D(x, y)) && (rectangle.getPointPosition().getX() + rectangle.getLongueur() <= largeurEcran)
                            && (rectangle.getPointPosition().getY() + rectangle.getLargeur() <= hauteurEcran)) {
                        for (Forme obstacle : obstacles) {
                            if (obstacle.collisionAvec(rectangle)) {
                                chevauchement = true;
                                break;
                            }
                        }
                        if (!chevauchement && ((gauche && x + largeur <= largeurEcran / 2) || (!gauche && x >= largeurEcran / 2))) {
                            obstacles.add(rectangle);
                        }
                    }
                }
            } while (chevauchement);
        }

        return obstacles;
    }
}
