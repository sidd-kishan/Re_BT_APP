/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.ImmutableZoomState
 */
package androidx.camera.core.internal;

import androidx.camera.core.internal.ImmutableZoomState;

final class AutoValue_ImmutableZoomState
extends ImmutableZoomState {
    private final float linearZoom;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private final float zoomRatio;

    AutoValue_ImmutableZoomState(float f, float f2, float f3, float f4) {
        this.zoomRatio = f;
        this.maxZoomRatio = f2;
        this.minZoomRatio = f3;
        this.linearZoom = f4;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof ImmutableZoomState)) return false;
        object = (ImmutableZoomState)object;
        if (Float.floatToIntBits(this.zoomRatio) == Float.floatToIntBits(object.getZoomRatio()) && Float.floatToIntBits(this.maxZoomRatio) == Float.floatToIntBits(object.getMaxZoomRatio()) && Float.floatToIntBits(this.minZoomRatio) == Float.floatToIntBits(object.getMinZoomRatio()) && Float.floatToIntBits(this.linearZoom) == Float.floatToIntBits(object.getLinearZoom())) return bl;
        bl = false;
        return bl;
    }

    public float getLinearZoom() {
        return this.linearZoom;
    }

    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.zoomRatio) ^ 0xF4243) * 1000003 ^ Float.floatToIntBits(this.maxZoomRatio)) * 1000003 ^ Float.floatToIntBits(this.minZoomRatio)) * 1000003 ^ Float.floatToIntBits(this.linearZoom);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableZoomState{zoomRatio=");
        stringBuilder.append(this.zoomRatio);
        stringBuilder.append(", maxZoomRatio=");
        stringBuilder.append(this.maxZoomRatio);
        stringBuilder.append(", minZoomRatio=");
        stringBuilder.append(this.minZoomRatio);
        stringBuilder.append(", linearZoom=");
        stringBuilder.append(this.linearZoom);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
