# RPG GAME PROJECT ON TERMINALE

## Context

Ce projet a été efféctué lors de ma foramtion de developpeur web et web mobile.
Le sujet est la création d'un jeu en Java, avec un affichage et une interraction avec l'utilisateur sur le terminal.

Ce projet m'a permis de travailler sur les éléments suivants :

* POO
* Héritage
* Interfaces
* Tests Unitaires / Mock
* Algoritmie avec Java

## Stack technique 

* Java 17
* Junit-Jupiter 5.5.1
* Mockito 4.1.0

sur la branche 2Dscene : Un début de mise en forme 2D avec Swing et awt

## base

Le joueur choisi 4 personnages, il choisi quel personnage joue à son tour.
Chaques personnage à 
* une Arme avec points d'attaques,
* un pouvoir avec points de mana,
* n points de vie, 
* n points de mana

Il existe 7 personnage  : l'Orc, le chevalier, le magicien, l'elfe, le necromencien, le druide et l'assasin.

* Orc : beaucoup de puissance weapon
* Chevalier : a une armure qui diminue la valeur d'attaque des adveraire. peu augmenter qon armure avec son pouvoir mana
* magicien : beaucoup de mana et pouvoir assez puissant
* elfe : peut se soigner
* necro : peut ressuciter un joueur avec moitier de vie
* druide : attack mana très puissante mais coute toute la mana
* assassin : mana tue en 1 cout et coute toute la mana, peu de vie
  
Le joueur à 2 carte optionnel pour redonner de la vie ou de la mana à un personnage.

Il y a deux modes de jeux : player vs player et player vs computer.

## Deroulé

### Init

* Le programme s'initialise en présentant globalement le jeu et les personnages
* L'utilisateur choisie le mode entre player vs player et player vs computer.
* Les players choissient leurs noms et leurs 4 personnages. Il ne peux pas avoir deux personnages identiques
  

### affichage

* Le terminal affiche l'arene avec les 4 perosnnages de chaques joueurs, leurs points de vie et de mana. Le chevalier affiche son armure.
* S'affiche en dessous le choix du personnage à jouer avec son type d'attaque weapon et mana
* un personnage mort dera suivie d'une tete de mort sur son nom

### deroulé

jusqu'à qu'un joueur n'ait plus de perso vivants :

* le joueur choisie son perso
* il choisie s'il attaque ou lui donne une carte soin/mana
* S'il choisie carte, choisie entre health et mana a appliquer
* s'il choisie attack choisie weapon ou mana
* il choisie ensuite l'adversaire à attaquer
  
### fin du jeu

* Le joueur n'ayant plus de perso perd,
* Le gagnant implemente son nombre de victoires
* Les joueurs peuvent choisir de rejouer une partie

## Author

Roland FOUCHER
