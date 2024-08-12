/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  android.view.ViewGroup
 *  com.google.android.material.R$id
 */
package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R;

public class ChildrenAlphaProperty
extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String string) {
        super(Float.class, string);
    }

    public Float get(ViewGroup object) {
        if ((object = (Float)object.getTag(R.id.mtrl_internal_children_alpha_tag)) == null) return Float.valueOf(1.0f);
        return object;
    }

    public void set(ViewGroup viewGroup, Float f) {
        float f2 = f.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, (Object)Float.valueOf(f2));
        int n = viewGroup.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            viewGroup.getChildAt(n2).setAlpha(f2);
            ++n2;
        }
    }
}
