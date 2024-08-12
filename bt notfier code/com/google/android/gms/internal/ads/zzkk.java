/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ApplicationMediaCapabilities$Builder
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.google.android.gms.internal.ads;

import android.media.ApplicationMediaCapabilities;
import android.os.Bundle;
import android.os.Parcelable;

final class zzkk {
    public static void zza(Bundle bundle) {
        bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", (Parcelable)new ApplicationMediaCapabilities.Builder().addSupportedVideoMimeType("video/hevc").addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
    }
}
