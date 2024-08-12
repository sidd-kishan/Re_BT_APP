/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.SurfaceRequest$Result
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;

final class AutoValue_SurfaceRequest_Result
extends SurfaceRequest.Result {
    private final int resultCode;
    private final Surface surface;

    AutoValue_SurfaceRequest_Result(int n, Surface surface) {
        this.resultCode = n;
        if (surface == null) throw new NullPointerException("Null surface");
        this.surface = surface;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof SurfaceRequest.Result)) return false;
        if (this.resultCode == (object = (SurfaceRequest.Result)object).getResultCode() && this.surface.equals(object.getSurface())) return bl;
        bl = false;
        return bl;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public int hashCode() {
        return (this.resultCode ^ 0xF4243) * 1000003 ^ this.surface.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Result{resultCode=");
        stringBuilder.append(this.resultCode);
        stringBuilder.append(", surface=");
        stringBuilder.append(this.surface);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
