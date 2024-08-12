/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.arch.core.util.Function
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.Transformations
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.model.Preference
 */
package androidx.work.impl.utils;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

public class PreferenceUtils {
    public static final String KEY_LAST_CANCEL_ALL_TIME_MS = "last_cancel_all_time_ms";
    public static final String KEY_RESCHEDULE_NEEDED = "reschedule_needed";
    public static final String PREFERENCES_FILE_NAME = "androidx.work.util.preferences";
    private final WorkDatabase mWorkDatabase;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public static void migrateLegacyPreferences(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!(context = context.getSharedPreferences(PREFERENCES_FILE_NAME, 0)).contains(KEY_RESCHEDULE_NEEDED)) {
            if (!context.contains(KEY_LAST_CANCEL_ALL_TIME_MS)) return;
        }
        long l = 0L;
        long l2 = context.getLong(KEY_LAST_CANCEL_ALL_TIME_MS, 0L);
        if (context.getBoolean(KEY_RESCHEDULE_NEEDED, false)) {
            l = 1L;
        }
        supportSQLiteDatabase.beginTransaction();
        try {
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{KEY_LAST_CANCEL_ALL_TIME_MS, l2});
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{KEY_RESCHEDULE_NEEDED, l});
            context.edit().clear().apply();
            supportSQLiteDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            supportSQLiteDatabase.endTransaction();
        }
    }

    public long getLastCancelAllTimeMillis() {
        Long l = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_CANCEL_ALL_TIME_MS);
        long l2 = l != null ? l : 0L;
        return l2;
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return Transformations.map((LiveData)this.mWorkDatabase.preferenceDao().getObservableLongValue(KEY_LAST_CANCEL_ALL_TIME_MS), (Function)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean getNeedsReschedule() {
        Long l = this.mWorkDatabase.preferenceDao().getLongValue(KEY_RESCHEDULE_NEEDED);
        boolean bl = l != null && l == 1L;
        return bl;
    }

    public void setLastCancelAllTimeMillis(long l) {
        Preference preference = new Preference(KEY_LAST_CANCEL_ALL_TIME_MS, l);
        this.mWorkDatabase.preferenceDao().insertPreference(preference);
    }

    public void setNeedsReschedule(boolean bl) {
        Preference preference = new Preference(KEY_RESCHEDULE_NEEDED, bl);
        this.mWorkDatabase.preferenceDao().insertPreference(preference);
    }
}
