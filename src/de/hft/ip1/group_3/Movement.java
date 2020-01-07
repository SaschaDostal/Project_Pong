package de.hft.ip1.group_3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement {

    Control con;

    public Movement(Control c) {

        con = c;
        MyRunnable lisThread = new MyRunnable() {
            public void run() {
                keylis = new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            UpWPressed();
                            System.out.println("Hallo");
                            break;
                        case KeyEvent.VK_S:
                            DownSPressed();
                            break;
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }

                    @Override
                    public void keyTyped(KeyEvent e) {
                    }
                };

            }

            public KeyListener getLis() {
                return keylis2;
            }
        };
        MyRunnable lisThread2 = new MyRunnable() {
            public void run() {
                keylis2 = new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            UpKeyPressed();
                            break;
                        case KeyEvent.VK_DOWN:
                            DownKeyPressed();
                            break;
                        }
                    }
                };
            }

            public KeyListener getLis() {
                return keylis2;
            }
        };
        
        lisThread.run();
        keylis = lisThread.getLis();
        
        lisThread2.run();
        keylis2 = lisThread2.getLis();
    }

    KeyListener keylis2;
    KeyListener keylis;

    protected void UpWPressed() {
        // TODO Auto-generated method stub
        con.UpWPressed();
    }

    protected void UpKeyPressed() {
        // TODO Auto-generated method stub
        con.UpKeyPressed();
    }

    protected void DownKeyPressed() {
        // TODO Auto-generated method stub
        con.DownKeyPressed();
    }

    protected void DownSPressed() {
        // TODO Auto-generated method stub
        con.DownSPressed();
    }

}

abstract class MyRunnable implements Runnable{

    protected abstract KeyListener getLis();
    
}