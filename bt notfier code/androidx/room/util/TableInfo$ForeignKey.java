/*
 * Decompiled with CFR 0.152.
 */
package androidx.room.util;

import java.util.Collections;
import java.util.List;

public static class TableInfo.ForeignKey {
    public final List<String> columnNames;
    public final String onDelete;
    public final String onUpdate;
    public final List<String> referenceColumnNames;
    public final String referenceTable;

    public TableInfo.ForeignKey(String string, String string2, String string3, List<String> list, List<String> list2) {
        this.referenceTable = string;
        this.onDelete = string2;
        this.onUpdate = string3;
        this.columnNames = Collections.unmodifiableList(list);
        this.referenceColumnNames = Collections.unmodifiableList(list2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (TableInfo.ForeignKey)object;
        if (!this.referenceTable.equals(((TableInfo.ForeignKey)object).referenceTable)) {
            return false;
        }
        if (!this.onDelete.equals(((TableInfo.ForeignKey)object).onDelete)) {
            return false;
        }
        if (!this.onUpdate.equals(((TableInfo.ForeignKey)object).onUpdate)) {
            return false;
        }
        if (this.columnNames.equals(((TableInfo.ForeignKey)object).columnNames)) return this.referenceColumnNames.equals(((TableInfo.ForeignKey)object).referenceColumnNames);
        return false;
    }

    public int hashCode() {
        return (((this.referenceTable.hashCode() * 31 + this.onDelete.hashCode()) * 31 + this.onUpdate.hashCode()) * 31 + this.columnNames.hashCode()) * 31 + this.referenceColumnNames.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ForeignKey{referenceTable='");
        stringBuilder.append(this.referenceTable);
        stringBuilder.append('\'');
        stringBuilder.append(", onDelete='");
        stringBuilder.append(this.onDelete);
        stringBuilder.append('\'');
        stringBuilder.append(", onUpdate='");
        stringBuilder.append(this.onUpdate);
        stringBuilder.append('\'');
        stringBuilder.append(", columnNames=");
        stringBuilder.append(this.columnNames);
        stringBuilder.append(", referenceColumnNames=");
        stringBuilder.append(this.referenceColumnNames);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
