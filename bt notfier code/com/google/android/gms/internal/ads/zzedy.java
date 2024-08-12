/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.core.app.NotificationCompat$Builder
 *  com.google.android.gms.ads.AdService
 *  com.google.android.gms.ads.impl.R$string
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbzd
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedk
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzeds
 *  com.google.android.gms.internal.ads.zzedt
 *  com.google.android.gms.internal.ads.zzedu
 *  com.google.android.gms.internal.ads.zzedv
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzfld
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbzd;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedk;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzeds;
import com.google.android.gms.internal.ads.zzedt;
import com.google.android.gms.internal.ads.zzedu;
import com.google.android.gms.internal.ads.zzedv;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzfld;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzedy
extends zzbzd {
    private final Context zza;
    private final zzdvi zzb;
    private final zzcgy zzc;
    private final zzedq zzd;
    private final zzffc zze;

    public zzedy(Context context, zzedq zzedq2, zzcgy zzcgy2, zzdvi zzdvi2, zzffc zzffc2) {
        this.zza = context;
        this.zzb = zzdvi2;
        this.zzc = zzcgy2;
        this.zzd = zzedq2;
        this.zze = zzffc2;
    }

    public static void zzc(Activity activity, zzl zzl2, zzbu object, zzedq zzedq2, zzdvi zzdvi2, zzffc zzffc2, String string2, String string3) {
        zzt.zzc();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, zzt.zze().zzm());
        Resources resources = zzt.zzg().zzj();
        String string4 = resources == null ? "Open ad when you're back online." : resources.getString(R.string.offline_opt_in_title);
        AlertDialog.Builder builder2 = builder.setTitle((CharSequence)string4);
        string4 = resources == null ? "We'll send you a notification with a link to the advertiser site." : resources.getString(R.string.offline_opt_in_message);
        builder2 = builder2.setMessage((CharSequence)string4);
        string4 = resources == null ? "OK" : resources.getString(R.string.offline_opt_in_confirm);
        string3 = builder2.setPositiveButton((CharSequence)string4, (DialogInterface.OnClickListener)new zzedt(zzdvi2, activity, zzffc2, zzedq2, string2, object, string3, resources, zzl2));
        object = resources == null ? "No thanks" : resources.getString(R.string.offline_opt_in_decline);
        string3.setNegativeButton((CharSequence)object, (DialogInterface.OnClickListener)new zzedu(zzedq2, string2, zzdvi2, activity, zzffc2, zzl2)).setOnCancelListener((DialogInterface.OnCancelListener)new zzedv(zzedq2, string2, zzdvi2, activity, zzffc2, zzl2));
        builder.create().show();
    }

    public static void zzd(Context context, zzdvi zzdvi2, zzffc zzffc2, zzedq zzedq2, String string2, String string3) {
        zzedy.zzh(context, zzdvi2, zzffc2, zzedq2, string2, string3, new HashMap<String, String>());
    }

    /*
     * WARNING - void declaration
     */
    public static void zzh(Context object5, zzdvi zzdvi2, zzffc object2, zzedq zzedq2, String string2, String object32, Map<String, String> map) {
        void var0_6;
        void var3_9;
        void var6_14;
        void var4_10;
        zzffb zzffb2;
        void var5_11;
        Object object = zzbjl.zzgi;
        boolean bl = (Boolean)zzbet.zzc().zzc(object);
        object = "offline";
        if (bl) {
            Iterator iterator;
            zzffb2 = zzffb.zza((String)var5_11);
            zzffb2.zzc("gqi", (String)var4_10);
            zzt.zzc();
            if (zzs.zzI((Context)object5)) {
                object = "online";
            }
            zzffb2.zzc("device_connectivity", (String)object);
            zzffb2.zzc("event_timestamp", String.valueOf(zzt.zzj().currentTimeMillis()));
            for (Map.Entry entry : var6_14.entrySet()) {
                zzffb2.zzc((String)entry.getKey(), (String)entry.getValue());
            }
            String string3 = iterator.zzb(zzffb2);
        } else {
            zzffb2 = zzffb2.zzd();
            zzffb2.zzd("gqi", (String)var4_10);
            zzffb2.zzd("action", (String)var5_11);
            zzt.zzc();
            if (zzs.zzI((Context)object5)) {
                object = "online";
            }
            zzffb2.zzd("device_connectivity", (String)object);
            zzffb2.zzd("event_timestamp", String.valueOf(zzt.zzj().currentTimeMillis()));
            for (Map.Entry entry : var6_14.entrySet()) {
                zzffb2.zzd((String)entry.getKey(), (String)entry.getValue());
            }
            String string4 = zzffb2.zzf();
        }
        var3_9.zze(new zzeds(zzt.zzj().currentTimeMillis(), (String)var4_10, (String)var0_6, 2));
    }

    private final void zzi(String string2, String string3, Map<String, String> map) {
        zzedy.zzh(this.zza, this.zzb, this.zze, this.zzd, string2, string3, map);
    }

    public final void zze(Intent object) {
        String string2;
        block9: {
            String string3 = object.getStringExtra("offline_notification_action");
            if (!string3.equals("offline_notification_clicked")) {
                if (!string3.equals("offline_notification_dismissed")) return;
            }
            string2 = object.getStringExtra("gws_query_id");
            String string4 = object.getStringExtra("uri");
            zzt.zzc();
            boolean bl = zzs.zzI((Context)this.zza);
            HashMap<String, String> hashMap = new HashMap<String, String>();
            boolean bl2 = string3.equals("offline_notification_clicked");
            int n = 2;
            if (bl2) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (bl) {
                    n = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(string4.startsWith("http")));
                try {
                    Context context = this.zza;
                    string3 = context.getPackageManager().getLaunchIntentForPackage(string4);
                    object = string3;
                    if (string3 == null) {
                        object = new Intent("android.intent.action.VIEW");
                        object.setData(Uri.parse((String)string4));
                    }
                    object.addFlags(0x10000000);
                    context.startActivity(object);
                    hashMap.put("olaa", "olas");
                }
                catch (ActivityNotFoundException activityNotFoundException) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            this.zzi(string2, "offline_notification_action", hashMap);
            try {
                object = this.zzd.getWritableDatabase();
                if (n != 1) break block9;
            }
            catch (SQLiteException sQLiteException) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Failed to get writable offline buffering database: ".concat(((Object)((Object)sQLiteException)).toString()));
                return;
            }
            this.zzd.zzb((SQLiteDatabase)object, this.zzc, string2);
            return;
        }
        zzedq.zzi((SQLiteDatabase)object, (String)string2);
    }

    public final void zzf(IObjectWrapper object, String string2, String string3) {
        Context context = (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
        zzt.zzc();
        if (PlatformVersion.isAtLeastO()) {
            object = new NotificationChannel("offline_notification_channel", (CharSequence)"AdMob Offline Notifications", 2);
            object.setShowBadge(false);
            ((NotificationManager)context.getSystemService(NotificationManager.class)).createNotificationChannel((NotificationChannel)object);
        }
        object = new Intent();
        object.setClass(context, AdService.class);
        object.setAction("offline_notification_clicked");
        object.putExtra("offline_notification_action", "offline_notification_clicked");
        object.putExtra("gws_query_id", string3);
        object.putExtra("uri", string2);
        string2 = zzfld.zza((Context)context, (int)0, (Intent)object, (int)(zzfld.zza | 0x40000000), (int)0);
        object = new Intent();
        object.setClass(context, AdService.class);
        object.setAction("offline_notification_dismissed");
        object.putExtra("offline_notification_action", "offline_notification_dismissed");
        object.putExtra("gws_query_id", string3);
        PendingIntent pendingIntent = zzfld.zza((Context)context, (int)0, (Intent)object, (int)(zzfld.zza | 0x40000000), (int)0);
        Resources resources = zzt.zzg().zzj();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        object = resources == null ? "View the ad you saved when you were offline" : resources.getString(R.string.offline_notification_title);
        builder = builder.setContentTitle((CharSequence)object);
        object = resources == null ? "Tap to open ad" : resources.getString(R.string.offline_notification_text);
        object = builder.setContentText((CharSequence)object).setAutoCancel(true).setDeleteIntent(pendingIntent).setContentIntent((PendingIntent)string2).setSmallIcon(context.getApplicationInfo().icon);
        ((NotificationManager)context.getSystemService("notification")).notify(string3, 54321, object.build());
        this.zzi(string3, "offline_notification_impression", new HashMap<String, String>());
    }

    public final void zzg() {
        this.zzd.zza((zzfdw)new zzedk(this.zzc));
    }
}
