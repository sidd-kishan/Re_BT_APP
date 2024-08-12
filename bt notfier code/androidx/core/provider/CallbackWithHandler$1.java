/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  androidx.core.provider.CallbackWithHandler
 *  androidx.core.provider.FontsContractCompat$FontRequestCallback
 */
package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler.1
implements Runnable {
    final CallbackWithHandler this$0;
    final FontsContractCompat.FontRequestCallback val$callback;
    final Typeface val$typeface;

    CallbackWithHandler.1(CallbackWithHandler callbackWithHandler, FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontRequestCallback;
        this.val$typeface = typeface;
    }

    @Override
    public void run() {
        this.val$callback.onTypefaceRetrieved(this.val$typeface);
    }
}
