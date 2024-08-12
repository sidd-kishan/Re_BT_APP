/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.PrecomputedText$Params
 *  android.text.PrecomputedText$Params$Builder
 *  android.text.TextDirectionHeuristic
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  androidx.core.util.ObjectsCompat
 */
package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;

public static final class PrecomputedTextCompat.Params {
    private final int mBreakStrategy;
    private final int mHyphenationFrequency;
    private final TextPaint mPaint;
    private final TextDirectionHeuristic mTextDir;
    final PrecomputedText.Params mWrapped;

    public PrecomputedTextCompat.Params(PrecomputedText.Params params) {
        this.mPaint = params.getTextPaint();
        this.mTextDir = params.getTextDirection();
        this.mBreakStrategy = params.getBreakStrategy();
        this.mHyphenationFrequency = params.getHyphenationFrequency();
        if (Build.VERSION.SDK_INT < 29) {
            params = null;
        }
        this.mWrapped = params;
    }

    PrecomputedTextCompat.Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int n, int n2) {
        this.mWrapped = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(n).setHyphenationFrequency(n2).setTextDirection(textDirectionHeuristic).build() : null;
        this.mPaint = textPaint;
        this.mTextDir = textDirectionHeuristic;
        this.mBreakStrategy = n;
        this.mHyphenationFrequency = n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PrecomputedTextCompat.Params)) {
            return false;
        }
        if (!this.equalsWithoutTextDirection((PrecomputedTextCompat.Params)(object = (PrecomputedTextCompat.Params)object))) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 18) return true;
        if (this.mTextDir == ((PrecomputedTextCompat.Params)object).getTextDirection()) return true;
        return false;
    }

    public boolean equalsWithoutTextDirection(PrecomputedTextCompat.Params params) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.mBreakStrategy != params.getBreakStrategy()) {
                return false;
            }
            if (this.mHyphenationFrequency != params.getHyphenationFrequency()) {
                return false;
            }
        }
        if (this.mPaint.getTextSize() != params.getTextPaint().getTextSize()) {
            return false;
        }
        if (this.mPaint.getTextScaleX() != params.getTextPaint().getTextScaleX()) {
            return false;
        }
        if (this.mPaint.getTextSkewX() != params.getTextPaint().getTextSkewX()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mPaint.getLetterSpacing() != params.getTextPaint().getLetterSpacing()) {
                return false;
            }
            if (!TextUtils.equals((CharSequence)this.mPaint.getFontFeatureSettings(), (CharSequence)params.getTextPaint().getFontFeatureSettings())) {
                return false;
            }
        }
        if (this.mPaint.getFlags() != params.getTextPaint().getFlags()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24 ? !this.mPaint.getTextLocales().equals((Object)params.getTextPaint().getTextLocales()) : Build.VERSION.SDK_INT >= 17 && !this.mPaint.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
            return false;
        }
        if (this.mPaint.getTypeface() == null) {
            if (params.getTextPaint().getTypeface() == null) return true;
            return false;
        }
        if (this.mPaint.getTypeface().equals((Object)params.getTextPaint().getTypeface())) return true;
        return false;
    }

    public int getBreakStrategy() {
        return this.mBreakStrategy;
    }

    public int getHyphenationFrequency() {
        return this.mHyphenationFrequency;
    }

    public TextDirectionHeuristic getTextDirection() {
        return this.mTextDir;
    }

    public TextPaint getTextPaint() {
        return this.mPaint;
    }

    public int hashCode() {
        if (Build.VERSION.SDK_INT >= 24) {
            return ObjectsCompat.hash((Object[])new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), this.mPaint.getFlags(), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), this.mPaint.isElegantTextHeight(), this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency});
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectsCompat.hash((Object[])new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), this.mPaint.getFlags(), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mPaint.isElegantTextHeight(), this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency});
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return ObjectsCompat.hash((Object[])new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), this.mPaint.getFlags(), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency});
        }
        if (Build.VERSION.SDK_INT < 17) return ObjectsCompat.hash((Object[])new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), this.mPaint.getFlags(), this.mPaint.getTypeface(), this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency});
        return ObjectsCompat.hash((Object[])new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), this.mPaint.getFlags(), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("textSize=");
        stringBuilder2.append(this.mPaint.getTextSize());
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", textScaleX=");
        stringBuilder2.append(this.mPaint.getTextScaleX());
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", textSkewX=");
        stringBuilder2.append(this.mPaint.getTextSkewX());
        stringBuilder.append(stringBuilder2.toString());
        if (Build.VERSION.SDK_INT >= 21) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(", letterSpacing=");
            stringBuilder2.append(this.mPaint.getLetterSpacing());
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(", elegantTextHeight=");
            stringBuilder2.append(this.mPaint.isElegantTextHeight());
            stringBuilder.append(stringBuilder2.toString());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(", textLocale=");
            stringBuilder2.append(this.mPaint.getTextLocales());
            stringBuilder.append(stringBuilder2.toString());
        } else if (Build.VERSION.SDK_INT >= 17) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(", textLocale=");
            stringBuilder2.append(this.mPaint.getTextLocale());
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", typeface=");
        stringBuilder2.append(this.mPaint.getTypeface());
        stringBuilder.append(stringBuilder2.toString());
        if (Build.VERSION.SDK_INT >= 26) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(", variationSettings=");
            stringBuilder2.append(this.mPaint.getFontVariationSettings());
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", textDir=");
        stringBuilder2.append(this.mTextDir);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", breakStrategy=");
        stringBuilder2.append(this.mBreakStrategy);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(", hyphenationFrequency=");
        stringBuilder2.append(this.mHyphenationFrequency);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
