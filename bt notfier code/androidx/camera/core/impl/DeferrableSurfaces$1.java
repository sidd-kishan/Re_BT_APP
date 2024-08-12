/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

class DeferrableSurfaces.1
implements FutureCallback<List<Surface>> {
    final CallbackToFutureAdapter.Completer val$completer;
    final boolean val$removeNullSurfaces;
    final ScheduledFuture val$scheduledFuture;

    DeferrableSurfaces.1(boolean bl, CallbackToFutureAdapter.Completer completer, ScheduledFuture scheduledFuture) {
        this.val$removeNullSurfaces = bl;
        this.val$completer = completer;
        this.val$scheduledFuture = scheduledFuture;
    }

    public void onFailure(Throwable throwable) {
        this.val$completer.set(Collections.unmodifiableList(Collections.emptyList()));
        this.val$scheduledFuture.cancel(true);
    }

    public void onSuccess(List<Surface> list) {
        list = new ArrayList<Surface>(list);
        if (this.val$removeNullSurfaces) {
            list.removeAll(Collections.singleton(null));
        }
        this.val$completer.set(list);
        this.val$scheduledFuture.cancel(true);
    }
}
