/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvc;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class zzvb
implements zzvc {
    private final ByteBuffer zza;

    public zzvb(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    public final long zza() {
        return this.zza.capacity();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void zzb(MessageDigest[] messageDigestArray, long l, int n) throws IOException {
        int n2;
        ByteBuffer byteBuffer;
        Object object = this.zza;
        synchronized (object) {
            byteBuffer = this.zza;
            n2 = (int)l;
            byteBuffer.position(n2);
            this.zza.limit(n2 + n);
            byteBuffer = this.zza.slice();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        n2 = messageDigestArray.length;
        n = 0;
        while (n < n2) {
            object = messageDigestArray[n];
            byteBuffer.position(0);
            ((MessageDigest)object).update(byteBuffer);
            ++n;
        }
    }
}
