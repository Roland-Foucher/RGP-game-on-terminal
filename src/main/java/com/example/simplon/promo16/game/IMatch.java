package com.example.simplon.promo16.game;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public interface IMatch {

    /**
     * methode to run the game and loop player turn while a player loose.
     * select the game mode and init players. 
     * 
     * players can replay game.
     */
    public void runProgramme();

    /**
     * While nobody loose, player play one by one with call playerTurn methode
     * display the arena before each turn.
     */
    public void playerMatch(PlayerTurnService playerTurnType1, PlayerTurnService playerTurnType2);
    
     /**
     * Get +1 to one player if other loose
     */
    public void playerLoose();
    
    /**
     * display the choose of perso and make player
     * 
     * @param playerName name choose by user to the player
     * @return player to make
     */
    public Player personnageInitChoice(String playerName);

     /**
     * switch between the 7 perso to add the perso selected by user
     * 
     * @param persoChoosen number choose by user
     * @return perso to add to player
     */
    public Perso choosePerso(int persoChoosenID);

    /**
     * make a player with the choose of user
     * 
     * @param userChoosePerso1 int choose by user for perso one
     * @param userChoosePerso2 int choose by user for perso two
     * @param userChoosePerso3 int choose by user for perso three
     * @param userChoosePerso4 int choose by user for perso four
     * @return player created
     */
    public Player makePlayer(int userChoosePerso1, int userChoosePerso2, int userChoosePerso3, int userChoosePerso4,
            String name);

    /**
     * make a player with random number, can't have two same perso. 
     * @return Player for computer
     */
    public Player makePlayerComputer();

}
