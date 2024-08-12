/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.common.internal.Objects
 */
package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

final class zad {
    public final Uri zaa;

    public zad(Uri uri) {
        this.zaa = uri;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof zad) return Objects.equal((Object)((zad)object).zaa, (Object)this.zaa);
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zaa});
    }
}
