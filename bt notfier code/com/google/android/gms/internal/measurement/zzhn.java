/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgb
 *  com.google.android.gms.internal.measurement.zzgf
 *  com.google.android.gms.internal.measurement.zzhd
 *  com.google.android.gms.internal.measurement.zzhr
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zzje
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzju
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzhd;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzje;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzju;
import java.io.IOException;

public class zzhn<MessageType extends zzhr<MessageType, BuilderType>, BuilderType extends zzhn<MessageType, BuilderType>>
extends zzgb<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb;
    private final MessageType zzc;

    protected zzhn(MessageType MessageType) {
        this.zzc = MessageType;
        this.zza = (zzhr)MessageType.zzl(4, null, null);
        this.zzb = false;
    }

    private static final void zza(MessageType MessageType, MessageType MessageType2) {
        zzje.zza().zzb(MessageType.getClass()).zzd(MessageType, MessageType2);
    }

    public final MessageType zzaA() {
        MessageType MessageType = this.zzaz();
        boolean bl = Boolean.TRUE;
        boolean bl2 = true;
        byte by = (Byte)MessageType.zzl(1, null, null);
        if (by != 1) {
            if (by == 0) {
                bl2 = false;
            } else {
                bl2 = zzje.zza().zzb(MessageType.getClass()).zzj(MessageType);
                if (bl) {
                    Object var4_5 = true != bl2 ? null : MessageType;
                    MessageType.zzl(2, var4_5, null);
                }
            }
        }
        if (!bl2) throw new zzju(MessageType);
        return MessageType;
    }

    public final BuilderType zzaB(MessageType MessageType) {
        if (this.zzb) {
            this.zzax();
            this.zzb = false;
        }
        zzhn.zza(this.zza, MessageType);
        return (BuilderType)((Object)this);
    }

    public final BuilderType zzaC(byte[] byArray, int n, int n2, zzhd zzhd2) throws zzib {
        if (this.zzb) {
            this.zzax();
            this.zzb = false;
        }
        try {
            zzjh zzjh2 = zzje.zza().zzb(this.zza.getClass());
            MessageType MessageType = this.zza;
            zzgf zzgf2 = new zzgf(zzhd2);
            zzjh2.zzh(MessageType, byArray, 0, n2, zzgf2);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", iOException);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw zzib.zza();
        }
        catch (zzib zzib2) {
            throw zzib2;
        }
        return (BuilderType)((Object)this);
    }

    protected void zzax() {
        zzhr zzhr2 = (zzhr)this.zza.zzl(4, null, null);
        zzhn.zza(zzhr2, this.zza);
        this.zza = zzhr2;
    }

    public final BuilderType zzay() {
        zzhn zzhn2 = (zzhn)((Object)this.zzc.zzl(5, null, null));
        zzhn2.zzaB(this.zzaz());
        return (BuilderType)((Object)zzhn2);
    }

    public MessageType zzaz() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType MessageType = this.zza;
        zzje.zza().zzb(MessageType.getClass()).zzi(MessageType);
        this.zzb = true;
        return this.zza;
    }
}
