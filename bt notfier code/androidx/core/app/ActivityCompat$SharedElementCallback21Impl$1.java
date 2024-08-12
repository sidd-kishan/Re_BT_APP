/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.SharedElementCallback$OnSharedElementsReadyListener
 *  androidx.core.app.ActivityCompat$SharedElementCallback21Impl
 *  androidx.core.app.SharedElementCallback$OnSharedElementsReadyListener
 */
package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

class ActivityCompat.SharedElementCallback21Impl.1
implements SharedElementCallback.OnSharedElementsReadyListener {
    final ActivityCompat.SharedElementCallback21Impl this$0;
    final SharedElementCallback.OnSharedElementsReadyListener val$listener;

    ActivityCompat.SharedElementCallback21Impl.1(ActivityCompat.SharedElementCallback21Impl sharedElementCallback21Impl, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.this$0 = sharedElementCallback21Impl;
        this.val$listener = onSharedElementsReadyListener;
    }

    public void onSharedElementsReady() {
        this.val$listener.onSharedElementsReady();
    }
}
