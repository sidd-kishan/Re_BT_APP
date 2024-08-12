/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomOpenHelper$ValidationResult
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.room;

import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

public static abstract class RoomOpenHelper.Delegate {
    public final int version;

    public RoomOpenHelper.Delegate(int n) {
        this.version = n;
    }

    protected abstract void createAllTables(SupportSQLiteDatabase var1);

    protected abstract void dropAllTables(SupportSQLiteDatabase var1);

    protected abstract void onCreate(SupportSQLiteDatabase var1);

    protected abstract void onOpen(SupportSQLiteDatabase var1);

    protected void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    protected void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.validateMigration(supportSQLiteDatabase);
        return new RoomOpenHelper.ValidationResult(true, null);
    }

    @Deprecated
    protected void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
        throw new UnsupportedOperationException("validateMigration is deprecated");
    }
}
