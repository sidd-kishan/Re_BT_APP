/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzfu
 *  com.google.android.gms.internal.measurement.zzfx
 *  com.google.android.gms.internal.measurement.zzfy
 *  com.google.android.gms.internal.measurement.zzfz
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import java.io.PrintStream;

public final class zzga {
    static final zzfu zza;

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    static {
        void var0_9;
        Integer n;
        block9: {
            Integer n2 = null;
            StringBuilder stringBuilder = null;
            n = n2;
            try {
                void var0_3;
                try {
                    Integer n3;
                    Integer n4 = n3 = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                }
                catch (Exception exception) {
                    n = n2;
                    System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                    n = n2;
                    exception.printStackTrace(System.err);
                    StringBuilder stringBuilder2 = stringBuilder;
                }
                if (var0_3 != null) {
                    n = var0_3;
                    if (var0_3.intValue() >= 19) {
                        n = var0_3;
                        n = var0_3;
                        stringBuilder = new zzfz();
                        n = var0_3;
                        StringBuilder stringBuilder3 = stringBuilder;
                        break block9;
                    }
                }
                n = var0_3;
                if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                    n = var0_3;
                    stringBuilder = new zzfx();
                    n = var0_3;
                    StringBuilder stringBuilder4 = stringBuilder;
                } else {
                    n = var0_3;
                    stringBuilder = new zzfy();
                    n = var0_3;
                    StringBuilder stringBuilder5 = stringBuilder;
                }
            }
            catch (Throwable throwable) {
                PrintStream printStream = System.err;
                String string = zzfy.class.getName();
                stringBuilder = new StringBuilder(String.valueOf(string).length() + 133);
                stringBuilder.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                stringBuilder.append(string);
                stringBuilder.append("will be used. The error is: ");
                printStream.println(stringBuilder.toString());
                throwable.printStackTrace(System.err);
                zzfy zzfy2 = new zzfy();
            }
        }
        zza = var0_9;
        if (n == null) {
            return;
        }
        n.intValue();
    }

    public static void zza(Throwable throwable, Throwable throwable2) {
        zza.zza(throwable, throwable2);
    }
}
