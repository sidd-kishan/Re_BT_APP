/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.TextDirectionHeuristicsCompat
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class TextDirectionHeuristicsCompat.FirstStrong
implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
    static final TextDirectionHeuristicsCompat.FirstStrong INSTANCE = new TextDirectionHeuristicsCompat.FirstStrong();

    private TextDirectionHeuristicsCompat.FirstStrong() {
    }

    public int checkRtl(CharSequence charSequence, int n, int n2) {
        int n3 = 2;
        int n4 = n;
        while (n4 < n2 + n) {
            if (n3 != 2) return n3;
            n3 = TextDirectionHeuristicsCompat.isRtlTextOrFormat((int)Character.getDirectionality(charSequence.charAt(n4)));
            ++n4;
        }
        return n3;
    }
}
