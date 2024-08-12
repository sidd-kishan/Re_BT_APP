/*
 * Decompiled with CFR 0.152.
 */
package androidx.room.util;

import java.util.List;

public static class TableInfo.Index {
    public static final String DEFAULT_PREFIX = "index_";
    public final List<String> columns;
    public final String name;
    public final boolean unique;

    public TableInfo.Index(String string, boolean bl, List<String> list) {
        this.name = string;
        this.unique = bl;
        this.columns = list;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (TableInfo.Index)object;
        if (this.unique != ((TableInfo.Index)object).unique) {
            return false;
        }
        if (!this.columns.equals(((TableInfo.Index)object).columns)) {
            return false;
        }
        if (!this.name.startsWith(DEFAULT_PREFIX)) return this.name.equals(((TableInfo.Index)object).name);
        return ((TableInfo.Index)object).name.startsWith(DEFAULT_PREFIX);
    }

    public int hashCode() {
        int n = this.name.startsWith(DEFAULT_PREFIX) ? -1184239155 : this.name.hashCode();
        return (n * 31 + this.unique) * 31 + this.columns.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", unique=");
        stringBuilder.append(this.unique);
        stringBuilder.append(", columns=");
        stringBuilder.append(this.columns);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
