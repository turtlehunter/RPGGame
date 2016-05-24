package me.urielsalis.RPGGame.base.engine;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * @author urielsalis
 */
public abstract class GameObject {
    protected float x;
    protected float y;
    protected Sprite spr;

    public void render() {
        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            spr.render();
        }
        glPopMatrix();
    }

    public void update() {

    }

    public Sprite getSpr() {
        return spr;
    }

    public void setSpr(Sprite spr) {
        this.spr = spr;
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

    public float getSX() {
        return spr.getSx();
    }

    public float getSY() {
        return spr.getSy();
    }

    protected void init(float x, float y, float r, float g, float b, float sx, float sy) {
        this.x = x;
        this.y = y;
        this.spr = new Sprite(r, g, b, sx, sy);
    }

}
