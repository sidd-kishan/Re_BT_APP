/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ProcessingImageReader
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

class ProcessingImageReader.1
implements ImageReaderProxy.OnImageAvailableListener {
    final ProcessingImageReader this$0;

    ProcessingImageReader.1(ProcessingImageReader processingImageReader) {
        this.this$0 = processingImageReader;
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.this$0.imageIncoming(imageReaderProxy);
    }
}
