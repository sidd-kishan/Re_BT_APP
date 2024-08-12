/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzfln;

final class zzdpc
implements zzfln {
    private final String zza;
    private final double zzb;
    private final int zzc;
    private final int zzd;

    zzdpc(String string, double d, int n, int n2) {
        this.zza = string;
        this.zzb = d;
        this.zzc = n;
        this.zzd = n2;
    }

    public final Object apply(Object object) {
        String string = this.zza;
        double d = this.zzb;
        int n = this.zzc;
        int n2 = this.zzd;
        object = (Bitmap)object;
        return new zzblr((Drawable)new BitmapDrawable(Resources.getSystem(), (Bitmap)object), Uri.parse((String)string), d, n, n2);
    }
}
