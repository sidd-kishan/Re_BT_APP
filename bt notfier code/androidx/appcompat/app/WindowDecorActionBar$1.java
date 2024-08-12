/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.WindowDecorActionBar
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class WindowDecorActionBar.1
extends ViewPropertyAnimatorListenerAdapter {
    final WindowDecorActionBar this$0;

    WindowDecorActionBar.1(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationEnd(View view) {
        if (this.this$0.mContentAnimations && this.this$0.mContentView != null) {
            this.this$0.mContentView.setTranslationY(0.0f);
            this.this$0.mContainerView.setTranslationY(0.0f);
        }
        this.this$0.mContainerView.setVisibility(8);
        this.this$0.mContainerView.setTransitioning(false);
        this.this$0.mCurrentShowAnim = null;
        this.this$0.completeDeferredDestroyActionMode();
        if (this.this$0.mOverlayLayout == null) return;
        ViewCompat.requestApplyInsets((View)this.this$0.mOverlayLayout);
    }
}
