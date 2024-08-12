/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.work;

import android.net.Uri;

public static final class ContentUriTriggers.Trigger {
    private final boolean mTriggerForDescendants;
    private final Uri mUri;

    ContentUriTriggers.Trigger(Uri uri, boolean bl) {
        this.mUri = uri;
        this.mTriggerForDescendants = bl;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (ContentUriTriggers.Trigger)object;
        if (this.mTriggerForDescendants == ((ContentUriTriggers.Trigger)object).mTriggerForDescendants && this.mUri.equals((Object)((ContentUriTriggers.Trigger)object).mUri)) return bl;
        bl = false;
        return bl;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public int hashCode() {
        return this.mUri.hashCode() * 31 + this.mTriggerForDescendants;
    }

    public boolean shouldTriggerForDescendants() {
        return this.mTriggerForDescendants;
    }
}
