package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.game.Delay;
import me.urielsalis.RPGGame.base.game.Game;
import me.urielsalis.RPGGame.base.game.Time;
import me.urielsalis.RPGGame.base.game.Util;
import me.urielsalis.RPGGame.base.gameobject.item.Item;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class Player extends StatObject {
    public static final int SIZE = 32;

    public static final int FORWARD = 0;
    public static final int BACKWARD = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;


    private Inventory inventory;
    private Equipment equipment;
    private int attackRange;
    private int facingDirection;
    private Delay attackDelay;
    private int attackDamage;

    public Player(float x, float y) {
        init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE, PLAYER_ID);
        stats = new Stats(0, true);
        inventory = new Inventory(20);
        equipment = new Equipment(inventory);
        attackRange = 49; //1 pixel more so if enemy is moving to us we can hit it
        attackDamage = 1;
        facingDirection = 0;
        attackDelay = new Delay(500);
        attackDelay.terminate();
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
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && attackDelay.isOver())
            attack();

    }

    private void move(float magX, float magY) {
        if(magX == 0 && magY == 1)
            facingDirection = FORWARD;
        else if(magX == 0 && magY == -1)
            facingDirection = BACKWARD;
        else if(magX == -1 && magY == 0)
           facingDirection = LEFT;
        else if(magX == 1 && magY == 0)
            facingDirection = RIGHT;

        x += 4f * magX * Time.getDelta(); //TODO add speed scale
        y += 4f * magY * Time.getDelta();
    }

    @Override
    public void update() {
        //System.out.println("Stats: SPEED: " + getSpeed() + " LEVEL: " + getLevel() + " MAXHP: " + getMaxHealth() + " HP: " + getCurrentHealth() + " STREGTH: " + getStrength() + " MAGIC: " + getMagic());
        ArrayList<GameObject> objects = Game.rectangleCollide(x, y, x+SIZE, y+SIZE);

        for(GameObject go: objects) {
            if(go.getType() == GameObject.ITEM_ID) {
                System.out.println("You just picked up " + ((Item) go).getName() + "!");
                ((Item) go).remove();
                addItem((Item) go);
            }
        }

    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void attack() {
        System.out.print("We are attacking!");
        //find objects in attack range
        ArrayList<GameObject> objects = new ArrayList<>();
        switch (facingDirection) {
            case FORWARD:
                objects = Game.rectangleCollide(x, y, x + SIZE, y + SIZE + attackRange);
                break;
            case BACKWARD:
                objects = Game.rectangleCollide(x, y - attackRange, x + SIZE, y + SIZE);
                break;
            case LEFT:
                objects = Game.rectangleCollide(x - attackRange, y, x + SIZE, y + SIZE);
                break;
            case RIGHT:
                objects = Game.rectangleCollide(x, y, x + SIZE + attackRange, y + SIZE);
                break;
        }

        //find which objects are a enemy
        ArrayList<Enemy> enemies = new ArrayList<>();
        for(GameObject go: objects) {
            if(go.getType() == ENEMY_ID)
                enemies.add((Enemy) go);
        }

        if(enemies.size() > 0) {
            Enemy target = enemies.get(0);

            if(enemies.size() > 1) {
                for (Enemy e : enemies) {
                    if (Util.dist(x, y, e.getX(), e.getY()) < Util.dist(x, y, target.getX(), target.getY()))
                        target = e;

                }
            }

            //Atack the enemy
            target.damage(attackDamage);
            System.out.println(" : " + target.getCurrentHealth() + "/" + target.getCurrentHealth());
        } else {
            System.out.println(" : No target");
        }

        attackDelay.restart();
    }
}
