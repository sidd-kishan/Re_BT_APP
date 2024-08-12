/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ProcessingImageReader
 *  androidx.camera.core.impl.ImageProxyBundle
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 */
package androidx.camera.core;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import java.util.List;

class ProcessingImageReader.3
implements FutureCallback<List<ImageProxy>> {
    final ProcessingImageReader this$0;

    ProcessingImageReader.3(ProcessingImageReader processingImageReader) {
        this.this$0 = processingImageReader;
    }

    public void onFailure(Throwable throwable) {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onSuccess(List<ImageProxy> object) {
        Object object2;
        object = this.this$0.mLock;
        synchronized (object) {
            if (this.this$0.mClosed) {
                return;
            }
            this.this$0.mProcessing = true;
            object2 = this.this$0.mSettableImageProxyBundle;
        }
        this.this$0.mCaptureProcessor.process((ImageProxyBundle)object2);
        object2 = this.this$0.mLock;
        synchronized (object2) {
            this.this$0.mProcessing = false;
            if (!this.this$0.mClosed) return;
            this.this$0.mInputImageReader.close();
            this.this$0.mSettableImageProxyBundle.close();
            this.this$0.mOutputImageReader.close();
            if (this.this$0.mCloseCompleter == null) return;
            this.this$0.mCloseCompleter.set(null);
            return;
        }
    }
}
