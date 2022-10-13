package edu.sdccd.cisc191.template;

/**
 * Outline for games. This is only general concepts or bodies
 * of what a game should consist. Specifics are within the
 * respective classes of each game.
 */

public interface Game {
    //  contains introduction/ setup for the game.
    void GameSetup();

    //  contains game itself.
    void GameStart();

    //  contains post game actions.
    void GameEnd();

}
