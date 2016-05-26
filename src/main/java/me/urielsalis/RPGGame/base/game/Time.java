package me.urielsalis.RPGGame.base.game;

/**
 * @author urielsalis
 */
public class Time {
    public static final float DAMPING = 18000000;

    public static long curTime;
    private static long lastTime;

    public static long getTime() {
        return System.nanoTime();
    }

    public static float getDelta() {
        return (curTime - lastTime) / DAMPING;
    }

    public static void update() {
        lastTime = curTime;
        curTime = getTime();
    }

    public static void init() {
        curTime = getTime();
        lastTime = getTime();
    }
}
