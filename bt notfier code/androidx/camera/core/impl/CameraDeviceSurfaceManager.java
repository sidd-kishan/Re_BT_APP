/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.impl.SurfaceConfig
 *  androidx.camera.core.impl.UseCaseConfig
 */
package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.List;
import java.util.Map;

public interface CameraDeviceSurfaceManager {
    public boolean checkSupported(String var1, List<SurfaceConfig> var2);

    public Map<UseCaseConfig<?>, Size> getSuggestedResolutions(String var1, List<SurfaceConfig> var2, List<UseCaseConfig<?>> var3);

    public SurfaceConfig transformSurfaceConfig(String var1, int var2, Size var3);
}
