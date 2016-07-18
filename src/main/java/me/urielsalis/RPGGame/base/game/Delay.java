package me.urielsalis.RPGGame.base.game;

/**
 * @author urielsalis
 */
public class Delay {
    private int length;
    private long endTime;
    private boolean started;

    public Delay(int length) {
        this.length = length;
        started = false;
    }

    public boolean isOver() {
        return started && Time.getTime() >= endTime;

    }

    public boolean isActive() {
        return started;
    }

    public void restart() {
        started = true;
        endTime = length * 1000000 + Time.getTime();
    }

    public void stop() {
        started = false;
    }

    public void terminate() {
        started = true;
        endTime = 0;
    }
}
