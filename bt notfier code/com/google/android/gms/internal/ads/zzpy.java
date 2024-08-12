/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamr
 *  com.google.android.gms.internal.ads.zzfog
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzpt
 *  com.google.android.gms.internal.ads.zzpu
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamr;
import com.google.android.gms.internal.ads.zzfog;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzpt;
import com.google.android.gms.internal.ads.zzpu;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class zzpy {
    private static final String[] zza = new String[]{"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = new String[]{"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = new String[]{"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static zzpu zza(String var0) throws IOException {
        var8_2 = null;
        try {
            var9_3 = XmlPullParserFactory.newInstance().newPullParser();
            var7_4 /* !! */  = new StringReader((String)var0 /* !! */ );
            var9_3.setInput((Reader)var7_4 /* !! */ );
            var9_3.next();
            if (zzamr.zzb((XmlPullParser)var9_3, (String)"x:xmpmeta") == false) throw zzaha.zzb((String)"Couldn't find xmp metadata", null);
            var7_4 /* !! */  = zzfoj.zzi();
            var3_5 = -9223372036854775807L;
            while (true) {
                var9_3.next();
                if (zzamr.zzb((XmlPullParser)var9_3, (String)"rdf:Description")) {
                    var7_4 /* !! */  = zzpy.zza;
                    var2_7 = 0;
                    var1_6 = 0;
                }
                ** GOTO lbl-1000
                break;
            }
        }
        catch (zzaha | NumberFormatException | XmlPullParserException var0_1) {
            Log.w((String)"MotionPhotoXmpParser", (String)"Ignoring unexpected XMP metadata");
            return null;
        }
        while (true) {
            block15: {
                block14: {
                    var0 /* !! */  = var8_2;
                    if (var1_6 >= 4) return var0 /* !! */ ;
                    var10_9 = zzamr.zzc((XmlPullParser)var9_3, var7_4 /* !! */ [var1_6]);
                    if (var10_9 == null) break block15;
                    var0 /* !! */  = var8_2;
                    if (Integer.parseInt(var10_9) != 1) return var0 /* !! */ ;
                    var0 /* !! */  = zzpy.zzb;
                    for (var1_6 = 0; var1_6 < 4; ++var1_6) {
                        var7_4 /* !! */  = zzamr.zzc((XmlPullParser)var9_3, (String)var0 /* !! */ [var1_6]);
                        if (var7_4 /* !! */  == null) continue;
                        var3_5 = var5_8 = Long.parseLong((String)var7_4 /* !! */ );
                        if (var5_8 == -1L) {
                            break;
                        }
                        ** GOTO lbl-1000
                    }
                    var3_5 = -9223372036854775807L;
lbl-1000:
                    // 2 sources

                    {
                        var7_4 /* !! */  = zzpy.zzc;
                        for (var1_6 = var2_7; var1_6 < 2; ++var1_6) {
                            var0 /* !! */  = zzamr.zzc((XmlPullParser)var9_3, (String)var7_4 /* !! */ [var1_6]);
                            if (var0 /* !! */  == null) continue;
                            var5_8 = Long.parseLong((String)var0 /* !! */ );
                            var0 /* !! */  = new zzpt("image/jpeg", "Primary", 0L, 0L);
                            var7_4 /* !! */  = new zzpt("video/mp4", "MotionPhoto", var5_8, 0L);
                            var0 /* !! */  = zzfoj.zzk((Object)var0 /* !! */ , (Object)var7_4 /* !! */ );
                            break block14;
                        }
                    }
                    {
                        var0 /* !! */  = zzfoj.zzi();
                    }
                }
                var5_8 = var3_5;
                ** GOTO lbl65
            }
            ++var1_6;
        }
lbl-1000:
        // 1 sources

        {
            if (zzamr.zzb((XmlPullParser)var9_3, (String)"Container:Directory")) {
                var0 /* !! */  = zzpy.zzb(var9_3, "Container", "Item");
                var5_8 = var3_5;
            } else {
                var0 /* !! */  = var7_4 /* !! */ ;
                var5_8 = var3_5;
                if (zzamr.zzb((XmlPullParser)var9_3, (String)"GContainer:Directory")) {
                    var0 /* !! */  = zzpy.zzb(var9_3, "GContainer", "GContainerItem");
                    var5_8 = var3_5;
                }
            }
lbl65:
            // 5 sources

            var7_4 /* !! */  = var0 /* !! */ ;
            var3_5 = var5_8;
            if (!zzamr.zza((XmlPullParser)var9_3, (String)"x:xmpmeta")) ** continue;
            var0 /* !! */  = var0 /* !! */ .isEmpty() != false ? var8_2 : new zzpu(var5_8, (List)var0 /* !! */ );
            return var0 /* !! */ ;
        }
    }

    private static zzfoj<zzpt> zzb(XmlPullParser xmlPullParser, String string, String string2) throws XmlPullParserException, IOException {
        zzfog zzfog2 = zzfoj.zzu();
        String string3 = string.concat(":Item");
        string = string.concat(":Directory");
        do {
            xmlPullParser.next();
            if (!zzamr.zzb((XmlPullParser)xmlPullParser, (String)string3)) continue;
            String string4 = string2.concat(":Mime");
            String string5 = string2.concat(":Semantic");
            String string6 = string2.concat(":Length");
            String string7 = string2.concat(":Padding");
            string4 = zzamr.zzc((XmlPullParser)xmlPullParser, (String)string4);
            string5 = zzamr.zzc((XmlPullParser)xmlPullParser, (String)string5);
            string6 = zzamr.zzc((XmlPullParser)xmlPullParser, (String)string6);
            string7 = zzamr.zzc((XmlPullParser)xmlPullParser, (String)string7);
            if (string4 == null) return zzfoj.zzi();
            if (string5 == null) {
                return zzfoj.zzi();
            }
            long l = string6 != null ? Long.parseLong(string6) : 0L;
            long l2 = string7 != null ? Long.parseLong(string7) : 0L;
            zzfog2.zze((Object)new zzpt(string4, string5, l, l2));
        } while (!zzamr.zza((XmlPullParser)xmlPullParser, (String)string));
        return zzfog2.zzf();
    }
}
