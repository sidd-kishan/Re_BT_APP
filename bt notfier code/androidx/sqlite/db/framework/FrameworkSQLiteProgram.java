/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 *  androidx.sqlite.db.SupportSQLiteProgram
 */
package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

class FrameworkSQLiteProgram
implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    public void bindBlob(int n, byte[] byArray) {
        this.mDelegate.bindBlob(n, byArray);
    }

    public void bindDouble(int n, double d) {
        this.mDelegate.bindDouble(n, d);
    }

    public void bindLong(int n, long l) {
        this.mDelegate.bindLong(n, l);
    }

    public void bindNull(int n) {
        this.mDelegate.bindNull(n);
    }

    public void bindString(int n, String string) {
        this.mDelegate.bindString(n, string);
    }

    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    public void close() {
        this.mDelegate.close();
    }
}
