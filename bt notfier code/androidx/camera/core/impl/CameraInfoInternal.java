/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.impl.CamcorderProfileProvider
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.Quirks
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CamcorderProfileProvider;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.Quirks;
import java.util.concurrent.Executor;

public interface CameraInfoInternal
extends CameraInfo {
    public void addSessionCaptureCallback(Executor var1, CameraCaptureCallback var2);

    public CamcorderProfileProvider getCamcorderProfileProvider();

    public String getCameraId();

    public Quirks getCameraQuirks();

    public Integer getLensFacing();

    public void removeSessionCaptureCallback(CameraCaptureCallback var1);
}
