/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkm
 *  com.google.android.gms.internal.ads.zzxk
 *  com.google.android.gms.internal.ads.zzxm
 *  com.google.android.gms.internal.ads.zzxo
 *  com.google.android.gms.internal.ads.zzxp
 *  com.google.android.gms.internal.ads.zzxq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkm;
import com.google.android.gms.internal.ads.zzxk;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxo;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxq;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzxl
implements zzxm {
    private static final Logger zzb = Logger.getLogger(zzxl.class.getName());
    final ThreadLocal<ByteBuffer> zza = new zzxk(this);

    public abstract zzxp zza(String var1, byte[] var2, String var3);

    public final zzxp zzb(zzgkm object, zzxq object2) throws IOException {
        Object object3;
        Object object4;
        Object object5;
        int n;
        long l;
        block7: {
            block6: {
                l = object.zzc();
                this.zza.get().rewind().limit(8);
                while ((n = object.zza(this.zza.get())) != 8) {
                    if (n >= 0) continue;
                    object.zzd(l);
                    throw new EOFException();
                }
                this.zza.get().rewind();
                l = zzxo.zza((ByteBuffer)this.zza.get());
                object5 = null;
                if (l < 8L && l > 1L) {
                    object2 = zzb;
                    object = Level.SEVERE;
                    object5 = new StringBuilder(80);
                    ((StringBuilder)object5).append("Plausibility check failed: size < 8 (size = ");
                    ((StringBuilder)object5).append(l);
                    ((StringBuilder)object5).append("). Stop parsing!");
                    ((Logger)object2).logp((Level)object, "com.coremedia.iso.AbstractBoxParser", "parseBox", ((StringBuilder)object5).toString());
                    return null;
                }
                object4 = this.zza.get();
                object3 = new byte[4];
                ((ByteBuffer)object4).get((byte[])object3);
                try {
                    object4 = new String((byte[])object3, "ISO-8859-1");
                    if (l != 1L) break block6;
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    RuntimeException runtimeException = new RuntimeException(unsupportedEncodingException);
                    throw runtimeException;
                }
                this.zza.get().limit(16);
                object.zza(this.zza.get());
                this.zza.get().position(8);
                l = zzxo.zzd((ByteBuffer)this.zza.get()) - 16L;
                break block7;
            }
            l = l == 0L ? object.zzb() - object.zzc() : (l -= 8L);
        }
        long l2 = l;
        if ("uuid".equals(object4)) {
            this.zza.get().limit(this.zza.get().limit() + 16);
            object.zza(this.zza.get());
            object5 = new byte[16];
            for (n = this.zza.get().position() - 16; n < this.zza.get().position(); ++n) {
                object5[n - (this.zza.get().position() - 16)] = this.zza.get().get(n);
            }
            l2 = l - 16L;
        }
        object3 = object2 instanceof zzxp ? (Object)((zzxp)object2).zzb() : (Object)"";
        object5 = this.zza((String)object4, (byte[])object5, (String)object3);
        object5.zza((zzxq)object2);
        this.zza.get().rewind();
        object5.zzc(object, this.zza.get(), l2, (zzxm)this);
        return object5;
    }
}
