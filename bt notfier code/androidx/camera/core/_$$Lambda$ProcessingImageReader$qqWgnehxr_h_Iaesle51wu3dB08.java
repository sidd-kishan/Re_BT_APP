/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ProcessingImageReader
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.ProcessingImageReader;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$ProcessingImageReader$qqWgnehxr_h_Iaesle51wu3dB08
implements CallbackToFutureAdapter.Resolver {
    private final ProcessingImageReader f$0;

    public /* synthetic */ _$$Lambda$ProcessingImageReader$qqWgnehxr_h_Iaesle51wu3dB08(ProcessingImageReader processingImageReader) {
        this.f$0 = processingImageReader;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$getCloseFuture$0$ProcessingImageReader(completer);
    }
}
