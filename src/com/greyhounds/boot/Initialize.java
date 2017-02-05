package com.greyhounds.boot;
import com.greyhounds.gui.*;

/**
 * Created by nicholas on 2/4/17.
 */
public class Initialize {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window();
            }
        });
    }
}
