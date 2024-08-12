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

class ChangeBounds.4
extends Property<View, PointF> {
    ChangeBounds.4(Class clazz, String string) {
        super(clazz, string);
    }

    public PointF get(View view) {
        return null;
    }

    public void set(View view, PointF pointF) {
        ViewUtils.setLeftTopRightBottom((View)view, (int)view.getLeft(), (int)view.getTop(), (int)Math.round(pointF.x), (int)Math.round(pointF.y));
    }
}
