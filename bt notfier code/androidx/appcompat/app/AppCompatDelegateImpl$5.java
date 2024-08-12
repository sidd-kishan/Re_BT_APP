/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.widget.ContentFrameLayout$OnAttachListener
 */
package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.ContentFrameLayout;

class AppCompatDelegateImpl.5
implements ContentFrameLayout.OnAttachListener {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.5(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onAttachedFromWindow() {
    }

    public void onDetachedFromWindow() {
        this.this$0.dismissPopups();
    }
}
