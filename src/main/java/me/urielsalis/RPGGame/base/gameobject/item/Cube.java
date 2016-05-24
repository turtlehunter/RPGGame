package me.urielsalis.RPGGame.base.gameobject.item;

import me.urielsalis.RPGGame.base.engine.Physics;
import me.urielsalis.RPGGame.base.gameobject.Player;

/**
 * @author urielsalis
 */
public class Cube  extends Item {
    public static final int SIZE = 32;

    private Player player;
    public Cube(float x, float y, Player play) {
        init(x, y, 1.0f, 0.5f, 0, SIZE, SIZE, "The Cube");
        this.player = play;
    }

    @Override
    public void pickUp() {
        System.out.println("You just picked up " + name + "!");
        player.addItem(this);
        remove = true;
    }

    @Override
    public void update() {
        if (Physics.checkCollision(this, player))
                pickUp();
    }
}
