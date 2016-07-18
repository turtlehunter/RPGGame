package me.urielsalis.RPGGame.base.engine;

import org.lwjgl.util.Rectangle;

/**
 * @author urielsalis
 */
public class Physics {
    public static GameObject checkCollision(GameObject go1, GameObject go2) {
        return checkCollision(new Rectangle((int) go1.getX(), (int) go1.getY(), (int) go1.getSX(), (int) go1.getSY()), go2);
    }

    public static GameObject checkCollision(Rectangle r1, GameObject go2) {
        Rectangle r2 = new Rectangle((int) go2.getX(), (int) go2.getY(), (int) go2.getSX(), (int) go2.getSY());

        return r1.intersects(r2) ? go2 : null;

    }
}
