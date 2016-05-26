package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.game.Time;
import me.urielsalis.RPGGame.base.gameobject.item.Item;
import org.lwjgl.input.Keyboard;

import static me.urielsalis.RPGGame.base.game.Time.getDelta;

/**
 * @author urielsalis
 */
public class Player extends StatObject {
    public static final int SIZE = 32;

    private Inventory inventory;

    public Player(float x, float y) {
        init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE, PLAYER_ID);
        stats = new Stats(0, true);
        inventory = new Inventory(20);
    }

    public void getInput() {
        if(Keyboard.isKeyDown(Keyboard.KEY_W))
            move(0, 1);
        if(Keyboard.isKeyDown(Keyboard.KEY_S))
            move(0, -1);
        if(Keyboard.isKeyDown(Keyboard.KEY_A))
            move(-1, 0);
        if(Keyboard.isKeyDown(Keyboard.KEY_D))
            move(1, 0);
    }

    private void move(float magX, float magY) {
        x += getSpeed() * magX * Time.getDelta();
        y += getSpeed() * magY * Time.getDelta();
    }

    @Override
    public void update() {
        //System.out.println("Stats: SPEED: " + getSpeed() + " LEVEL: " + getLevel() + " MAXHP: " + getMaxHealth() + " HP: " + getCurrentHealth() + " STREGTH: " + getStrength() + " MAGIC: " + getMagic());
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
}
