/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.util.Log
 *  android.util.StateSet
 *  android.util.Xml
 *  androidx.core.R$attr
 *  androidx.core.R$styleable
 *  androidx.core.content.res.GrowingArrayUtils
 */
package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.content.res.GrowingArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal();

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList createFromXml(Resources object, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        while ((n = xmlPullParser.next()) != 2 && n != 1) {
        }
        if (n == 2) {
            return ColorStateListInflaterCompat.createFromXmlInner(object, xmlPullParser, attributeSet, theme);
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
    }

    public static ColorStateList createFromXmlInner(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String string = xmlPullParser.getName();
        if (string.equals("selector")) {
            return ColorStateListInflaterCompat.inflate((Resources)object, xmlPullParser, attributeSet, theme);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(": invalid color state list tag ");
        ((StringBuilder)object).append(string);
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = sTempTypedValue.get();
        if (typedValue != null) return typedValue2;
        typedValue2 = new TypedValue();
        sTempTypedValue.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList inflate(Resources resources, int n, Resources.Theme theme) {
        try {
            resources = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(n), theme);
            return resources;
        }
        catch (Exception exception) {
            Log.e((String)"CSLCompat", (String)"Failed to inflate ColorStateList.", (Throwable)exception);
            return null;
        }
    }

    private static ColorStateList inflate(Resources object, XmlPullParser object2, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n;
        int n2;
        int n3 = object2.getDepth() + 1;
        int[][] nArrayArray = new int[20][];
        int[] nArray = new int[20];
        int n4 = 0;
        while ((n2 = object2.next()) != 1 && ((n = object2.getDepth()) >= n3 || n2 != 3)) {
            int[] nArray2 = nArray;
            Object object3 = nArrayArray;
            int n5 = n4;
            if (n2 == 2) {
                nArray2 = nArray;
                object3 = nArrayArray;
                n5 = n4;
                if (n <= n3) {
                    if (!object2.getName().equals("item")) {
                        nArray2 = nArray;
                        object3 = nArrayArray;
                        n5 = n4;
                    } else {
                        object3 = ColorStateListInflaterCompat.obtainAttributes(object, theme, attributeSet, R.styleable.ColorStateListItem);
                        n5 = object3.getResourceId(R.styleable.ColorStateListItem_android_color, -1);
                        if (n5 != -1 && !ColorStateListInflaterCompat.isColorInt(object, n5)) {
                            try {
                                n5 = ColorStateListInflaterCompat.createFromXml(object, object.getXml(n5), theme).getDefaultColor();
                            }
                            catch (Exception exception) {
                                n5 = object3.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                            }
                        } else {
                            n5 = object3.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                        }
                        float f = 1.0f;
                        if (object3.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                            f = object3.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
                        } else if (object3.hasValue(R.styleable.ColorStateListItem_alpha)) {
                            f = object3.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
                        }
                        object3.recycle();
                        int n6 = attributeSet.getAttributeCount();
                        object3 = new int[n6];
                        n = 0;
                        for (n2 = 0; n2 < n6; ++n2) {
                            int n7 = attributeSet.getAttributeNameResource(n2);
                            int n8 = n;
                            if (n7 != 16843173) {
                                n8 = n;
                                if (n7 != 16843551) {
                                    n8 = n;
                                    if (n7 != R.attr.alpha) {
                                        n8 = attributeSet.getAttributeBooleanValue(n2, false) ? n7 : -n7;
                                        object3[n] = (int[])n8;
                                        n8 = n + 1;
                                    }
                                }
                            }
                            n = n8;
                        }
                        object3 = StateSet.trimStateSet((int[])object3, (int)n);
                        nArray2 = GrowingArrayUtils.append((int[])nArray, (int)n4, (int)ColorStateListInflaterCompat.modulateColorAlpha(n5, f));
                        object3 = (int[][])GrowingArrayUtils.append((Object[])nArrayArray, (int)n4, (Object)object3);
                        n5 = n4 + 1;
                    }
                }
            }
            nArray = nArray2;
            nArrayArray = object3;
            n4 = n5;
        }
        object = new int[n4];
        object2 = new int[n4][];
        System.arraycopy(nArray, 0, object, 0, n4);
        System.arraycopy(nArrayArray, 0, object2, 0, n4);
        return new ColorStateList((int[][])object2, (int[])object);
    }

    private static boolean isColorInt(Resources resources, int n) {
        TypedValue typedValue = ColorStateListInflaterCompat.getTypedValue();
        boolean bl = true;
        resources.getValue(n, typedValue, true);
        if (typedValue.type >= 28 && typedValue.type <= 31) return bl;
        bl = false;
        return bl;
    }

    private static int modulateColorAlpha(int n, float f) {
        return n & 0xFFFFFF | Math.round((float)Color.alpha((int)n) * f) << 24;
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] nArray) {
        resources = theme == null ? resources.obtainAttributes(attributeSet, nArray) : theme.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        return resources;
    }
}
