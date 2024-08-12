/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.camera.view.video.AutoValue_Metadata
 *  androidx.camera.view.video.Metadata
 *  androidx.camera.view.video.Metadata$Builder
 */
package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.AutoValue_Metadata;
import androidx.camera.view.video.Metadata;

static final class AutoValue_Metadata.Builder
extends Metadata.Builder {
    private Location location;

    AutoValue_Metadata.Builder() {
    }

    public Metadata build() {
        return new AutoValue_Metadata(this.location, null);
    }

    public Metadata.Builder setLocation(Location location) {
        this.location = location;
        return this;
    }
}
