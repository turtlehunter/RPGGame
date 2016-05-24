package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.gameobject.item.Item;
import org.lwjgl.input.Keyboard;

/**
 * @author urielsalis
 */
public class Player extends GameObject {
    public static final int SIZE = 32;
    public static final double LEVEL_CONST = 25 * Math.pow(3, (3.0/2.0));

    private int health;
    private float xp;

    public Player(float x, float y) {
        init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE, 0);
        health = 10;
        xp = 0;
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

    public float getSpeed() {
        return 4f; //Will be replaced
    }

    public int getLevel() {
        double x = xp + 105; //Level 1 = 105xp, so move it so level 1 = 0xp

        double a = Math.sqrt(243 * (x * x) + 4050 * x + 17500); //almost logaritmic, exponential increase over time
        double c = (3 * x + 25)/25; //lineal ecuation
        double d = Math.cbrt(a / LEVEL_CONST + c); //combine both

        return (int) (d - (1.0 / d * 3)) - 1; //avoid starting in level -1
    }

    public int getMaxHealth() {
        return getLevel() * 10;
    }

    public float getXp() {
        return xp;
    }

    public void setXp(float xp) {
        this.xp = xp;
    }

    public void addXp(float amt) {
        xp += amt;
    }

    public float getStrength() {
        return getLevel() * 4f;
    }

    public float getMagic() {
        return getLevel() * 4f;
    }

    public int getCurrentHealth() {
        int max = getMaxHealth();
        if(health > max)
            health = max;

        return health;
    }

    @Override
    public void update() {
        //System.out.println("Stats: SPEED: " + getSpeed() + " LEVEL: " + getLevel() + " MAXHP: " + getMaxHealth() + " HP: " + getCurrentHealth() + " STREGTH: " + getStrength() + " MAGIC: " + getMagic());
    }

    public void addItem(Item item) {
        System.out.println("We just picked up an item!");
    }
}
