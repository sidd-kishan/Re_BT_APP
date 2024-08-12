/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.widget.QMUIFloatLayout$OnLineCountChangeListener
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.QMUIFloatLayout;

public class QMUIFloatLayout
extends ViewGroup {
    private static final int LINES = 0;
    private static final int NUMBER = 1;
    private int mChildHorizontalSpacing;
    private int mChildVerticalSpacing;
    private int mGravity;
    private int[] mItemNumberInEachLine;
    private int mLineCount = 0;
    private int mMaxMode = 0;
    private int mMaximum = Integer.MAX_VALUE;
    private OnLineCountChangeListener mOnLineCountChangeListener;
    private int[] mWidthSumInEachLine;
    private int measuredChildCount;

    public QMUIFloatLayout(Context context) {
        this(context, null);
    }

    public QMUIFloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIFloatLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIFloatLayout);
        this.mChildHorizontalSpacing = context.getDimensionPixelSize(R.styleable.QMUIFloatLayout_qmui_childHorizontalSpacing, 0);
        this.mChildVerticalSpacing = context.getDimensionPixelSize(R.styleable.QMUIFloatLayout_qmui_childVerticalSpacing, 0);
        this.mGravity = context.getInteger(R.styleable.QMUIFloatLayout_android_gravity, 3);
        int n = context.getInt(R.styleable.QMUIFloatLayout_android_maxLines, -1);
        if (n >= 0) {
            this.setMaxLines(n);
        }
        if ((n = context.getInt(R.styleable.QMUIFloatLayout_qmui_maxNumber, -1)) >= 0) {
            this.setMaxNumber(n);
        }
        context.recycle();
    }

    private void layoutWithGravityCenterHorizontal(int n) {
        int n2;
        Object object;
        int n3 = this.getPaddingTop();
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            int n7;
            int n8;
            object = this.mItemNumberInEachLine;
            n2 = n5;
            if (n4 >= ((int[])object).length) break;
            if (object[n4] == 0) {
                n2 = n5;
                break;
            }
            int n9 = (n - this.getPaddingLeft() - this.getPaddingRight() - this.mWidthSumInEachLine[n4]) / 2 + this.getPaddingLeft();
            int n10 = 0;
            int n11 = 0;
            while (true) {
                n2 = ++n5;
                n8 = n6;
                n7 = n11;
                if (n10 >= this.mItemNumberInEachLine[n4]) break;
                object = this.getChildAt(n5);
                if (object.getVisibility() == 8) continue;
                n2 = object.getMeasuredWidth();
                n8 = object.getMeasuredHeight();
                object.layout(n9, n3, n9 + n2, n3 + n8);
                n7 = Math.max(n11, n8);
                n9 += n2 + this.mChildHorizontalSpacing;
                n8 = n6 + 1;
                ++n10;
                n5 = n2 = n5 + 1;
                n6 = n8;
                n11 = n7;
                if (n8 == this.measuredChildCount) break;
            }
            if (n8 == this.measuredChildCount) break;
            n3 += n7 + this.mChildVerticalSpacing;
            ++n4;
            n5 = n2;
            n6 = n8;
        }
        n = this.getChildCount();
        while (n2 < n) {
            object = this.getChildAt(n2);
            if (object.getVisibility() != 8) {
                object.layout(0, 0, 0, 0);
            }
            ++n2;
        }
    }

    private void layoutWithGravityLeft(int n) {
        int n2 = this.getPaddingRight();
        int n3 = this.getPaddingLeft();
        int n4 = this.getPaddingTop();
        int n5 = this.getChildCount();
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        while (n6 < n5) {
            View view = this.getChildAt(n6);
            if (view.getVisibility() != 8) {
                if (n7 < this.measuredChildCount) {
                    int n9 = view.getMeasuredWidth();
                    int n10 = view.getMeasuredHeight();
                    int n11 = n3;
                    int n12 = n4;
                    int n13 = n8;
                    if (n3 + n9 > n - n2) {
                        n11 = this.getPaddingLeft();
                        n12 = n4 + (n8 + this.mChildVerticalSpacing);
                        n13 = 0;
                    }
                    view.layout(n11, n12, n11 + n9, n12 + n10);
                    n3 = n11 + (n9 + this.mChildHorizontalSpacing);
                    n8 = Math.max(n13, n10);
                    ++n7;
                    n4 = n12;
                } else {
                    view.layout(0, 0, 0, 0);
                }
            }
            ++n6;
        }
    }

    private void layoutWithGravityRight(int n) {
        int n2;
        Object object;
        int n3 = this.getPaddingTop();
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            int n7;
            int n8;
            object = this.mItemNumberInEachLine;
            n2 = n5;
            if (n4 >= ((int[])object).length) break;
            if (object[n4] == 0) {
                n2 = n5;
                break;
            }
            int n9 = n - this.getPaddingRight() - this.mWidthSumInEachLine[n4];
            int n10 = 0;
            int n11 = 0;
            while (true) {
                n2 = ++n5;
                n8 = n6;
                n7 = n11;
                if (n10 >= this.mItemNumberInEachLine[n4]) break;
                object = this.getChildAt(n5);
                if (object.getVisibility() == 8) continue;
                n2 = object.getMeasuredWidth();
                n8 = object.getMeasuredHeight();
                object.layout(n9, n3, n9 + n2, n3 + n8);
                n7 = Math.max(n11, n8);
                n9 += n2 + this.mChildHorizontalSpacing;
                n8 = n6 + 1;
                ++n10;
                n5 = n2 = n5 + 1;
                n6 = n8;
                n11 = n7;
                if (n8 == this.measuredChildCount) break;
            }
            if (n8 == this.measuredChildCount) break;
            n3 += n7 + this.mChildVerticalSpacing;
            ++n4;
            n5 = n2;
            n6 = n8;
        }
        n = this.getChildCount();
        while (n2 < n) {
            object = this.getChildAt(n2);
            if (object.getVisibility() != 8) {
                object.layout(0, 0, 0, 0);
            }
            ++n2;
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLineCount() {
        return this.mLineCount;
    }

    public int getMaxLines() {
        int n = this.mMaxMode == 0 ? this.mMaximum : -1;
        return n;
    }

    public int getMaxNumber() {
        int n = this.mMaxMode == 1 ? this.mMaximum : -1;
        return n;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        n2 = n3 - n;
        n = this.mGravity & 7;
        if (n != 1) {
            if (n != 3) {
                if (n != 5) {
                    this.layoutWithGravityLeft(n2);
                } else {
                    this.layoutWithGravityRight(n2);
                }
            } else {
                this.layoutWithGravityLeft(n2);
            }
        } else {
            this.layoutWithGravityCenterHorizontal(n2);
        }
    }

    protected void onMeasure(int n, int n2) {
        Object object;
        int n3;
        int n4 = View.MeasureSpec.getMode((int)n);
        int n5 = View.MeasureSpec.getSize((int)n);
        int n6 = View.MeasureSpec.getMode((int)n2);
        int n7 = View.MeasureSpec.getSize((int)n2);
        int n8 = this.getChildCount();
        this.mItemNumberInEachLine = new int[n8];
        this.mWidthSumInEachLine = new int[n8];
        int n9 = 0;
        if (n4 == 0x40000000) {
            this.measuredChildCount = 0;
            n9 = this.getPaddingLeft();
            int n10 = this.getPaddingTop();
            int n11 = this.getPaddingRight();
            n4 = 0;
            int n12 = 0;
            n3 = n5;
            for (int i = 0; !(i >= n8 || this.mMaxMode == 1 && this.measuredChildCount >= this.mMaximum || this.mMaxMode == 0 && n4 >= this.mMaximum); ++i) {
                int n13;
                View view = this.getChildAt(i);
                if (view.getVisibility() == 8) {
                    n13 = n12;
                } else {
                    object = view.getLayoutParams();
                    view.measure(QMUIFloatLayout.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)object.width), QMUIFloatLayout.getChildMeasureSpec((int)n2, (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)object.height));
                    int n14 = view.getMeasuredWidth();
                    n13 = Math.max(n12, view.getMeasuredHeight());
                    int n15 = n9;
                    n12 = n4;
                    int n16 = n10;
                    if (n9 + n14 > n5 - n11) {
                        if (this.mMaxMode == 0 && n4 + 1 >= this.mMaximum) {
                            n12 = n13;
                            break;
                        }
                        object = this.mWidthSumInEachLine;
                        object[n4] = object[n4] - this.mChildHorizontalSpacing;
                        n12 = n4 + 1;
                        n15 = this.getPaddingLeft();
                        n16 = n10 + (this.mChildVerticalSpacing + n13);
                    }
                    object = this.mItemNumberInEachLine;
                    object[n12] = object[n12] + 1;
                    object = this.mWidthSumInEachLine;
                    n4 = object[n12];
                    n10 = this.mChildHorizontalSpacing;
                    object[n12] = n4 + (n14 + n10);
                    n9 = n15 + (n14 + n10);
                    ++this.measuredChildCount;
                    n10 = n16;
                    n4 = n12;
                }
                n12 = n13;
            }
            if (((int[])(object = this.mWidthSumInEachLine)).length > 0 && object[n4] > 0) {
                object[n4] = object[n4] - this.mChildHorizontalSpacing;
            }
            if (n6 == 0) {
                n = n10 + n12 + this.getPaddingBottom();
            } else {
                n = n7;
                if (n6 == Integer.MIN_VALUE) {
                    n = Math.min(n10 + n12 + this.getPaddingBottom(), n7);
                }
            }
            n10 = n4;
            n2 = n3;
            n4 = n;
            n3 = n10;
        } else {
            int n17;
            int n18;
            n4 = this.getPaddingLeft() + this.getPaddingRight();
            this.measuredChildCount = 0;
            n3 = 0;
            for (n18 = 0; n18 < n8 && !((n17 = this.mMaxMode) != 1 ? n17 == 0 && 1 > this.mMaximum : this.measuredChildCount > this.mMaximum); ++n18) {
                View view = this.getChildAt(n18);
                if (view.getVisibility() == 8) continue;
                object = view.getLayoutParams();
                view.measure(QMUIFloatLayout.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)object.width), QMUIFloatLayout.getChildMeasureSpec((int)n2, (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)object.height));
                n4 += view.getMeasuredWidth();
                n3 = Math.max(n3, view.getMeasuredHeight());
                ++this.measuredChildCount;
            }
            n2 = this.measuredChildCount;
            n = n4;
            if (n2 > 0) {
                n = n4 + this.mChildHorizontalSpacing * (n2 - 1);
            }
            n18 = n3 + this.getPaddingTop() + this.getPaddingBottom();
            object = this.mItemNumberInEachLine;
            if (((int[])object).length > 0) {
                object[0] = n8;
            }
            object = this.mWidthSumInEachLine;
            n2 = n;
            n4 = n18;
            n3 = n9;
            if (((int[])object).length > 0) {
                object[0] = n;
                n3 = n9;
                n4 = n18;
                n2 = n;
            }
        }
        this.setMeasuredDimension(n2, n4);
        n = n3 + 1;
        n2 = this.mLineCount;
        if (n2 == n) return;
        object = this.mOnLineCountChangeListener;
        if (object != null) {
            object.onChange(n2, n);
        }
        this.mLineCount = n;
    }

    public void setChildHorizontalSpacing(int n) {
        this.mChildHorizontalSpacing = n;
        this.invalidate();
    }

    public void setChildVerticalSpacing(int n) {
        this.mChildVerticalSpacing = n;
        this.invalidate();
    }

    public void setGravity(int n) {
        if (this.mGravity == n) return;
        this.mGravity = n;
        this.requestLayout();
    }

    public void setMaxLines(int n) {
        this.mMaximum = n;
        this.mMaxMode = 0;
        this.requestLayout();
    }

    public void setMaxNumber(int n) {
        this.mMaximum = n;
        this.mMaxMode = 1;
        this.requestLayout();
    }

    public void setOnLineCountChangeListener(OnLineCountChangeListener onLineCountChangeListener) {
        this.mOnLineCountChangeListener = onLineCountChangeListener;
    }
}
