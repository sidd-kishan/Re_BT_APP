/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.VideoCapture$OutputFileResults
 */
package androidx.camera.core;

import androidx.camera.core.VideoCapture;

public static interface VideoCapture.OnVideoSavedCallback {
    public void onError(int var1, String var2, Throwable var3);

    public void onVideoSaved(VideoCapture.OutputFileResults var1);
}
