/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.AlarmManager$AlarmClockInfo
 *  android.app.PendingIntent
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;

public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(AlarmManager alarmManager, long l, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (Build.VERSION.SDK_INT >= 21) {
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(l, pendingIntent), pendingIntent2);
        } else {
            AlarmManagerCompat.setExact(alarmManager, 0, l, pendingIntent2);
        }
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setAndAllowWhileIdle(n, l, pendingIntent);
        } else {
            alarmManager.set(n, l, pendingIntent);
        }
    }

    public static void setExact(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(n, l, pendingIntent);
        } else {
            alarmManager.set(n, l, pendingIntent);
        }
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(n, l, pendingIntent);
        } else {
            AlarmManagerCompat.setExact(alarmManager, n, l, pendingIntent);
        }
    }
}
