/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfbk
 */
package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfbk;
import java.io.IOException;
import java.io.InputStream;

public final class zzfbl {
    public static ParcelFileDescriptor zza(InputStream inputStream) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor[0];
        parcelFileDescriptor = parcelFileDescriptor[1];
        zzchg.zza.execute((Runnable)new zzfbk(inputStream, parcelFileDescriptor));
        return parcelFileDescriptor2;
    }
}
