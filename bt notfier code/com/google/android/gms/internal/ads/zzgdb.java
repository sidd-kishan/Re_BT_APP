/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfvx
 *  com.google.android.gms.internal.ads.zzgdc
 *  com.google.android.gms.internal.ads.zzgdd
 *  com.google.android.gms.internal.ads.zzgde
 *  com.google.android.gms.internal.ads.zzgdf
 *  com.google.android.gms.internal.ads.zzgdg
 *  com.google.android.gms.internal.ads.zzgdh
 *  com.google.android.gms.internal.ads.zzgdi
 *  com.google.android.gms.internal.ads.zzgdj
 *  com.google.android.gms.internal.ads.zzgdt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfvx;
import com.google.android.gms.internal.ads.zzgdc;
import com.google.android.gms.internal.ads.zzgdd;
import com.google.android.gms.internal.ads.zzgde;
import com.google.android.gms.internal.ads.zzgdf;
import com.google.android.gms.internal.ads.zzgdg;
import com.google.android.gms.internal.ads.zzgdh;
import com.google.android.gms.internal.ads.zzgdi;
import com.google.android.gms.internal.ads.zzgdj;
import com.google.android.gms.internal.ads.zzgdt;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzgdb<T_WRAPPER extends zzgdj<T_ENGINE>, T_ENGINE> {
    public static final zzgdb<zzgdc, Cipher> zza;
    public static final zzgdb<zzgdg, Mac> zzb;
    public static final zzgdb<zzgdi, Signature> zzc;
    public static final zzgdb<zzgdh, MessageDigest> zzd;
    public static final zzgdb<zzgdd, KeyAgreement> zze;
    public static final zzgdb<zzgdf, KeyPairGenerator> zzf;
    public static final zzgdb<zzgde, KeyFactory> zzg;
    private static final Logger zzh;
    private static final List<Provider> zzi;
    private static final boolean zzj;
    private final T_WRAPPER zzk;

    static {
        zzh = Logger.getLogger(zzgdb.class.getName());
        if (zzfvx.zza()) {
            zzi = zzgdb.zza("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt");
            zzj = false;
        } else if (zzgdt.zza()) {
            zzi = zzgdb.zza("GmsCore_OpenSSL", "AndroidOpenSSL");
            zzj = true;
        } else {
            zzi = new ArrayList<Provider>();
            zzj = true;
        }
        zza = new zzgdb(new zzgdc());
        zzb = new zzgdb(new zzgdg());
        zzc = new zzgdb(new zzgdi());
        zzd = new zzgdb(new zzgdh());
        zze = new zzgdb(new zzgdd());
        zzf = new zzgdb(new zzgdf());
        zzg = new zzgdb(new zzgde());
    }

    public zzgdb(T_WRAPPER T_WRAPPER) {
        this.zzk = T_WRAPPER;
    }

    public static List<Provider> zza(String ... stringArray) {
        ArrayList<Provider> arrayList = new ArrayList<Provider>();
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            Provider provider = Security.getProvider(string);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", string));
            }
            ++n2;
        }
        return arrayList;
    }

    public final T_ENGINE zzb(String object) throws GeneralSecurityException {
        Iterator<Provider> iterator = zzi.iterator();
        Exception exception = null;
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            try {
                object2 = this.zzk.zza((String)object, (Provider)object2);
            }
            catch (Exception exception2) {
                if (exception != null) continue;
                exception = exception2;
                continue;
            }
            return (T_ENGINE)object2;
        }
        if (zzj) {
            return (T_ENGINE)this.zzk.zza((String)object, null);
        }
        object = new GeneralSecurityException("No good Provider found.", exception);
        throw object;
    }
}
