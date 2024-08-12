/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.shadow.ShadowViewDelegate
 */
package com.google.android.material.floatingactionbutton;

import android.graphics.drawable.Drawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shadow.ShadowViewDelegate;

/*
 * Exception performing whole class analysis ignored.
 */
private class FloatingActionButton.ShadowDelegateImpl
implements ShadowViewDelegate {
    final FloatingActionButton this$0;

    FloatingActionButton.ShadowDelegateImpl(FloatingActionButton floatingActionButton) {
        this.this$0 = floatingActionButton;
    }

    public float getRadius() {
        return (float)this.this$0.getSizeDimension() / 2.0f;
    }

    public boolean isCompatPaddingEnabled() {
        return this.this$0.compatPadding;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        FloatingActionButton.access$101((FloatingActionButton)this.this$0, (Drawable)drawable);
    }

    public void setShadowPadding(int n, int n2, int n3, int n4) {
        this.this$0.shadowPadding.set(n, n2, n3, n4);
        FloatingActionButton floatingActionButton = this.this$0;
        floatingActionButton.setPadding(n + FloatingActionButton.access$000((FloatingActionButton)floatingActionButton), n2 + FloatingActionButton.access$000((FloatingActionButton)this.this$0), n3 + FloatingActionButton.access$000((FloatingActionButton)this.this$0), n4 + FloatingActionButton.access$000((FloatingActionButton)this.this$0));
    }
}
