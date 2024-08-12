/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.VideoCapture$OutputFileResults
 *  androidx.camera.view.CameraView
 *  androidx.camera.view.video.OnVideoSavedCallback
 *  androidx.camera.view.video.OutputFileResults
 */
package androidx.camera.view;

import android.net.Uri;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.CameraView;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileResults;

class CameraView.2
implements VideoCapture.OnVideoSavedCallback {
    final CameraView this$0;
    final OnVideoSavedCallback val$callback;

    CameraView.2(CameraView cameraView, OnVideoSavedCallback onVideoSavedCallback) {
        this.this$0 = cameraView;
        this.val$callback = onVideoSavedCallback;
    }

    public void onError(int n, String string, Throwable throwable) {
        this.val$callback.onError(n, string, throwable);
    }

    public void onVideoSaved(VideoCapture.OutputFileResults outputFileResults) {
        this.val$callback.onVideoSaved(OutputFileResults.create((Uri)outputFileResults.getSavedUri()));
    }
}
