/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.Layout$Alignment
 *  android.text.PrecomputedText
 *  android.text.PrecomputedText$Params
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.style.MetricAffectingSpan
 *  androidx.core.os.TraceCompat
 *  androidx.core.text.PrecomputedTextCompat$Params
 *  androidx.core.text.PrecomputedTextCompat$PrecomputedTextFutureTask
 *  androidx.core.util.Preconditions
 */
package androidx.core.text;

import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.os.TraceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrecomputedTextCompat
implements Spannable {
    private static final char LINE_FEED = '\n';
    private static Executor sExecutor;
    private static final Object sLock;
    private final int[] mParagraphEnds;
    private final Params mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;

    static {
        sLock = new Object();
        sExecutor = null;
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, Params params) {
        this.mText = precomputedText;
        this.mParams = params;
        this.mParagraphEnds = null;
        if (Build.VERSION.SDK_INT < 29) {
            precomputedText = null;
        }
        this.mWrapped = precomputedText;
    }

    private PrecomputedTextCompat(CharSequence charSequence, Params params, int[] nArray) {
        this.mText = new SpannableString(charSequence);
        this.mParams = params;
        this.mParagraphEnds = nArray;
        this.mWrapped = null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static PrecomputedTextCompat create(CharSequence object, Params params) {
        Preconditions.checkNotNull((Object)object);
        Preconditions.checkNotNull((Object)params);
        try {
            TraceCompat.beginSection((String)"PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && params.mWrapped != null) {
                object = new PrecomputedTextCompat(PrecomputedText.create((CharSequence)object, (PrecomputedText.Params)params.mWrapped), params);
                return object;
            }
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int n = object.length();
            int n2 = 0;
            while (n2 < n) {
                n2 = (n2 = TextUtils.indexOf((CharSequence)object, (char)'\n', (int)n2, (int)n)) < 0 ? n : ++n2;
                arrayList.add(n2);
            }
            int[] nArray = new int[arrayList.size()];
            for (n2 = 0; n2 < arrayList.size(); ++n2) {
                nArray[n2] = (Integer)arrayList.get(n2);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain((CharSequence)object, (int)0, (int)object.length(), (TextPaint)params.getTextPaint(), (int)Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
            } else if (Build.VERSION.SDK_INT >= 21) {
                new StaticLayout((CharSequence)object, params.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            object = new PrecomputedTextCompat((CharSequence)object, params, nArray);
            return object;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    public static Future<PrecomputedTextCompat> getTextFuture(CharSequence object, Params params, Executor object2) {
        params = new PrecomputedTextFutureTask(params, (CharSequence)object);
        object = object2;
        if (object2 == null) {
            object2 = sLock;
            synchronized (object2) {
                if (sExecutor == null) {
                    sExecutor = Executors.newFixedThreadPool(1);
                }
                object = sExecutor;
            }
        }
        object.execute((Runnable)params);
        return params;
    }

    public char charAt(int n) {
        return this.mText.charAt(n);
    }

    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT < 29) return this.mParagraphEnds.length;
        return this.mWrapped.getParagraphCount();
    }

    public int getParagraphEnd(int n) {
        Preconditions.checkArgumentInRange((int)n, (int)0, (int)this.getParagraphCount(), (String)"paraIndex");
        if (Build.VERSION.SDK_INT < 29) return this.mParagraphEnds[n];
        return this.mWrapped.getParagraphEnd(n);
    }

    public int getParagraphStart(int n) {
        int n2 = this.getParagraphCount();
        int n3 = 0;
        Preconditions.checkArgumentInRange((int)n, (int)0, (int)n2, (String)"paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphStart(n);
        }
        n = n == 0 ? n3 : this.mParagraphEnds[n - 1];
        return n;
    }

    public Params getParams() {
        return this.mParams;
    }

    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.mText;
        if (!(spannable instanceof PrecomputedText)) return null;
        return (PrecomputedText)spannable;
    }

    public int getSpanEnd(Object object) {
        return this.mText.getSpanEnd(object);
    }

    public int getSpanFlags(Object object) {
        return this.mText.getSpanFlags(object);
    }

    public int getSpanStart(Object object) {
        return this.mText.getSpanStart(object);
    }

    public <T> T[] getSpans(int n, int n2, Class<T> clazz) {
        if (Build.VERSION.SDK_INT < 29) return this.mText.getSpans(n, n2, clazz);
        return this.mWrapped.getSpans(n, n2, clazz);
    }

    public int length() {
        return this.mText.length();
    }

    public int nextSpanTransition(int n, int n2, Class clazz) {
        return this.mText.nextSpanTransition(n, n2, clazz);
    }

    public void removeSpan(Object object) {
        if (object instanceof MetricAffectingSpan) throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.removeSpan(object);
        } else {
            this.mText.removeSpan(object);
        }
    }

    public void setSpan(Object object, int n, int n2, int n3) {
        if (object instanceof MetricAffectingSpan) throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.setSpan(object, n, n2, n3);
        } else {
            this.mText.setSpan(object, n, n2, n3);
        }
    }

    public CharSequence subSequence(int n, int n2) {
        return this.mText.subSequence(n, n2);
    }

    public String toString() {
        return this.mText.toString();
    }
}
