/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecList
 *  com.google.android.gms.internal.ads.zzarn
 *  com.google.android.gms.internal.ads.zzarq
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.gms.internal.ads.zzarn;
import com.google.android.gms.internal.ads.zzarq;

final class zzaro
implements zzarn {
    private zzaro() {
    }

    /* synthetic */ zzaro(zzarq zzarq2) {
    }

    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo zzb(int n) {
        return MediaCodecList.getCodecInfoAt((int)n);
    }

    public final boolean zzc() {
        return false;
    }

    public final boolean zzd(String string, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(string);
    }
}
