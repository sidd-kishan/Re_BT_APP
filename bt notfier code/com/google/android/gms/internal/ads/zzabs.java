/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzftl
 *  com.google.android.gms.internal.ads.zzftm
 *  com.google.android.gms.internal.ads.zzftv
 *  com.google.android.gms.internal.ads.zzftz
 *  com.google.android.gms.internal.ads.zzfue
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfwj
 *  com.google.android.gms.internal.ads.zzfwm
 *  com.google.android.gms.internal.ads.zzgax
 *  com.google.android.gms.internal.ads.zzzo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzftl;
import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzftv;
import com.google.android.gms.internal.ads.zzftz;
import com.google.android.gms.internal.ads.zzfue;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfwj;
import com.google.android.gms.internal.ads.zzfwm;
import com.google.android.gms.internal.ads.zzgax;
import com.google.android.gms.internal.ads.zzzo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.util.Iterator;

final class zzabs {
    static zzftl zza;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    static boolean zza(zzabr object) throws IllegalAccessException, InvocationTargetException {
        block12: {
            String string;
            Object object2;
            block14: {
                block13: {
                    if (zza != null) {
                        return true;
                    }
                    object2 = zzbjl.zzbQ;
                    string = (String)zzbet.zzc().zzc(object2);
                    if (string == null) break block13;
                    object2 = string;
                    if (string.length() != 0) break block14;
                }
                object2 = null;
                object = object == null ? object2 : ((object = object.zzq("wC9I8kYd+RKAHfQkBEAJYQw7avQUH+U9s6BQ/SJiEcKjDl2sT+FDEb6J3VYVY+ui", "FSkZmgTbP/gL1jHU7M+TcfgVpePk57vWMdHk6knGCa4=")) == null ? object2 : (String)((Method)object).invoke(null, new Object[0]));
                if (object == null) return false;
                object2 = object;
            }
            try {
                object = zzzo.zzb((String)object2, (boolean)true);
            }
            catch (IllegalArgumentException exception) {
                break block12;
            }
            {
                object = zzftz.zza((byte[])object);
                Iterator iterator = zzfwj.zza.zza().iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        object = zzfwm.zza((zzftv)object);
                        zza = object;
                        if (object == null) return false;
                        return true;
                    }
                    object2 = (zzgax)iterator.next();
                    if (object2.zzc().isEmpty()) {
                        object = new GeneralSecurityException("Missing type_url.");
                        throw object;
                    }
                    if (object2.zza().isEmpty()) {
                        object = new GeneralSecurityException("Missing primitive_name.");
                        throw object;
                    }
                    if (object2.zzf().isEmpty()) {
                        object = new GeneralSecurityException("Missing catalogue_name.");
                        throw object;
                    }
                    if (object2.zzf().equals("TinkAead") || object2.zzf().equals("TinkMac") || object2.zzf().equals("TinkHybridDecrypt") || object2.zzf().equals("TinkHybridEncrypt") || object2.zzf().equals("TinkPublicKeySign") || object2.zzf().equals("TinkPublicKeyVerify") || object2.zzf().equals("TinkStreamingAead") || object2.zzf().equals("TinkDeterministicAead")) continue;
                    string = zzfum.zza((String)object2.zzf());
                    zzfum.zze((zzfue)string.zza());
                    object2.zzc();
                    object2.zza();
                    object2.zzd();
                    zzfum.zzb((zzftm)string.zzb(), (boolean)object2.zze());
                }
            }
        }
        return false;
    }
}
