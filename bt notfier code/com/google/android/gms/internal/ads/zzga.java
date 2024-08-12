/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecList
 *  com.google.android.gms.internal.ads.zzfz
 *  com.google.android.gms.internal.ads.zzgc
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.gms.internal.ads.zzfz;
import com.google.android.gms.internal.ads.zzgc;

final class zzga
implements zzfz {
    private zzga() {
    }

    /* synthetic */ zzga(zzgc zzgc2) {
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

    public final boolean zzd(String string, String string2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (!"secure-playback".equals(string)) return false;
        if (!"video/avc".equals(string2)) return false;
        return true;
    }

    public final boolean zze(String string, String string2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }
}
