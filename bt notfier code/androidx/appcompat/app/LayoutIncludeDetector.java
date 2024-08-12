/*
 * Decompiled with CFR 0.152.
 */
package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class LayoutIncludeDetector {
    private final Deque<WeakReference<XmlPullParser>> mXmlParserStack = new ArrayDeque<WeakReference<XmlPullParser>>();

    LayoutIncludeDetector() {
    }

    private static boolean isParserOutdated(XmlPullParser xmlPullParser) {
        boolean bl;
        block3: {
            boolean bl2;
            bl = bl2 = true;
            if (xmlPullParser == null) return bl;
            bl = bl2;
            try {
                if (xmlPullParser.getEventType() == 3) return bl;
                int n = xmlPullParser.getEventType();
                if (n == 1) {
                    bl = bl2;
                    break block3;
                }
                bl = false;
            }
            catch (XmlPullParserException xmlPullParserException) {
                bl = bl2;
            }
        }
        return bl;
    }

    private static XmlPullParser popOutdatedAttrHolders(Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = (XmlPullParser)deque.peek().get();
            if (!LayoutIncludeDetector.isParserOutdated(xmlPullParser)) return xmlPullParser;
            deque.pop();
        }
        return null;
    }

    private static boolean shouldInheritContext(XmlPullParser xmlPullParser, XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 == null) return false;
        if (xmlPullParser == xmlPullParser2) return false;
        try {
            if (xmlPullParser2.getEventType() != 2) return false;
            boolean bl = "include".equals(xmlPullParser2.getName());
            return bl;
        }
        catch (XmlPullParserException xmlPullParserException) {
        }
        return false;
    }

    boolean detect(AttributeSet object) {
        if (!(object instanceof XmlPullParser)) return false;
        if ((object = (XmlPullParser)object).getDepth() != 1) return false;
        XmlPullParser xmlPullParser = LayoutIncludeDetector.popOutdatedAttrHolders(this.mXmlParserStack);
        this.mXmlParserStack.push(new WeakReference<Object>(object));
        if (!LayoutIncludeDetector.shouldInheritContext((XmlPullParser)object, xmlPullParser)) return false;
        return true;
    }
}
