/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraProvider
 *  androidx.camera.core.UseCase
 */
package androidx.camera.lifecycle;

import androidx.camera.core.CameraProvider;
import androidx.camera.core.UseCase;

interface LifecycleCameraProvider
extends CameraProvider {
    public boolean isBound(UseCase var1);

    public void unbind(UseCase ... var1);

    public void unbindAll();
}
