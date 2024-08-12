/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.TextureViewImplementation
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.view;

import androidx.camera.view.TextureViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$TextureViewImplementation$wCD6ilTjRIgpgUn9gSmCeAFq7P4
implements CallbackToFutureAdapter.Resolver {
    private final TextureViewImplementation f$0;

    public /* synthetic */ _$$Lambda$TextureViewImplementation$wCD6ilTjRIgpgUn9gSmCeAFq7P4(TextureViewImplementation textureViewImplementation) {
        this.f$0 = textureViewImplementation;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$waitForNextFrame$3$TextureViewImplementation(completer);
    }
}
