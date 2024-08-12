/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ProcessingImageReader
 *  androidx.camera.core._$$Lambda$ProcessingImageReader$2$Absc6rRf6C4HWC5BIoaUAtQpadI
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core._$;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

class ProcessingImageReader.2
implements ImageReaderProxy.OnImageAvailableListener {
    final ProcessingImageReader this$0;

    ProcessingImageReader.2(ProcessingImageReader processingImageReader) {
        this.this$0 = processingImageReader;
    }

    public /* synthetic */ void lambda$onImageAvailable$0$ProcessingImageReader$2(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable((ImageReaderProxy)this.this$0);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onImageAvailable(ImageReaderProxy object) {
        Executor executor;
        ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
        object = this.this$0.mLock;
        synchronized (object) {
            onImageAvailableListener = this.this$0.mListener;
            executor = this.this$0.mExecutor;
            this.this$0.mSettableImageProxyBundle.reset();
            this.this$0.setupSettableImageProxyBundleCallbacks();
        }
        if (onImageAvailableListener == null) return;
        if (executor != null) {
            executor.execute((Runnable)new _$.Lambda.ProcessingImageReader.2.Absc6rRf6C4HWC5BIoaUAtQpadI(this, onImageAvailableListener));
            return;
        }
        onImageAvailableListener.onImageAvailable((ImageReaderProxy)this.this$0);
    }
}
