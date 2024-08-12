/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.VideoCapture$OutputFileResults
 *  androidx.camera.view.CameraController
 *  androidx.camera.view.video.OnVideoSavedCallback
 *  androidx.camera.view.video.OutputFileResults
 */
package androidx.camera.view;

import android.net.Uri;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.CameraController;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileResults;

class CameraController.2
implements VideoCapture.OnVideoSavedCallback {
    final CameraController this$0;
    final OnVideoSavedCallback val$callback;

    CameraController.2(CameraController cameraController, OnVideoSavedCallback onVideoSavedCallback) {
        this.this$0 = cameraController;
        this.val$callback = onVideoSavedCallback;
    }

    public void onError(int n, String string, Throwable throwable) {
        this.this$0.mVideoIsRecording.set(false);
        this.val$callback.onError(n, string, throwable);
    }

    public void onVideoSaved(VideoCapture.OutputFileResults outputFileResults) {
        this.this$0.mVideoIsRecording.set(false);
        this.val$callback.onVideoSaved(OutputFileResults.create((Uri)outputFileResults.getSavedUri()));
    }
}
