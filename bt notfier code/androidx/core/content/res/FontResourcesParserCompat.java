/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.Base64
 *  android.util.Xml
 *  androidx.core.R$styleable
 *  androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry
 *  androidx.core.provider.FontRequest
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray typedArray, int n) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(n);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(n, typedValue);
        return typedValue.type;
    }

    public static FamilyResourceEntry parse(XmlPullParser object, Resources resources) throws XmlPullParserException, IOException {
        int n;
        while ((n = object.next()) != 2 && n != 1) {
        }
        if (n == 2) {
            return FontResourcesParserCompat.readFamilies((XmlPullParser)object, resources);
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static List<List<byte[]>> readCerts(Resources object, int n) {
        int n2;
        if (n2 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArray = object.obtainTypedArray(n2);
        try {
            if (typedArray.length() == 0) {
                List<List<byte[]>> list = Collections.emptyList();
                return list;
            }
            ArrayList<List<byte[]>> arrayList = new ArrayList<List<byte[]>>();
            if (FontResourcesParserCompat.getType(typedArray, 0) == 1) {
                n2 = 0;
                while (n2 < typedArray.length()) {
                    int n3 = typedArray.getResourceId(n2, 0);
                    if (n3 != 0) {
                        arrayList.add(FontResourcesParserCompat.toByteArrayList(object.getStringArray(n3)));
                    }
                    ++n2;
                }
                return arrayList;
            }
            arrayList.add(FontResourcesParserCompat.toByteArrayList(object.getStringArray(n2)));
            return arrayList;
        }
        finally {
            typedArray.recycle();
        }
    }

    private static FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return FontResourcesParserCompat.readFamily(xmlPullParser, resources);
        }
        FontResourcesParserCompat.skip(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry readFamily(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArray = resources.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.FontFamily);
        Object object = typedArray.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string = typedArray.getString(R.styleable.FontFamily_fontProviderPackage);
        String string2 = typedArray.getString(R.styleable.FontFamily_fontProviderQuery);
        int n = typedArray.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int n2 = typedArray.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int n3 = typedArray.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string3 = typedArray.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        typedArray.recycle();
        if (object != null && string != null && string2 != null) {
            while (xmlPullParser.next() != 3) {
                FontResourcesParserCompat.skip(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest((String)object, string, string2, FontResourcesParserCompat.readCerts(resources, n)), n2, n3, string3);
        }
        object = new ArrayList();
        while (true) {
            if (xmlPullParser.next() == 3) {
                if (!object.isEmpty()) return new FontFamilyFilesResourceEntry(object.toArray(new FontFileResourceEntry[object.size()]));
                return null;
            }
            if (xmlPullParser.getEventType() != 2) continue;
            if (xmlPullParser.getName().equals("font")) {
                object.add(FontResourcesParserCompat.readFont(xmlPullParser, resources));
                continue;
            }
            FontResourcesParserCompat.skip(xmlPullParser);
        }
    }

    private static FontFileResourceEntry readFont(XmlPullParser xmlPullParser, Resources object) throws XmlPullParserException, IOException {
        TypedArray typedArray = object.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.FontFamilyFont);
        int n = typedArray.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight;
        int n2 = typedArray.getInt(n, 400);
        n = typedArray.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle;
        boolean bl = 1 == typedArray.getInt(n, 0);
        n = typedArray.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        int n3 = typedArray.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings;
        String string = typedArray.getString(n3);
        n3 = typedArray.getInt(n, 0);
        n = typedArray.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int n4 = typedArray.getResourceId(n, 0);
        object = typedArray.getString(n);
        typedArray.recycle();
        while (xmlPullParser.next() != 3) {
            FontResourcesParserCompat.skip(xmlPullParser);
        }
        return new FontFileResourceEntry((String)object, n2, bl, string, n3, n4);
    }

    private static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n = 1;
        while (n > 0) {
            int n2 = xmlPullParser.next();
            if (n2 != 2) {
                if (n2 != 3) continue;
                --n;
                continue;
            }
            ++n;
        }
    }

    private static List<byte[]> toByteArrayList(String[] stringArray) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            arrayList.add(Base64.decode((String)stringArray[n2], (int)0));
            ++n2;
        }
        return arrayList;
    }
}
