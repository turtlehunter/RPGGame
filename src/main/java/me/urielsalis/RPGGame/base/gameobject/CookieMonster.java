package me.urielsalis.RPGGame.base.gameobject;

/**
 * @author urielsalis
 */
public class CookieMonster extends Enemy {
    public static final int SIZE = 32;

    public CookieMonster(float x, float y, int level) {
        super(level);
        init(x, y, 0.2f, 0.2f, 1f, SIZE, SIZE, 0);
        setAttackDelay(500);
    }

}
