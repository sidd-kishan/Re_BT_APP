/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgef
 *  com.google.android.gms.internal.ads.zzgej
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghq
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgin
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgef;
import com.google.android.gms.internal.ads.zzgej;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghq;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgin;
import java.io.IOException;

public class zzgfw<MessageType extends zzgga<MessageType, BuilderType>, BuilderType extends zzgfw<MessageType, BuilderType>>
extends zzgef<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb;
    private final MessageType zzc;

    protected zzgfw(MessageType MessageType) {
        this.zzc = MessageType;
        this.zza = (zzgga)MessageType.zzb(4, null, null);
        this.zzb = false;
    }

    private static final void zza(MessageType MessageType, MessageType MessageType2) {
        zzghq.zza().zzb(MessageType.getClass()).zzd(MessageType, MessageType2);
    }

    protected void zzae() {
        zzgga zzgga2 = (zzgga)this.zza.zzb(4, null, null);
        zzgfw.zza(zzgga2, this.zza);
        this.zza = zzgga2;
    }

    public final BuilderType zzaf() {
        zzgfw zzgfw2 = (zzgfw)((Object)this.zzc.zzb(5, null, null));
        zzgfw2.zzai(this.zzag());
        return (BuilderType)((Object)zzgfw2);
    }

    public MessageType zzag() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType MessageType = this.zza;
        zzghq.zza().zzb(MessageType.getClass()).zzj(MessageType);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzah() {
        MessageType MessageType = this.zzag();
        if (!MessageType.zzat()) throw new zzgin(MessageType);
        return MessageType;
    }

    public final BuilderType zzai(MessageType MessageType) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgfw.zza(this.zza, MessageType);
        return (BuilderType)((Object)this);
    }

    public final BuilderType zzaj(byte[] byArray, int n, int n2, zzgfm zzgfm2) throws zzggm {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        try {
            zzghz zzghz2 = zzghq.zza().zzb(this.zza.getClass());
            MessageType MessageType = this.zza;
            zzgej zzgej2 = new zzgej(zzgfm2);
            zzghz2.zzi(MessageType, byArray, 0, n2, zzgej2);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", iOException);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw zzggm.zzd();
        }
        catch (zzggm zzggm2) {
            throw zzggm2;
        }
        return (BuilderType)((Object)this);
    }
}
