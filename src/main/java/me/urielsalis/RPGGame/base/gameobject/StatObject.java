package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.engine.GameObject;

/**
 * @author urielsalis
 */
public class StatObject extends GameObject {
    protected Stats stats;

    public void damage(int amt) {
        stats.damage(amt);
    }

    public float getSpeed() {
        return stats.getSpeed();
    }

    public int getLevel() {
        return stats.getLevel();
    }

    public int getMaxHealth() {
        return stats.getMaxHealth();
    }

    public float getXp() {
        return stats.getXp();
    }

    public void setXp(float xp) {
        stats.setXp(xp);
    }

    public void addXp(float amt) {
        stats.addXp(amt);
    }

    public float getStrength() {
        return stats.getStrength();
    }

    public float getMagic() {
        return stats.getMagic();
    }

    public int getCurrentHealth() {
        return stats.getCurrentHealth();
    }


}
