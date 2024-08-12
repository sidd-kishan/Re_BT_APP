/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.camera.view.video.Metadata
 */
package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.Metadata;

final class AutoValue_Metadata
extends Metadata {
    private final Location location;

    private AutoValue_Metadata(Location location) {
        this.location = location;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof Metadata)) return false;
        Metadata metadata = (Metadata)object;
        object = this.location;
        metadata = metadata.getLocation();
        if (object == null) {
            if (metadata == null) return bl;
            bl = false;
        } else {
            bl = object.equals(metadata);
        }
        return bl;
    }

    public Location getLocation() {
        return this.location;
    }

    public int hashCode() {
        Location location = this.location;
        int n = location == null ? 0 : location.hashCode();
        return n ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Metadata{location=");
        stringBuilder.append(this.location);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
