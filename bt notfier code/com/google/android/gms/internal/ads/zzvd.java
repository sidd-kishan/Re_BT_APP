/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvc;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

final class zzvd
implements zzvc {
    private final FileChannel zza;
    private final long zzb;
    private final long zzc;

    public zzvd(FileChannel fileChannel, long l, long l2) {
        this.zza = fileChannel;
        this.zzb = l;
        this.zzc = l2;
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb(MessageDigest[] messageDigestArray, long l, int n) throws IOException {
        long l2 = this.zzb;
        MappedByteBuffer mappedByteBuffer = this.zza.map(FileChannel.MapMode.READ_ONLY, l2 + l, n);
        mappedByteBuffer.load();
        int n2 = messageDigestArray.length;
        n = 0;
        while (n < n2) {
            MessageDigest messageDigest = messageDigestArray[n];
            mappedByteBuffer.position(0);
            messageDigest.update(mappedByteBuffer);
            ++n;
        }
    }
}
