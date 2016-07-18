package me.urielsalis.RPGGame.base.game;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.engine.Physics;
import me.urielsalis.RPGGame.base.gameobject.*;
import me.urielsalis.RPGGame.base.gameobject.item.*;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;

import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class Game {
    public static Game game;

    private ArrayList<GameObject> objects;
    private ArrayList<GameObject> remove;
    private Player player;

    public Game() {
        objects = new ArrayList<GameObject>();
        remove = new ArrayList<GameObject>();
        RPGRandom.initRand();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);

        objects.add(player);
        objects.add(new Cube(32, 32));
        objects.add(new CookieMonster(300, 500, 1));
    }

    public void getInput() {
        player.getInput();
    }

    public void update() {

        for(GameObject go: objects)
            if(!go.getRemove())
                go.update();
            else
                remove.add(go);

        if(!remove.isEmpty())
            for(GameObject go: remove) {
                objects.remove(go);
            }
    }

    public void render() {
        for(GameObject go: objects)
            go.render();
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public static ArrayList<GameObject> sphereCollide(float x, float y, float radius) {
        ArrayList<GameObject> res = new ArrayList<>();

        for (GameObject go: game.getObjects()) {
            if(Util.dist(go.getX(), go.getY(), x, y) < radius) {
                res.add(go);
            }
        }

        return res;
    }

    public static ArrayList<GameObject> rectangleCollide(float x1, float y1, float x2, float y2) {
        ArrayList<GameObject> res = new ArrayList<>();
        Rectangle collider = new Rectangle((int) x1, (int) y1, (int) (x2 - x1), (int) (y2 - y1));

        for (GameObject go: game.getObjects()) {
            if(Physics.checkCollision(collider, go) != null)
                res.add(go);
        }

        return res;
    }
}
