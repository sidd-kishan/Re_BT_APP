/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.Logger
 *  androidx.camera.core.ProcessingSurface
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;

class ProcessingSurface.1
implements FutureCallback<Surface> {
    final ProcessingSurface this$0;

    ProcessingSurface.1(ProcessingSurface processingSurface) {
        this.this$0 = processingSurface;
    }

    public void onFailure(Throwable throwable) {
        Logger.e((String)"ProcessingSurfaceTextur", (String)"Failed to extract Listenable<Surface>.", (Throwable)throwable);
    }

    public void onSuccess(Surface surface) {
        Object object = this.this$0.mLock;
        synchronized (object) {
            this.this$0.mCaptureProcessor.onOutputSurface(surface, 1);
            return;
        }
    }
}
