/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.VideoCapture
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.SessionConfig$SessionError
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.SessionConfig;

class VideoCapture.1
implements SessionConfig.ErrorListener {
    final VideoCapture this$0;
    final String val$cameraId;
    final Size val$resolution;

    VideoCapture.1(VideoCapture videoCapture, String string, Size size) {
        this.this$0 = videoCapture;
        this.val$cameraId = string;
        this.val$resolution = size;
    }

    public void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (!this.this$0.isCurrentCamera(this.val$cameraId)) return;
        this.this$0.setupEncoder(this.val$cameraId, this.val$resolution);
        this.this$0.notifyReset();
    }
}
