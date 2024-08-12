/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaiz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaiz;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class zzaja {
    private final ByteArrayOutputStream zza = new ByteArrayOutputStream(512);
    private final DataOutputStream zzb = new DataOutputStream(this.zza);

    private static void zzb(DataOutputStream dataOutputStream, String string) throws IOException {
        dataOutputStream.writeBytes(string);
        dataOutputStream.writeByte(0);
    }

    public final byte[] zza(zzaiz object) {
        this.zza.reset();
        try {
            String string;
            zzaja.zzb(this.zzb, object.zza);
            String string2 = string = object.zzb;
            if (string == null) {
                string2 = "";
            }
            zzaja.zzb(this.zzb, string2);
            this.zzb.writeLong(object.zzc);
            this.zzb.writeLong(object.zzd);
            this.zzb.write(object.zze);
            this.zzb.flush();
            object = this.zza.toByteArray();
            return object;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }
}
