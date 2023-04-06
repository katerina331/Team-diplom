package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreInTwoGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Полет", "Симулятор");
        Game game2 = store.publishGame("Гонки", "Симулятор");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 5);
        player.play(game2, 10);
        player.play(game3, 3);

        int expected = 15;
        int actual = player.sumGenre("Симулятор");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Полет", "Симулятор");
        Game game2 = store.publishGame("Гонки", "Симулятор");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 5);
        player.play(game2, 10);
        player.play(game3, 3);

        Game expected = game2; // исправлен ожидаемый результат
        Game actual = player.mostPlayerByGenre("Симулятор");
        assertEquals(expected, actual);
    }

    @Test
    public void addGameWhenGameAlreadyInstalled() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Полет", "Симулятор");
        Game game2 = store.publishGame("Гонки", "Симулятор");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 5);
        player.installGame(game1);

        int expected = 5;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenGameNotInstalled() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Полет", "Симулятор");
        Game game2 = store.publishGame("Гонки", "Симулятор");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);


        assertThrows(RuntimeException.class, () -> {
            player.play(game3, 3);

        });
    }
    @Test
    public void shouldAddPlayerName() {

        Player player = new Player("Kolya");

        String expected = "Kolya";
        String actual = player.getName();

        Assertions.assertEquals(expected, actual);
    }

}
