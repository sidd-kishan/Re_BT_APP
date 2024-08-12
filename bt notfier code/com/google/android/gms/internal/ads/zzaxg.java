/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64OutputStream
 *  com.google.android.gms.ads.internal.util.zze
 */
package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.zze;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class zzaxg {
    ByteArrayOutputStream zza = new ByteArrayOutputStream(4096);
    Base64OutputStream zzb = new Base64OutputStream((OutputStream)this.zza, 10);

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final String toString() {
        Throwable throwable2222222;
        try {
            this.zzb.close();
        }
        catch (IOException iOException) {
            zze.zzg((String)"HashManager: Unable to convert to Base64.", (Throwable)iOException);
        }
        this.zza.close();
        String string = this.zza.toString();
        this.zza = null;
        this.zzb = null;
        return string;
        {
            catch (Throwable throwable2222222) {
            }
            catch (IOException iOException) {}
            {
                zze.zzg((String)"HashManager: Unable to convert to Base64.", (Throwable)iOException);
                this.zza = null;
                this.zzb = null;
                return "";
            }
        }
        this.zza = null;
        this.zzb = null;
        throw throwable2222222;
    }
}
