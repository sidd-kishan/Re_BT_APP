/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.view.View
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;

/*
 * Exception performing whole class analysis ignored.
 */
class WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
implements Runnable {
    final WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener this$0;
    final WindowInsetsAnimationCompat val$anim;
    final WindowInsetsAnimationCompat.BoundsCompat val$animationBounds;
    final ValueAnimator val$animator;
    final View val$v;

    WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3(WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener, View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat, ValueAnimator valueAnimator) {
        this.this$0 = impl21OnApplyWindowInsetsListener;
        this.val$v = view;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$animationBounds = boundsCompat;
        this.val$animator = valueAnimator;
    }

    @Override
    public void run() {
        WindowInsetsAnimationCompat.Impl21.dispatchOnStart((View)this.val$v, (WindowInsetsAnimationCompat)this.val$anim, (WindowInsetsAnimationCompat.BoundsCompat)this.val$animationBounds);
        this.val$animator.start();
    }
}
