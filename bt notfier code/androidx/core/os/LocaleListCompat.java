/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  androidx.core.os.LocaleListCompatWrapper
 *  androidx.core.os.LocaleListInterface
 *  androidx.core.os.LocaleListPlatformWrapper
 */
package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompatWrapper;
import androidx.core.os.LocaleListInterface;
import androidx.core.os.LocaleListPlatformWrapper;
import java.util.Locale;

public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = LocaleListCompat.create(new Locale[0]);
    private LocaleListInterface mImpl;

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    public static LocaleListCompat create(Locale ... localeArray) {
        if (Build.VERSION.SDK_INT < 24) return new LocaleListCompat((LocaleListInterface)new LocaleListCompatWrapper(localeArray));
        return LocaleListCompat.wrap(new LocaleList(localeArray));
    }

    static Locale forLanguageTagCompat(String string) {
        Object object;
        if (string.contains("-")) {
            object = string.split("-", -1);
            if (((String[])object).length > 2) {
                return new Locale(object[0], object[1], object[2]);
            }
            if (((String[])object).length > 1) {
                return new Locale(object[0], object[1]);
            }
            if (((String[])object).length == 1) {
                return new Locale(object[0]);
            }
        } else {
            if (!string.contains("_")) return new Locale(string);
            object = string.split("_", -1);
            if (((String[])object).length > 2) {
                return new Locale(object[0], object[1], (String)object[2]);
            }
            if (((String[])object).length > 1) {
                return new Locale(object[0], (String)object[1]);
            }
            if (((String[])object).length == 1) {
                return new Locale((String)object[0]);
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Can not parse language tag: [");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("]");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public static LocaleListCompat forLanguageTags(String object) {
        if (object == null) return LocaleListCompat.getEmptyLocaleList();
        if (((String)object).isEmpty()) {
            return LocaleListCompat.getEmptyLocaleList();
        }
        String[] stringArray = ((String)object).split(",", -1);
        int n = stringArray.length;
        Locale[] localeArray = new Locale[n];
        int n2 = 0;
        while (n2 < n) {
            object = Build.VERSION.SDK_INT >= 21 ? Locale.forLanguageTag(stringArray[n2]) : LocaleListCompat.forLanguageTagCompat(stringArray[n2]);
            localeArray[n2] = object;
            ++n2;
        }
        return LocaleListCompat.create(localeArray);
    }

    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT < 24) return LocaleListCompat.create(Locale.getDefault());
        return LocaleListCompat.wrap(LocaleList.getAdjustedDefault());
    }

    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT < 24) return LocaleListCompat.create(Locale.getDefault());
        return LocaleListCompat.wrap(LocaleList.getDefault());
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    public static LocaleListCompat wrap(LocaleList localeList) {
        return new LocaleListCompat((LocaleListInterface)new LocaleListPlatformWrapper(localeList));
    }

    @Deprecated
    public static LocaleListCompat wrap(Object object) {
        return LocaleListCompat.wrap((LocaleList)object);
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof LocaleListCompat && this.mImpl.equals(((LocaleListCompat)object).mImpl);
        return bl;
    }

    public Locale get(int n) {
        return this.mImpl.get(n);
    }

    public Locale getFirstMatch(String[] stringArray) {
        return this.mImpl.getFirstMatch(stringArray);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public int indexOf(Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }
}
