/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.MetadataImageReader
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureResult
 */
package androidx.camera.core;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;

class MetadataImageReader.1
extends CameraCaptureCallback {
    final MetadataImageReader this$0;

    MetadataImageReader.1(MetadataImageReader metadataImageReader) {
        this.this$0 = metadataImageReader;
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        super.onCaptureCompleted(cameraCaptureResult);
        this.this$0.resultIncoming(cameraCaptureResult);
    }
}
