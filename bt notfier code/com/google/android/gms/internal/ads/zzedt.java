/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.os.RemoteException
 *  com.google.android.gms.ads.impl.R$string
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzedw
 *  com.google.android.gms.internal.ads.zzedx
 *  com.google.android.gms.internal.ads.zzedy
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.RemoteException;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzedw;
import com.google.android.gms.internal.ads.zzedx;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzffc;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

final class zzedt
implements DialogInterface.OnClickListener {
    private final zzdvi zza;
    private final Activity zzb;
    private final zzffc zzc;
    private final zzedq zzd;
    private final String zze;
    private final zzbu zzf;
    private final String zzg;
    private final Resources zzh;
    private final zzl zzi;

    zzedt(zzdvi zzdvi2, Activity activity, zzffc zzffc2, zzedq zzedq2, String string, zzbu zzbu2, String string2, Resources resources, zzl zzl2) {
        this.zza = zzdvi2;
        this.zzb = activity;
        this.zzc = zzffc2;
        this.zzd = zzedq2;
        this.zze = string;
        this.zzf = zzbu2;
        this.zzg = string2;
        this.zzh = resources;
        this.zzi = zzl2;
    }

    public final void onClick(DialogInterface object, int n) {
        zzl zzl2;
        Object object2;
        Activity activity;
        block4: {
            zzdvi zzdvi2 = this.zza;
            activity = this.zzb;
            zzffc zzffc2 = this.zzc;
            zzedq zzedq2 = this.zzd;
            object2 = this.zze;
            zzbu zzbu2 = this.zzf;
            String string2 = this.zzg;
            object = this.zzh;
            zzl2 = this.zzi;
            if (zzdvi2 != null) {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("dialog_action", "confirm");
                zzedy.zzh((Context)activity, (zzdvi)zzdvi2, (zzffc)zzffc2, (zzedq)zzedq2, (String)object2, (String)"dialog_click", hashMap);
            }
            try {
                boolean bl = zzbu2.zze(ObjectWrapper.wrap((Object)activity), string2, (String)object2);
                if (bl) break block4;
            }
            catch (RemoteException remoteException) {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Failed to schedule offline notification poster.", (Throwable)remoteException);
            }
            zzedq2.zzd((String)object2);
            if (zzdvi2 != null) {
                zzedy.zzd((Context)activity, (zzdvi)zzdvi2, (zzffc)zzffc2, (zzedq)zzedq2, (String)object2, (String)"offline_notification_worker_not_scheduled");
            }
        }
        zzt.zzc();
        object2 = new AlertDialog.Builder((Context)activity, zzt.zze().zzm());
        object = object == null ? "You'll get a notification with the link when you're back online" : object.getString(R.string.offline_opt_in_confirmation);
        object2.setMessage((CharSequence)object).setOnCancelListener((DialogInterface.OnCancelListener)new zzedw(zzl2));
        object = object2.create();
        object.show();
        object2 = new Timer();
        ((Timer)object2).schedule((TimerTask)new zzedx((AlertDialog)object, (Timer)object2, zzl2), 3000L);
    }
}
