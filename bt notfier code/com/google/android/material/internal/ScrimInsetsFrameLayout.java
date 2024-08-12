/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.View
 *  android.widget.FrameLayout
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.internal.ThemeEnforcement
 */
package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

public class ScrimInsetsFrameLayout
extends FrameLayout {
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect = new Rect();

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        context = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.ScrimInsetsFrameLayout, (int)n, (int)R.style.Widget_Design_ScrimInsetsFrameLayout, (int[])new int[0]);
        this.insetForeground = context.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        context.recycle();
        this.setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int n = this.getWidth();
        int n2 = this.getHeight();
        if (this.insets == null) return;
        if (this.insetForeground == null) return;
        int n3 = canvas.save();
        canvas.translate((float)this.getScrollX(), (float)this.getScrollY());
        this.tempRect.set(0, 0, n, this.insets.top);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        this.tempRect.set(0, n2 - this.insets.bottom, n, n2);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        this.tempRect.set(0, this.insets.top, this.insets.left, n2 - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        this.tempRect.set(n - this.insets.right, this.insets.top, n, n2 - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        canvas.restoreToCount(n3);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.insetForeground;
        if (drawable == null) return;
        drawable.setCallback((Drawable.Callback)this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.insetForeground;
        if (drawable == null) return;
        drawable.setCallback(null);
    }

    protected void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
    }
}
