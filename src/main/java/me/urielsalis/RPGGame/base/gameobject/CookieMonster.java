package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.engine.Main;

import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class CookieMonster extends Enemy {
    public static final int SIZE = 32;
    public static final float DAMPING = 0.5f;
    public CookieMonster(float x, float y, int level) {
        super(level);
        this.init(x, y, 0.2f, 0.2f, 1f, SIZE, SIZE, 0);
    }

    @Override
    protected void Look() {
        ArrayList<GameObject> obj = Main.sphereCollide(x, y, 128);

        for(GameObject go: obj)
            if(go.getType() == PLAYER_ID)
                setTarget(go);
    }

    @Override
    protected void Chase() {
        float speedX = (getTarget().getX() - x);
        float speedY = (getTarget().getY() - y);

        float maxSpeed = getStats().getSpeed() * DAMPING;

        if(speedX > maxSpeed)
            speedX = maxSpeed;
        if(speedX < -maxSpeed)
            speedX = -maxSpeed;
        if(speedY > maxSpeed)
            speedY = maxSpeed;
        if(speedY < -maxSpeed)
            speedY = -maxSpeed;

        x += speedX;
        y += speedY;
    }

}
