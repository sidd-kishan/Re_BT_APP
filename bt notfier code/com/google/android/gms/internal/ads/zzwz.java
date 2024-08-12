/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzwz {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public static zzvl zza(zzvy var0) {
        block17: {
            block16: {
                block19: {
                    block18: {
                        block14: {
                            block15: {
                                var13_1 = System.currentTimeMillis();
                                var15_2 = var0.zzc;
                                if (var15_2 == null) {
                                    return null;
                                }
                                var16_3 = (String[])var15_2.get("Date");
                                var7_4 = var16_3 != null ? zzwz.zzb((String)var16_3) : 0L;
                                var16_3 = (String)var15_2.get("Cache-Control");
                                var1_5 = false;
                                if (var16_3 == null) break block15;
                                var16_3 = var16_3.split(",", 0);
                                var1_5 = false;
                                var5_7 = 0L;
                                var3_8 = 0L;
                                block3: for (var2_6 = 0; var2_6 < var16_3.length; ++var2_6) {
                                    var17_9 = var16_3[var2_6].trim();
                                    if (var17_9.equals("no-cache") != false) return null;
                                    if (var17_9.equals("no-store")) {
                                        return null;
                                    }
                                    if (var17_9.startsWith("max-age=")) {
                                        var9_11 = Long.parseLong(var17_9.substring(8));
                                        var11_12 = var3_8;
lbl23:
                                        // 4 sources

                                        while (true) {
                                            var5_7 = var9_11;
                                            var3_8 = var11_12;
                                            continue block3;
                                            break;
                                        }
                                    }
                                    break block14;
                                }
                                break block16;
                            }
                            var2_6 = 0;
                            var5_7 = 0L;
                            var3_8 = 0L;
                            break block17;
                            catch (Exception var17_10) {
                                var9_11 = var5_7;
                                var11_12 = var3_8;
                            }
                            ** GOTO lbl23
                        }
                        if (!var17_9.startsWith("stale-while-revalidate=")) break block18;
                        {
                            var11_12 = Long.parseLong(var17_9.substring(23));
                            var9_11 = var5_7;
                            ** GOTO lbl23
                        }
                    }
                    if (var17_9.equals("must-revalidate")) break block19;
                    var9_11 = var5_7;
                    var11_12 = var3_8;
                    if (!var17_9.equals("proxy-revalidate")) ** GOTO lbl23
                }
                var1_5 = true;
                var11_12 = var3_8;
                var9_11 = var5_7;
                ** while (true)
            }
            var2_6 = 1;
        }
        var16_3 = (String)var15_2.get("Expires");
        var11_12 = var16_3 != null ? zzwz.zzb((String)var16_3) : 0L;
        var16_3 = (String)var15_2.get("Last-Modified");
        var9_11 = var16_3 != null ? zzwz.zzb((String)var16_3) : 0L;
        var17_9 = (String)var15_2.get("ETag");
        if (var2_6 != 0) {
            var5_7 = var13_1 + var5_7 * 1000L;
            if (var1_5) {
                var3_8 = var5_7;
            } else {
                Long.signum(var3_8);
                var3_8 = var3_8 * 1000L + var5_7;
            }
            var11_12 = var3_8;
            var3_8 = var5_7;
            var5_7 = var11_12;
        } else {
            var5_7 = 0L;
            if (var7_4 > 0L && var11_12 >= var7_4) {
                var5_7 = var3_8 = var13_1 + (var11_12 - var7_4);
            } else {
                var3_8 = 0L;
            }
        }
        var16_3 = new zzvl();
        var16_3.zza = var0.zzb;
        var16_3.zzb = var17_9;
        var16_3.zzf = var3_8;
        var16_3.zze = var5_7;
        var16_3.zzc = var7_4;
        var16_3.zzd = var9_11;
        var16_3.zzg = var15_2;
        var16_3.zzh = var0.zzd;
        return var16_3;
    }

    public static long zzb(String string) {
        try {
            long l = zzwz.zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(string).getTime();
            return l;
        }
        catch (ParseException parseException) {
            if (!"0".equals(string) && !"-1".equals(string)) {
                zzwo.zzd((Throwable)parseException, (String)"Unable to parse dateStr: %s, falling back to 0", (Object[])new Object[]{string});
            } else {
                zzwo.zza((String)"Unable to parse dateStr: %s, falling back to 0", (Object[])new Object[]{string});
            }
            return 0L;
        }
    }

    static String zzc(long l) {
        return zzwz.zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(l));
    }

    private static SimpleDateFormat zzd(String object) {
        object = new SimpleDateFormat((String)object, Locale.US);
        ((DateFormat)object).setTimeZone(TimeZone.getTimeZone("GMT"));
        return object;
    }
}
