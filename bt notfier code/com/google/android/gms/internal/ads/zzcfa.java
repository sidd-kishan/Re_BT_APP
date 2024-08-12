/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.ClientLibraryUtils
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcej
 *  com.google.android.gms.internal.ads.zzcek
 *  com.google.android.gms.internal.ads.zzcel
 *  com.google.android.gms.internal.ads.zzcem
 *  com.google.android.gms.internal.ads.zzcen
 *  com.google.android.gms.internal.ads.zzceo
 *  com.google.android.gms.internal.ads.zzcep
 *  com.google.android.gms.internal.ads.zzceq
 *  com.google.android.gms.internal.ads.zzcer
 *  com.google.android.gms.internal.ads.zzces
 *  com.google.android.gms.internal.ads.zzcet
 *  com.google.android.gms.internal.ads.zzceu
 *  com.google.android.gms.internal.ads.zzcev
 *  com.google.android.gms.internal.ads.zzcew
 *  com.google.android.gms.internal.ads.zzcex
 *  com.google.android.gms.internal.ads.zzcey
 *  com.google.android.gms.internal.ads.zzcez
 *  com.google.android.gms.internal.ads.zzcfb
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcod
 *  com.google.android.gms.internal.ads.zzfkz
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcek;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzcem;
import com.google.android.gms.internal.ads.zzcen;
import com.google.android.gms.internal.ads.zzceo;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzceq;
import com.google.android.gms.internal.ads.zzcer;
import com.google.android.gms.internal.ads.zzces;
import com.google.android.gms.internal.ads.zzcet;
import com.google.android.gms.internal.ads.zzceu;
import com.google.android.gms.internal.ads.zzcev;
import com.google.android.gms.internal.ads.zzcew;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.internal.ads.zzcey;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcod;
import com.google.android.gms.internal.ads.zzfkz;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcfa {
    final AtomicBoolean zza;
    private final AtomicReference<ExecutorService> zzb = new AtomicReference<Object>(null);
    private final Object zzc = new Object();
    private String zzd = null;
    private String zze = null;
    private final AtomicInteger zzf;
    private final AtomicReference<Object> zzg;
    private final AtomicReference<Object> zzh;
    private final ConcurrentMap<String, Method> zzi;
    private final AtomicReference<zzcod> zzj;
    private final BlockingQueue<FutureTask<?>> zzk;
    private final Object zzl;

    public zzcfa() {
        this.zza = new AtomicBoolean(false);
        this.zzf = new AtomicInteger(-1);
        this.zzg = new AtomicReference<Object>(null);
        this.zzh = new AtomicReference<Object>(null);
        this.zzi = new ConcurrentHashMap<String, Method>(9);
        this.zzj = new AtomicReference<Object>(null);
        this.zzk = new ArrayBlockingQueue(20);
        this.zzl = new Object();
    }

    private final void zzA(String string, boolean bl) {
        if (this.zza.get()) return;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 30);
        stringBuilder.append("Invoke Firebase method ");
        stringBuilder.append(string);
        stringBuilder.append(" error.");
        com.google.android.gms.ads.internal.util.zze.zzi((String)stringBuilder.toString());
        if (!bl) return;
        com.google.android.gms.ads.internal.util.zze.zzi((String)"The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
        this.zza.set(true);
    }

    private final ExecutorService zzB() {
        Object object;
        if (this.zzb.get() != null) return this.zzb.get();
        if (ClientLibraryUtils.isPackageSide()) {
            object = zzfkz.zza();
            zzbjd zzbjd2 = zzbjl.zzab;
            object = object.zza(((Integer)zzbet.zzc().zzc(zzbjd2)).intValue(), (ThreadFactory)new zzcex(this), 2);
        } else {
            object = zzbjl.zzab;
            int n = (Integer)zzbet.zzc().zzc((zzbjd)object);
            object = zzbjl.zzab;
            object = new ThreadPoolExecutor(n, (int)((Integer)zzbet.zzc().zzc((zzbjd)object)), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)new zzcex(this));
        }
        this.zzb.compareAndSet(null, (ExecutorService)object);
        return this.zzb.get();
    }

    private final boolean zzC(Context context, String string, AtomicReference<Object> atomicReference, boolean bl) {
        if (atomicReference.get() != null) return true;
        try {
            atomicReference.compareAndSet(null, context.getClassLoader().loadClass(string).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
        }
        catch (Exception exception) {
            this.zzA("getInstance", bl);
            return false;
        }
        return true;
    }

    private final void zzD(String string, zzcez zzcez2) {
        AtomicReference<zzcod> atomicReference = this.zzj;
        synchronized (atomicReference) {
            zzcen zzcen2 = new zzcen(this, zzcez2, string);
            FutureTask<Object> futureTask = new FutureTask<Object>((Runnable)zzcen2, null);
            if (this.zzj.get() != null) {
                futureTask.run();
            } else {
                this.zzk.offer(futureTask);
            }
            return;
        }
    }

    private final <T> T zzE(String string, T t, zzcey<T> object) {
        AtomicReference<zzcod> atomicReference = this.zzj;
        synchronized (atomicReference) {
            block5: {
                zzcod zzcod2 = this.zzj.get();
                if (zzcod2 == null) return t;
                try {
                    object = object.zza(this.zzj.get());
                }
                catch (Exception exception) {
                    this.zzA(string, false);
                    break block5;
                }
                return (T)object;
            }
            return t;
        }
    }

    static final boolean zzv(Context context) {
        zzbjd zzbjd2 = zzbjl.zzac;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return false;
        int n = DynamiteModule.getLocalVersion((Context)context, (String)"com.google.android.gms.ads.dynamite");
        zzbjd2 = zzbjl.zzad;
        if (n < (Integer)zzbet.zzc().zzc(zzbjd2)) {
            return false;
        }
        zzbjd2 = zzbjl.zzae;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return true;
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return false;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private final void zzw(Context object, String string, String object2, Bundle bundle) {
        Bundle bundle2;
        block12: {
            void var5_10;
            if (!this.zzb((Context)object)) return;
            bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong((String)object2));
                break block12;
            }
            catch (NumberFormatException numberFormatException) {
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
            object2 = String.valueOf(object2);
            object2 = ((String)object2).length() != 0 ? "Invalid event ID: ".concat((String)object2) : new String("Invalid event ID: ");
            com.google.android.gms.ads.internal.util.zze.zzg((String)object2, (Throwable)var5_10);
        }
        if ("_ac".equals(string)) {
            bundle2.putInt("_r", 1);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (zzcfa.zzv(object)) {
            this.zzD("logEventInternal", (zzcez)new zzcem(string, bundle2));
            return;
        }
        if (!this.zzC((Context)object, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) return;
        object2 = (Method)this.zzi.get("logEventInternal");
        if (object2 != null) {
            object = object2;
        } else {
            try {
                object = object.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
                this.zzi.put("logEventInternal", (Method)object);
            }
            catch (Exception exception) {
                this.zzA("logEventInternal", true);
                object = null;
            }
        }
        try {
            object.invoke(this.zzg.get(), "am", string, bundle2);
            return;
        }
        catch (Exception exception) {
            this.zzA("logEventInternal", true);
        }
    }

    private final Method zzx(Context object, String string) {
        Method method = (Method)this.zzi.get(string);
        if (method != null) {
            return method;
        }
        try {
            object = object.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(string, new Class[0]);
            this.zzi.put(string, (Method)object);
            return object;
        }
        catch (Exception exception) {
            this.zzA(string, false);
            return null;
        }
    }

    private final void zzy(Context object, String string, String string2) {
        if (!this.zzC((Context)object, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) return;
        Method method = (Method)this.zzi.get(string2);
        if (method != null) {
            object = method;
        } else {
            try {
                object = object.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(string2, String.class);
                this.zzi.put(string2, (Method)object);
            }
            catch (Exception exception) {
                this.zzA(string2, false);
                object = null;
            }
        }
        try {
            ((Method)object).invoke(this.zzg.get(), string);
            int n = string2.length();
            int n2 = String.valueOf(string).length();
            object = new StringBuilder(n + 37 + n2);
            ((StringBuilder)object).append("Invoke Firebase method ");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(", Ad Unit Id: ");
            ((StringBuilder)object).append(string);
            com.google.android.gms.ads.internal.util.zze.zza((String)((StringBuilder)object).toString());
            return;
        }
        catch (Exception exception) {
            this.zzA(string2, false);
        }
    }

    private final Object zzz(String string, Context object) {
        if (!this.zzC((Context)object, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
            return null;
        }
        object = this.zzx((Context)object, string);
        try {
            object = ((Method)object).invoke(this.zzg.get(), new Object[0]);
            return object;
        }
        catch (Exception exception) {
            this.zzA(string, true);
            return null;
        }
    }

    public final boolean zza() {
        Object object = this.zzl;
        synchronized (object) {
            return false;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final boolean zzb(Context var1_1) {
        block4: {
            var2_2 = zzbjl.zzV;
            if ((Boolean)zzbet.zzc().zzc(var2_2) == false) return false;
            if (this.zza.get()) {
                return false;
            }
            var2_2 = zzbjl.zzaf;
            if (((Boolean)zzbet.zzc().zzc(var2_2)).booleanValue()) {
                return true;
            }
            if (this.zzf.get() != -1) break block4;
            zzber.zza();
            if (zzcgm.zzn((Context)var1_1, (int)12451000)) ** GOTO lbl-1000
            zzber.zza();
            if (zzcgm.zzo((Context)var1_1)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                this.zzf.set(0);
            } else lbl-1000:
            // 2 sources

            {
                this.zzf.set(1);
            }
        }
        if (this.zzf.get() != 1) return false;
        return true;
    }

    public final void zzc(Context context, zzbim object) {
        zzcfb.zzd((Context)context).zzb().zzc(object);
        object = zzbjl.zzah;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        if (!this.zzb(context)) return;
        if (!zzcfa.zzv(context)) {
            return;
        }
        object = this.zzl;
        synchronized (object) {
            return;
        }
    }

    public final void zzd(Context object, zzbdg zzbdg2) {
        zzbdg2 = zzbjl.zzah;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)zzbdg2) == false) return;
        if (!this.zzb((Context)object)) return;
        if (!zzcfa.zzv(object)) {
            return;
        }
        object = this.zzl;
        synchronized (object) {
            return;
        }
    }

    public final void zze(Bundle bundle) {
        this.zzD("setConsent", (zzcez)new zzcej(bundle));
    }

    public final void zzf(Context context, String string) {
        if (!this.zzb(context)) {
            return;
        }
        if (zzcfa.zzv(context)) {
            this.zzD("beginAdUnitExposure", (zzcez)new zzcep(string));
            return;
        }
        this.zzy(context, string, "beginAdUnitExposure");
    }

    public final void zzg(Context context, String string) {
        if (!this.zzb(context)) {
            return;
        }
        if (zzcfa.zzv(context)) {
            this.zzD("endAdUnitExposure", (zzcez)new zzceq(string));
            return;
        }
        this.zzy(context, string, "endAdUnitExposure");
    }

    public final String zzh(Context context) {
        if (!this.zzb(context)) {
            return "";
        }
        if (zzcfa.zzv(context)) {
            return this.zzE("getCurrentScreenNameOrScreenClass", "", zzcer.zza);
        }
        if (!this.zzC(context, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
            return "";
        }
        try {
            String string;
            String string2 = string = (String)this.zzx(context, "getCurrentScreenName").invoke(this.zzg.get(), new Object[0]);
            if (string == null) {
                string2 = (String)this.zzx(context, "getCurrentScreenClass").invoke(this.zzg.get(), new Object[0]);
            }
            if (string2 == null) return "";
            return string2;
        }
        catch (Exception exception) {
            this.zzA("getCurrentScreenName", false);
            return "";
        }
    }

    @Deprecated
    public final void zzi(Context context, String string) {
        if (!this.zzb(context)) {
            return;
        }
        if (!(context instanceof Activity)) {
            return;
        }
        if (zzcfa.zzv(context)) {
            this.zzD("setScreenName", (zzcez)new zzces(context, string));
            return;
        }
        if (!this.zzC(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzh, false)) return;
        Method method = (Method)this.zzi.get("setCurrentScreen");
        if (method == null) {
            try {
                method = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", Activity.class, String.class, String.class);
                this.zzi.put("setCurrentScreen", method);
            }
            catch (Exception exception) {
                this.zzA("setCurrentScreen", false);
                method = null;
            }
        }
        try {
            Activity activity = (Activity)context;
            method.invoke(this.zzh.get(), activity, string, context.getPackageName());
            return;
        }
        catch (Exception exception) {
            this.zzA("setCurrentScreen", false);
        }
    }

    public final String zzj(Context object) {
        if (!this.zzb((Context)object)) {
            return null;
        }
        Object object2 = this.zzc;
        synchronized (object2) {
            String string = this.zzd;
            if (string != null) {
                return string;
            }
            this.zzd = zzcfa.zzv(object) ? this.zzE("getGmpAppId", this.zzd, zzcet.zza) : (String)this.zzz("getGmpAppId", (Context)object);
            object = this.zzd;
            return object;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final String zzk(Context var1_1) {
        block8: {
            if (!this.zzb((Context)var1_1)) {
                return null;
            }
            var4_6 = zzbjl.zzaa;
            var2_7 = (Long)zzbet.zzc().zzc((zzbjd)var4_6);
            if (!zzcfa.zzv((Context)var1_1)) break block8;
            if (var2_7 >= 0L) ** GOTO lbl9
            try {
                return this.zzE("getAppInstanceId", null, zzceu.zza);
lbl9:
                // 1 sources

                var4_6 = this.zzB();
                var1_1 = new zzcev(this);
                var1_1 = (String)var4_6.submit(var1_1).get(var2_7, TimeUnit.MILLISECONDS);
                return var1_1;
            }
            catch (Exception var1_2) {
                return null;
            }
            catch (TimeoutException var1_3) {
                return "TIME_OUT";
            }
        }
        if (var2_7 < 0L) {
            return (String)this.zzz("getAppInstanceId", (Context)var1_1);
        }
        var1_1 = this.zzB().submit(new zzcew(this, (Context)var1_1));
        try {
            var1_1 = (String)var1_1.get(var2_7, TimeUnit.MILLISECONDS);
            return var1_1;
        }
        catch (Exception var1_4) {
            return null;
        }
        catch (TimeoutException var1_5) {
            return "TIME_OUT";
        }
    }

    public final String zzl(Context object) {
        if (!this.zzb((Context)object)) {
            return null;
        }
        if (zzcfa.zzv((Context)object)) {
            object = this.zzE("getAdEventId", null, zzcek.zza);
            if (object == null) return null;
            return Long.toString((Long)object);
        }
        if ((object = this.zzz("generateEventId", (Context)object)) == null) return null;
        return object.toString();
    }

    public final String zzm(Context object) {
        if (!this.zzb((Context)object)) {
            return null;
        }
        Object object2 = this.zzc;
        synchronized (object2) {
            String string = this.zze;
            if (string != null) {
                return string;
            }
            this.zze = zzcfa.zzv(object) ? this.zzE("getAppIdOrigin", this.zze, zzcel.zza) : "fa";
            object = this.zze;
            return object;
        }
    }

    public final void zzn(Context context, String string) {
        this.zzw(context, "_ac", string, null);
    }

    public final void zzo(Context context, String string) {
        this.zzw(context, "_ai", string, null);
    }

    public final void zzp(Context context, String string) {
        this.zzw(context, "_aq", string, null);
    }

    public final void zzq(Context context, String string) {
        this.zzw(context, "_aa", string, null);
    }

    public final void zzr(Context object, String string, String string2, String string3, int n) {
        if (!this.zzb((Context)object)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", string2);
        bundle.putString("reward_type", string3);
        bundle.putInt("reward_value", n);
        this.zzw((Context)object, "_ar", string, bundle);
        object = new StringBuilder(String.valueOf(string3).length() + 75);
        ((StringBuilder)object).append("Log a Firebase reward video event, reward type: ");
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(", reward value: ");
        ((StringBuilder)object).append(n);
        com.google.android.gms.ads.internal.util.zze.zza((String)((StringBuilder)object).toString());
    }

    final /* synthetic */ void zzs(zzcez zzcez2, String string) {
        if (this.zzj.get() == null) return;
        try {
            zzcez2.zza(this.zzj.get());
            return;
        }
        catch (Exception exception) {
            this.zzA(string, false);
        }
    }

    final /* synthetic */ String zzt(Context context) throws Exception {
        return (String)this.zzz("getAppInstanceId", context);
    }

    final /* synthetic */ String zzu() throws Exception {
        return this.zzE("getAppInstanceId", null, zzceo.zza);
    }
}
