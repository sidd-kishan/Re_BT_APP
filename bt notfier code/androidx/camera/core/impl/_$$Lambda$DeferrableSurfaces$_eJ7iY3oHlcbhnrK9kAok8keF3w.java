/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.DeferrableSurfaces
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class _$$Lambda$DeferrableSurfaces$_eJ7iY3oHlcbhnrK9kAok8keF3w
implements CallbackToFutureAdapter.Resolver {
    private final List f$0;
    private final ScheduledExecutorService f$1;
    private final Executor f$2;
    private final long f$3;
    private final boolean f$4;

    public /* synthetic */ _$$Lambda$DeferrableSurfaces$_eJ7iY3oHlcbhnrK9kAok8keF3w(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long l, boolean bl) {
        this.f$0 = list;
        this.f$1 = scheduledExecutorService;
        this.f$2 = executor;
        this.f$3 = l;
        this.f$4 = bl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return DeferrableSurfaces.lambda$surfaceListWithTimeout$3((List)this.f$0, (ScheduledExecutorService)this.f$1, (Executor)this.f$2, (long)this.f$3, (boolean)this.f$4, (CallbackToFutureAdapter.Completer)completer);
    }
}
