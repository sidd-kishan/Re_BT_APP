/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.room.RoomDatabase$Callback
 *  androidx.room.RoomDatabase$JournalMode
 *  androidx.room.RoomDatabase$MigrationContainer
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
 */
package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;

    @Deprecated
    public DatabaseConfiguration(Context context, String string, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set) {
        this(context, string, factory, migrationContainer, list, bl, journalMode, executor, executor2, bl2, bl3, bl4, set, null, null);
    }

    public DatabaseConfiguration(Context context, String string, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set, String string2, File file) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = string;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = bl;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidation = bl2;
        this.requireMigration = bl3;
        this.allowDestructiveMigrationOnDowngrade = bl4;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = string2;
        this.copyFromFile = file;
    }

    @Deprecated
    public DatabaseConfiguration(Context context, String string, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, boolean bl2, Set<Integer> set) {
        this(context, string, factory, migrationContainer, list, bl, journalMode, executor, executor, false, bl2, false, set, null, null);
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isMigrationRequired(int n, int n2) {
        boolean bl = true;
        if ((n2 = n > n2 ? 1 : 0) != 0 && this.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        if (!this.requireMigration) return false;
        Set<Integer> set = this.mMigrationNotRequiredFrom;
        boolean bl2 = bl;
        if (set == null) return bl2;
        if (set.contains(n)) return false;
        return bl;
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int n) {
        return this.isMigrationRequired(n, n + 1);
    }
}
