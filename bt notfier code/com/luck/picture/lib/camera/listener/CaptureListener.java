/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.camera.listener;

public interface CaptureListener {
    public void recordEnd(long var1);

    public void recordError();

    public void recordShort(long var1);

    public void recordStart();

    public void recordZoom(float var1);

    public void takePictures();
}
