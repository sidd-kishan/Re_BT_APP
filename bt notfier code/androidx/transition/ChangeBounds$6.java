/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Property
 *  android.view.View
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;
import androidx.transition.ViewUtils;

class ChangeBounds.6
extends Property<View, PointF> {
    ChangeBounds.6(Class clazz, String string) {
        super(clazz, string);
    }

    public PointF get(View view) {
        return null;
    }

    public void set(View view, PointF pointF) {
        int n = Math.round(pointF.x);
        int n2 = Math.round(pointF.y);
        ViewUtils.setLeftTopRightBottom((View)view, (int)n, (int)n2, (int)(view.getWidth() + n), (int)(view.getHeight() + n2));
    }
}
