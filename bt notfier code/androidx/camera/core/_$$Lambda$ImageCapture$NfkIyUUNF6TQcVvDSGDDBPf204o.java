/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$ImageCapture$NfkIyUUNF6TQcVvDSGDDBPf204o
implements Runnable {
    private final CallbackToFutureAdapter.Completer f$0;

    public /* synthetic */ _$$Lambda$ImageCapture$NfkIyUUNF6TQcVvDSGDDBPf204o(CallbackToFutureAdapter.Completer completer) {
        this.f$0 = completer;
    }

    @Override
    public final void run() {
        ImageCapture.lambda$openTorch$14((CallbackToFutureAdapter.Completer)this.f$0);
    }
}
