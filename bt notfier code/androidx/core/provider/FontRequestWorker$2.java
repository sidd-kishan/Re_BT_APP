/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.CallbackWithHandler
 *  androidx.core.provider.FontRequestWorker$TypefaceResult
 *  androidx.core.util.Consumer
 */
package androidx.core.provider;

import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.util.Consumer;

class FontRequestWorker.2
implements Consumer<FontRequestWorker.TypefaceResult> {
    final CallbackWithHandler val$callback;

    FontRequestWorker.2(CallbackWithHandler callbackWithHandler) {
        this.val$callback = callbackWithHandler;
    }

    public void accept(FontRequestWorker.TypefaceResult typefaceResult) {
        this.val$callback.onTypefaceResult(typefaceResult);
    }
}
