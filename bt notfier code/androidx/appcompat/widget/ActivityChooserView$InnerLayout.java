/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.LinearLayout
 *  androidx.appcompat.widget.TintTypedArray
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.TintTypedArray;

public static class ActivityChooserView.InnerLayout
extends LinearLayout {
    private static final int[] TINT_ATTRS = new int[]{16842964};

    public ActivityChooserView.InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])TINT_ATTRS);
        this.setBackgroundDrawable(context.getDrawable(0));
        context.recycle();
    }
}
