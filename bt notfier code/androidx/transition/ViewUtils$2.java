/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Property
 *  android.view.View
 *  androidx.core.view.ViewCompat
 */
package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

class ViewUtils.2
extends Property<View, Rect> {
    ViewUtils.2(Class clazz, String string) {
        super(clazz, string);
    }

    public Rect get(View view) {
        return ViewCompat.getClipBounds((View)view);
    }

    public void set(View view, Rect rect) {
        ViewCompat.setClipBounds((View)view, (Rect)rect);
    }
}
