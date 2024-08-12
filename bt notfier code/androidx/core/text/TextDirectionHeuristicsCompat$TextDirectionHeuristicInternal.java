/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
 *  androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
 */
package androidx.core.text;

import androidx.core.text.TextDirectionHeuristicsCompat;

private static class TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal
extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
    private final boolean mDefaultIsRtl;

    TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm textDirectionAlgorithm, boolean bl) {
        super(textDirectionAlgorithm);
        this.mDefaultIsRtl = bl;
    }

    protected boolean defaultIsRtl() {
        return this.mDefaultIsRtl;
    }
}
