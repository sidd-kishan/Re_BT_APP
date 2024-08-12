/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  androidx.cardview.widget.CardView
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.card.MaterialCardViewHelper
 *  com.google.android.material.internal.ThemeEnforcement
 */
package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.card.MaterialCardViewHelper;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialCardView
extends CardView {
    private final MaterialCardViewHelper cardViewHelper;

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        context = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.MaterialCardView, (int)n, (int)R.style.Widget_MaterialComponents_CardView, (int[])new int[0]);
        attributeSet = new MaterialCardViewHelper(this);
        this.cardViewHelper = attributeSet;
        attributeSet.loadFromAttributes((TypedArray)context);
        context.recycle();
    }

    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public void setRadius(float f) {
        super.setRadius(f);
        this.cardViewHelper.updateForeground();
    }

    public void setStrokeColor(int n) {
        this.cardViewHelper.setStrokeColor(n);
    }

    public void setStrokeWidth(int n) {
        this.cardViewHelper.setStrokeWidth(n);
    }
}
