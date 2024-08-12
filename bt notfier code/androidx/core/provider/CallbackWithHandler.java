/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Handler
 *  androidx.core.provider.CalleeHandler
 *  androidx.core.provider.FontRequestWorker$TypefaceResult
 *  androidx.core.provider.FontsContractCompat$FontRequestCallback
 */
package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.CalleeHandler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler {
    private final FontsContractCompat.FontRequestCallback mCallback;
    private final Handler mCallbackHandler;

    CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = CalleeHandler.create();
    }

    CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(int n) {
        FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mCallbackHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void onTypefaceRetrieved(Typeface typeface) {
        FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mCallbackHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            this.onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            this.onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }
}
