/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.TooltipCompatHandler
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.TooltipCompatHandler;

class TooltipCompatHandler.1
implements Runnable {
    final TooltipCompatHandler this$0;

    TooltipCompatHandler.1(TooltipCompatHandler tooltipCompatHandler) {
        this.this$0 = tooltipCompatHandler;
    }

    @Override
    public void run() {
        this.this$0.show(false);
    }
}
