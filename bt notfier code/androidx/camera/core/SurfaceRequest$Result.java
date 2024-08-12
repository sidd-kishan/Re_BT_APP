/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.AutoValue_SurfaceRequest_Result
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.AutoValue_SurfaceRequest_Result;

public static abstract class SurfaceRequest.Result {
    public static final int RESULT_INVALID_SURFACE = 2;
    public static final int RESULT_REQUEST_CANCELLED = 1;
    public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
    public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
    public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

    SurfaceRequest.Result() {
    }

    static SurfaceRequest.Result of(int n, Surface surface) {
        return new AutoValue_SurfaceRequest_Result(n, surface);
    }

    public abstract int getResultCode();

    public abstract Surface getSurface();
}
