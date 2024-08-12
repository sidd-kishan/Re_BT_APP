/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Shader
 *  android.util.Log
 *  android.util.Xml
 *  androidx.core.content.res.ColorStateListInflaterCompat
 *  androidx.core.content.res.GradientColorInflaterCompat
 */
package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.GradientColorInflaterCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int n) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = n;
    }

    private static ComplexColorCompat createFromXml(Resources object, int n, Resources.Theme theme) throws IOException, XmlPullParserException {
        XmlResourceParser xmlResourceParser = object.getXml(n);
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
        while ((n = xmlResourceParser.next()) != 2 && n != 1) {
        }
        if (n != 2) {
            object = new XmlPullParserException("No start tag found");
            throw object;
        }
        String string = xmlResourceParser.getName();
        n = -1;
        int n2 = string.hashCode();
        if (n2 != 89650992) {
            if (n2 == 1191572447 && string.equals("selector")) {
                n = 0;
            }
        } else if (string.equals("gradient")) {
            n = 1;
        }
        if (n == 0) return ComplexColorCompat.from(ColorStateListInflaterCompat.createFromXmlInner((Resources)object, (XmlPullParser)xmlResourceParser, (AttributeSet)attributeSet, (Resources.Theme)theme));
        if (n == 1) {
            return ComplexColorCompat.from(GradientColorInflaterCompat.createFromXmlInner((Resources)object, (XmlPullParser)xmlResourceParser, (AttributeSet)attributeSet, (Resources.Theme)theme));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlResourceParser.getPositionDescription());
        ((StringBuilder)object).append(": unsupported complex color tag ");
        ((StringBuilder)object).append(string);
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    static ComplexColorCompat from(int n) {
        return new ComplexColorCompat(null, null, n);
    }

    static ComplexColorCompat from(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    static ComplexColorCompat from(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    public static ComplexColorCompat inflate(Resources object, int n, Resources.Theme theme) {
        try {
            object = ComplexColorCompat.createFromXml(object, n, theme);
            return object;
        }
        catch (Exception exception) {
            Log.e((String)LOG_TAG, (String)"Failed to inflate ComplexColor.", (Throwable)exception);
            return null;
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        boolean bl = this.mShader != null;
        return bl;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        boolean bl = this.mShader == null && (colorStateList = this.mColorStateList) != null && colorStateList.isStateful();
        return bl;
    }

    public boolean onStateChanged(int[] nArray) {
        boolean bl;
        ColorStateList colorStateList;
        int n;
        if (this.isStateful() && (n = (colorStateList = this.mColorStateList).getColorForState(nArray, colorStateList.getDefaultColor())) != this.mColor) {
            bl = true;
            this.mColor = n;
        } else {
            bl = false;
        }
        return bl;
    }

    public void setColor(int n) {
        this.mColor = n;
    }

    public boolean willDraw() {
        boolean bl = this.isGradient() || this.mColor != 0;
        return bl;
    }
}
