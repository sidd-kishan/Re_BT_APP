/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkj
 *  com.google.android.gms.internal.ads.zzgko
 *  com.google.android.gms.internal.ads.zzgkt
 *  com.google.android.gms.internal.ads.zzxo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkj;
import com.google.android.gms.internal.ads.zzgko;
import com.google.android.gms.internal.ads.zzgkt;
import com.google.android.gms.internal.ads.zzxo;
import java.nio.ByteBuffer;
import java.util.Date;

public final class zzxs
extends zzgkj {
    private Date zza;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk = 1.0;
    private float zzl = 1.0f;
    private zzgkt zzm = zzgkt.zzj;
    private long zzn;

    public zzxs() {
        super("mvhd");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MovieHeaderBox[creationTime=");
        stringBuilder.append(this.zza);
        stringBuilder.append(";modificationTime=");
        stringBuilder.append(this.zzh);
        stringBuilder.append(";timescale=");
        stringBuilder.append(this.zzi);
        stringBuilder.append(";duration=");
        stringBuilder.append(this.zzj);
        stringBuilder.append(";rate=");
        stringBuilder.append(this.zzk);
        stringBuilder.append(";volume=");
        stringBuilder.append(this.zzl);
        stringBuilder.append(";matrix=");
        stringBuilder.append(this.zzm);
        stringBuilder.append(";nextTrackId=");
        stringBuilder.append(this.zzn);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final long zzd() {
        return this.zzi;
    }

    public final long zze() {
        return this.zzj;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        this.zzi(byteBuffer);
        if (this.zzh() == 1) {
            this.zza = zzgko.zza((long)zzxo.zzd((ByteBuffer)byteBuffer));
            this.zzh = zzgko.zza((long)zzxo.zzd((ByteBuffer)byteBuffer));
            this.zzi = zzxo.zza((ByteBuffer)byteBuffer);
            this.zzj = zzxo.zzd((ByteBuffer)byteBuffer);
        } else {
            this.zza = zzgko.zza((long)zzxo.zza((ByteBuffer)byteBuffer));
            this.zzh = zzgko.zza((long)zzxo.zza((ByteBuffer)byteBuffer));
            this.zzi = zzxo.zza((ByteBuffer)byteBuffer);
            this.zzj = zzxo.zza((ByteBuffer)byteBuffer);
        }
        this.zzk = zzxo.zze((ByteBuffer)byteBuffer);
        byte[] byArray = new byte[2];
        byteBuffer.get(byArray);
        short s = (short)(byArray[0] << 8 & 0xFF00);
        this.zzl = (float)((short)(byArray[1] & 0xFF | s)) / 256.0f;
        zzxo.zzb((ByteBuffer)byteBuffer);
        zzxo.zza((ByteBuffer)byteBuffer);
        zzxo.zza((ByteBuffer)byteBuffer);
        this.zzm = zzgkt.zza((ByteBuffer)byteBuffer);
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzxo.zza((ByteBuffer)byteBuffer);
    }
}
