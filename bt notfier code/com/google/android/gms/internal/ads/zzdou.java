/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  com.google.android.gms.ads.internal.util.zzbr
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdot
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdot;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzdou {
    private final zzbr zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdou(zzbr zzbr2, Clock clock, Executor executor) {
        this.zza = zzbr2;
        this.zzb = clock;
        this.zzc = executor;
    }

    static /* synthetic */ Bitmap zzb(zzdou zzdou2, byte[] byArray, double d, boolean bl) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int)(d * 160.0);
        if (!bl) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        zzbjd zzbjd2 = zzbjl.zzeu;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return zzdou2.zzc(byArray, options);
        options.inJustDecodeBounds = true;
        zzdou2.zzc(byArray, options);
        options.inJustDecodeBounds = false;
        int n = options.outWidth * options.outHeight;
        if (n <= 0) return zzdou2.zzc(byArray, options);
        zzbjd2 = zzbjl.zzev;
        options.inSampleSize = 1 << (33 - Integer.numberOfLeadingZeros((n - 1) / (Integer)zzbet.zzc().zzc(zzbjd2))) / 2;
        return zzdou2.zzc(byArray, options);
    }

    private final Bitmap zzc(byte[] object, BitmapFactory.Options options) {
        long l = this.zzb.elapsedRealtime();
        int n = ((byte[])object).length;
        boolean bl = false;
        options = BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)n, (BitmapFactory.Options)options);
        long l2 = this.zzb.elapsedRealtime();
        if (Build.VERSION.SDK_INT < 19) return options;
        if (options == null) return options;
        int n2 = options.getWidth();
        n = options.getHeight();
        int n3 = options.getAllocationByteCount();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            bl = true;
        }
        object = new StringBuilder(108);
        ((StringBuilder)object).append("Decoded image w: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" h:");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" bytes: ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(" time: ");
        ((StringBuilder)object).append(l2 - l);
        ((StringBuilder)object).append(" on ui thread: ");
        ((StringBuilder)object).append(bl);
        zze.zza((String)((StringBuilder)object).toString());
        return options;
    }

    public final zzfsm<Bitmap> zza(String string, double d, boolean bl) {
        return zzfsd.zzj((zzfsm)this.zza.zza(string), (zzfln)new zzdot(this, d, bl), (Executor)this.zzc);
    }
}
