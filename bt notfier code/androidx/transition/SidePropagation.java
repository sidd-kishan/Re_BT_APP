/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.view.ViewCompat
 *  androidx.transition.Transition
 *  androidx.transition.TransitionValues
 *  androidx.transition.VisibilityPropagation
 */
package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.VisibilityPropagation;

public class SidePropagation
extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /*
     * Unable to fully structure code
     */
    private int distance(View var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9) {
        block5: {
            block4: {
                var12_10 = this.mSide;
                var11_11 = 0;
                var13_12 = 1;
                var10_13 = 1;
                if (var12_10 != 0x800003) break block4;
                if (ViewCompat.getLayoutDirection((View)var1_1) != 1) {
                    var10_13 = 0;
                }
                if (var10_13 == 0) ** GOTO lbl-1000
                ** GOTO lbl-1000
            }
            var10_13 = var12_10;
            if (var12_10 == 0x800005) {
                var10_13 = ViewCompat.getLayoutDirection((View)var1_1) == 1 ? var13_12 : 0;
                ** if (var10_13 != 0) goto lbl-1000
            }
            break block5;
lbl-1000:
            // 2 sources

            {
                var10_13 = 5;
                ** GOTO lbl19
            }
lbl-1000:
            // 2 sources

            {
                var10_13 = 3;
            }
        }
        var2_2 = var10_13 != 3 ? (var10_13 != 5 ? (var10_13 != 48 ? (var10_13 != 80 ? var11_11 : var3_3 - var7_7 + Math.abs(var4_4 - var2_2)) : var9_9 - var3_3 + Math.abs(var4_4 - var2_2)) : var2_2 - var6_6 + Math.abs(var5_5 - var3_3)) : var8_8 - var2_2 + Math.abs(var5_5 - var3_3);
        return var2_2;
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int n = this.mSide;
        if (n == 3) return viewGroup.getWidth();
        if (n == 5) return viewGroup.getWidth();
        if (n == 0x800003) return viewGroup.getWidth();
        if (n == 0x800005) return viewGroup.getWidth();
        return viewGroup.getHeight();
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues object, TransitionValues transitionValues) {
        long l;
        Object object2;
        Object object3;
        int n;
        if (object == null && transitionValues == null) {
            return 0L;
        }
        Rect rect = transition.getEpicenter();
        if (transitionValues != null && this.getViewVisibility((TransitionValues)object) != 0) {
            n = 1;
            object = transitionValues;
        } else {
            n = -1;
        }
        int n2 = this.getViewX((TransitionValues)object);
        int n3 = this.getViewY((TransitionValues)object);
        object = new int[2];
        viewGroup.getLocationOnScreen((int[])object);
        reference var9_9 = object[0] + Math.round(viewGroup.getTranslationX());
        reference var14_10 = object[1] + Math.round(viewGroup.getTranslationY());
        reference var11_11 = var9_9 + viewGroup.getWidth();
        reference var10_12 = var14_10 + viewGroup.getHeight();
        if (rect != null) {
            object3 = rect.centerX();
            object2 = rect.centerY();
        } else {
            object3 = (var9_9 + var11_11) / 2;
            object2 = (var14_10 + var10_12) / 2;
        }
        float f = (float)this.distance((View)viewGroup, n2, n3, (int)object3, (int)object2, (int)var9_9, (int)var14_10, (int)var11_11, (int)var10_12) / (float)this.getMaxDistance(viewGroup);
        long l2 = l = transition.getDuration();
        if (l >= 0L) return Math.round((float)(l2 * (long)n) / this.mPropagationSpeed * f);
        l2 = 300L;
        return Math.round((float)(l2 * (long)n) / this.mPropagationSpeed * f);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) throw new IllegalArgumentException("propagationSpeed may not be 0");
        this.mPropagationSpeed = f;
    }

    public void setSide(int n) {
        this.mSide = n;
    }
}
