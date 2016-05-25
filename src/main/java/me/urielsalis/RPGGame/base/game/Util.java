package me.urielsalis.RPGGame.base.game;

import me.urielsalis.RPGGame.base.engine.GameObject;

/**
 * @author urielsalis
 */
public class Util {
    public static boolean LineOfSight(GameObject go1, GameObject go2) {
        return true;
    }

    public static float dist(float x1, float y1, float x2, float y2) {
        float x = x2 - x1;
        float y = y2 - y1;

        return (float) Math.sqrt((x * x) + (y * y));
    }
}
