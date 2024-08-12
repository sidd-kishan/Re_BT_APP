/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzgiy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzgiy;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

final class zzggn
extends InputStream {
    private Iterator<ByteBuffer> zza;
    private ByteBuffer zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    zzggn(Iterable<ByteBuffer> object) {
        this.zza = object.iterator();
        this.zzc = 0;
        Iterator<ByteBuffer> iterator = object.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zzd = -1;
                if (this.zza()) return;
                this.zzb = zzggk.zzd;
                this.zzd = 0;
                this.zze = 0;
                this.zzi = 0L;
                return;
            }
            object = iterator.next();
            ++this.zzc;
        }
    }

    private final boolean zza() {
        ByteBuffer byteBuffer;
        ++this.zzd;
        if (!this.zza.hasNext()) {
            return false;
        }
        this.zzb = byteBuffer = this.zza.next();
        this.zze = byteBuffer.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzgiy.zzs((ByteBuffer)this.zzb);
            this.zzg = null;
        }
        return true;
    }

    private final void zzb(int n) {
        this.zze = n = this.zze + n;
        if (n != this.zzb.limit()) return;
        this.zza();
    }

    @Override
    public final int read() throws IOException {
        int n;
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            n = this.zzg[this.zze + this.zzh];
            this.zzb(1);
        } else {
            n = this.zze;
            long l = this.zzi;
            n = zzgiy.zzr((long)((long)n + l));
            this.zzb(1);
        }
        return n & 0xFF;
    }

    @Override
    public final int read(byte[] object, int n, int n2) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int n3 = this.zzb.limit();
        int n4 = this.zze;
        int n5 = n3 - n4;
        n3 = n2;
        if (n2 > n5) {
            n3 = n5;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, n4 + this.zzh, object, n, n3);
            this.zzb(n3);
        } else {
            n2 = this.zzb.position();
            ByteBuffer byteBuffer = (ByteBuffer)this.zzb.position(this.zze);
            this.zzb.get((byte[])object, n, n3);
            object = (ByteBuffer)this.zzb.position(n2);
            this.zzb(n3);
        }
        return n3;
    }
}
