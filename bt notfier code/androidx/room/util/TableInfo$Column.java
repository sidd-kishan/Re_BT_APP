/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.room.util;

import android.os.Build;
import java.util.Locale;

public static class TableInfo.Column {
    public final int affinity;
    public final String defaultValue;
    private final int mCreatedFrom;
    public final String name;
    public final boolean notNull;
    public final int primaryKeyPosition;
    public final String type;

    @Deprecated
    public TableInfo.Column(String string, String string2, boolean bl, int n) {
        this(string, string2, bl, n, null, 0);
    }

    public TableInfo.Column(String string, String string2, boolean bl, int n, String string3, int n2) {
        this.name = string;
        this.type = string2;
        this.notNull = bl;
        this.primaryKeyPosition = n;
        this.affinity = TableInfo.Column.findAffinity(string2);
        this.defaultValue = string3;
        this.mCreatedFrom = n2;
    }

    private static int findAffinity(String string) {
        if (string == null) {
            return 5;
        }
        if ((string = string.toUpperCase(Locale.US)).contains("INT")) {
            return 3;
        }
        if (string.contains("CHAR")) return 2;
        if (string.contains("CLOB")) return 2;
        if (string.contains("TEXT")) {
            return 2;
        }
        if (string.contains("BLOB")) {
            return 5;
        }
        if (string.contains("REAL")) return 4;
        if (string.contains("FLOA")) return 4;
        if (!string.contains("DOUB")) return 1;
        return 4;
    }

    public boolean equals(Object object) {
        String string;
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (TableInfo.Column)object;
        if (Build.VERSION.SDK_INT >= 20 ? this.primaryKeyPosition != ((TableInfo.Column)object).primaryKeyPosition : this.isPrimaryKey() != ((TableInfo.Column)object).isPrimaryKey()) {
            return false;
        }
        if (!this.name.equals(((TableInfo.Column)object).name)) {
            return false;
        }
        if (this.notNull != ((TableInfo.Column)object).notNull) {
            return false;
        }
        if (this.mCreatedFrom == 1 && ((TableInfo.Column)object).mCreatedFrom == 2 && (string = this.defaultValue) != null && !string.equals(((TableInfo.Column)object).defaultValue)) {
            return false;
        }
        if (this.mCreatedFrom == 2 && ((TableInfo.Column)object).mCreatedFrom == 1 && (string = ((TableInfo.Column)object).defaultValue) != null && !string.equals(this.defaultValue)) {
            return false;
        }
        int n = this.mCreatedFrom;
        if (n != 0 && n == ((TableInfo.Column)object).mCreatedFrom && ((string = this.defaultValue) != null ? !string.equals(((TableInfo.Column)object).defaultValue) : ((TableInfo.Column)object).defaultValue != null)) {
            return false;
        }
        if (this.affinity == ((TableInfo.Column)object).affinity) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        int n = this.name.hashCode();
        int n2 = this.affinity;
        int n3 = this.notNull ? 1231 : 1237;
        return ((n * 31 + n2) * 31 + n3) * 31 + this.primaryKeyPosition;
    }

    public boolean isPrimaryKey() {
        boolean bl = this.primaryKeyPosition > 0;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Column{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", type='");
        stringBuilder.append(this.type);
        stringBuilder.append('\'');
        stringBuilder.append(", affinity='");
        stringBuilder.append(this.affinity);
        stringBuilder.append('\'');
        stringBuilder.append(", notNull=");
        stringBuilder.append(this.notNull);
        stringBuilder.append(", primaryKeyPosition=");
        stringBuilder.append(this.primaryKeyPosition);
        stringBuilder.append(", defaultValue='");
        stringBuilder.append(this.defaultValue);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
