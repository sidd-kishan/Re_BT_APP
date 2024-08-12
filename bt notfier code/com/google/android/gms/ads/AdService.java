/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbep
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcgt;

public class AdService
extends IntentService {
    public AdService() {
        super("AdService");
    }

    protected final void onHandleIntent(Intent intent) {
        try {
            zzbep zzbep2 = zzber.zzb();
            zzbvd zzbvd2 = new zzbvd();
            zzbep2.zzr((Context)this, (zzbvg)zzbvd2).zze(intent);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzf((String)"RemoteException calling handleNotificationIntent: ".concat(((Object)((Object)remoteException)).toString()));
            return;
        }
    }
}
