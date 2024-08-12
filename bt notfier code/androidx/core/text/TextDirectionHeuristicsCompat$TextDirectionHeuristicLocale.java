/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
 *  androidx.core.text.TextUtilsCompat
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

private static class TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale
extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
    static final TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale();

    TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale() {
        super(null);
    }

    protected boolean defaultIsRtl() {
        int n = TextUtilsCompat.getLayoutDirectionFromLocale((Locale)Locale.getDefault());
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }
}
