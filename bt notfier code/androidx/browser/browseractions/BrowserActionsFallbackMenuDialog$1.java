/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuDialog
 */
package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.browser.browseractions.BrowserActionsFallbackMenuDialog;

/*
 * Exception performing whole class analysis ignored.
 */
class BrowserActionsFallbackMenuDialog.1
extends AnimatorListenerAdapter {
    final BrowserActionsFallbackMenuDialog this$0;
    final boolean val$isEnterAnimation;

    BrowserActionsFallbackMenuDialog.1(BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog, boolean bl) {
        this.this$0 = browserActionsFallbackMenuDialog;
        this.val$isEnterAnimation = bl;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.val$isEnterAnimation) return;
        BrowserActionsFallbackMenuDialog.access$001((BrowserActionsFallbackMenuDialog)this.this$0);
    }
}
