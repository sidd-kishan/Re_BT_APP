/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.view.MotionEvent
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzaao
 *  com.google.android.gms.internal.ads.zzaat
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaao;
import com.google.android.gms.internal.ads.zzaat;

public final class zzaas {
    private static final String[] zzc = new String[]{"/aclk", "/pcs/click", "/dbm/clk"};
    private final String zza;
    private final String[] zzb = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final zzaao zzd;

    @Deprecated
    public zzaas(zzaao zzaao2) {
        this.zza = "ad.doubleclick.net";
        this.zzd = zzaao2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private final Uri zzg(Uri var1_1, String var2_3) throws zzaat {
        block12: {
            block11: {
                if (var1_1 == null) throw null;
                try {
                    var5_4 = var1_1.getHost().equals(this.zza);
                    if (!var5_4) break block11;
                    break block12;
                }
                catch (UnsupportedOperationException var1_2) {
                    throw new zzaat("Provided Uri is not in a valid state");
                }
            }
lbl10:
            // 2 sources

            while (true) {
                if (var1_1.getQueryParameter("ms") != null) ** GOTO lbl33
                var6_7 = var1_1.toString();
                var3_9 = var4_11 = var6_7.indexOf("&adurl");
                if (var4_11 == -1) {
                    var3_9 = var6_7.indexOf("?adurl");
                }
                if (var3_9 == -1) ** GOTO lbl30
                {
                    block13: {
                        var1_1 = new StringBuilder(var6_7.substring(0, ++var3_9));
                        var1_1.append("ms");
                        var1_1.append("=");
                        var1_1.append(var2_3);
                        var1_1.append("&");
                        var1_1.append(var6_7.substring(var3_9));
                        var1_1 = Uri.parse((String)var1_1.toString());
                        break block13;
lbl30:
                        // 1 sources

                        var1_1 = var1_1.buildUpon().appendQueryParameter("ms", var2_3).build();
                    }
                    return var1_1;
lbl33:
                    // 1 sources

                    var1_1 = new zzaat("Query parameter already exists: ms");
                    throw var1_1;
                }
                break;
            }
            catch (NullPointerException var6_6) {
                ** continue;
            }
        }
        if (!var1_1.toString().contains("dc_ms=")) {
            var6_5 = var1_1.toString();
            var3_8 = var6_5.indexOf(";adurl");
            if (var3_8 != -1) {
                var1_1 = new StringBuilder(var6_5.substring(0, ++var3_8));
                var1_1.append("dc_ms");
                var1_1.append("=");
                var1_1.append(var2_3);
                var1_1.append(";");
                var1_1.append(var6_5.substring(var3_8));
                var1_1 = Uri.parse((String)var1_1.toString());
            } else {
                var1_1 = var1_1.getEncodedPath();
                var3_8 = var6_5.indexOf((String)var1_1);
                var7_10 = new StringBuilder(var6_5.substring(0, var1_1.length() + var3_8));
                var7_10.append(";");
                var7_10.append("dc_ms");
                var7_10.append("=");
                var7_10.append(var2_3);
                var7_10.append(";");
                var7_10.append(var6_5.substring(var3_8 + var1_1.length()));
                var1_1 = Uri.parse((String)var7_10.toString());
            }
            return var1_1;
        }
        var1_1 = new zzaat("Parameter already exists: dc_ms");
        throw var1_1;
    }

    public final boolean zza(Uri object) {
        if (object == null) throw null;
        try {
            object = object.getHost();
            String[] stringArray = this.zzb;
            int n = 0;
            while (n < 3) {
                boolean bl = ((String)object).endsWith(stringArray[n]);
                if (bl) {
                    return true;
                }
                ++n;
            }
            return false;
        }
        catch (NullPointerException nullPointerException) {
        }
        return false;
    }

    @Deprecated
    public final zzaao zzb() {
        return this.zzd;
    }

    @Deprecated
    public final Uri zzc(Uri uri, Context context) throws zzaat {
        return this.zzg(uri, this.zzd.zzp(context));
    }

    @Deprecated
    public final void zzd(MotionEvent motionEvent) {
        this.zzd.zzj(motionEvent);
    }

    @Deprecated
    public final Uri zze(Uri uri, Context context, View view, Activity activity) throws zzaat {
        try {
            uri = this.zzg(uri, this.zzd.zzl(context, uri.getQueryParameter("ai"), view, activity));
            return uri;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            throw new zzaat("Provided Uri is not in a valid state");
        }
    }

    public final boolean zzf(Uri uri) {
        if (!this.zza(uri)) return false;
        String[] stringArray = zzc;
        int n = 0;
        while (n < 3) {
            String string = stringArray[n];
            if (uri.getPath().endsWith(string)) {
                return true;
            }
            ++n;
        }
        return false;
    }
}
