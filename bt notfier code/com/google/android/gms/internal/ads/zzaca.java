/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.provider.Settings$SettingNotFoundException
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzaca
extends zzacz {
    public zzaca(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "pECbn1i7ArZz8HseR71ZVkvFfTp84DNv2haWC1WmGQudMO74UcIxEa2NyELtzZhK", "LbaQh8VAFWEQeupBiMdSh8EgMse5yKT8p6jkCYTG+aQ=", zzyj2, n, 49);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzW(3);
        try {
            Method method = this.zzf;
            int n = 1;
            boolean bl = (Boolean)method.invoke(null, this.zzb.zzc());
            method = this.zze;
            if (bl) {
                n = 2;
            }
            method.zzW(n);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (!(invocationTargetException.getTargetException() instanceof Settings.SettingNotFoundException)) throw invocationTargetException;
            return;
        }
    }
}
