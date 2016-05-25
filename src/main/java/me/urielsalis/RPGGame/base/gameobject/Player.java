package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.gameobject.item.Item;
import org.lwjgl.input.Keyboard;

/**
 * @author urielsalis
 */
public class Player extends GameObject {
    public static final int SIZE = 32;

    private Stats stats;
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
        x += getSpeed() * magX;
        y += getSpeed() * magY;
    }

    @Override
    public void update() {
        //System.out.println("Stats: SPEED: " + getSpeed() + " LEVEL: " + getLevel() + " MAXHP: " + getMaxHealth() + " HP: " + getCurrentHealth() + " STREGTH: " + getStrength() + " MAGIC: " + getMagic());
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public float getSpeed() {
        return stats.getSpeed();
    }

    public int getLevel() {
        return stats.getLevel();
    }

    public int getMaxHealth() {
        return stats.getMaxHealth();
    }

    public float getXp() {
        return stats.getXp();
    }

    public void setXp(float xp) {
        stats.setXp(xp);
    }

    public void addXp(float amt) {
        stats.addXp(amt);
    }

    public float getStrength() {
        return stats.getStrength();
    }

    public float getMagic() {
        return stats.getMagic();
    }

    public int getCurrentHealth() {
        return stats.getCurrentHealth();
    }
}
