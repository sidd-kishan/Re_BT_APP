/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  androidx.core.text.PrecomputedTextCompat$Params
 */
package androidx.core.text;

import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.core.text.PrecomputedTextCompat;

public static class PrecomputedTextCompat.Params.Builder {
    private int mBreakStrategy;
    private int mHyphenationFrequency;
    private final TextPaint mPaint;
    private TextDirectionHeuristic mTextDir;

    public PrecomputedTextCompat.Params.Builder(TextPaint textPaint) {
        this.mPaint = textPaint;
        if (Build.VERSION.SDK_INT >= 23) {
            this.mBreakStrategy = 1;
            this.mHyphenationFrequency = 1;
        } else {
            this.mHyphenationFrequency = 0;
            this.mBreakStrategy = 0;
        }
        this.mTextDir = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
    }

    public PrecomputedTextCompat.Params build() {
        return new PrecomputedTextCompat.Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
    }

    public PrecomputedTextCompat.Params.Builder setBreakStrategy(int n) {
        this.mBreakStrategy = n;
        return this;
    }

    public PrecomputedTextCompat.Params.Builder setHyphenationFrequency(int n) {
        this.mHyphenationFrequency = n;
        return this;
    }

    public PrecomputedTextCompat.Params.Builder setTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
        this.mTextDir = textDirectionHeuristic;
        return this;
    }
}
