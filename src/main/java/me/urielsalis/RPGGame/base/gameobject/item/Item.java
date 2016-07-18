package me.urielsalis.RPGGame.base.gameobject.item;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.engine.Sprite;

/**
 * @author urielsalis
 */
public class Item extends GameObject {
    protected String name;

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void init(float x, float y, float r, float g, float b, float sx, float sy, String name) {
        this.x = x;
        this.y = y;
        this.type = ITEM_ID;
        this.spr = new Sprite(r, g, b, sx, sy);
        this.name = name;
    }

    @Override
    public void update() {
        //if (Physics.checkCollision(this, player) != null)
        //    pickUp();
    }
}
