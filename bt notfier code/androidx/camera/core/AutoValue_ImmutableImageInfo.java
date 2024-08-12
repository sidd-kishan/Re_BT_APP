/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImmutableImageInfo
 *  androidx.camera.core.impl.TagBundle
 */
package androidx.camera.core;

import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.impl.TagBundle;

final class AutoValue_ImmutableImageInfo
extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final TagBundle tagBundle;
    private final long timestamp;

    AutoValue_ImmutableImageInfo(TagBundle tagBundle, long l, int n) {
        if (tagBundle == null) throw new NullPointerException("Null tagBundle");
        this.tagBundle = tagBundle;
        this.timestamp = l;
        this.rotationDegrees = n;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof ImmutableImageInfo)) return false;
        if (this.tagBundle.equals((object = (ImmutableImageInfo)object).getTagBundle()) && this.timestamp == object.getTimestamp() && this.rotationDegrees == object.getRotationDegrees()) return bl;
        bl = false;
        return bl;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public TagBundle getTagBundle() {
        return this.tagBundle;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int n = this.tagBundle.hashCode();
        long l = this.timestamp;
        return ((n ^ 0xF4243) * 1000003 ^ (int)(l ^ l >>> 32)) * 1000003 ^ this.rotationDegrees;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableImageInfo{tagBundle=");
        stringBuilder.append(this.tagBundle);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", rotationDegrees=");
        stringBuilder.append(this.rotationDegrees);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
