/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  com.google.android.gms.internal.ads.zzvf
 *  com.google.android.gms.internal.ads.zzvi
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.internal.ads.zzvf;
import com.google.android.gms.internal.ads.zzvi;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public final class zzfie {
    protected static final byte[] zza = new byte[]{61, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, 63, 50, 108, -113, -103, 74};
    protected static final byte[] zzb = new byte[]{16, 57, 56, -18, 69, 55, -27, -98, -114, -25, -110, -10, 84, 80, 79, -72, 52, 111, -58, -77, 70, -48, -69, -60, 65, 95, -61, 57, -4, -4, -114, -63};
    private final byte[] zzc = zzb;
    private final byte[] zzd = zza;

    /*
     * WARNING - void declaration
     */
    public final boolean zza(File object) throws GeneralSecurityException {
        void var1_4;
        block6: {
            object = object.getAbsolutePath();
            try {
                object = zzvi.zza((String)object);
            }
            catch (RuntimeException runtimeException) {
                break block6;
            }
            catch (IOException iOException) {
                // empty catch block
                break block6;
            }
            catch (zzvf zzvf2) {
                throw new GeneralSecurityException("Package is not signed", zzvf2);
            }
            int n = ((X509Certificate[][])object).length;
            boolean bl = true;
            if (n != 1) throw new GeneralSecurityException("APK has more than one signature.");
            object = object[0][0];
            object = MessageDigest.getInstance("SHA-256").digest(object.getEncoded());
            boolean bl2 = bl;
            if (Arrays.equals(this.zzd, (byte[])object)) return bl2;
            if (!"user".equals(Build.TYPE)) {
                if (!Arrays.equals(this.zzc, (byte[])object)) return false;
                bl2 = bl;
            } else {
                bl2 = false;
            }
            return bl2;
        }
        throw new GeneralSecurityException("Failed to verify signatures", (Throwable)var1_4);
    }
}
