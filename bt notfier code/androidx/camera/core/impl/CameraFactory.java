/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraUnavailableException
 *  androidx.camera.core.impl.CameraInternal
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.CameraInternal;
import java.util.Set;

public interface CameraFactory {
    public Set<String> getAvailableCameraIds();

    public CameraInternal getCamera(String var1) throws CameraUnavailableException;

    public Object getCameraManager();
}
