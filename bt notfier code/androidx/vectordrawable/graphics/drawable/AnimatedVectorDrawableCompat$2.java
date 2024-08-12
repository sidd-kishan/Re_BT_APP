/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.drawable.Drawable
 *  androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
 *  androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.util.ArrayList;

class AnimatedVectorDrawableCompat.2
extends AnimatorListenerAdapter {
    final AnimatedVectorDrawableCompat this$0;

    AnimatedVectorDrawableCompat.2(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.this$0 = animatedVectorDrawableCompat;
    }

    public void onAnimationEnd(Animator object) {
        object = new ArrayList(this.this$0.mAnimationCallbacks);
        int n = ((ArrayList)object).size();
        int n2 = 0;
        while (n2 < n) {
            ((Animatable2Compat.AnimationCallback)((ArrayList)object).get(n2)).onAnimationEnd((Drawable)this.this$0);
            ++n2;
        }
    }

    public void onAnimationStart(Animator object) {
        object = new ArrayList(this.this$0.mAnimationCallbacks);
        int n = ((ArrayList)object).size();
        int n2 = 0;
        while (n2 < n) {
            ((Animatable2Compat.AnimationCallback)((ArrayList)object).get(n2)).onAnimationStart((Drawable)this.this$0);
            ++n2;
        }
    }
}
