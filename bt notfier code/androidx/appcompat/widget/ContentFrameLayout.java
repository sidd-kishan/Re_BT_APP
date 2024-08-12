/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 *  androidx.appcompat.widget.ContentFrameLayout$OnAttachListener
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.core.view.ViewCompat;

public class ContentFrameLayout
extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding = new Rect();
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public void dispatchFitSystemWindows(Rect rect) {
        this.fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor != null) return this.mFixedHeightMajor;
        this.mFixedHeightMajor = new TypedValue();
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor != null) return this.mFixedHeightMinor;
        this.mFixedHeightMinor = new TypedValue();
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor != null) return this.mFixedWidthMajor;
        this.mFixedWidthMajor = new TypedValue();
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor != null) return this.mFixedWidthMinor;
        this.mFixedWidthMinor = new TypedValue();
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor != null) return this.mMinWidthMajor;
        this.mMinWidthMajor = new TypedValue();
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor != null) return this.mMinWidthMinor;
        this.mMinWidthMinor = new TypedValue();
        return this.mMinWidthMinor;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener == null) return;
        onAttachListener.onAttachedFromWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener == null) return;
        onAttachListener.onDetachedFromWindow();
    }

    /*
     * Unable to fully structure code
     */
    protected void onMeasure(int var1_1, int var2_2) {
        block15: {
            block13: {
                block14: {
                    block12: {
                        var11_3 = this.getContext().getResources().getDisplayMetrics();
                        var5_4 = var11_3.widthPixels;
                        var4_5 = var11_3.heightPixels;
                        var8_6 = 1;
                        var4_5 = var5_4 < var4_5 ? 1 : 0;
                        var9_7 = View.MeasureSpec.getMode((int)var1_1);
                        var7_8 = View.MeasureSpec.getMode((int)var2_2);
                        if (var9_7 != -2147483648 || (var10_9 = var4_5 != 0 ? this.mFixedWidthMinor : this.mFixedWidthMajor) == null || var10_9.type == 0) ** GOTO lbl-1000
                        if (var10_9.type != 5) break block12;
                        var3_10 = var10_9.getDimension(var11_3);
                        ** GOTO lbl15
                    }
                    if (var10_9.type == 6) {
                        var3_10 = var10_9.getFraction(var11_3.widthPixels, var11_3.widthPixels);
lbl15:
                        // 2 sources

                        var5_4 = (int)var3_10;
                    } else {
                        var5_4 = 0;
                    }
                    if (var5_4 > 0) {
                        var6_11 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var5_4 - (this.mDecorPadding.left + this.mDecorPadding.right), View.MeasureSpec.getSize((int)var1_1)), (int)0x40000000);
                        var1_1 = 1;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var5_4 = 0;
                        var6_11 = var1_1;
                        var1_1 = var5_4;
                    }
                    var5_4 = var2_2;
                    if (var7_8 != -2147483648) break block13;
                    var10_9 = var4_5 != 0 ? this.mFixedHeightMajor : this.mFixedHeightMinor;
                    var5_4 = var2_2;
                    if (var10_9 == null) break block13;
                    var5_4 = var2_2;
                    if (var10_9.type == 0) break block13;
                    if (var10_9.type != 5) break block14;
                    var3_10 = var10_9.getDimension(var11_3);
                    ** GOTO lbl38
                }
                if (var10_9.type == 6) {
                    var3_10 = var10_9.getFraction(var11_3.heightPixels, var11_3.heightPixels);
lbl38:
                    // 2 sources

                    var7_8 = (int)var3_10;
                } else {
                    var7_8 = 0;
                }
                var5_4 = var2_2;
                if (var7_8 > 0) {
                    var5_4 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var7_8 - (this.mDecorPadding.top + this.mDecorPadding.bottom), View.MeasureSpec.getSize((int)var2_2)), (int)0x40000000);
                }
            }
            super.onMeasure(var6_11, var5_4);
            var7_8 = this.getMeasuredWidth();
            var6_11 = View.MeasureSpec.makeMeasureSpec((int)var7_8, (int)0x40000000);
            if (var1_1 != 0 || var9_7 != -2147483648 || (var10_9 = var4_5 != 0 ? this.mMinWidthMinor : this.mMinWidthMajor) == null || var10_9.type == 0) ** GOTO lbl-1000
            if (var10_9.type != 5) break block15;
            var3_10 = var10_9.getDimension(var11_3);
            ** GOTO lbl55
        }
        if (var10_9.type == 6) {
            var3_10 = var10_9.getFraction(var11_3.widthPixels, var11_3.widthPixels);
lbl55:
            // 2 sources

            var1_1 = (int)var3_10;
        } else {
            var1_1 = 0;
        }
        var2_2 = var1_1;
        if (var1_1 > 0) {
            var2_2 = var1_1 - (this.mDecorPadding.left + this.mDecorPadding.right);
        }
        if (var7_8 < var2_2) {
            var1_1 = View.MeasureSpec.makeMeasureSpec((int)var2_2, (int)0x40000000);
            var2_2 = var8_6;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 = 0;
            var1_1 = var6_11;
        }
        if (var2_2 == 0) return;
        super.onMeasure(var1_1, var5_4);
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.mAttachListener = onAttachListener;
    }

    public void setDecorPadding(int n, int n2, int n3, int n4) {
        this.mDecorPadding.set(n, n2, n3, n4);
        if (!ViewCompat.isLaidOut((View)this)) return;
        this.requestLayout();
    }
}
