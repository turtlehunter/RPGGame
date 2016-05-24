package me.urielsalis.RPGGame.base.gameobject.item;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.engine.Sprite;

/**
 * @author urielsalis
 */
public class Item extends GameObject {
    protected String name;

    public void pickUp() {

    }

    protected void init(float x, float y, float r, float g, float b, float sx, float sy, String name) {
        this.x = x;
        this.y = y;
        this.type = 1;
        this.spr = new Sprite(r, g, b, sx, sy);
        this.name = name;
    }
}
