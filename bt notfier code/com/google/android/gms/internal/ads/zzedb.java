/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.NetworkInfo$DetailedState
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.telephony.TelephonyManager
 *  android.util.SparseArray
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbaw
 *  com.google.android.gms.internal.ads.zzbbd
 *  com.google.android.gms.internal.ads.zzbbh
 *  com.google.android.gms.internal.ads.zzbbi
 *  com.google.android.gms.internal.ads.zzbbm
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdai
 *  com.google.android.gms.internal.ads.zzecq
 *  com.google.android.gms.internal.ads.zzecu
 *  com.google.android.gms.internal.ads.zzeda
 *  com.google.android.gms.internal.ads.zzfbd
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbh;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdai;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzecu;
import com.google.android.gms.internal.ads.zzeda;
import com.google.android.gms.internal.ads.zzfbd;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public final class zzedb {
    private static final SparseArray<zzbbm> zzg;
    private final Context zza;
    private final zzdai zzb;
    private final TelephonyManager zzc;
    private final zzecu zzd;
    private final zzecq zze;
    private final zzg zzf;
    private int zzh;

    static {
        SparseArray sparseArray;
        zzg = sparseArray = new SparseArray();
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), (Object)zzbbm.zzc);
        zzg.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), (Object)zzbbm.zzb);
        zzg.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), (Object)zzbbm.zzb);
        zzg.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), (Object)zzbbm.zzb);
        zzg.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), (Object)zzbbm.zzd);
        zzg.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), (Object)zzbbm.zze);
        zzg.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), (Object)zzbbm.zze);
        zzg.put(NetworkInfo.DetailedState.FAILED.ordinal(), (Object)zzbbm.zze);
        zzg.put(NetworkInfo.DetailedState.IDLE.ordinal(), (Object)zzbbm.zze);
        zzg.put(NetworkInfo.DetailedState.SCANNING.ordinal(), (Object)zzbbm.zze);
        zzg.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), (Object)zzbbm.zzf);
        if (Build.VERSION.SDK_INT >= 17) {
            zzg.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), (Object)zzbbm.zzb);
        }
        zzg.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), (Object)zzbbm.zzb);
    }

    zzedb(Context context, zzdai zzdai2, zzecu zzecu2, zzecq zzecq2, zzg zzg2) {
        this.zza = context;
        this.zzb = zzdai2;
        this.zzd = zzecu2;
        this.zze = zzecq2;
        this.zzc = (TelephonyManager)context.getSystemService("phone");
        this.zzf = zzg2;
    }

    static /* synthetic */ zzecq zza(zzedb zzedb2) {
        return zzedb2.zze;
    }

    static /* synthetic */ zzg zzb(zzedb zzedb2) {
        return zzedb2.zzf;
    }

    static /* synthetic */ zzbbd zzc(zzedb zzedb2, Bundle bundle) {
        zzbaw zzbaw2 = zzbbd.zzd();
        int n = bundle.getInt("cnt", -2);
        int n2 = bundle.getInt("gnt", 0);
        int n3 = 2;
        if (n == -1) {
            zzedb2.zzh = 2;
        } else {
            zzedb2.zzh = 1;
            if (n != 0) {
                if (n != 1) {
                    zzbaw2.zza(1);
                } else {
                    zzbaw2.zza(3);
                }
            } else {
                zzbaw2.zza(2);
            }
            switch (n2) {
                default: {
                    n3 = 1;
                    break;
                }
                case 13: {
                    n3 = 5;
                    break;
                }
                case 3: 
                case 5: 
                case 6: 
                case 8: 
                case 9: 
                case 10: 
                case 12: 
                case 14: 
                case 15: 
                case 17: {
                    n3 = 3;
                    break;
                }
                case 1: 
                case 2: 
                case 4: 
                case 7: 
                case 11: 
                case 16: 
            }
            zzbaw2.zzb(n3);
        }
        return (zzbbd)zzbaw2.zzah();
    }

    static /* synthetic */ zzbbm zzd(zzedb zzedb2, Bundle bundle) {
        int n = zzfbd.zza((Bundle)zzfbd.zza((Bundle)bundle, (String)"device"), (String)"network").getInt("active_network_state", -1);
        return (zzbbm)zzg.get(n, (Object)zzbbm.zza);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ byte[] zze(zzedb zzedb2, boolean bl, ArrayList arrayList, zzbbd zzbbd2, zzbbm zzbbm2) {
        zzbbh zzbbh2 = zzbbi.zzj();
        zzbbh2.zzd((Iterable)arrayList);
        arrayList = zzedb2.zza.getContentResolver();
        int n = zzt.zze().zzf((ContentResolver)arrayList);
        boolean bl2 = true;
        boolean bl3 = n != 0;
        zzbbh2.zzj(zzedb.zzg(bl3));
        zzbbh2.zzk(zzt.zze().zzq(zzedb2.zza, zzedb2.zzc));
        zzbbh2.zzb(zzedb2.zzd.zzd());
        zzbbh2.zzc(zzedb2.zzd.zzh());
        zzbbh2.zzf(zzedb2.zzd.zzb());
        zzbbh2.zzg(zzbbm2);
        zzbbh2.zze(zzbbd2);
        zzbbh2.zzl(zzedb2.zzh);
        zzbbh2.zzh(zzedb.zzg(bl));
        zzbbh2.zza(zzt.zzj().currentTimeMillis());
        zzedb2 = zzedb2.zza.getContentResolver();
        bl = zzt.zze().zze((ContentResolver)zzedb2) != 0 ? bl2 : false;
        zzbbh2.zzi(zzedb.zzg(bl));
        return ((zzbbi)zzbbh2.zzah()).zzao();
    }

    private static final int zzg(boolean bl) {
        if (!bl) return 1;
        return 2;
    }

    public final void zzf(boolean bl) {
        zzfsd.zzp((zzfsm)this.zzb.zza(), (zzfrz)new zzeda(this, bl), (Executor)zzchg.zzf);
    }
}
