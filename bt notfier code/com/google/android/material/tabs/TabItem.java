/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  androidx.appcompat.widget.TintTypedArray
 *  com.google.android.material.R$styleable
 */
package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

public class TabItem
extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.TabItem);
        this.text = context.getText(R.styleable.TabItem_android_text);
        this.icon = context.getDrawable(R.styleable.TabItem_android_icon);
        this.customLayout = context.getResourceId(R.styleable.TabItem_android_layout, 0);
        context.recycle();
    }
}
