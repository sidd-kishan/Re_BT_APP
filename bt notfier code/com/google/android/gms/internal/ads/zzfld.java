/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ClipData
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  com.google.android.gms.internal.ads.zzflx
 */
package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.internal.ads.zzflx;
import javax.annotation.Nullable;

public final class zzfld {
    public static final int zza;
    public static final ClipData zzb;

    static {
        int n = Build.VERSION.SDK_INT > 22 ? 0x4000000 : 0;
        zza = n;
        zzb = ClipData.newIntent((CharSequence)"", (Intent)new Intent());
    }

    @Nullable
    public static PendingIntent zza(Context context, int n, Intent intent, int n2, int n3) {
        boolean bl = true;
        boolean bl2 = (n2 & 0x5F) == 0;
        zzflx.zza((boolean)bl2, (Object)"Cannot set any dangerous parts of intent to be mutable.");
        bl2 = intent.getComponent() != null;
        zzflx.zza((boolean)bl2, (Object)"Must set component on Intent.");
        if (zzfld.zzb(0, 1)) {
            zzflx.zza((boolean)(zzfld.zzb(n2, 0x4000000) ^ true), (Object)"Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            bl2 = bl;
            if (Build.VERSION.SDK_INT >= 23) {
                bl2 = zzfld.zzb(n2, 0x4000000) ? bl : false;
            }
            zzflx.zza((boolean)bl2, (Object)"Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        intent = new Intent(intent);
        if (Build.VERSION.SDK_INT >= 23) {
            if (zzfld.zzb(n2, 0x4000000)) return PendingIntent.getService((Context)context, (int)0, (Intent)intent, (int)n2);
        }
        if (intent.getPackage() == null) {
            intent.setPackage(intent.getComponent().getPackageName());
        }
        if (!zzfld.zzb(0, 3) && intent.getAction() == null) {
            intent.setAction("");
        }
        if (!zzfld.zzb(0, 9) && intent.getCategories() == null) {
            intent.addCategory("");
        }
        if (!zzfld.zzb(0, 5) && intent.getData() == null) {
            intent.setDataAndType(Uri.EMPTY, "*/*");
        }
        if (zzfld.zzb(0, 17)) return PendingIntent.getService((Context)context, (int)0, (Intent)intent, (int)n2);
        if (intent.getClipData() != null) return PendingIntent.getService((Context)context, (int)0, (Intent)intent, (int)n2);
        intent.setClipData(zzb);
        return PendingIntent.getService((Context)context, (int)0, (Intent)intent, (int)n2);
    }

    private static boolean zzb(int n, int n2) {
        if ((n & n2) != n2) return false;
        return true;
    }
}
