/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.VideoCapture
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.VideoCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final class _$$Lambda$VideoCapture$sWuEFWqiGVmDEh_KqMmeL3T_hpU
implements CallbackToFutureAdapter.Resolver {
    private final AtomicReference f$0;

    public /* synthetic */ _$$Lambda$VideoCapture$sWuEFWqiGVmDEh_KqMmeL3T_hpU(AtomicReference atomicReference) {
        this.f$0 = atomicReference;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return VideoCapture.lambda$startRecording$1((AtomicReference)this.f$0, (CallbackToFutureAdapter.Completer)completer);
    }
}
