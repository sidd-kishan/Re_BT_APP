/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  androidx.appcompat.widget.AppCompatSpinner
 */
package androidx.appcompat.widget;

import android.os.Build;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

class AppCompatSpinner.2
implements ViewTreeObserver.OnGlobalLayoutListener {
    final AppCompatSpinner this$0;

    AppCompatSpinner.2(AppCompatSpinner appCompatSpinner) {
        this.this$0 = appCompatSpinner;
    }

    public void onGlobalLayout() {
        ViewTreeObserver viewTreeObserver;
        if (!this.this$0.getInternalPopup().isShowing()) {
            this.this$0.showPopup();
        }
        if ((viewTreeObserver = this.this$0.getViewTreeObserver()) == null) return;
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
    }
}
