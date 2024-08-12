/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Collections;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
implements ValueAnimator.AnimatorUpdateListener {
    final WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener this$0;
    final WindowInsetsAnimationCompat val$anim;
    final int val$animationMask;
    final WindowInsetsCompat val$startingInsets;
    final WindowInsetsCompat val$targetInsets;
    final View val$v;

    WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1(WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int n, View view) {
        this.this$0 = impl21OnApplyWindowInsetsListener;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$targetInsets = windowInsetsCompat;
        this.val$startingInsets = windowInsetsCompat2;
        this.val$animationMask = n;
        this.val$v = view;
    }

    public void onAnimationUpdate(ValueAnimator object) {
        this.val$anim.setFraction(object.getAnimatedFraction());
        WindowInsetsCompat windowInsetsCompat = WindowInsetsAnimationCompat.Impl21.interpolateInsets((WindowInsetsCompat)this.val$targetInsets, (WindowInsetsCompat)this.val$startingInsets, (float)this.val$anim.getInterpolatedFraction(), (int)this.val$animationMask);
        object = Collections.singletonList(this.val$anim);
        WindowInsetsAnimationCompat.Impl21.dispatchOnProgress((View)this.val$v, (WindowInsetsCompat)windowInsetsCompat, (List)object);
    }
}
