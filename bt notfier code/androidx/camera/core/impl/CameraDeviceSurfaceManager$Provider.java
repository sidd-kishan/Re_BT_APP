/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.core.InitializationException
 *  androidx.camera.core.impl.CameraDeviceSurfaceManager
 */
package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import java.util.Set;

public static interface CameraDeviceSurfaceManager.Provider {
    public CameraDeviceSurfaceManager newInstance(Context var1, Object var2, Set<String> var3) throws InitializationException;
}
