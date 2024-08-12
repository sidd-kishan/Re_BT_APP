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

public static abstract class Metadata.Builder {
    Metadata.Builder() {
    }

    public abstract Metadata build();

    public abstract Metadata.Builder setLocation(Location var1);
}
