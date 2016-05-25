package me.urielsalis.RPGGame.base.gameobject;

/**
 * @author urielsalis
 */
public class Stats {
    public static final double LEVEL_CONST = 25 * Math.pow(3, (3.0/2.0));

    private float xp;
    private int health;

    public Stats(float xp) {
        this.xp = xp;
        this.health = getMaxHealth();
    }

    public float getSpeed() {
        return 4f; //Will be replaced
    }

    public int getLevel() {
        double x = xp + 105; //Level 1 = 105xp, so move it so level 1 = 0xp

        double a = Math.sqrt(243 * (x * x) + 4050 * x + 17500); //almost logaritmic, exponential increase over time
        double c = (3 * x + 25)/25; //lineal ecuation
        double d = Math.cbrt(a / LEVEL_CONST + c); //combine both

        return (int) (d - (1.0 / d * 3)) - 1; //avoid starting in level -1
    }

    public int getMaxHealth() {
        return getLevel() * 10;
    }

    public float getXp() {
        return xp;
    }

    public void setXp(float xp) {
        this.xp = xp;
    }

    public void addXp(float amt) {
        xp += amt;
    }

    public float getStrength() {
        return getLevel() * 4f;
    }

    public float getMagic() {
        return getLevel() * 4f;
    }

    public int getCurrentHealth() {
        int max = getMaxHealth();
        if(health > max)
            health = max;

        return health;
    }

}
