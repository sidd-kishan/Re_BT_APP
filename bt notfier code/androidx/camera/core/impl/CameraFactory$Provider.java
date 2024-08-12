/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.InitializationException
 *  androidx.camera.core.impl.CameraFactory
 *  androidx.camera.core.impl.CameraThreadConfig
 */
package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;

public static interface CameraFactory.Provider {
    public CameraFactory newInstance(Context var1, CameraThreadConfig var2, CameraSelector var3) throws InitializationException;
}
