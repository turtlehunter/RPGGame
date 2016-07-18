package me.urielsalis.RPGGame.base.gameobject;

/**
 * @author urielsalis
 */
public class Stats {
    public static final int MAX_XP = 999999;
    public static final int MAX_LEVEL = 99;
    public static final double LEVEL_CONST = (double)MAX_XP/((double)MAX_LEVEL * (double)MAX_LEVEL);
    //public static final double LEVEL_CONST = 25.0 * Math.pow(3.0, (3.0/2.0)); OLD LEVEL CONSTANT

    private StatScale scale;
    private float xp;
    private int health;
    private boolean levelable;
    private int level;

    public Stats(float xp, boolean levelable) {
        this.levelable = levelable;
        scale = new StatScale();
        //WARNING: Entering the land of the temporary code 17/04/2012
        scale.generateStatScale();
        //Now leaving the land of the temporary code

        if(levelable) {
            this.xp = xp;
            this.level = 1;
        } else {
            this.xp = -1;
            this.level = (int) xp;
        }
        this.health = getMaxHealth();

    }

    public float getSpeed() {
        return (float)(getLevel() * scale.getScale(StatScale.SPEED));
    }

    public int getLevel() {
        if(!levelable) return level;

        //Calculate XP from level = ax^2
        //Calculate level from XP = sqrt(XP/a)

        return (int)Math.sqrt((double)xp/LEVEL_CONST) + 1;

        /* OLD LEVELING FORMULA
        double x = xp + 105; //Level 1 = 105xp, so move it so level 1 = 0xp

        double a = Math.sqrt(243.0 * (x * x) + 4050.0 * x + 17500.0); //almost logaritmic, exponential increase overtime
        double c = (3.0 * x + 25.0)/25.0; //lineal ecuation
        double d = Math.cbrt(a / LEVEL_CONST + c); //combine both

        return (int) (d - (1.0 / d * 3.0)) - 1; //avoid starting in level -1
        */
    }

    public int getMaxHealth() {
        return (int)(getLevel() * scale.getScale(StatScale.VITALITY) * 10);
    }

    public float getXp() {
        return xp;
    }

    public void setXp(float xp) {
        this.xp = xp;
    }

    public void addXp(float amt) {
        xp += amt;
        if(xp > MAX_XP) xp = MAX_XP;
        if(xp < 0) xp = 0;
    }

    public float getStrength() {
        return (float)(getLevel() * scale.getScale(StatScale.STRENGTH) * 10);
    }

    public float getMagic() {
        return (float)(getLevel() * scale.getScale(StatScale.MAGIC) * 10);
    }

    public float getPhysicalDefense() {
        return (float)(getLevel() * scale.getScale(StatScale.DEFENSE) * 10);
    }

    public float getMagicDefense() {
        return (float)(getLevel() * scale.getScale(StatScale.MAGICDEFENSE) * 10);
    }

    public int getCurrentHealth() {
        int max = getMaxHealth();
        if(health > max)
            health = max;

        return health;
    }

    public void damage(int amt) {
        health -= amt;
    }
}
