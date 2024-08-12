/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.R$styleable
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.R;

public final class zzbdt {
    private final AdSize[] zza;
    private final String zzb;

    public zzbdt(Context context, AttributeSet object) {
        boolean bl;
        block6: {
            block5: {
                boolean bl2;
                String string;
                block4: {
                    context = context.getResources().obtainAttributes((AttributeSet)object, R.styleable.AdsAttrs);
                    object = context.getString(R.styleable.AdsAttrs_adSize);
                    string = context.getString(R.styleable.AdsAttrs_adSizes);
                    bl = TextUtils.isEmpty((CharSequence)object) ^ true;
                    bl2 = TextUtils.isEmpty((CharSequence)string) ^ true;
                    if (!bl || bl2) break block4;
                    this.zza = zzbdt.zzc((String)object);
                    break block5;
                }
                if (bl || !bl2) break block6;
                this.zza = zzbdt.zzc(string);
            }
            this.zzb = context.getString(R.styleable.AdsAttrs_adUnitId);
            context.recycle();
            if (TextUtils.isEmpty((CharSequence)this.zzb)) throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
            return;
        }
        if (bl) {
            context.recycle();
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        }
        context.recycle();
        throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
    }

    private static AdSize[] zzc(String string) {
        String[] stringArray = string.split("\\s*,\\s*");
        int n = stringArray.length;
        AdSize[] adSizeArray = new AdSize[n];
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i].trim();
            if (string2.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                int n2;
                int n3;
                String[] stringArray2 = string2.split("[xX]");
                stringArray2[0] = stringArray2[0].trim();
                stringArray2[1] = stringArray2[1].trim();
                try {
                    n3 = "FULL_WIDTH".equals(stringArray2[0]) ? -1 : Integer.parseInt(stringArray2[0]);
                    n2 = "AUTO_HEIGHT".equals(stringArray2[1]) ? -2 : Integer.parseInt(stringArray2[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    String string3 = String.valueOf(string2);
                    string3 = string3.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(string3) : new String("Could not parse XML attribute \"adSize\": ");
                    throw new IllegalArgumentException(string3);
                }
                adSizeArray[i] = new AdSize(n3, n2);
                continue;
            }
            if ("BANNER".equals(string2)) {
                adSizeArray[i] = AdSize.BANNER;
                continue;
            }
            if ("LARGE_BANNER".equals(string2)) {
                adSizeArray[i] = AdSize.LARGE_BANNER;
                continue;
            }
            if ("FULL_BANNER".equals(string2)) {
                adSizeArray[i] = AdSize.FULL_BANNER;
                continue;
            }
            if ("LEADERBOARD".equals(string2)) {
                adSizeArray[i] = AdSize.LEADERBOARD;
                continue;
            }
            if ("MEDIUM_RECTANGLE".equals(string2)) {
                adSizeArray[i] = AdSize.MEDIUM_RECTANGLE;
                continue;
            }
            if ("SMART_BANNER".equals(string2)) {
                adSizeArray[i] = AdSize.SMART_BANNER;
                continue;
            }
            if ("WIDE_SKYSCRAPER".equals(string2)) {
                adSizeArray[i] = AdSize.WIDE_SKYSCRAPER;
                continue;
            }
            if ("FLUID".equals(string2)) {
                adSizeArray[i] = AdSize.FLUID;
                continue;
            }
            if ("ICON".equals(string2)) {
                adSizeArray[i] = AdSize.zza;
                continue;
            }
            string = String.valueOf(string2);
            string = string.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(string) : new String("Could not parse XML attribute \"adSize\": ");
            throw new IllegalArgumentException(string);
        }
        if (n != 0) return adSizeArray;
        string = (string = String.valueOf(string)).length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(string) : new String("Could not parse XML attribute \"adSize\": ");
        throw new IllegalArgumentException(string);
    }

    public final AdSize[] zza(boolean bl) {
        if (bl) return this.zza;
        if (this.zza.length != 1) throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
