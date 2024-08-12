/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.room.util;

import androidx.sqlite.db.SupportSQLiteDatabase;

public class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String string, String string2) {
        this.name = string;
        this.sql = string2;
    }

    public static ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '");
        stringBuilder.append((String)object);
        stringBuilder.append("'");
        supportSQLiteDatabase = supportSQLiteDatabase.query(stringBuilder.toString());
        try {
            if (supportSQLiteDatabase.moveToFirst()) {
                object = new ViewInfo(supportSQLiteDatabase.getString(0), supportSQLiteDatabase.getString(1));
                return object;
            }
            object = new ViewInfo((String)object, null);
            return object;
        }
        finally {
            supportSQLiteDatabase.close();
        }
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (ViewInfo)object;
        String string = this.name;
        if ((string != null ? string.equals(((ViewInfo)object).name) : ((ViewInfo)object).name == null) && ((string = this.sql) != null ? string.equals(((ViewInfo)object).sql) : ((ViewInfo)object).sql == null)) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        String string = this.name;
        int n = 0;
        int n2 = string != null ? string.hashCode() : 0;
        string = this.sql;
        if (string == null) return n2 * 31 + n;
        n = string.hashCode();
        return n2 * 31 + n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewInfo{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", sql='");
        stringBuilder.append(this.sql);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
