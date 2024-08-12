/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.BidiFormatter
 *  androidx.core.text.TextDirectionHeuristicCompat
 */
package androidx.core.text;

import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicCompat;
import java.util.Locale;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class BidiFormatter.Builder {
    private int mFlags;
    private boolean mIsRtlContext;
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

    public BidiFormatter.Builder() {
        this.initialize(BidiFormatter.isRtlLocale((Locale)Locale.getDefault()));
    }

    public BidiFormatter.Builder(Locale locale) {
        this.initialize(BidiFormatter.isRtlLocale((Locale)locale));
    }

    public BidiFormatter.Builder(boolean bl) {
        this.initialize(bl);
    }

    private static BidiFormatter getDefaultInstanceFromContext(boolean bl) {
        BidiFormatter bidiFormatter = bl ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        return bidiFormatter;
    }

    private void initialize(boolean bl) {
        this.mIsRtlContext = bl;
        this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
        this.mFlags = 2;
    }

    public BidiFormatter build() {
        if (this.mFlags != 2) return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        if (this.mTextDirectionHeuristicCompat != BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        return BidiFormatter.Builder.getDefaultInstanceFromContext(this.mIsRtlContext);
    }

    public BidiFormatter.Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
        return this;
    }

    public BidiFormatter.Builder stereoReset(boolean bl) {
        this.mFlags = bl ? (this.mFlags |= 2) : (this.mFlags &= 0xFFFFFFFD);
        return this;
    }
}
