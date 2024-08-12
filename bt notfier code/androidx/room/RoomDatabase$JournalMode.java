/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

public static final class RoomDatabase.JournalMode
extends Enum<RoomDatabase.JournalMode> {
    private static final RoomDatabase.JournalMode[] $VALUES;
    public static final /* enum */ RoomDatabase.JournalMode AUTOMATIC;
    public static final /* enum */ RoomDatabase.JournalMode TRUNCATE;
    public static final /* enum */ RoomDatabase.JournalMode WRITE_AHEAD_LOGGING;

    static {
        RoomDatabase.JournalMode journalMode;
        AUTOMATIC = new RoomDatabase.JournalMode();
        TRUNCATE = new RoomDatabase.JournalMode();
        WRITE_AHEAD_LOGGING = journalMode = new RoomDatabase.JournalMode();
        $VALUES = new RoomDatabase.JournalMode[]{AUTOMATIC, TRUNCATE, journalMode};
    }

    private static boolean isLowRamDevice(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT < 19) return false;
        return activityManager.isLowRamDevice();
    }

    public static RoomDatabase.JournalMode valueOf(String string) {
        return Enum.valueOf(RoomDatabase.JournalMode.class, string);
    }

    public static RoomDatabase.JournalMode[] values() {
        return (RoomDatabase.JournalMode[])$VALUES.clone();
    }

    RoomDatabase.JournalMode resolve(Context context) {
        if (this != AUTOMATIC) {
            return this;
        }
        if (Build.VERSION.SDK_INT < 16) return TRUNCATE;
        if ((context = (ActivityManager)context.getSystemService("activity")) == null) return TRUNCATE;
        if (RoomDatabase.JournalMode.isLowRamDevice((ActivityManager)context)) return TRUNCATE;
        return WRITE_AHEAD_LOGGING;
    }
}
