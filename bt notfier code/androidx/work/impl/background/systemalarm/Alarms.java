/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  androidx.work.Logger
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemalarm.CommandHandler
 *  androidx.work.impl.model.SystemIdInfo
 *  androidx.work.impl.utils.IdGenerator
 */
package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.utils.IdGenerator;

class Alarms {
    private static final String TAG = Logger.tagWithPrefix((String)"Alarms");

    private Alarms() {
    }

    public static void cancelAlarm(Context context, WorkManagerImpl workManagerImpl, String string) {
        SystemIdInfo systemIdInfo = (workManagerImpl = workManagerImpl.getWorkDatabase().systemIdInfoDao()).getSystemIdInfo(string);
        if (systemIdInfo == null) return;
        Alarms.cancelExactAlarm(context, string, systemIdInfo.systemId);
        Logger.get().debug(TAG, String.format("Removing SystemIdInfo for workSpecId (%s)", string), new Throwable[0]);
        workManagerImpl.removeSystemIdInfo(string);
    }

    private static void cancelExactAlarm(Context context, String string, int n) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        Intent intent = CommandHandler.createDelayMetIntent((Context)context, (String)string);
        int n2 = Build.VERSION.SDK_INT >= 23 ? 0x24000000 : 0x20000000;
        context = PendingIntent.getService((Context)context, (int)n, (Intent)intent, (int)n2);
        if (context == null) return;
        if (alarmManager == null) return;
        Logger.get().debug(TAG, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", string, n), new Throwable[0]);
        alarmManager.cancel((PendingIntent)context);
    }

    public static void setAlarm(Context context, WorkManagerImpl workManagerImpl, String string, long l) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        SystemIdInfo systemIdInfo = (workManagerImpl = workDatabase.systemIdInfoDao()).getSystemIdInfo(string);
        if (systemIdInfo != null) {
            Alarms.cancelExactAlarm(context, string, systemIdInfo.systemId);
            Alarms.setExactAlarm(context, string, systemIdInfo.systemId, l);
        } else {
            int n = new IdGenerator(workDatabase).nextAlarmManagerId();
            workManagerImpl.insertSystemIdInfo(new SystemIdInfo(string, n));
            Alarms.setExactAlarm(context, string, n, l);
        }
    }

    private static void setExactAlarm(Context context, String string, int n, long l) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        int n2 = Build.VERSION.SDK_INT >= 23 ? 0xC000000 : 0x8000000;
        context = PendingIntent.getService((Context)context, (int)n, (Intent)CommandHandler.createDelayMetIntent((Context)context, (String)string), (int)n2);
        if (alarmManager == null) return;
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, l, (PendingIntent)context);
        } else {
            alarmManager.set(0, l, (PendingIntent)context);
        }
    }
}
