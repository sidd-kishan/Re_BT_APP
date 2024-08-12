/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbzq
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzcgt;

public final class AdActivity
extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbzq zza;

    private final void zza() {
        zzbzq zzbzq2 = this.zza;
        if (zzbzq2 == null) return;
        try {
            zzbzq2.zzs();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }

    protected final void onActivityResult(int n, int n2, Intent intent) {
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 != null) {
                zzbzq2.zzm(n, n2, intent);
            }
        }
        catch (Exception exception) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)exception);
        }
        super.onActivityResult(n, n2, intent);
    }

    public final void onBackPressed() {
        zzbzq zzbzq2;
        try {
            zzbzq2 = this.zza;
            if (zzbzq2 != null) {
                boolean bl = zzbzq2.zzg();
                if (!bl) return;
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        super.onBackPressed();
        try {
            zzbzq2 = this.zza;
            if (zzbzq2 == null) return;
            zzbzq2.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 == null) return;
            zzbzq2.zzn(ObjectWrapper.wrap((Object)configuration));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    protected final void onCreate(Bundle bundle) {
        zzbzq zzbzq2;
        super.onCreate(bundle);
        this.zza = zzbzq2 = zzber.zzb().zzp((Activity)this);
        if (zzbzq2 == null) {
            zzcgt.zzl((String)"#007 Could not call remote method.", null);
            this.finish();
            return;
        }
        try {
            zzbzq2.zzh(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            this.finish();
            return;
        }
    }

    protected final void onDestroy() {
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 != null) {
                zzbzq2.zzq();
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        super.onDestroy();
    }

    protected final void onPause() {
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 != null) {
                zzbzq2.zzl();
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            this.finish();
        }
        super.onPause();
    }

    protected final void onRestart() {
        super.onRestart();
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 == null) return;
            zzbzq2.zzi();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            this.finish();
            return;
        }
    }

    protected final void onResume() {
        super.onResume();
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 == null) return;
            zzbzq2.zzk();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            this.finish();
            return;
        }
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 != null) {
                zzbzq2.zzo(bundle);
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            this.finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected final void onStart() {
        super.onStart();
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 == null) return;
            zzbzq2.zzj();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            this.finish();
            return;
        }
    }

    protected final void onStop() {
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 != null) {
                zzbzq2.zzp();
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            this.finish();
        }
        super.onStop();
    }

    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbzq zzbzq2 = this.zza;
            if (zzbzq2 == null) return;
            zzbzq2.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setContentView(int n) {
        super.setContentView(n);
        this.zza();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        this.zza();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.zza();
    }
}
