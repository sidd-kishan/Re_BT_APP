/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaah
 *  com.google.android.gms.internal.ads.zzabs
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzgee
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzyj
 *  com.google.android.gms.internal.ads.zzyz
 *  com.google.android.gms.internal.ads.zzzl
 *  com.google.android.gms.internal.ads.zzzm
 *  com.google.android.gms.internal.ads.zzzo
 *  com.google.android.gms.internal.ads.zzzq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaah;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzgee;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzyz;
import com.google.android.gms.internal.ads.zzzl;
import com.google.android.gms.internal.ads.zzzm;
import com.google.android.gms.internal.ads.zzzo;
import com.google.android.gms.internal.ads.zzzq;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzzs {
    static boolean zza;
    static final CountDownLatch zzb;
    private static MessageDigest zzc;
    private static final Object zzd;
    private static final Object zze;

    static {
        zzd = new Object();
        zze = new Object();
        zzb = new CountDownLatch(1);
    }

    static /* synthetic */ MessageDigest zza(MessageDigest messageDigest) {
        zzc = messageDigest;
        return messageDigest;
    }

    static void zzb() {
        Object object = zze;
        synchronized (object) {
            if (zza) return;
            zza = true;
            zzzq zzzq2 = new zzzq(null);
            Thread thread = new Thread((Runnable)zzzq2);
            thread.start();
            return;
        }
    }

    static String zzc(zzyz object, String object2) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] byArray = object.zzao();
        object = zzbjl.zzbR;
        if (!((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
            if (zzabs.zza == null) throw new GeneralSecurityException();
            object = object2 != null ? (Object)((String)object2).getBytes() : (Object)new byte[0];
            object2 = zzabs.zza.zza(byArray, (byte[])object);
            object = zzzm.zza();
            object.zza(zzgex.zzt((byte[])object2));
            object.zzc(3);
            object = ((zzzm)object.zzah()).zzao();
        } else {
            object = zzzs.zzd(byArray, 255);
            if (object != null && ((Vector)object).size() != 0) {
                zzzl zzzl2 = zzzm.zza();
                int n = object.size();
                for (int i = 0; i < n; ++i) {
                    zzzl2.zza(zzgex.zzt((byte[])zzzs.zzg((byte[])object.get(i), (String)object2, false)));
                }
                zzzl2.zzb(zzgex.zzt((byte[])zzzs.zze(byArray)));
                object = ((zzzm)zzzl2.zzah()).zzao();
            } else {
                object = zzzs.zzg(zzzs.zzf(4096).zzao(), (String)object2, true);
            }
        }
        return zzzo.zza((byte[])object, (boolean)true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    static Vector<byte[]> zzd(byte[] byArray, int n) {
        if (byArray == null) return null;
        n = byArray.length;
        if (n <= 0) {
            return null;
        }
        int n2 = (n + 254) / 255;
        Vector<byte[]> vector = new Vector<byte[]>();
        n = 0;
        while (n < n2) {
            int n3;
            int n4 = n * 255;
            try {
                int n5;
                n3 = n5 = byArray.length;
                if (n5 - n4 > 255) {
                    n3 = n4 + 255;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                return null;
            }
            {
                vector.add(Arrays.copyOfRange(byArray, n4, n3));
                ++n;
            }
        }
        return vector;
    }

    public static byte[] zze(byte[] object) throws NoSuchAlgorithmException {
        Object object2 = zzd;
        synchronized (object2) {
            zzzs.zzb();
            MessageDigest messageDigest = null;
            try {
                boolean bl = zzb.await(2L, TimeUnit.SECONDS);
                if (bl && zzc != null) {
                    messageDigest = zzc;
                }
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            if (messageDigest != null) {
                messageDigest.reset();
                messageDigest.update((byte[])object);
                object = zzc.digest();
                return object;
            }
            object = new NoSuchAlgorithmException;
            object("Cannot compute hash");
            throw object;
        }
    }

    static zzyz zzf(int n) {
        zzyj zzyj2 = zzyz.zzi();
        zzyj2.zzl(4096L);
        return (zzyz)zzyj2.zzah();
    }

    private static byte[] zzg(byte[] object, String string, boolean bl) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int n;
        int n2 = true != bl ? 255 : 239;
        byte[] byArray = object;
        if (((byte[])object).length > n2) {
            byArray = zzzs.zzf(4096).zzao();
        }
        if ((n = byArray.length) < n2) {
            object = new byte[n2 - n];
            new SecureRandom().nextBytes((byte[])object);
            object = ByteBuffer.allocate(n2 + 1).put((byte)n).put(byArray).put((byte[])object).array();
        } else {
            object = ByteBuffer.allocate(n2 + 1).put((byte)n).put(byArray).array();
        }
        byArray = object;
        if (bl) {
            byArray = zzzs.zze(object);
            byArray = ByteBuffer.allocate(256).put(byArray).put((byte[])object).array();
        }
        byte[] byArray2 = new byte[256];
        object = new zzaah().zzcG;
        n2 = ((byte[])object).length;
        for (n2 = 0; n2 < 12; ++n2) {
            object[n2].zza(byArray, byArray2);
        }
        if (string == null) return byArray2;
        if (string.length() <= 0) return byArray2;
        object = string;
        if (string.length() > 32) {
            object = string.substring(0, 32);
        }
        new zzgee(object.getBytes("UTF-8")).zza(byArray2);
        return byArray2;
    }
}
