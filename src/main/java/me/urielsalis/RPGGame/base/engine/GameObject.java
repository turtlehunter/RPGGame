package me.urielsalis.RPGGame.base.engine;

import me.urielsalis.RPGGame.base.game.Game;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * @author urielsalis
 */
public abstract class GameObject {
    public static final int DEFAULT_ID = 0;
    public static final int ITEM_ID = 1;
    public static final int PLAYER_ID = 2;
    public static final int ENEMY_ID = 3;

    protected float x;
    protected float y;
    protected Sprite spr;
    protected int type = 0;

    protected boolean[] flags = new boolean[2];

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

    public int getType() {
        return type;
    }

    protected void init(float x, float y, float r, float g, float b, float sx, float sy, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.spr = new Sprite(r, g, b, sx, sy);
    }

    public boolean getRemove() {
        return flags[0];
    }

    public boolean getSolid() {
        return flags[1];
    }

    public void remove() {
        flags[0] = true;
    }
    public void setSolid(boolean value) {
        flags[1] = value;
    }


}
