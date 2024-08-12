/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.icu.text.DecimalFormatSymbols
 *  android.os.Build$VERSION
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.method.PasswordTransformationMethod
 *  android.util.Log
 *  android.view.ActionMode$Callback
 *  android.widget.TextView
 *  androidx.core.text.PrecomputedTextCompat
 *  androidx.core.text.PrecomputedTextCompat$Params
 *  androidx.core.text.PrecomputedTextCompat$Params$Builder
 *  androidx.core.util.Preconditions
 *  androidx.core.widget.AutoSizeableTextView
 *  androidx.core.widget.TextViewCompat$OreoCallback
 *  androidx.core.widget.TintableCompoundDrawablesView
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.lang.reflect.Field;
import java.util.Locale;

public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeMaxTextSize();
        }
        if (!(textView instanceof AutoSizeableTextView)) return -1;
        return ((AutoSizeableTextView)textView).getAutoSizeMaxTextSize();
    }

    public static int getAutoSizeMinTextSize(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeMinTextSize();
        }
        if (!(textView instanceof AutoSizeableTextView)) return -1;
        return ((AutoSizeableTextView)textView).getAutoSizeMinTextSize();
    }

    public static int getAutoSizeStepGranularity(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeStepGranularity();
        }
        if (!(textView instanceof AutoSizeableTextView)) return -1;
        return ((AutoSizeableTextView)textView).getAutoSizeStepGranularity();
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeTextAvailableSizes();
        }
        if (!(textView instanceof AutoSizeableTextView)) return new int[0];
        return ((AutoSizeableTextView)textView).getAutoSizeTextAvailableSizes();
    }

    public static int getAutoSizeTextType(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return textView.getAutoSizeTextType();
        }
        if (!(textView instanceof AutoSizeableTextView)) return 0;
        return ((AutoSizeableTextView)textView).getAutoSizeTextType();
    }

    public static ColorStateList getCompoundDrawableTintList(TextView textView) {
        Preconditions.checkNotNull((Object)textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return textView.getCompoundDrawableTintList();
        }
        if (!(textView instanceof TintableCompoundDrawablesView)) return null;
        return ((TintableCompoundDrawablesView)textView).getSupportCompoundDrawablesTintList();
    }

    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
        Preconditions.checkNotNull((Object)textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return textView.getCompoundDrawableTintMode();
        }
        if (!(textView instanceof TintableCompoundDrawablesView)) return null;
        return ((TintableCompoundDrawablesView)textView).getSupportCompoundDrawablesTintMode();
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        if (Build.VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (Build.VERSION.SDK_INT < 17) return textView.getCompoundDrawables();
        int n = textView.getLayoutDirection();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        Drawable[] drawableArray = textView.getCompoundDrawables();
        if (!bl) return drawableArray;
        Drawable drawable = drawableArray[2];
        textView = drawableArray[0];
        drawableArray[0] = drawable;
        drawableArray[2] = textView;
        return drawableArray;
    }

    public static int getFirstBaselineToTopHeight(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(TextView textView) {
        Field field;
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!sMaxModeFieldFetched) {
            sMaxModeField = TextViewCompat.retrieveField("mMaxMode");
            sMaxModeFieldFetched = true;
        }
        if ((field = sMaxModeField) == null) return -1;
        if (TextViewCompat.retrieveIntFromField(field, textView) != 1) return -1;
        if (!sMaximumFieldFetched) {
            sMaximumField = TextViewCompat.retrieveField("mMaximum");
            sMaximumFieldFetched = true;
        }
        if ((field = sMaximumField) == null) return -1;
        return TextViewCompat.retrieveIntFromField(field, textView);
    }

    public static int getMinLines(TextView textView) {
        Field field;
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMinLines();
        }
        if (!sMinModeFieldFetched) {
            sMinModeField = TextViewCompat.retrieveField("mMinMode");
            sMinModeFieldFetched = true;
        }
        if ((field = sMinModeField) == null) return -1;
        if (TextViewCompat.retrieveIntFromField(field, textView) != 1) return -1;
        if (!sMinimumFieldFetched) {
            sMinimumField = TextViewCompat.retrieveField("mMinimum");
            sMinimumFieldFetched = true;
        }
        if ((field = sMinimumField) == null) return -1;
        return TextViewCompat.retrieveIntFromField(field, textView);
    }

    private static int getTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL) return 1;
        return 7;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        int n = Build.VERSION.SDK_INT;
        byte by = 0;
        if (n >= 28 && (textView.getInputType() & 0xF) == 3) {
            by = Character.getDirectionality(DecimalFormatSymbols.getInstance((Locale)textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (by == 1) return TextDirectionHeuristics.RTL;
            if (by != 2) return TextDirectionHeuristics.LTR;
            return TextDirectionHeuristics.RTL;
        }
        if (textView.getLayoutDirection() == 1) {
            by = 1;
        }
        switch (textView.getTextDirection()) {
            default: {
                textView = by != 0 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 7: {
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            }
            case 6: {
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 5: {
                return TextDirectionHeuristics.LOCALE;
            }
            case 4: {
                return TextDirectionHeuristics.RTL;
            }
            case 3: {
                return TextDirectionHeuristics.LTR;
            }
            case 2: {
                return TextDirectionHeuristics.ANYRTL_LTR;
            }
        }
        return textView;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint((Paint)textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setBreakStrategy(textView.getBreakStrategy());
            builder.setHyphenationFrequency(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT < 18) return builder.build();
        builder.setTextDirection(TextViewCompat.getTextDirectionHeuristic(textView));
        return builder.build();
    }

    private static Field retrieveField(String string) {
        Field field = null;
        try {
            Field field2;
            field = field2 = TextView.class.getDeclaredField(string);
            field2.setAccessible(true);
            field = field2;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not retrieve ");
            stringBuilder.append(string);
            stringBuilder.append(" field.");
            Log.e((String)LOG_TAG, (String)stringBuilder.toString());
        }
        return field;
    }

    private static int retrieveIntFromField(Field field, TextView textView) {
        try {
            int n = field.getInt(textView);
            return n;
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not retrieve value of ");
            stringBuilder.append(field.getName());
            stringBuilder.append(" field.");
            Log.d((String)LOG_TAG, (String)stringBuilder.toString());
            return -1;
        }
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int n, int n2, int n3, int n4) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        } else {
            if (!(textView instanceof AutoSizeableTextView)) return;
            ((AutoSizeableTextView)textView).setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] nArray, int n) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        } else {
            if (!(textView instanceof AutoSizeableTextView)) return;
            ((AutoSizeableTextView)textView).setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        }
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView textView, int n) {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeWithDefaults(n);
        } else {
            if (!(textView instanceof AutoSizeableTextView)) return;
            ((AutoSizeableTextView)textView).setAutoSizeTextTypeWithDefaults(n);
        }
    }

    public static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
        Preconditions.checkNotNull((Object)textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else {
            if (!(textView instanceof TintableCompoundDrawablesView)) return;
            ((TintableCompoundDrawablesView)textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
        Preconditions.checkNotNull((Object)textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else {
            if (!(textView instanceof TintableCompoundDrawablesView)) return;
            ((TintableCompoundDrawablesView)textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            int n = textView.getLayoutDirection();
            boolean bl = true;
            if (n != 1) {
                bl = false;
            }
            Drawable drawable5 = bl ? drawable3 : drawable;
            if (!bl) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int n, int n2, int n3, int n4) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(n, n2, n3, n4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            int n5 = textView.getLayoutDirection();
            boolean bl = true;
            if (n5 != 1) {
                bl = false;
            }
            n5 = bl ? n3 : n;
            if (!bl) {
                n = n3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(n5, n2, n, n4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(n, n2, n3, n4);
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            int n = textView.getLayoutDirection();
            boolean bl = true;
            if (n != 1) {
                bl = false;
            }
            Drawable drawable5 = bl ? drawable3 : drawable;
            if (!bl) {
                drawable = drawable3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(textView, callback));
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int n) {
        Preconditions.checkArgumentNonnegative((int)n);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(n);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n2 = Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding() ? fontMetricsInt.ascent : fontMetricsInt.top;
        if (n <= Math.abs(n2)) return;
        textView.setPadding(textView.getPaddingLeft(), n + n2, textView.getPaddingRight(), textView.getPaddingBottom());
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int n) {
        Preconditions.checkArgumentNonnegative((int)n);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n2 = Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding() ? fontMetricsInt.descent : fontMetricsInt.bottom;
        if (n <= Math.abs(n2)) return;
        textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), n - n2);
    }

    public static void setLineHeight(TextView textView, int n) {
        Preconditions.checkArgumentNonnegative((int)n);
        int n2 = textView.getPaint().getFontMetricsInt(null);
        if (n == n2) return;
        textView.setLineSpacing((float)(n - n2), 1.0f);
    }

    public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText((CharSequence)precomputedTextCompat.getPrecomputedText());
        } else {
            if (!TextViewCompat.getTextMetricsParams(textView).equalsWithoutTextDirection(precomputedTextCompat.getParams())) throw new IllegalArgumentException("Given text can not be applied to TextView.");
            textView.setText((CharSequence)precomputedTextCompat);
        }
    }

    public static void setTextAppearance(TextView textView, int n) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(n);
        } else {
            textView.setTextAppearance(textView.getContext(), n);
        }
    }

    public static void setTextMetricsParams(TextView textView, PrecomputedTextCompat.Params params) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(TextViewCompat.getTextDirection(params.getTextDirection()));
        }
        if (Build.VERSION.SDK_INT < 23) {
            float f = params.getTextPaint().getTextScaleX();
            textView.getPaint().set(params.getTextPaint());
            if (f == textView.getTextScaleX()) {
                textView.setTextScaleX(f / 2.0f + 1.0f);
            }
            textView.setTextScaleX(f);
        } else {
            textView.getPaint().set(params.getTextPaint());
            textView.setBreakStrategy(params.getBreakStrategy());
            textView.setHyphenationFrequency(params.getHyphenationFrequency());
        }
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        ActionMode.Callback callback2 = callback;
        if (!(callback instanceof OreoCallback)) return callback2;
        callback2 = callback;
        if (Build.VERSION.SDK_INT < 26) return callback2;
        callback2 = ((OreoCallback)callback).getWrappedCallback();
        return callback2;
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT < 26) return callback;
        if (Build.VERSION.SDK_INT > 27) return callback;
        if (callback instanceof OreoCallback) return callback;
        if (callback != null) return new OreoCallback(callback, textView);
        return callback;
    }
}
