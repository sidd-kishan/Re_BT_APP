/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Property
 *  androidx.transition.ChangeBounds$ViewBounds
 */
package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import androidx.transition.ChangeBounds;

class ChangeBounds.2
extends Property<ChangeBounds.ViewBounds, PointF> {
    ChangeBounds.2(Class clazz, String string) {
        super(clazz, string);
    }

    public PointF get(ChangeBounds.ViewBounds viewBounds) {
        return null;
    }

    public void set(ChangeBounds.ViewBounds viewBounds, PointF pointF) {
        viewBounds.setTopLeft(pointF);
    }
}
