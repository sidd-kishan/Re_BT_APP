/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.NetworkOnMainThreadException
 *  android.os.RemoteException
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.common.util.DefaultClock
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.dynamite.DynamiteModule$LoadingException
 *  com.google.android.gms.dynamite.DynamiteModule$VersionPolicy
 *  com.google.android.gms.internal.measurement.zzab
 *  com.google.android.gms.internal.measurement.zzac
 *  com.google.android.gms.internal.measurement.zzad
 *  com.google.android.gms.internal.measurement.zzae
 *  com.google.android.gms.internal.measurement.zzaf
 *  com.google.android.gms.internal.measurement.zzag
 *  com.google.android.gms.internal.measurement.zzah
 *  com.google.android.gms.internal.measurement.zzai
 *  com.google.android.gms.internal.measurement.zzaj
 *  com.google.android.gms.internal.measurement.zzak
 *  com.google.android.gms.internal.measurement.zzal
 *  com.google.android.gms.internal.measurement.zzam
 *  com.google.android.gms.internal.measurement.zzan
 *  com.google.android.gms.internal.measurement.zzao
 *  com.google.android.gms.internal.measurement.zzap
 *  com.google.android.gms.internal.measurement.zzaq
 *  com.google.android.gms.internal.measurement.zzar
 *  com.google.android.gms.internal.measurement.zzas
 *  com.google.android.gms.internal.measurement.zzat
 *  com.google.android.gms.internal.measurement.zzau
 *  com.google.android.gms.internal.measurement.zzav
 *  com.google.android.gms.internal.measurement.zzaw
 *  com.google.android.gms.internal.measurement.zzax
 *  com.google.android.gms.internal.measurement.zzay
 *  com.google.android.gms.internal.measurement.zzaz
 *  com.google.android.gms.internal.measurement.zzba
 *  com.google.android.gms.internal.measurement.zzbb
 *  com.google.android.gms.internal.measurement.zzbc
 *  com.google.android.gms.internal.measurement.zzbd
 *  com.google.android.gms.internal.measurement.zzbe
 *  com.google.android.gms.internal.measurement.zzbf
 *  com.google.android.gms.internal.measurement.zzbg
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbi
 *  com.google.android.gms.internal.measurement.zzbj
 *  com.google.android.gms.internal.measurement.zzbr
 *  com.google.android.gms.internal.measurement.zzl
 *  com.google.android.gms.internal.measurement.zzn
 *  com.google.android.gms.internal.measurement.zzp
 *  com.google.android.gms.internal.measurement.zzq
 *  com.google.android.gms.internal.measurement.zzw
 *  com.google.android.gms.measurement.api.AppMeasurementSdk
 *  com.google.android.gms.measurement.internal.zzfh
 *  com.google.android.gms.measurement.internal.zzgp
 *  com.google.android.gms.measurement.internal.zzgq
 *  com.google.android.gms.measurement.internal.zzhx
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzad;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzaf;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.internal.measurement.zzah;
import com.google.android.gms.internal.measurement.zzai;
import com.google.android.gms.internal.measurement.zzaj;
import com.google.android.gms.internal.measurement.zzak;
import com.google.android.gms.internal.measurement.zzal;
import com.google.android.gms.internal.measurement.zzam;
import com.google.android.gms.internal.measurement.zzan;
import com.google.android.gms.internal.measurement.zzao;
import com.google.android.gms.internal.measurement.zzap;
import com.google.android.gms.internal.measurement.zzaq;
import com.google.android.gms.internal.measurement.zzar;
import com.google.android.gms.internal.measurement.zzas;
import com.google.android.gms.internal.measurement.zzat;
import com.google.android.gms.internal.measurement.zzau;
import com.google.android.gms.internal.measurement.zzav;
import com.google.android.gms.internal.measurement.zzaw;
import com.google.android.gms.internal.measurement.zzax;
import com.google.android.gms.internal.measurement.zzay;
import com.google.android.gms.internal.measurement.zzaz;
import com.google.android.gms.internal.measurement.zzba;
import com.google.android.gms.internal.measurement.zzbb;
import com.google.android.gms.internal.measurement.zzbc;
import com.google.android.gms.internal.measurement.zzbd;
import com.google.android.gms.internal.measurement.zzbe;
import com.google.android.gms.internal.measurement.zzbf;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbi;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfh;
import com.google.android.gms.measurement.internal.zzgp;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzhx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public final class zzbs {
    private static volatile zzbs zzc;
    protected final Clock zza;
    protected final ExecutorService zzb;
    private final String zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<zzgq, zzbj>> zzf;
    private int zzg;
    private boolean zzh;
    private final String zzi;
    private volatile zzq zzj;

    protected zzbs(Context context, String string, String string2, String string3, Bundle bundle) {
        boolean bl;
        block10: {
            this.zzd = string != null && zzbs.zzV(string2, string3) ? string : "FA";
            this.zza = DefaultClock.getInstance();
            string = zzl.zza();
            zzaw zzaw2 = new zzaw(this);
            bl = true;
            this.zzb = string.zzb((ThreadFactory)zzaw2, 1);
            this.zze = new AppMeasurementSdk(this);
            this.zzf = new ArrayList<Pair<zzgq, zzbj>>();
            try {
                string = zzhx.zza((Context)context, (String)"google_app_id", (String)zzfh.zza((Context)context));
                if (string == null) break block10;
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
                break block10;
            }
            if (!zzbs.zzR()) {
                this.zzi = null;
                this.zzh = true;
                Log.w((String)this.zzd, (String)"Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        }
        if (!zzbs.zzV(string2, string3)) {
            this.zzi = "fa";
            if (string2 != null && string3 != null) {
                Log.v((String)this.zzd, (String)"Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            } else {
                boolean bl2 = string2 == null;
                if (string3 != null) {
                    bl = false;
                }
                if (bl2 ^ bl) {
                    Log.w((String)this.zzd, (String)"Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        } else {
            this.zzi = string2;
        }
        this.zzS((zzbh)new zzal(this, string2, string3, context, bundle));
        context = (Application)context.getApplicationContext();
        if (context == null) {
            Log.w((String)this.zzd, (String)"Unable to register lifecycle notifications. Application null.");
            return;
        }
        context.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new zzbr(this));
    }

    static /* synthetic */ boolean zzK(zzbs zzbs2) {
        return zzbs2.zzh;
    }

    static /* synthetic */ void zzL(zzbs zzbs2, Exception exception, boolean bl, boolean bl2) {
        zzbs2.zzT(exception, bl, bl2);
    }

    static /* synthetic */ boolean zzM(zzbs zzbs2, String string, String string2) {
        return zzbs.zzV(string, string2);
    }

    static /* synthetic */ String zzN(zzbs zzbs2) {
        return zzbs2.zzd;
    }

    static /* synthetic */ zzq zzO(zzbs zzbs2, zzq zzq2) {
        zzbs2.zzj = zzq2;
        return zzq2;
    }

    static /* synthetic */ zzq zzP(zzbs zzbs2) {
        return zzbs2.zzj;
    }

    static /* synthetic */ void zzQ(zzbs zzbs2, zzbh zzbh2) {
        zzbs2.zzS(zzbh2);
    }

    protected static final boolean zzR() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    private final void zzS(zzbh zzbh2) {
        this.zzb.execute((Runnable)zzbh2);
    }

    private final void zzT(Exception exception, boolean bl, boolean bl2) {
        this.zzh |= bl;
        if (bl) {
            Log.w((String)this.zzd, (String)"Data collection startup failed. No data will be collected.", (Throwable)exception);
            return;
        }
        if (bl2) {
            this.zzC(5, "Error with data collection. Data lost.", exception, null, null);
        }
        Log.w((String)this.zzd, (String)"Error with data collection. Data lost.", (Throwable)exception);
    }

    private final void zzU(String string, String string2, Bundle bundle, boolean bl, boolean bl2, Long l) {
        this.zzS((zzbh)new zzbf(this, l, string, string2, bundle, bl, bl2));
    }

    private static final boolean zzV(String string, String string2) {
        if (string2 == null) return false;
        if (string == null) return false;
        if (zzbs.zzR()) return false;
        return true;
    }

    public static zzbs zza(Context context, String string, String string2, String string3, Bundle bundle) {
        Preconditions.checkNotNull((Object)context);
        if (zzc != null) return zzc;
        synchronized (zzbs.class) {
            zzbs zzbs2;
            if (zzc != null) return zzc;
            zzc = zzbs2 = new zzbs(context, string, string2, string3, bundle);
        }
        return zzc;
    }

    public final String zzA() {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzas(this, zzn2));
        return zzn2.zzc(500L);
    }

    public final Map<String, Object> zzB(String object, String object2, boolean bl) {
        Object object3 = new zzn();
        this.zzS((zzbh)new zzat(this, (String)object, (String)object2, bl, object3));
        Bundle bundle = object3.zzd(5000L);
        if (bundle == null) return Collections.emptyMap();
        if (bundle.size() == 0) {
            return Collections.emptyMap();
        }
        object2 = new HashMap(bundle.size());
        object = bundle.keySet().iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            object3 = bundle.get(string);
            if (!(object3 instanceof Double) && !(object3 instanceof Long) && !(object3 instanceof String)) continue;
            object2.put(string, object3);
        }
        return object2;
    }

    public final void zzC(int n, String string, Object object, Object object2, Object object3) {
        this.zzS((zzbh)new zzau(this, false, 5, string, object, null, null));
    }

    public final Bundle zzD(Bundle bundle, boolean bl) {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzav(this, bundle, zzn2));
        if (!bl) return null;
        return zzn2.zzd(5000L);
    }

    public final int zzE(String object) {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzax(this, (String)object, zzn2));
        object = (Integer)zzn.zze((Bundle)zzn2.zzd(10000L), Integer.class);
        if (object != null) return (Integer)object;
        return 25;
    }

    public final String zzF() {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzay(this, zzn2));
        return zzn2.zzc(120000L);
    }

    public final String zzG() {
        return this.zzi;
    }

    public final Object zzH(int n) {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzaz(this, zzn2, n));
        return zzn.zze((Bundle)zzn2.zzd(15000L), Object.class);
    }

    public final void zzI(boolean bl) {
        this.zzS((zzbh)new zzba(this, bl));
    }

    public final void zzJ(Bundle bundle) {
        this.zzS((zzbh)new zzbb(this, bundle));
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    protected final zzq zzc(Context context, boolean bl) {
        try {
            context = zzp.asInterface((IBinder)DynamiteModule.load((Context)context, (DynamiteModule.VersionPolicy)DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, (String)"com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
            return context;
        }
        catch (DynamiteModule.LoadingException loadingException) {
            this.zzT((Exception)((Object)loadingException), true, false);
            return null;
        }
    }

    public final void zzd(zzgp zzgp2) {
        zzbi zzbi2 = new zzbi(zzgp2);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor((zzw)zzbi2);
                return;
            }
            catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException throwable) {
                Log.w((String)this.zzd, (String)"Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        this.zzS((zzbh)new zzbc(this, zzbi2));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void zze(zzgq zzgq2) {
        zzbj zzbj2;
        block8: {
            Preconditions.checkNotNull((Object)zzgq2);
            List<Pair<zzgq, zzbj>> list = this.zzf;
            synchronized (list) {
                for (int i = 0; i < this.zzf.size(); ++i) {
                    if (!zzgq2.equals(this.zzf.get((int)i).first)) continue;
                    Log.w((String)this.zzd, (String)"OnEventListener already registered.");
                    return;
                }
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
                {
                    zzbj2 = new zzbj(zzgq2);
                    List<Pair<zzgq, zzbj>> list2 = this.zzf;
                    Pair pair = new Pair((Object)zzgq2, (Object)zzbj2);
                    list2.add((Pair<zzgq, zzbj>)pair);
                    // MONITOREXIT @DISABLED, blocks:[1, 4] lbl21 : MonitorExitStatement: MONITOREXIT : var3_4
                    if (this.zzj == null) break block8;
                }
            }
            try {
                this.zzj.registerOnMeasurementEventListener((zzw)zzbj2);
                return;
            }
            catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException throwable) {
                Log.w((String)this.zzd, (String)"Failed to register event listener on calling thread. Trying again on the dynamite thread.");
            }
        }
        this.zzS((zzbh)new zzbd(this, zzbj2));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void zzf(zzgq pair) {
        block10: {
            block9: {
                Preconditions.checkNotNull(pair);
                List<Pair<zzgq, zzbj>> list = this.zzf;
                // MONITORENTER : list
                for (int i = 0; i < this.zzf.size(); ++i) {
                    if (!pair.equals(this.zzf.get((int)i).first)) continue;
                    pair = this.zzf.get(i);
                    break block9;
                }
                pair = null;
            }
            if (pair == null) {
                Log.w((String)this.zzd, (String)"OnEventListener had not been registered.");
                // MONITOREXIT : list
                return;
            }
            this.zzf.remove(pair);
            pair = (Pair<zzgq, zzbj>)pair.second;
            // MONITOREXIT : list
            if (this.zzj == null) break block10;
            {
                catch (Throwable throwable) {}
                {
                    // MONITOREXIT : list
                    throw throwable;
                }
            }
            try {
                this.zzj.unregisterOnMeasurementEventListener(pair);
                return;
            }
            catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException throwable) {
                Log.w((String)this.zzd, (String)"Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
            }
        }
        this.zzS((zzbh)new zzbe(this, pair));
    }

    public final void zzg(String string, Bundle bundle) {
        this.zzU(null, string, bundle, false, true, null);
    }

    public final void zzh(String string, String string2, Bundle bundle) {
        this.zzU(string, string2, bundle, true, true, null);
    }

    public final void zzi(String string, String string2, Bundle bundle, long l) {
        this.zzU(string, string2, bundle, true, false, l);
    }

    public final void zzj(String string, String string2, Object object, boolean bl) {
        this.zzS((zzbh)new zzbg(this, string, string2, object, bl));
    }

    public final void zzk(Bundle bundle) {
        this.zzS((zzbh)new zzab(this, bundle));
    }

    public final void zzl(String string, String string2, Bundle bundle) {
        this.zzS((zzbh)new zzac(this, string, string2, bundle));
    }

    public final List<Bundle> zzm(String list, String object) {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzad(this, (String)((Object)list), (String)object, zzn2));
        object = (List)zzn.zze((Bundle)zzn2.zzd(5000L), List.class);
        list = object;
        if (object != null) return list;
        list = Collections.emptyList();
        return list;
    }

    public final void zzn(String string) {
        this.zzS((zzbh)new zzae(this, string));
    }

    public final void zzo(Activity activity, String string, String string2) {
        this.zzS((zzbh)new zzaf(this, activity, string, string2));
    }

    public final void zzp(Boolean bl) {
        this.zzS((zzbh)new zzag(this, bl));
    }

    public final void zzq(Bundle bundle) {
        this.zzS((zzbh)new zzah(this, bundle));
    }

    public final void zzr(Bundle bundle) {
        this.zzS((zzbh)new zzai(this, bundle));
    }

    public final void zzs() {
        this.zzS((zzbh)new zzaj(this));
    }

    public final void zzt(long l) {
        this.zzS((zzbh)new zzak(this, l));
    }

    public final void zzu(String string) {
        this.zzS((zzbh)new zzam(this, string));
    }

    public final void zzv(String string) {
        this.zzS((zzbh)new zzan(this, string));
    }

    public final String zzw() {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzao(this, zzn2));
        return zzn2.zzc(500L);
    }

    public final String zzx() {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzap(this, zzn2));
        return zzn2.zzc(50L);
    }

    public final long zzy() {
        long l;
        Object object = new zzn();
        this.zzS((zzbh)new zzaq(this, (zzn)object));
        object = (Long)zzn.zze((Bundle)object.zzd(500L), Long.class);
        if (object == null) {
            int n;
            l = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            this.zzg = n = this.zzg + 1;
            l += (long)n;
        } else {
            l = (Long)object;
        }
        return l;
    }

    public final String zzz() {
        zzn zzn2 = new zzn();
        this.zzS((zzbh)new zzar(this, zzn2));
        return zzn2.zzc(500L);
    }
}
