/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 *  androidx.core.view.WindowInsetsControllerCompat$Impl30
 *  androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

class WindowInsetsControllerCompat.Impl30.2
implements WindowInsetsController.OnControllableInsetsChangedListener {
    final WindowInsetsControllerCompat.Impl30 this$0;
    final WindowInsetsControllerCompat.OnControllableInsetsChangedListener val$listener;

    WindowInsetsControllerCompat.Impl30.2(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.this$0 = impl30;
        this.val$listener = onControllableInsetsChangedListener;
    }

    public void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int n) {
        if (this.this$0.mInsetsController != windowInsetsController) return;
        this.val$listener.onControllableInsetsChanged(this.this$0.mCompatController, n);
    }
}
