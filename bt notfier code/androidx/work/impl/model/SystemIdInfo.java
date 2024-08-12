/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.model;

public class SystemIdInfo {
    public final int systemId;
    public final String workSpecId;

    public SystemIdInfo(String string, int n) {
        this.workSpecId = string;
        this.systemId = n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SystemIdInfo)) {
            return false;
        }
        object = (SystemIdInfo)object;
        if (this.systemId == ((SystemIdInfo)object).systemId) return this.workSpecId.equals(((SystemIdInfo)object).workSpecId);
        return false;
    }

    public int hashCode() {
        return this.workSpecId.hashCode() * 31 + this.systemId;
    }
}
