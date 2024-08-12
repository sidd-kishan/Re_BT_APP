/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.transition.ChangeClipBounds
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeClipBounds;

class ChangeClipBounds.1
extends AnimatorListenerAdapter {
    final ChangeClipBounds this$0;
    final View val$endView;

    ChangeClipBounds.1(ChangeClipBounds changeClipBounds, View view) {
        this.this$0 = changeClipBounds;
        this.val$endView = view;
    }

    public void onAnimationEnd(Animator animator) {
        ViewCompat.setClipBounds((View)this.val$endView, null);
    }
}
