/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.TextDirectionHeuristicCompat
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import java.nio.CharBuffer;

private static abstract class TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
implements TextDirectionHeuristicCompat {
    private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;

    TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm textDirectionAlgorithm) {
        this.mAlgorithm = textDirectionAlgorithm;
    }

    private boolean doCheck(CharSequence charSequence, int n, int n2) {
        if ((n = this.mAlgorithm.checkRtl(charSequence, n, n2)) == 0) return true;
        if (n == 1) return false;
        return this.defaultIsRtl();
    }

    protected abstract boolean defaultIsRtl();

    public boolean isRtl(CharSequence charSequence, int n, int n2) {
        if (charSequence == null) throw new IllegalArgumentException();
        if (n < 0) throw new IllegalArgumentException();
        if (n2 < 0) throw new IllegalArgumentException();
        if (charSequence.length() - n2 < n) throw new IllegalArgumentException();
        if (this.mAlgorithm != null) return this.doCheck(charSequence, n, n2);
        return this.defaultIsRtl();
    }

    public boolean isRtl(char[] cArray, int n, int n2) {
        return this.isRtl(CharBuffer.wrap(cArray), n, n2);
    }
}
