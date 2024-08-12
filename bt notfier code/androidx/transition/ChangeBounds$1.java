/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 */
package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

class ChangeBounds.1
extends Property<Drawable, PointF> {
    private Rect mBounds = new Rect();

    ChangeBounds.1(Class clazz, String string) {
        super(clazz, string);
    }

    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.mBounds);
        return new PointF((float)this.mBounds.left, (float)this.mBounds.top);
    }

    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.mBounds);
        this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.mBounds);
    }
}
