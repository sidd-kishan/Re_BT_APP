/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0004\u00a8\u0006\r"}, d2={"precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "createFormatForDecimals", "decimals", "", "formatToExactDecimals", "", "value", "", "formatUpToDecimals", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class FormatToDecimalsKt {
    private static final ThreadLocal<DecimalFormat>[] precisionFormats;

    static {
        ThreadLocal[] threadLocalArray = new ThreadLocal[4];
        int n = 0;
        while (true) {
            if (n >= 4) {
                precisionFormats = threadLocalArray;
                return;
            }
            threadLocalArray[n] = new ThreadLocal();
            ++n;
        }
    }

    private static final DecimalFormat createFormatForDecimals(int n) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (n > 0) {
            decimalFormat.setMinimumFractionDigits(n);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    public static final String formatToExactDecimals(double d, int n) {
        Object object = precisionFormats;
        if (n < ((ThreadLocal<DecimalFormat>[])object).length) {
            ThreadLocal<DecimalFormat> threadLocal = object[n];
            if ((object = threadLocal.get()) == null) {
                object = FormatToDecimalsKt.createFormatForDecimals(n);
                threadLocal.set((DecimalFormat)object);
            }
            object = (DecimalFormat)object;
        } else {
            object = FormatToDecimalsKt.createFormatForDecimals(n);
        }
        object = ((NumberFormat)object).format(d);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"format.format(value)");
        return object;
    }

    public static final String formatUpToDecimals(double d, int n) {
        Object object = FormatToDecimalsKt.createFormatForDecimals(0);
        ((DecimalFormat)object).setMaximumFractionDigits(n);
        object = ((NumberFormat)object).format(d);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"createFormatForDecimals(\u2026 }\n        .format(value)");
        return object;
    }
}
