package me.urielsalis.RPGGame.base.engine;

import org.lwjgl.util.Rectangle;

/**
 * @author urielsalis
 */
public class Physics {
    public static GameObject checkCollision(GameObject go1, GameObject go2) {
        Rectangle r1 = new Rectangle((int) go1.getX(), (int) go1.getY(), (int) go1.getSX(), (int) go1.getSY());
        Rectangle r2 = new Rectangle((int) go2.getX(), (int) go2.getY(), (int) go2.getSX(), (int) go2.getSY());

        if(r1.intersects(r2)) return go2;

        return null;
    }

}
