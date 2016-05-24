package me.urielsalis.RPGGame.base.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author urielsalis
 */
public class Main {

    private static Game game;

    public static void main(String[] args) {
        initDisplay();
        initGL();
        initGame();

        gameLoop();

        cleanUp();
    }

    private static void initGame() {
        game = new Game();
    }

    private static void cleanUp() {
        Display.destroy();
        Keyboard.destroy();
    }

    private static void gameLoop() {
        while (!Display.isCloseRequested()) {
            getInput();
            update();
            render();

        }
    }

    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        game.render();

        Display.update();
        Display.sync(60);
    }

    private static void update() {
        game.update();
    }

    private static void getInput() {
        game.getInput();
    }

    private static void initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);

        glDisable(GL_DEPTH_TEST);

        glClearColor(0, 0, 0, 0);
    }

    private static void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            Keyboard.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
