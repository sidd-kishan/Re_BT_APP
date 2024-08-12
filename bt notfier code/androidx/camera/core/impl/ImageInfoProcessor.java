/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.impl.CaptureStage
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CaptureStage;

public interface ImageInfoProcessor {
    public CaptureStage getCaptureStage();

    public boolean process(ImageInfo var1);
}
