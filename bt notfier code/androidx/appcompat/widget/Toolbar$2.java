/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.Toolbar
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.Toolbar;

class Toolbar.2
implements Runnable {
    final Toolbar this$0;

    Toolbar.2(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    @Override
    public void run() {
        this.this$0.showOverflowMenu();
    }
}
