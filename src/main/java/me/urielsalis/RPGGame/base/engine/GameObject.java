package me.urielsalis.RPGGame.base.engine;

/**
 * @author urielsalis
 */
public abstract class GameObject {
    private float x;
    private float y;
    private Animation anim;

    public void render() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Animation getAnim() {
        return anim;
    }

    public void setAnim(Animation anim) {
        this.anim = anim;
    }

    public void update() {

    }

}
