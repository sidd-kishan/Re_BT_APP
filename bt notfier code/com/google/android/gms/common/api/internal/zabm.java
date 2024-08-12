/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.zabg
 *  com.google.android.gms.common.internal.Objects
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.zabg;
import com.google.android.gms.common.internal.Objects;

final class zabm {
    private final ApiKey<?> zaa;
    private final Feature zab;

    /* synthetic */ zabm(ApiKey apiKey, Feature feature, zabg zabg2) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    static /* synthetic */ ApiKey zaa(zabm zabm2) {
        return zabm2.zaa;
    }

    static /* synthetic */ Feature zab(zabm zabm2) {
        return zabm2.zab;
    }

    public final boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof zabm)) return false;
        object = (zabm)object;
        if (!Objects.equal(this.zaa, ((zabm)object).zaa)) return false;
        if (!Objects.equal((Object)this.zab, (Object)((zabm)object).zab)) return false;
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zaa, this.zab});
    }

    public final String toString() {
        return Objects.toStringHelper((Object)this).add("key", this.zaa).add("feature", (Object)this.zab).toString();
    }
}
