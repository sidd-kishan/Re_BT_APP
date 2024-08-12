/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraRepository
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraRepository;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$CameraRepository$GfCuwjwqCywAr4DgCn1JSOYgBEg
implements CallbackToFutureAdapter.Resolver {
    private final CameraRepository f$0;

    public /* synthetic */ _$$Lambda$CameraRepository$GfCuwjwqCywAr4DgCn1JSOYgBEg(CameraRepository cameraRepository) {
        this.f$0 = cameraRepository;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$deinit$0$CameraRepository(completer);
    }
}
