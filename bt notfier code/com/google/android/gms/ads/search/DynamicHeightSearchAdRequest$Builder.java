/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.search.DynamicHeightSearchAdRequest
 *  com.google.android.gms.ads.search.zzb
 */
package com.google.android.gms.ads.search;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.DynamicHeightSearchAdRequest;
import com.google.android.gms.ads.search.zzb;

public static final class DynamicHeightSearchAdRequest.Builder {
    private final zzb zza = new zzb();
    private final Bundle zzb = new Bundle();

    static /* synthetic */ zzb zza(DynamicHeightSearchAdRequest.Builder builder) {
        return builder.zza;
    }

    public DynamicHeightSearchAdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> clazz, Bundle bundle) {
        this.zza.zze(clazz, bundle);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder addNetworkExtras(NetworkExtras networkExtras) {
        this.zza.zzc(networkExtras);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> clazz, Bundle bundle) {
        this.zza.zzd(clazz, bundle);
        return this;
    }

    public DynamicHeightSearchAdRequest build() {
        this.zza.zzd(AdMobAdapter.class, this.zzb);
        return new DynamicHeightSearchAdRequest(this, null);
    }

    public DynamicHeightSearchAdRequest.Builder setAdBorderSelectors(String string) {
        this.zzb.putString("csa_adBorderSelectors", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setAdTest(boolean bl) {
        Bundle bundle = this.zzb;
        String string = true != bl ? "off" : "on";
        bundle.putString("csa_adtest", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setAdjustableLineHeight(int n) {
        this.zzb.putString("csa_adjustableLineHeight", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setAdvancedOptionValue(String string, String string2) {
        this.zzb.putString(string, string2);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setAttributionSpacingBelow(int n) {
        this.zzb.putString("csa_attributionSpacingBelow", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setBorderSelections(String string) {
        this.zzb.putString("csa_borderSelections", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setChannel(String string) {
        this.zzb.putString("csa_channel", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorAdBorder(String string) {
        this.zzb.putString("csa_colorAdBorder", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorAdSeparator(String string) {
        this.zzb.putString("csa_colorAdSeparator", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorAnnotation(String string) {
        this.zzb.putString("csa_colorAnnotation", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorAttribution(String string) {
        this.zzb.putString("csa_colorAttribution", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorBackground(String string) {
        this.zzb.putString("csa_colorBackground", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorBorder(String string) {
        this.zzb.putString("csa_colorBorder", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorDomainLink(String string) {
        this.zzb.putString("csa_colorDomainLink", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorText(String string) {
        this.zzb.putString("csa_colorText", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setColorTitleLink(String string) {
        this.zzb.putString("csa_colorTitleLink", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setCssWidth(int n) {
        this.zzb.putString("csa_width", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setDetailedAttribution(boolean bl) {
        this.zzb.putString("csa_detailedAttribution", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setFontFamily(String string) {
        this.zzb.putString("csa_fontFamily", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setFontFamilyAttribution(String string) {
        this.zzb.putString("csa_fontFamilyAttribution", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setFontSizeAnnotation(int n) {
        this.zzb.putString("csa_fontSizeAnnotation", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setFontSizeAttribution(int n) {
        this.zzb.putString("csa_fontSizeAttribution", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setFontSizeDescription(int n) {
        this.zzb.putString("csa_fontSizeDescription", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setFontSizeDomainLink(int n) {
        this.zzb.putString("csa_fontSizeDomainLink", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setFontSizeTitle(int n) {
        this.zzb.putString("csa_fontSizeTitle", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setHostLanguage(String string) {
        this.zzb.putString("csa_hl", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setIsClickToCallEnabled(boolean bl) {
        this.zzb.putString("csa_clickToCall", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setIsLocationEnabled(boolean bl) {
        this.zzb.putString("csa_location", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setIsPlusOnesEnabled(boolean bl) {
        this.zzb.putString("csa_plusOnes", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setIsSellerRatingsEnabled(boolean bl) {
        this.zzb.putString("csa_sellerRatings", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setIsSiteLinksEnabled(boolean bl) {
        this.zzb.putString("csa_siteLinks", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setIsTitleBold(boolean bl) {
        this.zzb.putString("csa_titleBold", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setIsTitleUnderlined(boolean bl) {
        this.zzb.putString("csa_noTitleUnderline", Boolean.toString(bl ^ true));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setLocationColor(String string) {
        this.zzb.putString("csa_colorLocation", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setLocationFontSize(int n) {
        this.zzb.putString("csa_fontSizeLocation", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setLongerHeadlines(boolean bl) {
        this.zzb.putString("csa_longerHeadlines", Boolean.toString(bl));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setNumber(int n) {
        this.zzb.putString("csa_number", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setPage(int n) {
        this.zzb.putString("csa_adPage", Integer.toString(n));
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setQuery(String string) {
        this.zza.zzf(string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setStyleId(String string) {
        this.zzb.putString("csa_styleId", string);
        return this;
    }

    public DynamicHeightSearchAdRequest.Builder setVerticalSpacing(int n) {
        this.zzb.putString("csa_verticalSpacing", Integer.toString(n));
        return this;
    }
}
