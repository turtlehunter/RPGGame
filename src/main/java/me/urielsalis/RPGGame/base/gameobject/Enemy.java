package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.game.Util;

/**
 * @author urielsalis
 */
public class Enemy  extends GameObject {
    private Stats stats;
    private GameObject target;

    public Enemy(int level) {
        stats = new Stats(level, false);
        target = null;
    }

    @Override
    public void update() {
        if(target == null)
            Look();
        else {
            Chase();

            if(Util.LineOfSight(this, target)) {
                Attack();
            }
        }

        if(stats.getCurrentHealth() <= 0)
            Die();
    }

    protected void Attack() {

    }

    protected void Chase() {

    }

    protected void Look() {

    }

    protected void Die() {

    }

    public void setTarget(GameObject go) {
        target = go;
    }

    public GameObject getTarget() {
        return target;
    }

    public Stats getStats() {
        return stats;
    }


}
