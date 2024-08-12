/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ZoomState
 *  androidx.camera.core.internal.AutoValue_ImmutableZoomState
 */
package androidx.camera.core.internal;

import androidx.camera.core.ZoomState;
import androidx.camera.core.internal.AutoValue_ImmutableZoomState;

public abstract class ImmutableZoomState
implements ZoomState {
    public static ZoomState create(float f, float f2, float f3, float f4) {
        return new AutoValue_ImmutableZoomState(f, f2, f3, f4);
    }

    public static ZoomState create(ZoomState zoomState) {
        return new AutoValue_ImmutableZoomState(zoomState.getZoomRatio(), zoomState.getMaxZoomRatio(), zoomState.getMinZoomRatio(), zoomState.getLinearZoom());
    }

    public abstract float getLinearZoom();

    public abstract float getMaxZoomRatio();

    public abstract float getMinZoomRatio();

    public abstract float getZoomRatio();
}
