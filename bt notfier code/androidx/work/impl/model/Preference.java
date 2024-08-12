/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.model;

public class Preference {
    public String mKey;
    public Long mValue;

    public Preference(String string, long l) {
        this.mKey = string;
        this.mValue = l;
    }

    public Preference(String string, boolean bl) {
        long l = bl ? 1L : 0L;
        this(string, l);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof Preference)) {
            return false;
        }
        Object object2 = (Preference)object;
        if (!this.mKey.equals(((Preference)object2).mKey)) {
            return false;
        }
        object = this.mValue;
        object2 = ((Preference)object2).mValue;
        if (object != null) {
            bl = ((Long)object).equals(object2);
        } else {
            if (object2 == null) return bl;
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        int n = this.mKey.hashCode();
        Long l = this.mValue;
        int n2 = l != null ? l.hashCode() : 0;
        return n * 31 + n2;
    }
}
