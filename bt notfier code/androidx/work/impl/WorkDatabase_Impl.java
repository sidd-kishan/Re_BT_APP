/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  androidx.room.DatabaseConfiguration
 *  androidx.room.InvalidationTracker
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomOpenHelper
 *  androidx.room.RoomOpenHelper$Delegate
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteOpenHelper
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Callback
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.model.DependencyDao
 *  androidx.work.impl.model.DependencyDao_Impl
 *  androidx.work.impl.model.PreferenceDao
 *  androidx.work.impl.model.PreferenceDao_Impl
 *  androidx.work.impl.model.RawWorkInfoDao
 *  androidx.work.impl.model.RawWorkInfoDao_Impl
 *  androidx.work.impl.model.SystemIdInfoDao
 *  androidx.work.impl.model.SystemIdInfoDao_Impl
 *  androidx.work.impl.model.WorkNameDao
 *  androidx.work.impl.model.WorkNameDao_Impl
 *  androidx.work.impl.model.WorkProgressDao
 *  androidx.work.impl.model.WorkProgressDao_Impl
 *  androidx.work.impl.model.WorkSpecDao
 *  androidx.work.impl.model.WorkSpecDao_Impl
 *  androidx.work.impl.model.WorkTagDao
 *  androidx.work.impl.model.WorkTagDao_Impl
 */
package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.HashMap;
import java.util.List;

public final class WorkDatabase_Impl
extends WorkDatabase {
    private volatile DependencyDao _dependencyDao;
    private volatile PreferenceDao _preferenceDao;
    private volatile RawWorkInfoDao _rawWorkInfoDao;
    private volatile SystemIdInfoDao _systemIdInfoDao;
    private volatile WorkNameDao _workNameDao;
    private volatile WorkProgressDao _workProgressDao;
    private volatile WorkSpecDao _workSpecDao;
    private volatile WorkTagDao _workTagDao;

    static /* synthetic */ List access$000(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$100(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$1000(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$200(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$300(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$400(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$500(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(WorkDatabase_Impl workDatabase_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        workDatabase_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    static /* synthetic */ void access$700(WorkDatabase_Impl workDatabase_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        workDatabase_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
    }

    static /* synthetic */ List access$800(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$900(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }

    /*
     * Unable to fully structure code
     */
    public void clearAllTables() {
        super.assertNotMainThread();
        var2_1 = super.getOpenHelper().getWritableDatabase();
        var1_2 = Build.VERSION.SDK_INT >= 21;
        if (var1_2) ** GOTO lbl7
        try {
            var2_1.execSQL("PRAGMA foreign_keys = FALSE");
lbl7:
            // 2 sources

            super.beginTransaction();
            if (var1_2) {
                var2_1.execSQL("PRAGMA defer_foreign_keys = TRUE");
            }
            var2_1.execSQL("DELETE FROM `Dependency`");
            var2_1.execSQL("DELETE FROM `WorkSpec`");
            var2_1.execSQL("DELETE FROM `WorkTag`");
            var2_1.execSQL("DELETE FROM `SystemIdInfo`");
            var2_1.execSQL("DELETE FROM `WorkName`");
            var2_1.execSQL("DELETE FROM `WorkProgress`");
            var2_1.execSQL("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
            return;
        }
        finally {
            super.endTransaction();
            if (!var1_2) {
                var2_1.execSQL("PRAGMA foreign_keys = TRUE");
            }
            var2_1.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!var2_1.inTransaction()) {
                var2_1.execSQL("VACUUM");
            }
        }
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker((RoomDatabase)this, new HashMap(0), new HashMap(0), new String[]{"Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference"});
    }

    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, (RoomOpenHelper.Delegate)new /* Unavailable Anonymous Inner Class!! */, "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6");
        roomOpenHelper = SupportSQLiteOpenHelper.Configuration.builder((Context)databaseConfiguration.context).name(databaseConfiguration.name).callback((SupportSQLiteOpenHelper.Callback)roomOpenHelper).build();
        return databaseConfiguration.sqliteOpenHelperFactory.create((SupportSQLiteOpenHelper.Configuration)roomOpenHelper);
    }

    public DependencyDao dependencyDao() {
        if (this._dependencyDao != null) {
            return this._dependencyDao;
        }
        synchronized (this) {
            DependencyDao_Impl dependencyDao_Impl;
            if (this._dependencyDao == null) {
                dependencyDao_Impl = new DependencyDao_Impl((RoomDatabase)this);
                this._dependencyDao = dependencyDao_Impl;
            }
            dependencyDao_Impl = this._dependencyDao;
            return dependencyDao_Impl;
        }
    }

    public PreferenceDao preferenceDao() {
        if (this._preferenceDao != null) {
            return this._preferenceDao;
        }
        synchronized (this) {
            PreferenceDao_Impl preferenceDao_Impl;
            if (this._preferenceDao == null) {
                preferenceDao_Impl = new PreferenceDao_Impl((RoomDatabase)this);
                this._preferenceDao = preferenceDao_Impl;
            }
            preferenceDao_Impl = this._preferenceDao;
            return preferenceDao_Impl;
        }
    }

    public RawWorkInfoDao rawWorkInfoDao() {
        if (this._rawWorkInfoDao != null) {
            return this._rawWorkInfoDao;
        }
        synchronized (this) {
            RawWorkInfoDao_Impl rawWorkInfoDao_Impl;
            if (this._rawWorkInfoDao == null) {
                rawWorkInfoDao_Impl = new RawWorkInfoDao_Impl((RoomDatabase)this);
                this._rawWorkInfoDao = rawWorkInfoDao_Impl;
            }
            rawWorkInfoDao_Impl = this._rawWorkInfoDao;
            return rawWorkInfoDao_Impl;
        }
    }

    public SystemIdInfoDao systemIdInfoDao() {
        if (this._systemIdInfoDao != null) {
            return this._systemIdInfoDao;
        }
        synchronized (this) {
            SystemIdInfoDao_Impl systemIdInfoDao_Impl;
            if (this._systemIdInfoDao == null) {
                systemIdInfoDao_Impl = new SystemIdInfoDao_Impl((RoomDatabase)this);
                this._systemIdInfoDao = systemIdInfoDao_Impl;
            }
            systemIdInfoDao_Impl = this._systemIdInfoDao;
            return systemIdInfoDao_Impl;
        }
    }

    public WorkNameDao workNameDao() {
        if (this._workNameDao != null) {
            return this._workNameDao;
        }
        synchronized (this) {
            WorkNameDao_Impl workNameDao_Impl;
            if (this._workNameDao == null) {
                workNameDao_Impl = new WorkNameDao_Impl((RoomDatabase)this);
                this._workNameDao = workNameDao_Impl;
            }
            workNameDao_Impl = this._workNameDao;
            return workNameDao_Impl;
        }
    }

    public WorkProgressDao workProgressDao() {
        if (this._workProgressDao != null) {
            return this._workProgressDao;
        }
        synchronized (this) {
            WorkProgressDao_Impl workProgressDao_Impl;
            if (this._workProgressDao == null) {
                workProgressDao_Impl = new WorkProgressDao_Impl((RoomDatabase)this);
                this._workProgressDao = workProgressDao_Impl;
            }
            workProgressDao_Impl = this._workProgressDao;
            return workProgressDao_Impl;
        }
    }

    public WorkSpecDao workSpecDao() {
        if (this._workSpecDao != null) {
            return this._workSpecDao;
        }
        synchronized (this) {
            WorkSpecDao_Impl workSpecDao_Impl;
            if (this._workSpecDao == null) {
                workSpecDao_Impl = new WorkSpecDao_Impl((RoomDatabase)this);
                this._workSpecDao = workSpecDao_Impl;
            }
            workSpecDao_Impl = this._workSpecDao;
            return workSpecDao_Impl;
        }
    }

    public WorkTagDao workTagDao() {
        if (this._workTagDao != null) {
            return this._workTagDao;
        }
        synchronized (this) {
            WorkTagDao_Impl workTagDao_Impl;
            if (this._workTagDao == null) {
                workTagDao_Impl = new WorkTagDao_Impl((RoomDatabase)this);
                this._workTagDao = workTagDao_Impl;
            }
            workTagDao_Impl = this._workTagDao;
            return workTagDao_Impl;
        }
    }
}
