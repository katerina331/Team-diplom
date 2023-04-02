package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void containsGameFails() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game findGame = new Game("Шашки", "Стратегия", store);

        assertFalse(store.containsGame(findGame));
    }

    @Test
    public void publishGame() {

        GameStore store = new GameStore();

        Game expected = new Game("Нетология Баттл Онлайн", "Аркады", store);
        Game actual = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void getSumPlayedTime() {

        GameStore store = new GameStore();

        int expected = 10;
        store.addPlayTime("Коля", expected);
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void getSumPlayedTimeSecond() {

        GameStore store = new GameStore();

        int expected = 20;
        store.addPlayTime("Коля", 5);
        store.addPlayTime("Коля", 15);
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void getSumTwoPlayedTime() {

        GameStore store = new GameStore();

        int expected = 25;
        store.addPlayTime("Коля", 13);
        store.addPlayTime("Вася", 12);
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerMaxK() {

        GameStore store = new GameStore();

        String expected = "Коля";
        store.addPlayTime("Коля", 13);
        store.addPlayTime("Вася", 12);
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerNull() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();

        assertNull(actual);
    }
    // другие ваши тесты
}
