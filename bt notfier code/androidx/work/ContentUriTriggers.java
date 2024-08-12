/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.work.ContentUriTriggers$Trigger
 */
package androidx.work;

import android.net.Uri;
import androidx.work.ContentUriTriggers;
import java.util.HashSet;
import java.util.Set;

public final class ContentUriTriggers {
    private final Set<Trigger> mTriggers = new HashSet<Trigger>();

    public void add(Uri uri, boolean bl) {
        uri = new Trigger(uri, bl);
        this.mTriggers.add((Trigger)uri);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (ContentUriTriggers)object;
        return this.mTriggers.equals(((ContentUriTriggers)object).mTriggers);
    }

    public Set<Trigger> getTriggers() {
        return this.mTriggers;
    }

    public int hashCode() {
        return this.mTriggers.hashCode();
    }

    public int size() {
        return this.mTriggers.size();
    }
}
