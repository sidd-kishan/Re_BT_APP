/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.telephony.mbms.ServiceInfo
 */
package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;

public final class MbmsHelper {
    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context object, ServiceInfo serviceInfo) {
        int n = Build.VERSION.SDK_INT;
        Object var3_3 = null;
        if (n < 28) {
            return null;
        }
        LocaleList localeList = object.getResources().getConfiguration().getLocales();
        n = serviceInfo.getNamedContentLocales().size();
        if (n == 0) {
            return null;
        }
        object = new String[n];
        n = 0;
        Iterator iterator = serviceInfo.getNamedContentLocales().iterator();
        while (iterator.hasNext()) {
            object[n] = ((Locale)iterator.next()).toLanguageTag();
            ++n;
        }
        object = (object = localeList.getFirstMatch(object)) == null ? var3_3 : serviceInfo.getNameForLocale((Locale)object);
        return object;
    }
}
