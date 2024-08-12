/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.model.Preference
 */
package androidx.work.impl.utils;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

public class IdGenerator {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";
    private final WorkDatabase mWorkDatabase;

    public IdGenerator(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public static void migrateLegacyIdGenerator(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!(context = context.getSharedPreferences(PREFERENCE_FILE_KEY, 0)).contains(NEXT_JOB_SCHEDULER_ID_KEY)) {
            if (!context.contains(NEXT_JOB_SCHEDULER_ID_KEY)) return;
        }
        int n = context.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
        int n2 = context.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
        supportSQLiteDatabase.beginTransaction();
        try {
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, n});
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{NEXT_ALARM_MANAGER_ID_KEY, n2});
            context.edit().clear().apply();
            supportSQLiteDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            supportSQLiteDatabase.endTransaction();
        }
    }

    private int nextId(String string) {
        this.mWorkDatabase.beginTransaction();
        try {
            Long l = this.mWorkDatabase.preferenceDao().getLongValue(string);
            int n = 0;
            int n2 = l != null ? l.intValue() : 0;
            if (n2 != Integer.MAX_VALUE) {
                n = n2 + 1;
            }
            this.update(string, n);
            this.mWorkDatabase.setTransactionSuccessful();
            return n2;
        }
        finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    private void update(String string, int n) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(string, (long)n));
    }

    public int nextAlarmManagerId() {
        synchronized (IdGenerator.class) {
            int n = this.nextId(NEXT_ALARM_MANAGER_ID_KEY);
            return n;
        }
    }

    public int nextJobSchedulerIdWithRange(int n, int n2) {
        synchronized (IdGenerator.class) {
            int n3 = this.nextId(NEXT_JOB_SCHEDULER_ID_KEY);
            if (n3 >= n && n3 <= n2) {
                n = n3;
            } else {
                this.update(NEXT_JOB_SCHEDULER_ID_KEY, n + 1);
            }
            return n;
        }
    }
}
