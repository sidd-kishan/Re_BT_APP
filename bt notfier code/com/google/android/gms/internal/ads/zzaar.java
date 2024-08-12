/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzaaq
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacg
 *  com.google.android.gms.internal.ads.zzyc
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaaq;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacg;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyj;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzaar
extends zzaaq {
    protected zzaar(Context context, String string, boolean bl) {
        super(context, string, bl);
    }

    public static zzaar zzs(String string, Context context, boolean bl) {
        zzaar.zzf((Context)context, (boolean)false);
        return new zzaar(context, string, false);
    }

    @Deprecated
    public static zzaar zzt(String string, Context context, boolean bl, int n) {
        zzaar.zzf((Context)context, (boolean)bl);
        return new zzaar(context, string, bl);
    }

    protected final List<Callable<Void>> zzi(zzabr zzabr2, Context context, zzyj zzyj2, zzyc object) {
        if (zzabr2.zze() == null) return super.zzi(zzabr2, context, zzyj2, null);
        if (!this.zzt) {
            return super.zzi(zzabr2, context, zzyj2, null);
        }
        int n = zzabr2.zzu();
        object = new ArrayList();
        object.addAll(super.zzi(zzabr2, context, zzyj2, null));
        object.add(new zzacg(zzabr2, "NSYe0Ak7CUXd9zFZA3bczJ8pTgBK/kfUu9ICpHR+lQrTNc8+V7Owo49e2WIp0407", "Ux7t0A/7z2bV/IDvLZJgV4tTxr0Vvc1KngWKlG2Szwg=", zzyj2, n, 24));
        return object;
    }
}
