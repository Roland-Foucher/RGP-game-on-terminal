# RPG GAME PROJECT ON TERMINALE

## Contexte

Ce projet a été effectué lors de ma formation de développeur web et web mobile.
Le sujet est la création d'un jeu en Java, avec un affichage et une interaction avec l'utilisateur sur le terminal.

Ce projet m'a permis de travailler sur les éléments suivants :

* POO
* Héritage
* Interfaces
* Tests Unitaires / Mock
* Algorithmes avec Java

## Stack technique 

* Java 17
* Junit-Jupiter 5.5.1
* Mockito 4.1.0

Sur la branche 2Dscene : Un début de mise en forme 2D avec Swing et awt

## base

Le joueur choisi 4 personnages, il choisit quel personnage joue à son tour.
Chaque personnage à 
* une Arme avec points d'attaques,
* un pouvoir avec points de mana,
* n points de vie, 
* n points de mana

Il existe 7 personnages : l'Orc, le chevalier, le magicien, l'elfe, le nécromancien, le druide et l'assassin.

* Orc : beaucoup de puissance weapon
* Chevalier : a une armure qui diminue la valeur d'attaque des adversaires. Peu augmenter son armure avec son pouvoir mana
* magicien : beaucoup de mana et pouvoir assez puissant
* elfe : peut se soigner
* nécro : peut ressusciter un joueur avec moitié de vie
* druide : attack mana très puissante mais coute tout le mana
* assassin : mana tue en 1 cout et coute tout le mana, peu de vie
  
Le joueur à 2 cartes optionnelles pour redonner de la vie ou du mana à un personnage.

Il y a deux modes de jeux : player vs player et player vs computer.

## Déroulé

### Init

* Le programme s'initialise en présentant globalement le jeu et les personnages
* L'utilisateur choisie le mode entre player vs player et player vs computer.
* Les players choisissent leurs noms et leurs 4 personnages. Il ne peut pas avoir deux personnages identiques
  

### affichage

* Le terminal affiche l’arène avec les 4 personnages de chaque joueurs, leurs points de vie et de mana. Le chevalier affiche son armure.
* S'affiche en dessous le choix du personnage à jouer avec son type d'attaque weapon et mana
* un personnage mort sera suivi d'une tête de mort sur son nom
### déroulé

Jusqu’à qu'un joueur n'ait plus de perso vivant :

* le joueur choisie son perso
* il choisit s'il attaque ou lui donne une carte soin/mana
* S'il choisit carte, choisie entre health et mana à appliquer
* s'il choisit attack choisie weapon ou mana
* il choisit ensuite l'adversaire à attaquer
  
### fin du jeu

* Le joueur n'ayant plus de perso perd,
* Le gagnant implémente son nombre de victoires
* Les joueurs peuvent choisir de rejouer une partie

## Author

Roland FOUCHER