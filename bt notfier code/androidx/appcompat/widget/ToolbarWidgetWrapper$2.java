/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.ToolbarWidgetWrapper
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class ToolbarWidgetWrapper.2
extends ViewPropertyAnimatorListenerAdapter {
    private boolean mCanceled;
    final ToolbarWidgetWrapper this$0;
    final int val$visibility;

    ToolbarWidgetWrapper.2(ToolbarWidgetWrapper toolbarWidgetWrapper, int n) {
        this.this$0 = toolbarWidgetWrapper;
        this.val$visibility = n;
        this.mCanceled = false;
    }

    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(View view) {
        if (this.mCanceled) return;
        this.this$0.mToolbar.setVisibility(this.val$visibility);
    }

    public void onAnimationStart(View view) {
        this.this$0.mToolbar.setVisibility(0);
    }
}
