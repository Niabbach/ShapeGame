# ShapeGame


ShapeGame est un petit jeu graphique en Java permettant de créer, déplacer, redimensionner et supprimer des formes géométriques (cercles et rectangles) dans une interface utilisateur interactive. Ce projet met en œuvre un modèle MVC simple, la gestion d’états pour les interactions utilisateur, ainsi qu’une gestion d’historique des actions (undo/redo).

---

## Fonctionnalités principales

- Création de formes : cercles et rectangles.
- Déplacement, redimensionnement et suppression de formes.
- Gestion des états de l’interface pour des interactions intuitives.
- Affichage dynamique des formes dans une fenêtre graphique.
- Affichage d’un tableau listant les formes et leur état.
- Undo / Redo des actions utilisateur.
- Calcul et affichage d’un score lié aux formes créées.
- Initialisation du jeu avec des obstacles aléatoires.

---

## Architecture et organisation

Le projet est organisé en plusieurs packages :

-**shapegame.modele** : Contient la logique métier (modèle), notamment la classe `Jeu`, les formes (`Cercle`, `Rectangle`), et les joueurs.

-**shapegame.vue** : Contient les composants graphiques Swing, les vues pour chaque forme (`CercleVue`, `RectangleVue`), la fenêtre principale (`JFrameJeu`), ainsi que le conteneur des vues et l’interface graphique globale.

-**shapegame.etat** : Gère les différents états du jeu liés aux actions utilisateur (création, déplacement, suppression, etc.).

-**shapegame.strategie** : Stratégies pour l'initialisation du jeu, comme l’implantation d’obstacles aléatoires.

-**shapegame.observateur** : Interface d’écouteur pour la mise à jour des vues.

-**shapegame.vue.composant** : Composants personnalisés Swing (ex : `Bouton`).

## Utilisation

### Lancer le jeu

Le jeu se lance via la classe principale `Main` :

```bash
java shapegame.Main
```

Cette commande démarre la fenêtre graphique et initialise un jeu avec un joueur humain, des obstacles aléatoires, et une interface utilisateur interactive.

---

## Détails techniques

* **Langage** : Java
* **Interface graphique** : Swing (JFrame, JPanel, JButton, JTable, etc.)
* **Modèle-Vue-Contrôleur (MVC)** : Séparation claire entre modèle (logique), vue (affichage) et contrôleur (gestion des événements via états).
* **Gestion des états** : via le pattern état, chaque mode d’interaction (création cercle, déplacement, etc.) est encapsulé dans une classe dédiée.
* **Observateur** : Le modèle notifie la vue pour mettre à jour l’affichage après chaque modification.
* **Undo / Redo** : Méthodes dans la classe `Jeu` permettent d’annuler ou refaire les actions.
* **Tableau des formes** : Affiche la liste des formes avec un modèle personnalisé `AdaptateurJTable`.
* **Gestion du score** : Calcul et affichage en temps réel.

  ---

  ## Structure des classes principales


  * `shapegame.GUI` : Classe utilitaire pour lancer l’interface graphique.
  * `shapegame.Main` : Point d’entrée du programme.
  * `shapegame.vue.JFrameJeu` : Fenêtre principale Swing.
  * `shapegame.vue.InterfaceGraphique` : Conteneur des boutons, tableau et zone de dessin.
  * `shapegame.vue.VueConteneur` : JPanel qui affiche toutes les formes.
  * `shapegame.modele.Jeu` : Classe centrale du modèle.
  * `shapegame.modele.forme.Cercle` et `Rectangle` : Représentation des formes géométriques.
  * `shapegame.etat.EtatCreationCercle`, `EtatDeplacement`, etc. : États pour gérer les interactions.

    ---

    ## Auteur


    * Channel NIANGA
