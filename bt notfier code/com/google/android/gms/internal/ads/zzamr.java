/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class zzamr {
    public static boolean zza(XmlPullParser xmlPullParser, String string) throws XmlPullParserException {
        if (xmlPullParser.getEventType() != 3) return false;
        if (!xmlPullParser.getName().equals(string)) return false;
        return true;
    }

    public static boolean zzb(XmlPullParser xmlPullParser, String string) throws XmlPullParserException {
        if (xmlPullParser.getEventType() != 2) return false;
        if (!xmlPullParser.getName().equals(string)) return false;
        return true;
    }

    public static String zzc(XmlPullParser xmlPullParser, String string) {
        int n = xmlPullParser.getAttributeCount();
        int n2 = 0;
        while (n2 < n) {
            if (xmlPullParser.getAttributeName(n2).equals(string)) {
                return xmlPullParser.getAttributeValue(n2);
            }
            ++n2;
        }
        return null;
    }
}
