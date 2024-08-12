/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.core.view.ViewCompat
 *  androidx.transition.GhostViewPort
 */
package androidx.transition;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.transition.GhostViewPort;

class GhostViewPort.1
implements ViewTreeObserver.OnPreDrawListener {
    final GhostViewPort this$0;

    GhostViewPort.1(GhostViewPort ghostViewPort) {
        this.this$0 = ghostViewPort;
    }

    public boolean onPreDraw() {
        ViewCompat.postInvalidateOnAnimation((View)this.this$0);
        if (this.this$0.mStartParent == null) return true;
        if (this.this$0.mStartView == null) return true;
        this.this$0.mStartParent.endViewTransition(this.this$0.mStartView);
        ViewCompat.postInvalidateOnAnimation((View)this.this$0.mStartParent);
        this.this$0.mStartParent = null;
        this.this$0.mStartView = null;
        return true;
    }
}
