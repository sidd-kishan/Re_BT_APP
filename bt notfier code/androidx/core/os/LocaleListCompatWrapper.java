/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.core.os.LocaleListCompat
 *  androidx.core.os.LocaleListInterface
 */
package androidx.core.os;

import android.os.Build;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

final class LocaleListCompatWrapper
implements LocaleListInterface {
    private static final Locale EN_LATN;
    private static final Locale LOCALE_AR_XB;
    private static final Locale LOCALE_EN_XA;
    private static final Locale[] sEmptyList;
    private final Locale[] mList;
    private final String mStringRepresentation;

    static {
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = new Locale("en", "XA");
        LOCALE_AR_XB = new Locale("ar", "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat((String)"en-Latn");
    }

    LocaleListCompatWrapper(Locale ... object) {
        if (((Locale[])object).length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
        } else {
            ArrayList<Locale> arrayList = new ArrayList<Locale>();
            HashSet<Locale> hashSet = new HashSet<Locale>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < ((Locale[])object).length; ++i) {
                Locale locale = object[i];
                if (locale == null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("list[");
                    ((StringBuilder)object).append(i);
                    ((StringBuilder)object).append("] is null");
                    throw new NullPointerException(((StringBuilder)object).toString());
                }
                if (hashSet.contains(locale)) continue;
                locale = (Locale)locale.clone();
                arrayList.add(locale);
                LocaleListCompatWrapper.toLanguageTag(stringBuilder, locale);
                if (i < ((Object)object).length - 1) {
                    stringBuilder.append(',');
                }
                hashSet.add(locale);
            }
            this.mList = arrayList.toArray(new Locale[arrayList.size()]);
            this.mStringRepresentation = stringBuilder.toString();
        }
    }

    private Locale computeFirstMatch(Collection<String> object, boolean bl) {
        int n = this.computeFirstMatchIndex((Collection<String>)object, bl);
        object = n == -1 ? null : this.mList[n];
        return object;
    }

    private int computeFirstMatchIndex(Collection<String> object, boolean bl) {
        int n;
        block10: {
            block9: {
                Locale[] localeArray = this.mList;
                if (localeArray.length == 1) {
                    return 0;
                }
                if (localeArray.length == 0) {
                    return -1;
                }
                if (!bl) break block9;
                n = this.findFirstMatchIndex(EN_LATN);
                if (n == 0) {
                    return 0;
                }
                if (n < Integer.MAX_VALUE) break block10;
            }
            n = Integer.MAX_VALUE;
        }
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                if (n != Integer.MAX_VALUE) return n;
                return 0;
            }
            int n2 = this.findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat((String)((String)object.next())));
            if (n2 == 0) {
                return 0;
            }
            if (n2 >= n) continue;
            n = n2;
        }
    }

    private int findFirstMatchIndex(Locale locale) {
        Locale[] localeArray;
        int n = 0;
        while (n < (localeArray = this.mList).length) {
            if (LocaleListCompatWrapper.matchScore(locale, localeArray[n]) > 0) {
                return n;
            }
            ++n;
        }
        return Integer.MAX_VALUE;
    }

    private static String getLikelyScript(Locale object) {
        if (Build.VERSION.SDK_INT < 21) return "";
        if (((String)(object = ((Locale)object).getScript())).isEmpty()) return "";
        return object;
    }

    private static boolean isPseudoLocale(Locale locale) {
        boolean bl = LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale);
        return bl;
    }

    private static int matchScore(Locale object, Locale locale) {
        boolean bl = ((Locale)object).equals(locale);
        int n = 1;
        if (bl) {
            return 1;
        }
        if (!((Locale)object).getLanguage().equals(locale.getLanguage())) {
            return 0;
        }
        if (LocaleListCompatWrapper.isPseudoLocale((Locale)object)) return 0;
        if (LocaleListCompatWrapper.isPseudoLocale(locale)) {
            return 0;
        }
        String string = LocaleListCompatWrapper.getLikelyScript((Locale)object);
        if (!string.isEmpty()) return string.equals(LocaleListCompatWrapper.getLikelyScript(locale)) ? 1 : 0;
        object = ((Locale)object).getCountry();
        int n2 = n;
        if (((String)object).isEmpty()) return n2;
        n2 = ((String)object).equals(locale.getCountry()) ? n : 0;
        return n2;
    }

    static void toLanguageTag(StringBuilder stringBuilder, Locale locale) {
        stringBuilder.append(locale.getLanguage());
        String string = locale.getCountry();
        if (string == null) return;
        if (string.isEmpty()) return;
        stringBuilder.append('-');
        stringBuilder.append(locale.getCountry());
    }

    public boolean equals(Object localeArray) {
        Locale[] localeArray2;
        if (localeArray == this) {
            return true;
        }
        if (!(localeArray instanceof LocaleListCompatWrapper)) {
            return false;
        }
        localeArray = ((LocaleListCompatWrapper)localeArray).mList;
        if (this.mList.length != localeArray.length) {
            return false;
        }
        int n = 0;
        while (n < (localeArray2 = this.mList).length) {
            if (!localeArray2[n].equals(localeArray[n])) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public Locale get(int n) {
        Object object;
        object = n >= 0 && n < ((Locale[])(object = this.mList)).length ? object[n] : null;
        return object;
    }

    public Locale getFirstMatch(String[] stringArray) {
        return this.computeFirstMatch(Arrays.asList(stringArray), false);
    }

    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        Locale[] localeArray;
        int n = 1;
        int n2 = 0;
        while (n2 < (localeArray = this.mList).length) {
            n = n * 31 + localeArray[n2].hashCode();
            ++n2;
        }
        return n;
    }

    public int indexOf(Locale locale) {
        Locale[] localeArray;
        int n = 0;
        while (n < (localeArray = this.mList).length) {
            if (localeArray[n].equals(locale)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public boolean isEmpty() {
        boolean bl = this.mList.length == 0;
        return bl;
    }

    public int size() {
        return this.mList.length;
    }

    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int n = 0;
        while (true) {
            Locale[] localeArray;
            if (n >= (localeArray = this.mList).length) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            stringBuilder.append(localeArray[n]);
            if (n < this.mList.length - 1) {
                stringBuilder.append(',');
            }
            ++n;
        }
    }
}
