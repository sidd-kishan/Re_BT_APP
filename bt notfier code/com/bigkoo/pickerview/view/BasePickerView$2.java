/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  com.bigkoo.pickerview.view.BasePickerView
 */
package com.bigkoo.pickerview.view;

import android.view.animation.Animation;
import com.bigkoo.pickerview.view.BasePickerView;

class BasePickerView.2
implements Animation.AnimationListener {
    final BasePickerView this$0;

    BasePickerView.2(BasePickerView basePickerView) {
        this.this$0 = basePickerView;
    }

    public void onAnimationEnd(Animation animation) {
        this.this$0.dismissImmediately();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
