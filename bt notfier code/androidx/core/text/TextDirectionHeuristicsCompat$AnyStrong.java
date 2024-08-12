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
private static class TextDirectionHeuristicsCompat.AnyStrong
implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
    static final TextDirectionHeuristicsCompat.AnyStrong INSTANCE_RTL = new TextDirectionHeuristicsCompat.AnyStrong(true);
    private final boolean mLookForRtl;

    private TextDirectionHeuristicsCompat.AnyStrong(boolean bl) {
        this.mLookForRtl = bl;
    }

    public int checkRtl(CharSequence charSequence, int n, int n2) {
        boolean bl = false;
        int n3 = n;
        while (true) {
            block5: {
                block6: {
                    block4: {
                        if (n3 >= n2 + n) {
                            if (!bl) return 2;
                            return this.mLookForRtl ? 1 : 0;
                        }
                        int n4 = TextDirectionHeuristicsCompat.isRtlText((int)Character.getDirectionality(charSequence.charAt(n3)));
                        if (n4 == 0) break block4;
                        if (n4 != 1) break block5;
                        if (!this.mLookForRtl) {
                            return 1;
                        }
                        break block6;
                    }
                    if (this.mLookForRtl) {
                        return 0;
                    }
                }
                bl = true;
            }
            ++n3;
        }
    }
}
