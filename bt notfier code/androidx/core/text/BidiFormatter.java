/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.SpannableStringBuilder
 *  androidx.core.text.BidiFormatter$Builder
 *  androidx.core.text.BidiFormatter$DirectionalityEstimator
 *  androidx.core.text.TextDirectionHeuristicCompat
 *  androidx.core.text.TextDirectionHeuristicsCompat
 *  androidx.core.text.TextUtilsCompat
 */
package androidx.core.text;

import android.text.SpannableStringBuilder;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE;
    static final BidiFormatter DEFAULT_RTL_INSTANCE;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '\u202a';
    private static final char LRM = '\u200e';
    private static final String LRM_STRING;
    private static final char PDF = '\u202c';
    private static final char RLE = '\u202b';
    private static final char RLM = '\u200f';
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    static {
        DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        LRM_STRING = Character.toString('\u200e');
        RLM_STRING = Character.toString('\u200f');
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    }

    BidiFormatter(boolean bl, int n, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = bl;
        this.mFlags = n;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static BidiFormatter getInstance(boolean bl) {
        return new Builder(bl).build();
    }

    static boolean isRtlLocale(Locale locale) {
        int n = TextUtilsCompat.getLayoutDirectionFromLocale((Locale)locale);
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean bl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext) {
            if (bl) return LRM_STRING;
            if (BidiFormatter.getExitDir(charSequence) == 1) {
                return LRM_STRING;
            }
        }
        if (!this.mIsRtlContext) return EMPTY_STRING;
        if (!bl) return RLM_STRING;
        if (BidiFormatter.getExitDir(charSequence) != -1) return EMPTY_STRING;
        return RLM_STRING;
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean bl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext) {
            if (bl) return LRM_STRING;
            if (BidiFormatter.getEntryDir(charSequence) == 1) {
                return LRM_STRING;
            }
        }
        if (!this.mIsRtlContext) return EMPTY_STRING;
        if (!bl) return RLM_STRING;
        if (BidiFormatter.getEntryDir(charSequence) != -1) return EMPTY_STRING;
        return RLM_STRING;
    }

    public boolean getStereoReset() {
        boolean bl = (this.mFlags & 2) != 0;
        return bl;
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public boolean isRtl(String string) {
        return this.isRtl((CharSequence)string);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return this.unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return this.unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean bl) {
        if (charSequence == null) {
            return null;
        }
        boolean bl2 = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.getStereoReset() && bl) {
            textDirectionHeuristicCompat = bl2 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
            spannableStringBuilder.append((CharSequence)this.markBefore(charSequence, textDirectionHeuristicCompat));
        }
        if (bl2 != this.mIsRtlContext) {
            char c = bl2 ? (char)'\u202b' : '\u202a';
            spannableStringBuilder.append(c);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('\u202c');
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (!bl) return spannableStringBuilder;
        textDirectionHeuristicCompat = bl2 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
        spannableStringBuilder.append((CharSequence)this.markAfter(charSequence, textDirectionHeuristicCompat));
        return spannableStringBuilder;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean bl) {
        return this.unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, bl);
    }

    public String unicodeWrap(String string) {
        return this.unicodeWrap(string, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String string, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return this.unicodeWrap(string, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String string, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean bl) {
        if (string != null) return this.unicodeWrap((CharSequence)string, textDirectionHeuristicCompat, bl).toString();
        return null;
    }

    public String unicodeWrap(String string, boolean bl) {
        return this.unicodeWrap(string, this.mDefaultTextDirectionHeuristicCompat, bl);
    }
}
