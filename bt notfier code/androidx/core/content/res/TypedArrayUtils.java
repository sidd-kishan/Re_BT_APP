/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  androidx.core.content.res.ColorStateListInflaterCompat
 *  androidx.core.content.res.ComplexColorCompat
 */
package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.ComplexColorCompat;
import org.xmlpull.v1.XmlPullParser;

public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(Context context, int n, int n2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n, typedValue, true);
        if (typedValue.resourceId == 0) return n2;
        return n;
    }

    public static boolean getBoolean(TypedArray typedArray, int n, int n2, boolean bl) {
        return typedArray.getBoolean(n, typedArray.getBoolean(n2, bl));
    }

    public static Drawable getDrawable(TypedArray typedArray, int n, int n2) {
        Drawable drawable;
        Drawable drawable2 = drawable = typedArray.getDrawable(n);
        if (drawable != null) return drawable2;
        drawable2 = typedArray.getDrawable(n2);
        return drawable2;
    }

    public static int getInt(TypedArray typedArray, int n, int n2, int n3) {
        return typedArray.getInt(n, typedArray.getInt(n2, n3));
    }

    public static boolean getNamedBoolean(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n, boolean bl) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, string)) return typedArray.getBoolean(n, bl);
        return bl;
    }

    public static int getNamedColor(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n, int n2) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, string)) return typedArray.getColor(n, n2);
        return n2;
    }

    public static ColorStateList getNamedColorStateList(TypedArray object, XmlPullParser object2, Resources.Theme theme, String string, int n) {
        if (!TypedArrayUtils.hasAttribute((XmlPullParser)object2, string)) return null;
        object2 = new TypedValue();
        object.getValue(n, (TypedValue)object2);
        if (((TypedValue)object2).type != 2) {
            if (((TypedValue)object2).type < 28) return ColorStateListInflaterCompat.inflate((Resources)object.getResources(), (int)object.getResourceId(n, 0), (Resources.Theme)theme);
            if (((TypedValue)object2).type > 31) return ColorStateListInflaterCompat.inflate((Resources)object.getResources(), (int)object.getResourceId(n, 0), (Resources.Theme)theme);
            return TypedArrayUtils.getNamedColorStateListFromInt((TypedValue)object2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Failed to resolve attribute at index ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(": ");
        ((StringBuilder)object).append(object2);
        throw new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue typedValue) {
        return ColorStateList.valueOf((int)typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray typedArray, XmlPullParser object, Resources.Theme theme, String string, int n, int n2) {
        if (!TypedArrayUtils.hasAttribute((XmlPullParser)object, string)) return ComplexColorCompat.from((int)n2);
        object = new TypedValue();
        typedArray.getValue(n, (TypedValue)object);
        if (((TypedValue)object).type >= 28 && ((TypedValue)object).type <= 31) {
            return ComplexColorCompat.from((int)((TypedValue)object).data);
        }
        if ((typedArray = ComplexColorCompat.inflate((Resources)typedArray.getResources(), (int)typedArray.getResourceId(n, 0), (Resources.Theme)theme)) == null) return ComplexColorCompat.from((int)n2);
        return typedArray;
    }

    public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n, float f) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, string)) return typedArray.getFloat(n, f);
        return f;
    }

    public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n, int n2) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, string)) return typedArray.getInt(n, n2);
        return n2;
    }

    public static int getNamedResourceId(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n, int n2) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, string)) return typedArray.getResourceId(n, n2);
        return n2;
    }

    public static String getNamedString(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, string)) return typedArray.getString(n);
        return null;
    }

    public static int getResourceId(TypedArray typedArray, int n, int n2, int n3) {
        return typedArray.getResourceId(n, typedArray.getResourceId(n2, n3));
    }

    public static String getString(TypedArray typedArray, int n, int n2) {
        String string;
        String string2 = string = typedArray.getString(n);
        if (string != null) return string2;
        string2 = typedArray.getString(n2);
        return string2;
    }

    public static CharSequence getText(TypedArray typedArray, int n, int n2) {
        CharSequence charSequence;
        CharSequence charSequence2 = charSequence = typedArray.getText(n);
        if (charSequence != null) return charSequence2;
        charSequence2 = typedArray.getText(n2);
        return charSequence2;
    }

    public static CharSequence[] getTextArray(TypedArray typedArray, int n, int n2) {
        CharSequence[] charSequenceArray;
        CharSequence[] charSequenceArray2 = charSequenceArray = typedArray.getTextArray(n);
        if (charSequenceArray != null) return charSequenceArray2;
        charSequenceArray2 = typedArray.getTextArray(n2);
        return charSequenceArray2;
    }

    public static boolean hasAttribute(XmlPullParser xmlPullParser, String string) {
        boolean bl = xmlPullParser.getAttributeValue(NAMESPACE, string) != null;
        return bl;
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] nArray) {
        if (theme != null) return theme.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        return resources.obtainAttributes(attributeSet, nArray);
    }

    public static TypedValue peekNamedValue(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, string)) return typedArray.peekValue(n);
        return null;
    }
}
