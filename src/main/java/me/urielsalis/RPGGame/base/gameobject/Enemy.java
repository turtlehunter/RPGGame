package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.engine.Main;
import me.urielsalis.RPGGame.base.game.Delay;
import me.urielsalis.RPGGame.base.game.Time;
import me.urielsalis.RPGGame.base.game.Util;

import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class Enemy  extends StatObject {
    public static final float DAMPING = 0.5f;

    private StatObject target;
    private float attackRange;
    private int attackDamage;
    private Delay attackDelay;
    private float sightRange;

    public Enemy(int level) {
        stats = new Stats(level, false);
        target = null;
        attackRange = 48f;
        attackDamage = 1;
        sightRange = 128f;
        attackDelay = new Delay(0);
        attackDelay.end();
    }

    @Override
    public void update() {
        if(target == null)
            Look();
        else {
            if(Util.LineOfSight(this, target) && Util.dist(x, y, getTarget().getX(), getTarget().getY()) < attackRange) {
                if (attackDelay.over()) {
                    Attack();
                }
            } else {
                Chase();
            }

        }

        if(stats.getCurrentHealth() <= 0)
            Death();
    }

    protected void Attack() {
        getTarget().damage(getAttackDamage());
        restartAttackDelay();
    }

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

        x += speedX * Time.getDelta();
        y += speedY * Time.getDelta();
    }

    protected void Look() {
        ArrayList<GameObject> obj = Main.sphereCollide(x, y, sightRange);

        for(GameObject go: obj)
            if(go.getType() == PLAYER_ID)
                setTarget((StatObject) go);
    }

    protected void Death() {
        remove();
    }

    public void setTarget(StatObject go) {
        target = go;
    }

    public StatObject getTarget() {
        return target;
    }

    public Stats getStats() {
        return stats;
    }


    public void setAttackRange(float attackRange) {
        this.attackRange = attackRange;
    }

    public void setAttackDelay(int time) {
        attackDelay = new Delay(time);
        attackDelay.end();
    }

    public void restartAttackDelay() {
        attackDelay.start();
    }

    public void setAttackDamage(int amt) {
        attackDamage = amt;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setSightRange(float distance) {
        this.sightRange = distance;
    }

}
