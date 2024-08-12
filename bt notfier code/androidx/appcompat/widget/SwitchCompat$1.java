/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  androidx.appcompat.widget.SwitchCompat
 */
package androidx.appcompat.widget;

import android.util.Property;
import androidx.appcompat.widget.SwitchCompat;

class SwitchCompat.1
extends Property<SwitchCompat, Float> {
    SwitchCompat.1(Class clazz, String string) {
        super(clazz, string);
    }

    public Float get(SwitchCompat switchCompat) {
        return Float.valueOf(switchCompat.mThumbPosition);
    }

    public void set(SwitchCompat switchCompat, Float f) {
        switchCompat.setThumbPosition(f.floatValue());
    }
}
