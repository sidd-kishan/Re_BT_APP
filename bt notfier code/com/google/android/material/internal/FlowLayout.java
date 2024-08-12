/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.core.view.MarginLayoutParamsCompat
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$styleable
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

public class FlowLayout
extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private boolean singleLine = false;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.loadFromAttributes(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.loadFromAttributes(context, attributeSet);
    }

    private static int getMeasuredDimension(int n, int n2, int n3) {
        if (n2 == Integer.MIN_VALUE) return Math.min(n3, n);
        if (n2 == 0x40000000) return n;
        return n3;
    }

    private void loadFromAttributes(Context context, AttributeSet attributeSet) {
        context = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = context.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = context.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        context.recycle();
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    protected boolean isSingleLine() {
        return this.singleLine;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (this.getChildCount() == 0) {
            return;
        }
        n2 = ViewCompat.getLayoutDirection((View)this);
        boolean bl2 = true;
        if (n2 != 1) {
            bl2 = false;
        }
        n2 = bl2 ? this.getPaddingRight() : this.getPaddingLeft();
        n4 = bl2 ? this.getPaddingLeft() : this.getPaddingRight();
        int n5 = this.getPaddingTop();
        int n6 = n3 - n - n4;
        n3 = n2;
        n = n5;
        int n7 = 0;
        while (n7 < this.getChildCount()) {
            View view = this.getChildAt(n7);
            if (view.getVisibility() != 8) {
                int n8;
                int n9;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
                    n9 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)layoutParams);
                    n8 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)layoutParams);
                } else {
                    n8 = 0;
                    n9 = 0;
                }
                int n10 = view.getMeasuredWidth();
                int n11 = n3;
                n4 = n;
                if (!this.singleLine) {
                    n11 = n3;
                    n4 = n;
                    if (n3 + n9 + n10 > n6) {
                        n4 = this.lineSpacing + n5;
                        n11 = n2;
                    }
                }
                n3 = n11 + n9;
                n = view.getMeasuredWidth() + n3;
                n5 = view.getMeasuredHeight() + n4;
                if (bl2) {
                    view.layout(n6 - n, n4, n6 - n11 - n9, n5);
                } else {
                    view.layout(n3, n4, n, n5);
                }
                n3 = n11 + (n9 + n8 + view.getMeasuredWidth() + this.itemSpacing);
                n = n4;
            }
            ++n7;
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getSize((int)n);
        int n4 = View.MeasureSpec.getMode((int)n);
        int n5 = View.MeasureSpec.getSize((int)n2);
        int n6 = View.MeasureSpec.getMode((int)n2);
        int n7 = n4 != Integer.MIN_VALUE && n4 != 0x40000000 ? Integer.MAX_VALUE : n3;
        int n8 = this.getPaddingLeft();
        int n9 = this.getPaddingTop();
        int n10 = this.getPaddingRight();
        int n11 = n9;
        int n12 = 0;
        int n13 = 0;
        while (true) {
            if (n12 >= this.getChildCount()) {
                this.setMeasuredDimension(FlowLayout.getMeasuredDimension(n3, n4, n13), FlowLayout.getMeasuredDimension(n5, n6, n9));
                return;
            }
            View view = this.getChildAt(n12);
            if (view.getVisibility() != 8) {
                int n14;
                int n15;
                this.measureChild(view, n, n2);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
                    n15 = layoutParams.leftMargin + 0;
                    n14 = layoutParams.rightMargin + 0;
                } else {
                    n15 = 0;
                    n14 = 0;
                }
                if (n8 + n15 + view.getMeasuredWidth() > n7 - n10 && !this.isSingleLine()) {
                    n8 = this.getPaddingLeft();
                    n11 = this.lineSpacing + n9;
                    n9 = n8;
                } else {
                    n9 = n8;
                }
                int n16 = n9 + n15 + view.getMeasuredWidth();
                int n17 = view.getMeasuredHeight();
                n8 = n13;
                if (n16 > n13) {
                    n8 = n16;
                }
                n15 = n9 + (n15 + n14 + view.getMeasuredWidth() + this.itemSpacing);
                n9 = n11 + n17;
                n13 = n8;
                n8 = n15;
            }
            ++n12;
        }
    }

    protected void setItemSpacing(int n) {
        this.itemSpacing = n;
    }

    protected void setLineSpacing(int n) {
        this.lineSpacing = n;
    }

    public void setSingleLine(boolean bl) {
        this.singleLine = bl;
    }
}
