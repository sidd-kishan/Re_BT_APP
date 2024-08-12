/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.graphics.drawable.DrawableWrapper
 */
package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

private static class DropDownListView.GateKeeperDrawable
extends DrawableWrapper {
    private boolean mEnabled = true;

    DropDownListView.GateKeeperDrawable(Drawable drawable) {
        super(drawable);
    }

    public void draw(Canvas canvas) {
        if (!this.mEnabled) return;
        super.draw(canvas);
    }

    void setEnabled(boolean bl) {
        this.mEnabled = bl;
    }

    public void setHotspot(float f, float f2) {
        if (!this.mEnabled) return;
        super.setHotspot(f, f2);
    }

    public void setHotspotBounds(int n, int n2, int n3, int n4) {
        if (!this.mEnabled) return;
        super.setHotspotBounds(n, n2, n3, n4);
    }

    public boolean setState(int[] nArray) {
        if (!this.mEnabled) return false;
        return super.setState(nArray);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        if (!this.mEnabled) return false;
        return super.setVisible(bl, bl2);
    }
}
