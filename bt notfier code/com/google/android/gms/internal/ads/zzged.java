/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdx
 *  com.google.android.gms.internal.ads.zzgea
 *  com.google.android.gms.internal.ads.zzgeb
 *  com.google.android.gms.internal.ads.zzgec
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdx;
import com.google.android.gms.internal.ads.zzgea;
import com.google.android.gms.internal.ads.zzgeb;
import com.google.android.gms.internal.ads.zzgec;
import java.io.PrintStream;
import java.io.PrintWriter;

public final class zzged {
    static final zzgdx zza;

    /*
     * Enabled unnecessary exception pruning
     */
    static {
        Object object;
        Object object2;
        block9: {
            PrintStream printStream = null;
            object2 = null;
            object = printStream;
            try {
                try {
                    Integer n = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                    object2 = n;
                }
                catch (Exception exception) {
                    object = printStream;
                    System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                    object = printStream;
                    exception.printStackTrace(System.err);
                }
                if (object2 != null) {
                    object = object2;
                    if ((Integer)object2 >= 19) {
                        object = object2;
                        object = object2;
                        printStream = new zzgec();
                        object = object2;
                        object2 = printStream;
                        break block9;
                    }
                }
                object = object2;
                if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                    object = object2;
                    printStream = new zzgea();
                    object = object2;
                    object2 = printStream;
                } else {
                    object = object2;
                    printStream = new zzgeb();
                    object = object2;
                    object2 = printStream;
                }
            }
            catch (Throwable throwable) {
                printStream = System.err;
                String string = zzgeb.class.getName();
                object2 = new StringBuilder(String.valueOf(string).length() + 133);
                ((StringBuilder)object2).append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                ((StringBuilder)object2).append(string);
                ((StringBuilder)object2).append("will be used. The error is: ");
                printStream.println(((StringBuilder)object2).toString());
                throwable.printStackTrace(System.err);
                object2 = new zzgeb();
            }
        }
        zza = object2;
        if (object == null) {
            return;
        }
        ((Integer)object).intValue();
    }

    public static void zza(Throwable throwable, Throwable throwable2) {
        zza.zza(throwable, throwable2);
    }

    public static void zzb(Throwable throwable) {
        zza.zzb(throwable);
    }

    public static void zzc(Throwable throwable, PrintWriter printWriter) {
        zza.zzc(throwable, printWriter);
    }
}
