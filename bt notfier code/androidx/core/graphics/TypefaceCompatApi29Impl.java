/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.Typeface$CustomFallbackBuilder
 *  android.graphics.fonts.Font
 *  android.graphics.fonts.Font$Builder
 *  android.graphics.fonts.FontFamily
 *  android.graphics.fonts.FontFamily$Builder
 *  android.graphics.fonts.FontStyle
 *  android.os.CancellationSignal
 *  androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry
 *  androidx.core.graphics.TypefaceCompatBaseImpl
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

public class TypefaceCompatApi29Impl
extends TypefaceCompatBaseImpl {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public Typeface createFromFontFamilyFilesResourceEntry(Context var1_1, FontResourcesParserCompat.FontFamilyFilesResourceEntry var2_3, Resources var3_5, int var4_6) {
        var9_7 = null;
        try {
            var10_8 = var2_3.getEntries();
            var8_9 = var10_8.length;
            var7_10 = 0;
            var1_1 = null;
            var5_11 = 0;
        }
        catch (Exception var1_2) {
            var1_1 = var9_7;
            ** GOTO lbl43
        }
        block5: while (true) {
            var6_12 = 1;
            if (var5_11 >= var8_9) break;
            var2_3 = var10_8[var5_11];
            try {
                var11_13 = new Font.Builder(var3_5, var2_3.getResourceId());
                var11_13 = var11_13.setWeight(var2_3.getWeight());
                if (!var2_3.isItalic()) {
                    var6_12 = 0;
                }
                var11_13 = var11_13.setSlant(var6_12).setTtcIndex(var2_3.getTtcIndex()).setFontVariationSettings(var2_3.getVariationSettings()).build();
                if (var1_1 == null) {
                    var2_3 = new FontFamily.Builder((Font)var11_13);
                    var1_1 = var2_3;
                } else {
                    var1_1.addFont((Font)var11_13);
                }
lbl28:
                // 3 sources

                while (true) {
                    ++var5_11;
                    continue block5;
                    break;
                }
            }
            catch (IOException var2_4) {
                ** continue;
            }
        }
        if (var1_1 != null) ** GOTO lbl-1000
        return null;
lbl-1000:
        // 1 sources

        {
            var5_11 = (var4_6 & 1) != 0 ? 700 : 400;
            var6_12 = var7_10;
            if ((var4_6 & 2) != 0) {
                var6_12 = 1;
            }
            var2_3 = new FontStyle(var5_11, var6_12);
            var3_5 = new Typeface.CustomFallbackBuilder(var1_1.build());
            var1_1 = var3_5.setStyle((FontStyle)var2_3).build();
lbl43:
            // 2 sources

            return var1_1;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public Typeface createFromFontInfo(Context var1_1, CancellationSignal var2_4, FontsContractCompat.FontInfo[] var3_5, int var4_6) {
        var10_7 = var1_1.getContentResolver();
        var8_8 = ((FontStyle)var3_5).length;
        var7_9 = 0;
        var1_1 = null;
        var5_10 = 0;
        while (true) {
            block19: {
                var6_11 = 1;
                if (var5_10 >= var8_8) ** GOTO lbl46
                var12_15 = var3_5[var5_10];
                var9_12 = var1_1;
                var11_13 = var10_7.openFileDescriptor(var12_15.getUri(), "r", var2_4);
                if (var11_13 == null) {
                    var9_12 = var1_1;
                    if (var11_13 == null) break block19;
                } else {
                    var9_12 = new Font.Builder(var11_13);
                    var9_12 = var9_12.setWeight(var12_15.getWeight());
                    if (!var12_15.isItalic()) {
                        var6_11 = 0;
                    }
                    var9_12 = var9_12.setSlant(var6_11).setTtcIndex(var12_15.getTtcIndex()).build();
                    if (var1_1 == null) {
                        var1_1 = var9_12 = new FontFamily.Builder((Font)var9_12);
                    } else {
                        var1_1.addFont((Font)var9_12);
                    }
                    var9_12 = var1_1;
                    if (var11_13 == null) break block19;
                }
                var9_12 = var1_1;
                var11_13.close();
                var9_12 = var1_1;
                {
                    break block19;
                }
                catch (Throwable var12_16) {
                    if (var11_13 == null) ** GOTO lbl44
                    try {
                        var11_13.close();
                        ** GOTO lbl44
                    }
                    catch (Throwable var11_14) {
                        var9_12 = var1_1;
                        var12_16.addSuppressed(var11_14);
lbl44:
                        // 3 sources

                        var9_12 = var1_1;
                        throw var12_16;
lbl46:
                        // 1 sources

                        if (var1_1 == null) {
                            return null;
                        }
                        try {
                            var5_10 = (var4_6 & 1) != 0 ? 700 : 400;
                            var6_11 = var7_9;
                            if ((var4_6 & 2) != 0) {
                                var6_11 = 1;
                            }
                            var3_5 = new FontStyle(var5_10, var6_11);
                            var2_4 = new Typeface.CustomFallbackBuilder(var1_1.build());
                            return var2_4.setStyle(var3_5).build();
                        }
                        catch (Exception var1_2) {
                            return null;
                        }
                        catch (IOException var1_3) {}
                    }
                }
            }
            ++var5_10;
            var1_1 = var9_12;
        }
    }

    protected Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int n, String string, int n2) {
        try {
            context = new Font.Builder(resources, n);
            context = context.build();
            resources = new FontFamily.Builder((Font)context);
            resources = resources.build();
            string = new Typeface.CustomFallbackBuilder((FontFamily)resources);
            context = string.setStyle(context.getStyle()).build();
            return context;
        }
        catch (Exception exception) {
            return null;
        }
    }

    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
