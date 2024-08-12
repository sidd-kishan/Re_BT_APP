/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.LocusId
 *  android.os.Build$VERSION
 *  androidx.core.content.LocusIdCompat$Api29Impl
 *  androidx.core.util.Preconditions
 */
package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.content.LocusIdCompat;
import androidx.core.util.Preconditions;

/*
 * Exception performing whole class analysis ignored.
 */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    public LocusIdCompat(String string) {
        this.mId = (String)Preconditions.checkStringNotEmpty((CharSequence)string, (Object)"id cannot be empty");
        this.mWrapped = Build.VERSION.SDK_INT >= 29 ? Api29Impl.create((String)string) : null;
    }

    private String getSanitizedId() {
        int n = this.mId.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append("_chars");
        return stringBuilder.toString();
    }

    public static LocusIdCompat toLocusIdCompat(LocusId locusId) {
        Preconditions.checkNotNull((Object)locusId, (Object)"locusId cannot be null");
        return new LocusIdCompat((String)Preconditions.checkStringNotEmpty((CharSequence)Api29Impl.getId((LocusId)locusId), (Object)"id cannot be empty"));
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat)object;
        object = this.mId;
        if (object != null) return ((String)object).equals(locusIdCompat.mId);
        if (locusIdCompat.mId == null) return bl;
        bl = false;
        return bl;
    }

    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        String string = this.mId;
        int n = string == null ? 0 : string.hashCode();
        return 31 + n;
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocusIdCompat[");
        stringBuilder.append(this.getSanitizedId());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
