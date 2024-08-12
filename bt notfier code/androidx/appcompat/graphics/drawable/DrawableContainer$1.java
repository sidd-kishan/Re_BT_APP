/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.graphics.drawable.DrawableContainer
 */
package androidx.appcompat.graphics.drawable;

import androidx.appcompat.graphics.drawable.DrawableContainer;

class DrawableContainer.1
implements Runnable {
    final DrawableContainer this$0;

    DrawableContainer.1(DrawableContainer drawableContainer) {
        this.this$0 = drawableContainer;
    }

    @Override
    public void run() {
        this.this$0.animate(true);
        this.this$0.invalidateSelf();
    }
}
