/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 *  androidx.core.view.WindowInsetsControllerCompat$Impl20
 */
package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowInsetsControllerCompat;

class WindowInsetsControllerCompat.Impl20.1
implements Runnable {
    final WindowInsetsControllerCompat.Impl20 this$0;
    final View val$finalView;

    WindowInsetsControllerCompat.Impl20.1(WindowInsetsControllerCompat.Impl20 impl20, View view) {
        this.this$0 = impl20;
        this.val$finalView = view;
    }

    @Override
    public void run() {
        ((InputMethodManager)this.val$finalView.getContext().getSystemService("input_method")).showSoftInput(this.val$finalView, 0);
    }
}
