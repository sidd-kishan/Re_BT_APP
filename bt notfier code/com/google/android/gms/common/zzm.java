/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzad
 *  com.google.android.gms.common.internal.zzae
 *  com.google.android.gms.common.zzd
 *  com.google.android.gms.common.zze
 *  com.google.android.gms.common.zzf
 *  com.google.android.gms.common.zzg
 *  com.google.android.gms.common.zzh
 *  com.google.android.gms.common.zzi
 *  com.google.android.gms.common.zzk
 *  com.google.android.gms.common.zzn
 *  com.google.android.gms.common.zzq
 *  com.google.android.gms.common.zzs
 *  com.google.android.gms.common.zzw
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.dynamite.DynamiteModule$LoadingException
 *  com.google.android.gms.dynamite.DynamiteModule$VersionPolicy
 */
package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.zzd;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.zzf;
import com.google.android.gms.common.zzg;
import com.google.android.gms.common.zzh;
import com.google.android.gms.common.zzi;
import com.google.android.gms.common.zzk;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.common.zzw;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
final class zzm {
    static final zzk zza = new zze(zzi.zzf((String)"0\u0082\u0005\u00c80\u0082\u0003\u00b0\u00a0\u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bs\u00f9/\u008eQ\u00ed"));
    static final zzk zzb = new zzf(zzi.zzf((String)"0\u0082\u0006\u00040\u0082\u0003\u00ec\u00a0\u0003\u0002\u0001\u0002\u0002\u0014\u0003\u00a3\u00b2\u00ad\u00d7\u00e1r\u00cak\u00ec"));
    static final zzk zzc = new zzg(zzi.zzf((String)"0\u0082\u0004C0\u0082\u0003+\u00a0\u0003\u0002\u0001\u0002\u0002\t\u0000\u00c2\u00e0\u0087FdJ0\u008d0"));
    static final zzk zzd = new zzh(zzi.zzf((String)"0\u0082\u0004\u00a80\u0082\u0003\u0090\u00a0\u0003\u0002\u0001\u0002\u0002\t\u0000\u00d5\u0085\u00b8l}\u00d3N\u00f50"));
    private static volatile zzae zze;
    private static final Object zzf;
    private static Context zzg;

    static {
        zzf = new Object();
    }

    static void zza(Context context) {
        synchronized (zzm.class) {
            if (zzg == null) {
                if (context == null) return;
                zzg = context.getApplicationContext();
                return;
            }
            Log.w((String)"GoogleCertificates", (String)"GoogleCertificates has been initialized already");
            return;
        }
    }

    static zzw zzb(String string, boolean bl, boolean bl2, boolean bl3) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        try {
            block12: {
                zzq zzq2;
                Preconditions.checkNotNull((Object)zzg);
                try {
                    zzm.zzf();
                }
                catch (DynamiteModule.LoadingException loadingException) {
                    Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)loadingException);
                    string = String.valueOf(loadingException.getMessage());
                    string = string.length() != 0 ? "module init: ".concat(string) : new String("module init: ");
                    string = zzw.zze((String)string, (Throwable)loadingException);
                    break block12;
                }
                Object object = new zzn(string, bl, false, (IBinder)ObjectWrapper.wrap((Object)zzg), false);
                try {
                    zzq2 = zze.zzf(object);
                }
                catch (RemoteException remoteException) {
                    Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)remoteException);
                    string = zzw.zze((String)"module call", (Throwable)remoteException);
                    break block12;
                }
                if (zzq2.zza()) {
                    string = zzw.zzb();
                } else {
                    object = zzq2.zzb();
                    string = object;
                    if (object == null) {
                        string = "error checking package certificate";
                    }
                    if (zzq2.zzc() == 4) {
                        object = new PackageManager.NameNotFoundException();
                        string = zzw.zze((String)string, (Throwable)object);
                    } else {
                        string = zzw.zzd((String)string);
                    }
                }
            }
            return string;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    static zzw zzc(String string, zzi zzi2, boolean bl, boolean bl2) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        try {
            string = zzm.zzg(string, zzi2, bl, bl2);
            return string;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    static boolean zzd() {
        Throwable throwable2;
        StrictMode.ThreadPolicy threadPolicy;
        block5: {
            boolean bl;
            threadPolicy = StrictMode.allowThreadDiskReads();
            try {
                zzm.zzf();
                bl = zze.zzg();
            }
            catch (Throwable throwable2) {
                break block5;
            }
            catch (RemoteException remoteException) {
            }
            catch (DynamiteModule.LoadingException loadingException) {
                // empty catch block
            }
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            return bl;
            {
                void var1_5;
                Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)var1_5);
            }
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            return false;
        }
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw throwable2;
    }

    static final /* synthetic */ String zze(boolean bl, String string, zzi zzi2) throws Exception {
        boolean bl2 = true;
        if (!bl && zzm.zzg((String)string, (zzi)zzi2, (boolean)true, (boolean)false).zza) return zzw.zzg((String)string, (zzi)zzi2, (boolean)bl, (boolean)bl2);
        bl2 = false;
        return zzw.zzg((String)string, (zzi)zzi2, (boolean)bl, (boolean)bl2);
    }

    private static void zzf() throws DynamiteModule.LoadingException {
        if (zze != null) {
            return;
        }
        Preconditions.checkNotNull((Object)zzg);
        Object object = zzf;
        synchronized (object) {
            if (zze != null) return;
            zze = zzad.zzb((IBinder)DynamiteModule.load((Context)zzg, (DynamiteModule.VersionPolicy)DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, (String)"com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            return;
        }
    }

    private static zzw zzg(String string, zzi zzi2, boolean bl, boolean bl2) {
        try {
            zzm.zzf();
        }
        catch (DynamiteModule.LoadingException loadingException) {
            Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)loadingException);
            string = String.valueOf(loadingException.getMessage());
            string = string.length() != 0 ? "module init: ".concat(string) : new String("module init: ");
            return zzw.zze((String)string, (Throwable)loadingException);
        }
        Preconditions.checkNotNull((Object)zzg);
        zzs zzs2 = new zzs(string, zzi2, bl, bl2);
        try {
            bl2 = zze.zze(zzs2, ObjectWrapper.wrap((Object)zzg.getPackageManager()));
            if (!bl2) return zzw.zzc((Callable)new zzd(bl, string, zzi2));
        }
        catch (RemoteException remoteException) {
            Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)remoteException);
            return zzw.zze((String)"module call", (Throwable)remoteException);
        }
        return zzw.zzb();
    }
}
