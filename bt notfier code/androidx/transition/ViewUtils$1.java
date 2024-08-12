/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  android.view.View
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.util.Property;
import android.view.View;
import androidx.transition.ViewUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class ViewUtils.1
extends Property<View, Float> {
    ViewUtils.1(Class clazz, String string) {
        super(clazz, string);
    }

    public Float get(View view) {
        return Float.valueOf(ViewUtils.getTransitionAlpha((View)view));
    }

    public void set(View view, Float f) {
        ViewUtils.setTransitionAlpha((View)view, (float)f.floatValue());
    }
}
