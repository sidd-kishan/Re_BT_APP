/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.view.TextureViewImplementation
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.view;

import android.view.Surface;
import androidx.camera.view.TextureViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$TextureViewImplementation$Hl0YGRNVRzSkOIexKiob_cdd3zk
implements CallbackToFutureAdapter.Resolver {
    private final TextureViewImplementation f$0;
    private final Surface f$1;

    public /* synthetic */ _$$Lambda$TextureViewImplementation$Hl0YGRNVRzSkOIexKiob_cdd3zk(TextureViewImplementation textureViewImplementation, Surface surface) {
        this.f$0 = textureViewImplementation;
        this.f$1 = surface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$tryToProvidePreviewSurface$1$TextureViewImplementation(this.f$1, completer);
    }
}
