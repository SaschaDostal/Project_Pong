package de.hft.ip1.group_3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement {

    private Control con;
    private KeyListener keylis;
    private boolean upPressed, downPressed, wPressed, sPressed;

    public Movement(Control c) {

        con = c;
        upPressed = false;
        downPressed = false;
        wPressed = false;
        sPressed = false;

        MyRunnable lisThread = new MyRunnable() {
            @Override
            public void run() {
                keylis = new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            wPressed = true;
                            System.out.println("Hallo");
                            break;
                        case KeyEvent.VK_S:
                            sPressed = true;
                            break;
                        case KeyEvent.VK_UP:
                            upPressed = true;
                            System.out.println("Hallo");
                            break;
                        case KeyEvent.VK_DOWN:
                            downPressed = true;
                            break;
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            wPressed = false;
                            break;
                        case KeyEvent.VK_S:
                            sPressed = false;
                            break;
                        case KeyEvent.VK_UP:
                            upPressed = false;
                            break;
                        case KeyEvent.VK_DOWN:
                            downPressed = false;
                            break;
                        }
                    }

                    @Override
                    public void keyTyped(KeyEvent e) {
                    }
                };

            }

            public KeyListener getLis() {
                return this.keylis;
            }
        };

        new Thread(lisThread).run();
        keylis = lisThread.getLis();
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isWPressed() {
        return wPressed;
    }

    public boolean isSPressed() {
        return sPressed;
    }

    public KeyListener getKeyListener() {
        return this.keylis;
    }
}

abstract class MyRunnable implements Runnable {

    KeyListener keylis;

    protected abstract KeyListener getLis();

}