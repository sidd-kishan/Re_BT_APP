/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkm
 *  com.google.android.gms.internal.ads.zzgks
 *  com.google.android.gms.internal.ads.zzxm
 *  com.google.android.gms.internal.ads.zzxp
 *  com.google.android.gms.internal.ads.zzxq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkm;
import com.google.android.gms.internal.ads.zzgks;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxq;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public abstract class zzgkh
implements zzxp {
    private static final zzgks zza = zzgks.zzb(zzgkh.class);
    protected final String zzb;
    boolean zzc;
    boolean zzd;
    long zze;
    long zzf = -1L;
    zzgkm zzg;
    private zzxq zzh;
    private ByteBuffer zzi;
    private ByteBuffer zzj = null;

    protected zzgkh(String string) {
        this.zzb = string;
        this.zzd = true;
        this.zzc = true;
    }

    private final void zzd() {
        synchronized (this) {
            boolean bl = this.zzd;
            if (bl) return;
            try {
                zzgks zzgks2 = zza;
                String string = this.zzb;
                string = string.length() != 0 ? "mem mapping ".concat(string) : new String("mem mapping ");
                zzgks2.zza(string);
                this.zzi = this.zzg.zze(this.zze, this.zzf);
                this.zzd = true;
            }
            catch (IOException iOException) {
                RuntimeException runtimeException = new RuntimeException(iOException);
                throw runtimeException;
            }
            return;
        }
    }

    public final void zza(zzxq zzxq2) {
        this.zzh = zzxq2;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(zzgkm zzgkm2, ByteBuffer byteBuffer, long l, zzxm zzxm2) throws IOException {
        this.zze = zzgkm2.zzc();
        byteBuffer.remaining();
        this.zzf = l;
        this.zzg = zzgkm2;
        zzgkm2.zzd(zzgkm2.zzc() + l);
        this.zzd = false;
        this.zzc = false;
        this.zzg();
    }

    protected abstract void zzf(ByteBuffer var1);

    public final void zzg() {
        synchronized (this) {
            this.zzd();
            zzgks zzgks2 = zza;
            Object object = this.zzb;
            object = ((String)object).length() != 0 ? "parsing details of ".concat((String)object) : new String("parsing details of ");
            zzgks2.zza((String)object);
            object = this.zzi;
            if (object == null) return;
            this.zzc = true;
            ((Buffer)object).rewind();
            this.zzf((ByteBuffer)object);
            if (((Buffer)object).remaining() > 0) {
                this.zzj = ((ByteBuffer)object).slice();
            }
            this.zzi = null;
            return;
        }
    }
}
