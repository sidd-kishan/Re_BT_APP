/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
 *  net.sourceforge.pinyin4j.format.HanyuPinyinToneType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
 *  net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination
 */
package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

class PinyinFormatter {
    PinyinFormatter() {
    }

    private static String convertToneNumber2ToneMark(String string) {
        int n;
        int n2;
        int n3;
        CharSequence charSequence;
        block8: {
            string = string.toLowerCase();
            charSequence = string;
            if (!string.matches("[a-z]*[1-5]?")) return charSequence;
            if (!string.matches("[a-z]*[1-5]")) {
                charSequence = string.replaceAll("v", "\u00fc");
                return charSequence;
            }
            n3 = Character.getNumericValue(string.charAt(string.length() - 1));
            int n4 = 97;
            n2 = string.indexOf(97);
            int n5 = string.indexOf(101);
            n = string.indexOf("ou");
            if (-1 != n2) {
                n = n4;
            } else if (-1 != n5) {
                n2 = n5;
                n = 101;
            } else if (-1 != n) {
                n5 = "ou".charAt(0);
                n2 = n;
                n = n5;
            } else {
                for (n2 = string.length() - 1; n2 >= 0; --n2) {
                    if (!String.valueOf(string.charAt(n2)).matches("[aeiouv]")) continue;
                    n = string.charAt(n2);
                    break block8;
                }
                n = 36;
                n2 = -1;
            }
        }
        charSequence = string;
        if (36 == n) return charSequence;
        charSequence = string;
        if (-1 == n2) return charSequence;
        char c = "\u0101\u00e1\u0103\u00e0a\u0113\u00e9\u0115\u00e8e\u012b\u00ed\u012d\u00eci\u014d\u00f3\u014f\u00f2o\u016b\u00fa\u016d\u00f9u\u01d6\u01d8\u01da\u01dc\u00fc".charAt("aeiouv".indexOf(n) * 5 + (n3 - 1));
        charSequence = new StringBuffer();
        ((StringBuffer)charSequence).append(string.substring(0, n2).replaceAll("v", "\u00fc"));
        ((StringBuffer)charSequence).append(c);
        ((StringBuffer)charSequence).append(string.substring(n2 + 1, string.length() - 1).replaceAll("v", "\u00fc"));
        charSequence = ((StringBuffer)charSequence).toString();
        return charSequence;
    }

    static String formatHanyuPinyin(String string, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        String string2;
        if (HanyuPinyinToneType.WITH_TONE_MARK == hanyuPinyinOutputFormat.getToneType()) {
            if (HanyuPinyinVCharType.WITH_V == hanyuPinyinOutputFormat.getVCharType()) throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
            if (HanyuPinyinVCharType.WITH_U_AND_COLON == hanyuPinyinOutputFormat.getVCharType()) throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
        }
        if (HanyuPinyinToneType.WITHOUT_TONE == hanyuPinyinOutputFormat.getToneType()) {
            string2 = string.replaceAll("[1-5]", "");
        } else {
            string2 = string;
            if (HanyuPinyinToneType.WITH_TONE_MARK == hanyuPinyinOutputFormat.getToneType()) {
                string2 = PinyinFormatter.convertToneNumber2ToneMark(string.replaceAll("u:", "v"));
            }
        }
        if (HanyuPinyinVCharType.WITH_V == hanyuPinyinOutputFormat.getVCharType()) {
            string = string2.replaceAll("u:", "v");
        } else {
            string = string2;
            if (HanyuPinyinVCharType.WITH_U_UNICODE == hanyuPinyinOutputFormat.getVCharType()) {
                string = string2.replaceAll("u:", "\u00fc");
            }
        }
        string2 = string;
        if (HanyuPinyinCaseType.UPPERCASE != hanyuPinyinOutputFormat.getCaseType()) return string2;
        string2 = string.toUpperCase();
        return string2;
    }
}
