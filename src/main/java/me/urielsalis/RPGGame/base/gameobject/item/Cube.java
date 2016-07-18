package me.urielsalis.RPGGame.base.gameobject.item;

import me.urielsalis.RPGGame.base.engine.Physics;
import me.urielsalis.RPGGame.base.gameobject.Player;

/**
 * @author urielsalis
 */
public class Cube  extends Item {
    public static final int SIZE = 32;

    public Cube(float x, float y) {
        init(x, y, 1.0f, 0.5f, 0, SIZE, SIZE, "The Cube");
    }
}
