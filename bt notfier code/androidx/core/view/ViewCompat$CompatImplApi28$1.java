/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnUnhandledKeyEventListener
 *  androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat
 */
package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

class ViewCompat.CompatImplApi28.1
implements View.OnUnhandledKeyEventListener {
    final ViewCompat.OnUnhandledKeyEventListenerCompat val$listener;

    ViewCompat.CompatImplApi28.1(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.val$listener = onUnhandledKeyEventListenerCompat;
    }

    public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.val$listener.onUnhandledKeyEvent(view, keyEvent);
    }
}
