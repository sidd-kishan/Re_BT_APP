/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.language;

import java.util.Locale;

public class LocaleTransform {
    public static Locale getLanguage(int n) {
        switch (n) {
            default: {
                return Locale.CHINESE;
            }
            case 8: {
                return new Locale("es", "ES");
            }
            case 7: {
                return new Locale("vi");
            }
            case 6: {
                return Locale.JAPAN;
            }
            case 5: {
                return Locale.FRANCE;
            }
            case 4: {
                return Locale.GERMANY;
            }
            case 3: {
                return Locale.KOREA;
            }
            case 2: {
                return Locale.ENGLISH;
            }
            case 1: 
        }
        return Locale.TRADITIONAL_CHINESE;
    }
}
