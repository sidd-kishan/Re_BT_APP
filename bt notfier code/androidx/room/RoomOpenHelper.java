/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.DatabaseConfiguration
 *  androidx.room.RoomMasterTable
 *  androidx.room.RoomOpenHelper$Delegate
 *  androidx.room.RoomOpenHelper$ValidationResult
 *  androidx.room.migration.Migration
 *  androidx.sqlite.db.SimpleSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Callback
 *  androidx.sqlite.db.SupportSQLiteQuery
 */
package androidx.room;

import android.database.Cursor;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;

public class RoomOpenHelper
extends SupportSQLiteOpenHelper.Callback {
    private DatabaseConfiguration mConfiguration;
    private final Delegate mDelegate;
    private final String mIdentityHash;
    private final String mLegacyHash;

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String string) {
        this(databaseConfiguration, delegate, "", string);
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String string, String string2) {
        super(delegate.version);
        this.mConfiguration = databaseConfiguration;
        this.mDelegate = delegate;
        this.mIdentityHash = string;
        this.mLegacyHash = string2;
    }

    private void checkIdentity(SupportSQLiteDatabase object) {
        if (RoomOpenHelper.hasRoomMasterTable((SupportSQLiteDatabase)object)) {
            Object var2_3 = null;
            Cursor cursor = object.query((SupportSQLiteQuery)new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            object = var2_3;
            try {
                if (cursor.moveToFirst()) {
                    object = cursor.getString(0);
                }
                if (this.mIdentityHash.equals(object)) return;
                if (!this.mLegacyHash.equals(object)) throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
            finally {
                cursor.close();
            }
        } else {
            ValidationResult validationResult = this.mDelegate.onValidateSchema((SupportSQLiteDatabase)object);
            if (!validationResult.isValid) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Pre-packaged database has an invalid schema: ");
                ((StringBuilder)object).append(validationResult.expectedFoundMsg);
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            this.mDelegate.onPostMigrate((SupportSQLiteDatabase)object);
            this.updateIdentity((SupportSQLiteDatabase)object);
        }
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean hasEmptySchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean bl;
        Cursor cursor = supportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean bl2;
            boolean bl3 = cursor.moveToFirst();
            bl = bl2 = false;
            if (!bl3) return bl;
            int n = cursor.getInt(0);
            bl = bl2;
            if (n != 0) return bl;
            bl = true;
        }
        finally {
            cursor.close();
        }
        return bl;
    }

    private static boolean hasRoomMasterTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean bl;
        Cursor cursor = supportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean bl2;
            boolean bl3 = cursor.moveToFirst();
            bl = bl2 = false;
            if (!bl3) return bl;
            int n = cursor.getInt(0);
            bl = bl2;
            if (n == 0) return bl;
            bl = true;
        }
        finally {
            cursor.close();
        }
        return bl;
    }

    private void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery((String)this.mIdentityHash));
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onConfigure(supportSQLiteDatabase);
    }

    public void onCreate(SupportSQLiteDatabase object) {
        boolean bl = RoomOpenHelper.hasEmptySchema((SupportSQLiteDatabase)object);
        this.mDelegate.createAllTables((SupportSQLiteDatabase)object);
        if (!bl) {
            ValidationResult validationResult = this.mDelegate.onValidateSchema((SupportSQLiteDatabase)object);
            if (!validationResult.isValid) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Pre-packaged database has an invalid schema: ");
                ((StringBuilder)object).append(validationResult.expectedFoundMsg);
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
        }
        this.updateIdentity((SupportSQLiteDatabase)object);
        this.mDelegate.onCreate((SupportSQLiteDatabase)object);
    }

    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int n, int n2) {
        this.onUpgrade(supportSQLiteDatabase, n, n2);
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        this.checkIdentity(supportSQLiteDatabase);
        this.mDelegate.onOpen(supportSQLiteDatabase);
        this.mConfiguration = null;
    }

    public void onUpgrade(SupportSQLiteDatabase object, int n, int n2) {
        boolean bl;
        Object object2 = this.mConfiguration;
        if (object2 != null && (object2 = ((DatabaseConfiguration)object2).migrationContainer.findMigrationPath(n, n2)) != null) {
            this.mDelegate.onPreMigrate((SupportSQLiteDatabase)object);
            object2 = object2.iterator();
            while (object2.hasNext()) {
                ((Migration)object2.next()).migrate((SupportSQLiteDatabase)object);
            }
            object2 = this.mDelegate.onValidateSchema((SupportSQLiteDatabase)object);
            if (!((ValidationResult)object2).isValid) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Migration didn't properly handle: ");
                ((StringBuilder)object).append(((ValidationResult)object2).expectedFoundMsg);
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            this.mDelegate.onPostMigrate((SupportSQLiteDatabase)object);
            this.updateIdentity((SupportSQLiteDatabase)object);
            bl = true;
        } else {
            bl = false;
        }
        if (bl) return;
        object2 = this.mConfiguration;
        if (object2 != null && !object2.isMigrationRequired(n, n2)) {
            this.mDelegate.dropAllTables((SupportSQLiteDatabase)object);
            this.mDelegate.createAllTables((SupportSQLiteDatabase)object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("A migration from ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" to ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }
}
