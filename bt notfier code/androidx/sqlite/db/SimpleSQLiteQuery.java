/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteProgram
 *  androidx.sqlite.db.SupportSQLiteQuery
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;

public final class SimpleSQLiteQuery
implements SupportSQLiteQuery {
    private final Object[] mBindArgs;
    private final String mQuery;

    public SimpleSQLiteQuery(String string) {
        this(string, null);
    }

    public SimpleSQLiteQuery(String string, Object[] objectArray) {
        this.mQuery = string;
        this.mBindArgs = objectArray;
    }

    private static void bind(SupportSQLiteProgram object, int n, Object object2) {
        if (object2 == null) {
            object.bindNull(n);
        } else if (object2 instanceof byte[]) {
            object.bindBlob(n, (byte[])object2);
        } else if (object2 instanceof Float) {
            object.bindDouble(n, (double)((Float)object2).floatValue());
        } else if (object2 instanceof Double) {
            object.bindDouble(n, ((Double)object2).doubleValue());
        } else if (object2 instanceof Long) {
            object.bindLong(n, ((Long)object2).longValue());
        } else if (object2 instanceof Integer) {
            object.bindLong(n, (long)((Integer)object2).intValue());
        } else if (object2 instanceof Short) {
            object.bindLong(n, (long)((Short)object2).shortValue());
        } else if (object2 instanceof Byte) {
            object.bindLong(n, (long)((Byte)object2).byteValue());
        } else if (object2 instanceof String) {
            object.bindString(n, (String)object2);
        } else {
            if (!(object2 instanceof Boolean)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Cannot bind ");
                ((StringBuilder)object).append(object2);
                ((StringBuilder)object).append(" at index ");
                ((StringBuilder)object).append(n);
                ((StringBuilder)object).append(" Supported types: null, byte[], float, double, long, int, short, byte, string");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            long l = (Boolean)object2 != false ? 1L : 0L;
            object.bindLong(n, l);
        }
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objectArray) {
        if (objectArray == null) {
            return;
        }
        int n = objectArray.length;
        int n2 = 0;
        while (n2 < n) {
            Object object = objectArray[n2];
            SimpleSQLiteQuery.bind(supportSQLiteProgram, ++n2, object);
        }
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        SimpleSQLiteQuery.bind(supportSQLiteProgram, this.mBindArgs);
    }

    public int getArgCount() {
        Object[] objectArray = this.mBindArgs;
        int n = objectArray == null ? 0 : objectArray.length;
        return n;
    }

    public String getSql() {
        return this.mQuery;
    }
}
