/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkh;
import java.nio.ByteBuffer;

public final class zzxt
extends zzgkh {
    ByteBuffer zza;

    public zzxt(String string) {
        super(string);
    }

    public final void zzf(ByteBuffer byteBuffer) {
        this.zza = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
