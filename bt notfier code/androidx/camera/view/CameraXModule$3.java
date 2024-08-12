/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.VideoCapture$OutputFileResults
 *  androidx.camera.view.CameraXModule
 */
package androidx.camera.view;

import androidx.camera.core.Logger;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.CameraXModule;

class CameraXModule.3
implements VideoCapture.OnVideoSavedCallback {
    final CameraXModule this$0;
    final VideoCapture.OnVideoSavedCallback val$callback;

    CameraXModule.3(CameraXModule cameraXModule, VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        this.this$0 = cameraXModule;
        this.val$callback = onVideoSavedCallback;
    }

    public void onError(int n, String string, Throwable throwable) {
        this.this$0.mVideoIsRecording.set(false);
        Logger.e((String)"CameraXModule", (String)string, (Throwable)throwable);
        this.val$callback.onError(n, string, throwable);
    }

    public void onVideoSaved(VideoCapture.OutputFileResults outputFileResults) {
        this.this$0.mVideoIsRecording.set(false);
        this.val$callback.onVideoSaved(outputFileResults);
    }
}
