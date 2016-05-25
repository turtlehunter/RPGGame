package me.urielsalis.RPGGame.base.gameobject.item;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.engine.Physics;
import me.urielsalis.RPGGame.base.engine.Sprite;
import me.urielsalis.RPGGame.base.gameobject.Player;

/**
 * @author urielsalis
 */
public class Item extends GameObject {
    protected String name;
    protected Player player;

    public Item(Player play) {
        this.player = play;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void pickUp() {
        System.out.println("You just picked up " + name + "!");
        player.addItem(this);
        remove();

    }

    protected void init(float x, float y, float r, float g, float b, float sx, float sy, String name) {
        this.x = x;
        this.y = y;
        this.type = 1;
        this.spr = new Sprite(r, g, b, sx, sy);
        this.name = name;
    }

    @Override
    public void update() {
        if (Physics.checkCollision(this, player))
            pickUp();
    }
}
