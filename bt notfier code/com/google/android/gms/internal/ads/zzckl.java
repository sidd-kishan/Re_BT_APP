/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzckk
 *  com.google.android.gms.internal.ads.zzckn
 *  com.google.android.gms.internal.ads.zzgkm
 *  com.google.android.gms.internal.ads.zzxm
 *  com.google.android.gms.internal.ads.zzxn
 *  com.google.android.gms.internal.ads.zzxp
 *  com.google.android.gms.internal.ads.zzxr
 *  com.google.android.gms.internal.ads.zzxs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzckk;
import com.google.android.gms.internal.ads.zzckn;
import com.google.android.gms.internal.ads.zzgkm;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxr;
import com.google.android.gms.internal.ads.zzxs;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class zzckl {
    private long zza;

    public final long zza(ByteBuffer object) {
        long l = this.zza;
        if (l > 0L) {
            return l;
        }
        try {
            block6: {
                Object object2;
                ByteBuffer byteBuffer;
                block7: {
                    block5: {
                        byteBuffer = ((ByteBuffer)object).duplicate();
                        byteBuffer.flip();
                        object = new zzckk(byteBuffer);
                        byteBuffer = new zzxn((zzgkm)object, (zzxm)zzckn.zzb);
                        object = byteBuffer.zzd().iterator();
                        do {
                            boolean bl = object.hasNext();
                            byteBuffer = null;
                            if (!bl) break block5;
                        } while (!((object2 = (zzxp)object.next()) instanceof zzxr));
                        object = (zzxr)object2;
                        break block7;
                    }
                    object = null;
                }
                object2 = object.zzd().iterator();
                do {
                    object = byteBuffer;
                    if (!object2.hasNext()) break block6;
                } while (!((object = (zzxp)object2.next()) instanceof zzxs));
                object = (zzxs)object;
            }
            this.zza = l = object.zze() * 1000L / object.zzd();
            return l;
        }
        catch (IOException | RuntimeException exception) {
            return 0L;
        }
    }
}
