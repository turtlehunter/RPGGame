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

    public void generateTestLevel() {
        //Generate First Room
        objects.add(new Wall(200, 200, 1, 300)); //standard size = 300 left wall
        //objects.add(new Wall(500, 200, 1, 300)); //right wall
        objects.add(new Wall(500, 200, 1, 100)); //hole in right first half
        objects.add(new Wall(500, 400, 1, 100)); //hole in right second half
        objects.add(new Wall(200, 200, 300, 1)); //bottom wall
        objects.add(new Wall(200, 500, 100, 1)); //hole in top first half
        objects.add(new Wall(400, 500, 100, 1)); //hole in top second half

        //Generate Hallway 1
        objects.add(new Wall(300, 500, 1, 200));
        objects.add(new Wall(400, 500, 1, 200)); //last arg = length of halway up

        //Generate Second Room
        objects.add(new Wall(400, 700, 100, 1)); //y = previousY + length(500 + 200) //first half of room opened in the bottom
        objects.add(new Wall(200, 700, 100, 1)); //first half of wall opened in the bottom
        objects.add(new Wall(200, 700, 1, 300));
        objects.add(new Wall(500, 700, 1, 300));
        objects.add(new Wall(200, 1000, 300, 1));

        //Generate Hallway 2
        objects.add(new Wall(500, 400, 100, 1)); //top wall 100 so shorter halfway than 200
        objects.add(new Wall(500, 300, 100, 1)); //top wall
        objects.add(new Wall(600, 200, 1, 100)); //hole in left first half
        objects.add(new Wall(600, 400, 1, 100)); //hole in left second half
        objects.add(new Wall(600, 200, 300, 1)); //bottom wall
        objects.add(new Wall(600, 500, 300, 1)); //top wall
        objects.add(new Wall(900, 200, 1, 300)); //right wall

    }

    public Game() {
        objects = new ArrayList<GameObject>();
        remove = new ArrayList<GameObject>();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);

        objects.add(player);
        generateTestLevel();
        //objects.add(new Cube(32, 32));
        //objects.add(new CookieMonster(300, 500, 1));
        //objects.add(new Wall(200, 200, 1, 300));
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
