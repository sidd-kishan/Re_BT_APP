/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.nativead.MediaView
 *  com.google.android.gms.ads.nativead.NativeAd$Image
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd$DisplayOpenMeasurement
 */
package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import java.util.List;

public interface NativeCustomFormatAd {
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    public void destroy();

    public List<String> getAvailableAssetNames();

    public String getCustomFormatId();

    public DisplayOpenMeasurement getDisplayOpenMeasurement();

    public NativeAd.Image getImage(String var1);

    public CharSequence getText(String var1);

    public VideoController getVideoController();

    public MediaView getVideoMediaView();

    public void performClick(String var1);

    public void recordImpression();
}
