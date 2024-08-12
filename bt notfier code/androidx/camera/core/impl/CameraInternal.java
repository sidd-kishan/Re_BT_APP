/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Camera
 *  androidx.camera.core.CameraControl
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCase$StateChangeCallback
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraControlInternal
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.core.impl.CameraInternal$State
 *  androidx.camera.core.impl.Observable
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraException
 */
package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.LinkedHashSet;

public interface CameraInternal
extends Camera,
UseCase.StateChangeCallback {
    public void attachUseCases(Collection<UseCase> var1);

    public void close();

    public void detachUseCases(Collection<UseCase> var1);

    public CameraControl getCameraControl();

    public CameraControlInternal getCameraControlInternal();

    public CameraInfo getCameraInfo();

    public CameraInfoInternal getCameraInfoInternal();

    public LinkedHashSet<CameraInternal> getCameraInternals();

    public Observable<State> getCameraState();

    public CameraConfig getExtendedConfig();

    public void open();

    public ListenableFuture<Void> release();

    public void setExtendedConfig(CameraConfig var1) throws CameraUseCaseAdapter.CameraException;
}
