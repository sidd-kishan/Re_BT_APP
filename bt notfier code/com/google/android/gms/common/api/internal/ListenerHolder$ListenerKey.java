/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.api.internal;

public static final class ListenerHolder.ListenerKey<L> {
    private final L zaa;
    private final String zab;

    ListenerHolder.ListenerKey(L l, String string) {
        this.zaa = l;
        this.zab = string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ListenerHolder.ListenerKey)) {
            return false;
        }
        object = (ListenerHolder.ListenerKey)object;
        if (this.zaa != ((ListenerHolder.ListenerKey)object).zaa) return false;
        if (!this.zab.equals(((ListenerHolder.ListenerKey)object).zab)) return false;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.zaa) * 31 + this.zab.hashCode();
    }
}
