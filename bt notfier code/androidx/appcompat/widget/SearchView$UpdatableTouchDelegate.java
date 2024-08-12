/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.MotionEvent
 *  android.view.TouchDelegate
 *  android.view.View
 *  android.view.ViewConfiguration
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

private static class SearchView.UpdatableTouchDelegate
extends TouchDelegate {
    private final Rect mActualBounds;
    private boolean mDelegateTargeted;
    private final View mDelegateView;
    private final int mSlop;
    private final Rect mSlopBounds;
    private final Rect mTargetBounds;

    public SearchView.UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
        super(rect, view);
        this.mSlop = ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop();
        this.mTargetBounds = new Rect();
        this.mSlopBounds = new Rect();
        this.mActualBounds = new Rect();
        this.setBounds(rect, rect2);
        this.mDelegateView = view;
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block6: {
            block4: {
                block5: {
                    var4_2 = (int)var1_1.getX();
                    var3_3 = (int)var1_1.getY();
                    var2_4 = var1_1.getAction();
                    var5_5 = true;
                    var7_6 = false;
                    if (var2_4 == 0) break block4;
                    if (var2_4 == 1 || var2_4 == 2) break block5;
                    if (var2_4 != 3) ** GOTO lbl-1000
                    var5_5 = this.mDelegateTargeted;
                    this.mDelegateTargeted = false;
                    ** GOTO lbl23
                }
                var5_5 = var6_7 = this.mDelegateTargeted;
                if (!var6_7) ** GOTO lbl23
                var5_5 = var6_7;
                if (this.mSlopBounds.contains(var4_2, var3_3)) ** GOTO lbl23
                var5_5 = var6_7;
                var2_4 = 0;
                break block6;
            }
            if (this.mTargetBounds.contains(var4_2, var3_3)) {
                this.mDelegateTargeted = true;
lbl23:
                // 4 sources

                var2_4 = 1;
            } else lbl-1000:
            // 2 sources

            {
                var2_4 = 1;
                var5_5 = false;
            }
        }
        var6_7 = var7_6;
        if (var5_5 == false) return var6_7;
        if (var2_4 != 0 && !this.mActualBounds.contains(var4_2, var3_3)) {
            var1_1.setLocation((float)(this.mDelegateView.getWidth() / 2), (float)(this.mDelegateView.getHeight() / 2));
        } else {
            var1_1.setLocation((float)(var4_2 - this.mActualBounds.left), (float)(var3_3 - this.mActualBounds.top));
        }
        var6_7 = this.mDelegateView.dispatchTouchEvent(var1_1);
        return var6_7;
    }

    public void setBounds(Rect rect, Rect rect2) {
        this.mTargetBounds.set(rect);
        this.mSlopBounds.set(rect);
        rect = this.mSlopBounds;
        int n = this.mSlop;
        rect.inset(-n, -n);
        this.mActualBounds.set(rect2);
    }
}
