/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;

public abstract class zzehh<AdT>
implements zzeec<AdT> {
    private static Bundle zzd(Bundle bundle) {
        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
        return bundle;
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        if (TextUtils.isEmpty((CharSequence)zzezz2.zzv.optString("pubid", ""))) return false;
        return true;
    }

    public final zzfsm<AdT> zzb(zzfal zzfal2, zzezz zzezz2) {
        String string = zzezz2.zzv.optString("pubid", "");
        zzfar zzfar2 = zzfal2.zza.zza;
        zzfap zzfap2 = new zzfap();
        zzfap2.zzK(zzfar2);
        zzfap2.zzw(string);
        string = zzehh.zzd(zzfar2.zzd.zzm);
        Object object = zzehh.zzd(string.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        object.putInt("gw", 1);
        Object object2 = zzezz2.zzv.optString("mad_hac", null);
        if (object2 != null) {
            object.putString("mad_hac", (String)object2);
        }
        if ((object2 = zzezz2.zzv.optString("adJson", null)) != null) {
            object.putString("_ad", (String)object2);
        }
        object.putBoolean("_noRefresh", true);
        object2 = zzezz2.zzD.keys();
        while (object2.hasNext()) {
            String string2 = (String)object2.next();
            String string3 = zzezz2.zzD.optString(string2, null);
            if (string2 == null) continue;
            object.putString(string2, string3);
        }
        string.putBundle("com.google.ads.mediation.admob.AdMobAdapter", object);
        zzfar2 = zzfar2.zzd;
        zzfap2.zzr(new zzbdg(zzfar2.zza, zzfar2.zzb, object, zzfar2.zzd, zzfar2.zze, zzfar2.zzf, zzfar2.zzg, zzfar2.zzh, zzfar2.zzi, zzfar2.zzj, zzfar2.zzk, zzfar2.zzl, (Bundle)string, zzfar2.zzn, zzfar2.zzo, zzfar2.zzp, zzfar2.zzq, zzfar2.zzr, zzfar2.zzs, zzfar2.zzt, zzfar2.zzu, zzfar2.zzv, zzfar2.zzw, zzfar2.zzx));
        zzfap2 = zzfap2.zzL();
        string = new Bundle();
        zzfar2 = zzfal2.zzb.zzb;
        object = new Bundle();
        object.putStringArrayList("nofill_urls", new ArrayList(zzfar2.zza));
        object.putInt("refresh_interval", zzfar2.zzc);
        object.putString("gws_query_id", zzfar2.zzb);
        string.putBundle("parent_common_config", object);
        object = zzfal2.zza.zza.zzf;
        zzfal2 = new Bundle();
        zzfal2.putString("initial_ad_unit_id", (String)object);
        zzfal2.putString("allocation_id", zzezz2.zzw);
        zzfal2.putStringArrayList("click_urls", new ArrayList(zzezz2.zzc));
        zzfal2.putStringArrayList("imp_urls", new ArrayList(zzezz2.zzd));
        zzfal2.putStringArrayList("manual_tracking_urls", new ArrayList(zzezz2.zzp));
        zzfal2.putStringArrayList("fill_urls", new ArrayList(zzezz2.zzn));
        zzfal2.putStringArrayList("video_start_urls", new ArrayList(zzezz2.zzh));
        zzfal2.putStringArrayList("video_reward_urls", new ArrayList(zzezz2.zzi));
        zzfal2.putStringArrayList("video_complete_urls", new ArrayList(zzezz2.zzj));
        zzfal2.putString("transaction_id", zzezz2.zzk);
        zzfal2.putString("valid_from_timestamp", zzezz2.zzl);
        zzfal2.putBoolean("is_closable_area_disabled", zzezz2.zzL);
        if (zzezz2.zzm != null) {
            object = new Bundle();
            object.putInt("rb_amount", zzezz2.zzm.zzb);
            object.putString("rb_type", zzezz2.zzm.zza);
            zzfal2.putParcelableArray("rewards", (Parcelable[])new Bundle[]{object});
        }
        string.putBundle("parent_ad_config", (Bundle)zzfal2);
        return this.zzc((zzfar)zzfap2, (Bundle)string);
    }

    protected abstract zzfsm<AdT> zzc(zzfar var1, Bundle var2);
}
