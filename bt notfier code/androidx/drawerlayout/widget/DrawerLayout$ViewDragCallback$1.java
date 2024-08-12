/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback
 */
package androidx.drawerlayout.widget;

import androidx.drawerlayout.widget.DrawerLayout;

class DrawerLayout.ViewDragCallback.1
implements Runnable {
    final DrawerLayout.ViewDragCallback this$1;

    DrawerLayout.ViewDragCallback.1(DrawerLayout.ViewDragCallback viewDragCallback) {
        this.this$1 = viewDragCallback;
    }

    @Override
    public void run() {
        this.this$1.peekDrawer();
    }
}
