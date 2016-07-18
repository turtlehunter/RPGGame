package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.game.RPGRandom;

public class StatScale {
    public static final int NUM_STATS = 8;
    public static final double MIN_STATSCALE = 0.125;
    private static final double MAX_STAT_BOOST = 0.25;

    public static final int VITALITY = 0;
    public static final int SPEED = 1;
    //public static final int UNKNOWN1 = 2;
    //public static final int UNKNOWN2 = 3;
    public static final int STRENGTH = 4;
    public static final int DEFENSE = 5;
    public static final int MAGIC = 6;
    public static final int MAGICDEFENSE = 7;

    private double[] scales;
    private double[] scaleBonus;

    public StatScale() {
        scales = new double[NUM_STATS];
        scaleBonus = new double[NUM_STATS];
    }

    public void generateStatScale() {
        double sum = 0;
        for(int i=0; i < NUM_STATS; i++) {
            double val = RPGRandom.nextDouble(1);
            scales[i] = val;
            sum += val * val;
        }

        sum = Math.sqrt(sum);

        //Normalize scales
        for (int i=0; i < NUM_STATS; i++) {
            scales[i] /= sum;
            if (scales[i] < MIN_STATSCALE) {
                generateStatScale(); //lets hope we arent unlikely enough that we have to re run it 256 times
                return;
            }
        }

    }

    public double getScale(int stat) {
        return scales[stat] + scaleBonus[stat] * MAX_STAT_BOOST;
    }

    public void addScaleBonus(int stat, double bonus) {
        if(bonus > 1)
            bonus = 1;
        else if(bonus < 0)
            bonus = 0;
        scaleBonus[stat] = bonus;
    }
}
