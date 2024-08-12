/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.ToolbarActionBar
 */
package androidx.appcompat.app;

import androidx.appcompat.app.ToolbarActionBar;

class ToolbarActionBar.1
implements Runnable {
    final ToolbarActionBar this$0;

    ToolbarActionBar.1(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    @Override
    public void run() {
        this.this$0.populateOptionsMenu();
    }
}
