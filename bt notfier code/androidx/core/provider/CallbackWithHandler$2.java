/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.CallbackWithHandler
 *  androidx.core.provider.FontsContractCompat$FontRequestCallback
 */
package androidx.core.provider;

import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler.2
implements Runnable {
    final CallbackWithHandler this$0;
    final FontsContractCompat.FontRequestCallback val$callback;
    final int val$reason;

    CallbackWithHandler.2(CallbackWithHandler callbackWithHandler, FontsContractCompat.FontRequestCallback fontRequestCallback, int n) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontRequestCallback;
        this.val$reason = n;
    }

    @Override
    public void run() {
        this.val$callback.onTypefaceRequestFailed(this.val$reason);
    }
}
