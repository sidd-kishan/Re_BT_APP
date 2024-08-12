/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.WindowDecorActionBar
 *  androidx.core.view.ViewPropertyAnimatorUpdateListener
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

class WindowDecorActionBar.3
implements ViewPropertyAnimatorUpdateListener {
    final WindowDecorActionBar this$0;

    WindowDecorActionBar.3(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationUpdate(View view) {
        ((View)this.this$0.mContainerView.getParent()).invalidate();
    }
}
