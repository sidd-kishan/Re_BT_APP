/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.core.text.ICUCompat
 */
package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class TextUtilsCompat {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT = new Locale("", "");

    private TextUtilsCompat() {
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        byte by = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        if (by == 1) return 1;
        if (by == 2) return 1;
        return 0;
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale((Locale)locale);
        }
        if (locale == null) return 0;
        if (locale.equals(ROOT)) return 0;
        String string = ICUCompat.maximizeAndGetScript((Locale)locale);
        if (string == null) {
            return TextUtilsCompat.getLayoutDirectionFromFirstChar(locale);
        }
        if (string.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG)) return 1;
        if (!string.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) return 0;
        return 1;
    }

    public static String htmlEncode(String string) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.htmlEncode((String)string);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while (n < string.length()) {
            char c = string.charAt(n);
            if (c != '\"') {
                if (c != '<') {
                    if (c != '>') {
                        if (c != '&') {
                            if (c != '\'') {
                                stringBuilder.append(c);
                            } else {
                                stringBuilder.append("&#39;");
                            }
                        } else {
                            stringBuilder.append("&amp;");
                        }
                    } else {
                        stringBuilder.append("&gt;");
                    }
                } else {
                    stringBuilder.append("&lt;");
                }
            } else {
                stringBuilder.append("&quot;");
            }
            ++n;
        }
        return stringBuilder.toString();
    }
}
