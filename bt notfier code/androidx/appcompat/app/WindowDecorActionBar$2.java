/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.WindowDecorActionBar
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class WindowDecorActionBar.2
extends ViewPropertyAnimatorListenerAdapter {
    final WindowDecorActionBar this$0;

    WindowDecorActionBar.2(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationEnd(View view) {
        this.this$0.mCurrentShowAnim = null;
        this.this$0.mContainerView.requestLayout();
    }
}
