package me.urielsalis.RPGGame.base.game;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.gameobject.Player;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class Game {
    private ArrayList<GameObject> objects;
    private Player player;

    public Game() {
        objects = new ArrayList<GameObject>();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);

        objects.add(player);
    }

    public void getInput() {
        player.getInput();
    }

    public void update() {
        for(GameObject go: objects)
            go.update();
    }

    public void render() {
        for(GameObject go: objects)
            go.render();
    }
}
