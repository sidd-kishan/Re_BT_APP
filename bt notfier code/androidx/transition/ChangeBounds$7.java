/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.AnimatorListenerAdapter
 *  androidx.transition.ChangeBounds
 *  androidx.transition.ChangeBounds$ViewBounds
 */
package androidx.transition;

import android.animation.AnimatorListenerAdapter;
import androidx.transition.ChangeBounds;

class ChangeBounds.7
extends AnimatorListenerAdapter {
    private ChangeBounds.ViewBounds mViewBounds;
    final ChangeBounds this$0;
    final ChangeBounds.ViewBounds val$viewBounds;

    ChangeBounds.7(ChangeBounds changeBounds, ChangeBounds.ViewBounds viewBounds) {
        this.this$0 = changeBounds;
        this.val$viewBounds = viewBounds;
        this.mViewBounds = this.val$viewBounds;
    }
}
