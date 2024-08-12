/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.room.Room
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomDatabase$Builder
 *  androidx.room.RoomDatabase$Callback
 *  androidx.room.migration.Migration
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
 *  androidx.work.impl.WorkDatabaseMigrations
 *  androidx.work.impl.WorkDatabaseMigrations$RescheduleMigration
 *  androidx.work.impl.WorkDatabaseMigrations$WorkMigration9To10
 *  androidx.work.impl.WorkDatabasePathHelper
 *  androidx.work.impl.model.DependencyDao
 *  androidx.work.impl.model.PreferenceDao
 *  androidx.work.impl.model.RawWorkInfoDao
 *  androidx.work.impl.model.SystemIdInfoDao
 *  androidx.work.impl.model.WorkNameDao
 *  androidx.work.impl.model.WorkProgressDao
 *  androidx.work.impl.model.WorkSpecDao
 *  androidx.work.impl.model.WorkTagDao
 */
package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase
extends RoomDatabase {
    private static final String PRUNE_SQL_FORMAT_PREFIX = "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ";
    private static final String PRUNE_SQL_FORMAT_SUFFIX = " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    private static final long PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(1L);

    public static WorkDatabase create(Context context, Executor executor, boolean bl) {
        RoomDatabase.Builder builder;
        if (bl) {
            builder = Room.inMemoryDatabaseBuilder((Context)context, WorkDatabase.class).allowMainThreadQueries();
        } else {
            builder = Room.databaseBuilder((Context)context, WorkDatabase.class, (String)WorkDatabasePathHelper.getWorkDatabaseName());
            builder.openHelperFactory((SupportSQLiteOpenHelper.Factory)new /* Unavailable Anonymous Inner Class!! */);
        }
        return (WorkDatabase)builder.setQueryExecutor(executor).addCallback(WorkDatabase.generateCleanupCallback()).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_1_2}).addMigrations(new Migration[]{new WorkDatabaseMigrations.RescheduleMigration(context, 2, 3)}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_3_4}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_4_5}).addMigrations(new Migration[]{new WorkDatabaseMigrations.RescheduleMigration(context, 5, 6)}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_6_7}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_7_8}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_8_9}).addMigrations(new Migration[]{new WorkDatabaseMigrations.WorkMigration9To10(context)}).addMigrations(new Migration[]{new WorkDatabaseMigrations.RescheduleMigration(context, 10, 11)}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_11_12}).fallbackToDestructiveMigration().build();
    }

    static RoomDatabase.Callback generateCleanupCallback() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    static long getPruneDate() {
        return System.currentTimeMillis() - PRUNE_THRESHOLD_MILLIS;
    }

    static String getPruneSQL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PRUNE_SQL_FORMAT_PREFIX);
        stringBuilder.append(WorkDatabase.getPruneDate());
        stringBuilder.append(PRUNE_SQL_FORMAT_SUFFIX);
        return stringBuilder.toString();
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract RawWorkInfoDao rawWorkInfoDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();
}
