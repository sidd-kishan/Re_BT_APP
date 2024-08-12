/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.LinearGradient
 *  android.graphics.RadialGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.SweepGradient
 *  android.util.Xml
 *  androidx.core.R$styleable
 *  androidx.core.content.res.GradientColorInflaterCompat$ColorStops
 *  androidx.core.content.res.TypedArrayUtils
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R;
import androidx.core.content.res.GradientColorInflaterCompat;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    private GradientColorInflaterCompat() {
    }

    private static ColorStops checkColors(ColorStops colorStops, int n, int n2, boolean bl, int n3) {
        if (colorStops != null) {
            return colorStops;
        }
        if (!bl) return new ColorStops(n, n2);
        return new ColorStops(n, n3, n2);
    }

    static Shader createFromXml(Resources object, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        while ((n = xmlPullParser.next()) != 2 && n != 1) {
        }
        if (n == 2) {
            return GradientColorInflaterCompat.createFromXmlInner(object, xmlPullParser, attributeSet, theme);
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
    }

    static Shader createFromXmlInner(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String string = xmlPullParser.getName();
        if (!string.equals("gradient")) {
            object = new StringBuilder();
            ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
            ((StringBuilder)object).append(": invalid gradient color tag ");
            ((StringBuilder)object).append(string);
            throw new XmlPullParserException(((StringBuilder)object).toString());
        }
        string = TypedArrayUtils.obtainAttributes((Resources)object, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.GradientColor);
        float f = TypedArrayUtils.getNamedFloat((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"startX", (int)R.styleable.GradientColor_android_startX, (float)0.0f);
        float f2 = TypedArrayUtils.getNamedFloat((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"startY", (int)R.styleable.GradientColor_android_startY, (float)0.0f);
        float f3 = TypedArrayUtils.getNamedFloat((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"endX", (int)R.styleable.GradientColor_android_endX, (float)0.0f);
        float f4 = TypedArrayUtils.getNamedFloat((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"endY", (int)R.styleable.GradientColor_android_endY, (float)0.0f);
        float f5 = TypedArrayUtils.getNamedFloat((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"centerX", (int)R.styleable.GradientColor_android_centerX, (float)0.0f);
        float f6 = TypedArrayUtils.getNamedFloat((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"centerY", (int)R.styleable.GradientColor_android_centerY, (float)0.0f);
        int n = TypedArrayUtils.getNamedInt((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"type", (int)R.styleable.GradientColor_android_type, (int)0);
        int n2 = TypedArrayUtils.getNamedColor((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"startColor", (int)R.styleable.GradientColor_android_startColor, (int)0);
        boolean bl = TypedArrayUtils.hasAttribute((XmlPullParser)xmlPullParser, (String)"centerColor");
        int n3 = TypedArrayUtils.getNamedColor((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"centerColor", (int)R.styleable.GradientColor_android_centerColor, (int)0);
        int n4 = TypedArrayUtils.getNamedColor((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"endColor", (int)R.styleable.GradientColor_android_endColor, (int)0);
        int n5 = TypedArrayUtils.getNamedInt((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"tileMode", (int)R.styleable.GradientColor_android_tileMode, (int)0);
        float f7 = TypedArrayUtils.getNamedFloat((TypedArray)string, (XmlPullParser)xmlPullParser, (String)"gradientRadius", (int)R.styleable.GradientColor_android_gradientRadius, (float)0.0f);
        string.recycle();
        object = GradientColorInflaterCompat.checkColors(GradientColorInflaterCompat.inflateChildElements((Resources)object, xmlPullParser, attributeSet, theme), n2, n4, bl, n3);
        if (n != 1) {
            if (n == 2) return new SweepGradient(f5, f6, ((ColorStops)object).mColors, ((ColorStops)object).mOffsets);
            return new LinearGradient(f, f2, f3, f4, ((ColorStops)object).mColors, ((ColorStops)object).mOffsets, GradientColorInflaterCompat.parseTileMode(n5));
        }
        if (f7 <= 0.0f) throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        return new RadialGradient(f5, f6, f7, ((ColorStops)object).mColors, ((ColorStops)object).mOffsets, GradientColorInflaterCompat.parseTileMode(n5));
    }

    private static ColorStops inflateChildElements(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n;
        int n2;
        int n3 = xmlPullParser.getDepth() + 1;
        ArrayList<Float> arrayList = new ArrayList<Float>(20);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(20);
        while ((n2 = xmlPullParser.next()) != 1 && ((n = xmlPullParser.getDepth()) >= n3 || n2 != 3)) {
            if (n2 != 2 || n > n3 || !xmlPullParser.getName().equals("item")) continue;
            TypedArray typedArray = TypedArrayUtils.obtainAttributes((Resources)object, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.GradientColorItem);
            boolean bl = typedArray.hasValue(R.styleable.GradientColorItem_android_color);
            boolean bl2 = typedArray.hasValue(R.styleable.GradientColorItem_android_offset);
            if (bl && bl2) {
                n = typedArray.getColor(R.styleable.GradientColorItem_android_color, 0);
                float f = typedArray.getFloat(R.styleable.GradientColorItem_android_offset, 0.0f);
                typedArray.recycle();
                arrayList2.add(n);
                arrayList.add(Float.valueOf(f));
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
            ((StringBuilder)object).append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
            throw new XmlPullParserException(((StringBuilder)object).toString());
        }
        if (arrayList2.size() <= 0) return null;
        return new ColorStops(arrayList2, arrayList);
    }

    private static Shader.TileMode parseTileMode(int n) {
        if (n == 1) return Shader.TileMode.REPEAT;
        if (n == 2) return Shader.TileMode.MIRROR;
        return Shader.TileMode.CLAMP;
    }
}
