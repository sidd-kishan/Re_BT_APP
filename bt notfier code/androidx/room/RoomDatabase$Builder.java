/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.arch.core.executor.ArchTaskExecutor
 *  androidx.room.DatabaseConfiguration
 *  androidx.room.Room
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomDatabase$Callback
 *  androidx.room.RoomDatabase$JournalMode
 *  androidx.room.RoomDatabase$MigrationContainer
 *  androidx.room.SQLiteCopyOpenHelperFactory
 *  androidx.room.migration.Migration
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
 *  androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
 */
package androidx.room;

import android.content.Context;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.DatabaseConfiguration;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.SQLiteCopyOpenHelperFactory;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public static class RoomDatabase.Builder<T extends RoomDatabase> {
    private boolean mAllowDestructiveMigrationOnDowngrade;
    private boolean mAllowMainThreadQueries;
    private ArrayList<RoomDatabase.Callback> mCallbacks;
    private final Context mContext;
    private String mCopyFromAssetPath;
    private File mCopyFromFile;
    private final Class<T> mDatabaseClass;
    private SupportSQLiteOpenHelper.Factory mFactory;
    private RoomDatabase.JournalMode mJournalMode;
    private final RoomDatabase.MigrationContainer mMigrationContainer;
    private Set<Integer> mMigrationStartAndEndVersions;
    private Set<Integer> mMigrationsNotRequiredFrom;
    private boolean mMultiInstanceInvalidation;
    private final String mName;
    private Executor mQueryExecutor;
    private boolean mRequireMigration;
    private Executor mTransactionExecutor;

    RoomDatabase.Builder(Context context, Class<T> clazz, String string) {
        this.mContext = context;
        this.mDatabaseClass = clazz;
        this.mName = string;
        this.mJournalMode = RoomDatabase.JournalMode.AUTOMATIC;
        this.mRequireMigration = true;
        this.mMigrationContainer = new RoomDatabase.MigrationContainer();
    }

    public RoomDatabase.Builder<T> addCallback(RoomDatabase.Callback callback) {
        if (this.mCallbacks == null) {
            this.mCallbacks = new ArrayList();
        }
        this.mCallbacks.add(callback);
        return this;
    }

    public RoomDatabase.Builder<T> addMigrations(Migration ... migrationArray) {
        if (this.mMigrationStartAndEndVersions == null) {
            this.mMigrationStartAndEndVersions = new HashSet<Integer>();
        }
        int n = migrationArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mMigrationContainer.addMigrations(migrationArray);
                return this;
            }
            Migration migration = migrationArray[n2];
            this.mMigrationStartAndEndVersions.add(migration.startVersion);
            this.mMigrationStartAndEndVersions.add(migration.endVersion);
            ++n2;
        }
    }

    public RoomDatabase.Builder<T> allowMainThreadQueries() {
        this.mAllowMainThreadQueries = true;
        return this;
    }

    public T build() {
        Object object;
        Object object2;
        if (this.mContext == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot provide null context for the database.");
            throw illegalArgumentException;
        }
        if (this.mDatabaseClass == null) throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        if (this.mQueryExecutor == null && this.mTransactionExecutor == null) {
            object2 = ArchTaskExecutor.getIOThreadExecutor();
            this.mTransactionExecutor = object2;
            this.mQueryExecutor = object2;
        } else {
            object2 = this.mQueryExecutor;
            if (object2 != null && this.mTransactionExecutor == null) {
                this.mTransactionExecutor = object2;
            } else if (this.mQueryExecutor == null && (object2 = this.mTransactionExecutor) != null) {
                this.mQueryExecutor = object2;
            }
        }
        object2 = this.mMigrationStartAndEndVersions;
        if (object2 != null && this.mMigrationsNotRequiredFrom != null) {
            object = object2.iterator();
            while (object.hasNext()) {
                object2 = (Integer)object.next();
                if (!this.mMigrationsNotRequiredFrom.contains(object2)) continue;
                object = new StringBuilder();
                ((StringBuilder)object).append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                ((StringBuilder)object).append(object2);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
        }
        if (this.mFactory == null) {
            this.mFactory = new FrameworkSQLiteOpenHelperFactory();
        }
        if (this.mCopyFromAssetPath != null || this.mCopyFromFile != null) {
            if (this.mName == null) throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
            if (this.mCopyFromAssetPath != null) {
                if (this.mCopyFromFile != null) throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
            }
            this.mFactory = new SQLiteCopyOpenHelperFactory(this.mCopyFromAssetPath, this.mCopyFromFile, this.mFactory);
        }
        object2 = this.mContext;
        object2 = new DatabaseConfiguration((Context)object2, this.mName, this.mFactory, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve((Context)object2), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidation, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile);
        object = (RoomDatabase)Room.getGeneratedImplementation(this.mDatabaseClass, (String)"_Impl");
        object.init((DatabaseConfiguration)object2);
        return (T)object;
    }

    public RoomDatabase.Builder<T> createFromAsset(String string) {
        this.mCopyFromAssetPath = string;
        return this;
    }

    public RoomDatabase.Builder<T> createFromFile(File file) {
        this.mCopyFromFile = file;
        return this;
    }

    public RoomDatabase.Builder<T> enableMultiInstanceInvalidation() {
        boolean bl = this.mName != null;
        this.mMultiInstanceInvalidation = bl;
        return this;
    }

    public RoomDatabase.Builder<T> fallbackToDestructiveMigration() {
        this.mRequireMigration = false;
        this.mAllowDestructiveMigrationOnDowngrade = true;
        return this;
    }

    public RoomDatabase.Builder<T> fallbackToDestructiveMigrationFrom(int ... nArray) {
        if (this.mMigrationsNotRequiredFrom == null) {
            this.mMigrationsNotRequiredFrom = new HashSet<Integer>(nArray.length);
        }
        int n = nArray.length;
        int n2 = 0;
        while (n2 < n) {
            int n3 = nArray[n2];
            this.mMigrationsNotRequiredFrom.add(n3);
            ++n2;
        }
        return this;
    }

    public RoomDatabase.Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
        this.mRequireMigration = true;
        this.mAllowDestructiveMigrationOnDowngrade = true;
        return this;
    }

    public RoomDatabase.Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory) {
        this.mFactory = factory;
        return this;
    }

    public RoomDatabase.Builder<T> setJournalMode(RoomDatabase.JournalMode journalMode) {
        this.mJournalMode = journalMode;
        return this;
    }

    public RoomDatabase.Builder<T> setQueryExecutor(Executor executor) {
        this.mQueryExecutor = executor;
        return this;
    }

    public RoomDatabase.Builder<T> setTransactionExecutor(Executor executor) {
        this.mTransactionExecutor = executor;
        return this;
    }
}
