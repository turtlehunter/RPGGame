package me.urielsalis.RPGGame.base.gameobject.item;

import me.urielsalis.RPGGame.base.engine.GameObject;

public class Wall extends GameObject{
    public static final int SIZE = 32;

    public Wall(float x, float y, float sizeX, float sizeY) {
        init(x, y, 1.0f, 0.5f, 0, sizeX, sizeY, DEFAULT_ID);
        setSolid(true);
    }
}
