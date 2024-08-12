/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener
 */
package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.FitWindowsViewGroup;

class AppCompatDelegateImpl.4
implements FitWindowsViewGroup.OnFitSystemWindowsListener {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.4(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onFitSystemWindows(Rect rect) {
        rect.top = this.this$0.updateStatusGuard(null, rect);
    }
}
