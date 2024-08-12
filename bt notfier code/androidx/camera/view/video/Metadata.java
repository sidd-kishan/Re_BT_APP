/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.camera.view.video.AutoValue_Metadata$Builder
 *  androidx.camera.view.video.Metadata$Builder
 */
package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.AutoValue_Metadata;
import androidx.camera.view.video.Metadata;

public abstract class Metadata {
    Metadata() {
    }

    public static Builder builder() {
        return new AutoValue_Metadata.Builder();
    }

    public abstract Location getLocation();
}
