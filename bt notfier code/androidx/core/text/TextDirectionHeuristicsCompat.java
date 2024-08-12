/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.TextDirectionHeuristicCompat
 *  androidx.core.text.TextDirectionHeuristicsCompat$AnyStrong
 *  androidx.core.text.TextDirectionHeuristicsCompat$FirstStrong
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR;
    public static final TextDirectionHeuristicCompat RTL;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    static {
        LTR = new TextDirectionHeuristicInternal(null, false);
        RTL = new TextDirectionHeuristicInternal(null, true);
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)FirstStrong.INSTANCE, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)FirstStrong.INSTANCE, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int isRtlText(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        if (n == 2) return 0;
        return 2;
    }

    static int isRtlTextOrFormat(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        if (n == 2) return 0;
        switch (n) {
            default: {
                return 2;
            }
            case 16: 
            case 17: {
                return 0;
            }
            case 14: 
            case 15: 
        }
        return 1;
    }
}
