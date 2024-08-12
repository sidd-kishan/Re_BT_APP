/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.LocusId
 */
package androidx.core.content;

import android.content.LocusId;

private static class LocusIdCompat.Api29Impl {
    private LocusIdCompat.Api29Impl() {
    }

    static LocusId create(String string) {
        return new LocusId(string);
    }

    static String getId(LocusId locusId) {
        return locusId.getId();
    }
}
