/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.video.OutputFileResults
 */
package androidx.camera.view.video;

import androidx.camera.view.video.OutputFileResults;

public interface OnVideoSavedCallback {
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_FILE_IO = 4;
    public static final int ERROR_INVALID_CAMERA = 5;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;

    public void onError(int var1, String var2, Throwable var3);

    public void onVideoSaved(OutputFileResults var1);
}
