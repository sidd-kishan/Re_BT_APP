/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.formats.MediaView
 *  com.google.android.gms.ads.formats.NativeAd$Image
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$DisplayOpenMeasurement
 */
package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;

@Deprecated
public interface NativeCustomTemplateAd {
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    public void destroy();

    public List<String> getAvailableAssetNames();

    public String getCustomTemplateId();

    public DisplayOpenMeasurement getDisplayOpenMeasurement();

    public NativeAd.Image getImage(String var1);

    public CharSequence getText(String var1);

    public VideoController getVideoController();

    public MediaView getVideoMediaView();

    public void performClick(String var1);

    public void recordImpression();
}
