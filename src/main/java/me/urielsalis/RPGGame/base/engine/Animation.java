package me.urielsalis.RPGGame.base.engine;

import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class Animation {
    private ArrayList<Frame> frames;
    private int curFrame;


    public Animation() {
        frames = new ArrayList<Frame>();
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }

    public void setFrames(ArrayList<Frame> frames) {
        this.frames = frames;
    }

    public int getCurFrame() {
        return curFrame;
    }

    public void setCurFrame(int curFrame) {
        this.curFrame = curFrame;
    }

    public void render() {
        Frame temp = frames.get(curFrame);

        if(temp.render()) {
            curFrame++;
            curFrame %= frames.size();
        }
    }
}
