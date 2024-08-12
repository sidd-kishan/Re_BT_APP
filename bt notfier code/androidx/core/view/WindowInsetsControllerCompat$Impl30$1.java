/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsAnimationControlListener
 *  android.view.WindowInsetsAnimationController
 *  androidx.core.view.WindowInsetsAnimationControlListenerCompat
 *  androidx.core.view.WindowInsetsAnimationControllerCompat
 *  androidx.core.view.WindowInsetsControllerCompat$Impl30
 */
package androidx.core.view;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import androidx.core.view.WindowInsetsControllerCompat;

class WindowInsetsControllerCompat.Impl30.1
implements WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationControllerCompat mCompatAnimController;
    final WindowInsetsControllerCompat.Impl30 this$0;
    final WindowInsetsAnimationControlListenerCompat val$listener;

    WindowInsetsControllerCompat.Impl30.1(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.this$0 = impl30;
        this.val$listener = windowInsetsAnimationControlListenerCompat;
        this.mCompatAnimController = null;
    }

    public void onCancelled(WindowInsetsAnimationController object) {
        WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat = this.val$listener;
        object = object == null ? null : this.mCompatAnimController;
        windowInsetsAnimationControlListenerCompat.onCancelled((WindowInsetsAnimationControllerCompat)object);
    }

    public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.val$listener.onFinished(this.mCompatAnimController);
    }

    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int n) {
        windowInsetsAnimationController = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
        this.mCompatAnimController = windowInsetsAnimationController;
        this.val$listener.onReady((WindowInsetsAnimationControllerCompat)windowInsetsAnimationController, n);
    }
}
