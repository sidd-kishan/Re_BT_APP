/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.IOUtils
 *  com.google.android.gms.internal.ads.zzcbh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzcbh;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class zzcbg
implements Runnable {
    private final OutputStream zza;
    private final byte[] zzb;

    zzcbg(OutputStream outputStream, byte[] byArray) {
        this.zza = outputStream;
        this.zzb = byArray;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    @Override
    public final void run() {
        Object object;
        Object object2;
        OutputStream outputStream;
        block8: {
            block10: {
                block9: {
                    outputStream = this.zza;
                    byte[] byArray = this.zzb;
                    object2 = zzcbh.CREATOR;
                    Object var4_5 = null;
                    DataOutputStream dataOutputStream = null;
                    object2 = dataOutputStream;
                    try {
                        object2 = dataOutputStream;
                        object = new DataOutputStream(outputStream);
                    }
                    catch (Throwable throwable) {
                        break block8;
                    }
                    catch (IOException iOException) {
                        object = var4_5;
                        break block9;
                    }
                    try {
                        ((DataOutputStream)object).writeInt(byArray.length);
                        ((FilterOutputStream)object).write(byArray);
                    }
                    catch (Throwable throwable) {
                        dataOutputStream = object;
                        object = throwable;
                        object2 = dataOutputStream;
                        break block8;
                    }
                    catch (IOException iOException) {
                        break block9;
                    }
                    IOUtils.closeQuietly((Closeable)object);
                    return;
                }
                object2 = object;
                {
                    void var3_9;
                    zze.zzg((String)"Error transporting the ad response", (Throwable)var3_9);
                    object2 = object;
                    zzt.zzg().zzk((Throwable)var3_9, "LargeParcelTeleporter.pipeData.1");
                    if (object != null) break block10;
                }
                IOUtils.closeQuietly((Closeable)outputStream);
                return;
            }
            IOUtils.closeQuietly((Closeable)object);
            return;
        }
        if (object2 == null) {
            IOUtils.closeQuietly((Closeable)outputStream);
            throw object;
        }
        IOUtils.closeQuietly((Closeable)object2);
        throw object;
    }
}
