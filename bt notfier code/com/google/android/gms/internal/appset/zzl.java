/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.util.Log
 *  com.google.android.gms.appset.AppSetIdClient
 *  com.google.android.gms.appset.AppSetIdInfo
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.DefaultClock
 *  com.google.android.gms.internal.appset.zzh
 *  com.google.android.gms.internal.appset.zzj
 *  com.google.android.gms.internal.appset.zzk
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.internal.appset;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.appset.zzh;
import com.google.android.gms.internal.appset.zzj;
import com.google.android.gms.internal.appset.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzl
implements AppSetIdClient {
    private static AppSetIdClient zza;
    private final Context zzb;
    private boolean zzc = false;
    private final ScheduledExecutorService zzd = Executors.newSingleThreadScheduledExecutor();
    private final ExecutorService zze = Executors.newSingleThreadExecutor();

    zzl(Context context) {
        this.zzb = context;
        if (this.zzc) return;
        this.zzd.scheduleAtFixedRate((Runnable)new zzj(this, null), 0L, 86400L, TimeUnit.SECONDS);
        this.zzc = true;
    }

    static /* bridge */ /* synthetic */ Context zzb(zzl zzl2) {
        return zzl2.zzb;
    }

    static AppSetIdClient zzc(Context context) {
        synchronized (zzl.class) {
            Preconditions.checkNotNull((Object)context, (Object)"Context must not be null");
            if (zza == null) {
                zzl zzl2 = new zzl(context.getApplicationContext());
                zza = zzl2;
            }
            context = zza;
            return context;
        }
    }

    protected static final void zze(Context object) {
        if (!zzl.zzf((Context)object).edit().remove("app_set_id").commit()) {
            String string = String.valueOf(object.getPackageName());
            string = string.length() != 0 ? "Failed to clear app set ID generated for App ".concat(string) : new String("Failed to clear app set ID generated for App ");
            Log.e((String)"AppSet", (String)string);
        }
        if (zzl.zzf((Context)object).edit().remove("app_set_id_last_used_time").commit()) return;
        object = ((String)(object = String.valueOf(object.getPackageName()))).length() != 0 ? "Failed to clear app set ID last used time for App ".concat((String)object) : new String("Failed to clear app set ID last used time for App ");
        Log.e((String)"AppSet", (String)object);
    }

    private static final SharedPreferences zzf(Context context) {
        return context.getSharedPreferences("app_set_id_storage", 0);
    }

    private static final void zzg(Context object) throws zzk {
        SharedPreferences sharedPreferences = zzl.zzf((Context)object);
        long l = DefaultClock.getInstance().currentTimeMillis();
        if (sharedPreferences.edit().putLong("app_set_id_last_used_time", l).commit()) return;
        object = ((String)(object = String.valueOf(object.getPackageName()))).length() != 0 ? "Failed to store app set ID last used time for App ".concat((String)object) : new String("Failed to store app set ID last used time for App ");
        Log.e((String)"AppSet", (String)object);
        throw new zzk("Failed to store the app set ID last used time.");
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zze.execute((Runnable)new zzh(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    protected final long zza() {
        long l = zzl.zzf(this.zzb).getLong("app_set_id_last_used_time", -1L);
        if (l == -1L) return -1L;
        return l + 33696000000L;
    }

    final /* synthetic */ void zzd(TaskCompletionSource taskCompletionSource) {
        Object object = zzl.zzf(this.zzb).getString("app_set_id", null);
        long l = this.zza();
        if (object != null && DefaultClock.getInstance().currentTimeMillis() <= l) {
            try {
                zzl.zzg(this.zzb);
            }
            catch (zzk zzk2) {
                taskCompletionSource.setException((Exception)((Object)zzk2));
                return;
            }
        }
        object = UUID.randomUUID().toString();
        try {
            Context context = this.zzb;
            boolean bl = zzl.zzf(context).edit().putString("app_set_id", object).commit();
            if (!bl) {
                object = String.valueOf(context.getPackageName());
                object = object.length() != 0 ? "Failed to store app set ID generated for App ".concat((String)object) : new String("Failed to store app set ID generated for App ");
                Log.e((String)"AppSet", (String)object);
                object = new zzk("Failed to store the app set ID.");
                throw object;
            }
            zzl.zzg(context);
            context = this.zzb;
            SharedPreferences sharedPreferences = zzl.zzf(context);
            l = DefaultClock.getInstance().currentTimeMillis();
            if (!sharedPreferences.edit().putLong("app_set_id_creation_time", l).commit()) {
                object = String.valueOf(context.getPackageName());
                object = object.length() != 0 ? "Failed to store app set ID creation time for App ".concat((String)object) : new String("Failed to store app set ID creation time for App ");
                Log.e((String)"AppSet", (String)object);
                object = new zzk("Failed to store the app set ID creation time.");
                throw object;
            }
        }
        catch (zzk zzk3) {
            taskCompletionSource.setException((Exception)((Object)zzk3));
            return;
        }
        taskCompletionSource.setResult((Object)new AppSetIdInfo(object, 1));
    }
}
