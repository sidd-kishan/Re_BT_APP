/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfve
 *  com.google.android.gms.internal.ads.zzfvf
 *  com.google.android.gms.internal.ads.zzfys
 *  com.google.android.gms.internal.ads.zzfyu
 *  com.google.android.gms.internal.ads.zzfyv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfve;
import com.google.android.gms.internal.ads.zzfvf;
import com.google.android.gms.internal.ads.zzfys;
import com.google.android.gms.internal.ads.zzfyu;
import com.google.android.gms.internal.ads.zzfyv;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class zzfvg
extends zzftu<zzfys> {
    zzfvg() {
        super(zzfys.class, new zzftt[]{new zzfve(zzftg.class)});
    }

    public static void zzk(boolean bl) throws GeneralSecurityException {
        if (!zzfvg.zzm()) return;
        zzfum.zzc((zzftu)new zzfvg(), (boolean)true);
    }

    static /* synthetic */ zzftr<zzfyv> zzl(int n, int n2) {
        zzfyu zzfyu2 = zzfyv.zzd();
        zzfyu2.zza(n);
        return new zzftr((Object)((zzfyv)zzfyu2.zzah()), n2);
    }

    private static boolean zzm() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException generalSecurityException) {
            return false;
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final zzfts<zzfyv, zzfys> zzh() {
        return new zzfvf(this, zzfyv.class);
    }

    public final int zzi() {
        return 3;
    }
}
