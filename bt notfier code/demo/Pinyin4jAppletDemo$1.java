/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  demo.Pinyin4jAppletDemo
 */
package demo;

import demo.Pinyin4jAppletDemo;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class Pinyin4jAppletDemo$1
extends WindowAdapter {
    private final Pinyin4jAppletDemo val$appletDemo;

    Pinyin4jAppletDemo$1(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        this.val$appletDemo = pinyin4jAppletDemo;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        this.val$appletDemo.stop();
        this.val$appletDemo.destroy();
        System.exit(0);
    }
}
