/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;

/*
 * Exception performing whole class analysis ignored.
 */
class WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
extends AnimatorListenerAdapter {
    final WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener this$0;
    final WindowInsetsAnimationCompat val$anim;
    final View val$v;

    WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2(WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener, WindowInsetsAnimationCompat windowInsetsAnimationCompat, View view) {
        this.this$0 = impl21OnApplyWindowInsetsListener;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$v = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$anim.setFraction(1.0f);
        WindowInsetsAnimationCompat.Impl21.dispatchOnEnd((View)this.val$v, (WindowInsetsAnimationCompat)this.val$anim);
    }
}
