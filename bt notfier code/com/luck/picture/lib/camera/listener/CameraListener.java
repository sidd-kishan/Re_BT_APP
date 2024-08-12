/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.camera.listener;

import java.io.File;

public interface CameraListener {
    public void onError(int var1, String var2, Throwable var3);

    public void onPictureSuccess(File var1);

    public void onRecordSuccess(File var1);
}
