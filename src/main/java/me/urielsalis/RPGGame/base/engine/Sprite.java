package me.urielsalis.RPGGame.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author urielsalis
 */
public class Sprite {
    private float r;
    private float g;
    private float b;

    private float sx;
    private float sy;

    public void render() {
        glColor3f(r, g, b);
        glBegin(GL_QUADS);
        {
            glVertex2f(0, 0);
            glVertex2f(0, sy);
            glVertex2f(sx, sy);
            glVertex2f(sx, 0);
        }
        glEnd();
    }

    public Sprite(float r, float g, float b, float sx, float sy) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.sx = sx;
        this.sy = sy;

    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getSx() {
        return sx;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public float getSy() {
        return sy;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }
}
