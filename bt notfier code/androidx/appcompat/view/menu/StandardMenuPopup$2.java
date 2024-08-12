/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  androidx.appcompat.view.menu.StandardMenuPopup
 */
package androidx.appcompat.view.menu;

import android.view.View;
import androidx.appcompat.view.menu.StandardMenuPopup;

class StandardMenuPopup.2
implements View.OnAttachStateChangeListener {
    final StandardMenuPopup this$0;

    StandardMenuPopup.2(StandardMenuPopup standardMenuPopup) {
        this.this$0 = standardMenuPopup;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        if (this.this$0.mTreeObserver != null) {
            if (!this.this$0.mTreeObserver.isAlive()) {
                this.this$0.mTreeObserver = view.getViewTreeObserver();
            }
            this.this$0.mTreeObserver.removeGlobalOnLayoutListener(this.this$0.mGlobalLayoutListener);
        }
        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }
}
