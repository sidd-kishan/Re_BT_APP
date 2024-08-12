/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sourceforge.pinyin4j.ChineseToPinyinResource
 *  net.sourceforge.pinyin4j.GwoyeuRomatzyhTranslator
 *  net.sourceforge.pinyin4j.PinyinFormatter
 *  net.sourceforge.pinyin4j.PinyinRomanizationTranslator
 *  net.sourceforge.pinyin4j.PinyinRomanizationType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
 *  net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination
 */
package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.ChineseToPinyinResource;
import net.sourceforge.pinyin4j.GwoyeuRomatzyhTranslator;
import net.sourceforge.pinyin4j.PinyinFormatter;
import net.sourceforge.pinyin4j.PinyinRomanizationTranslator;
import net.sourceforge.pinyin4j.PinyinRomanizationType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinHelper {
    private PinyinHelper() {
    }

    private static String[] convertToGwoyeuRomatzyhStringArray(char c) {
        String[] stringArray = PinyinHelper.getUnformattedHanyuPinyinStringArray(c);
        if (stringArray == null) return null;
        String[] stringArray2 = new String[stringArray.length];
        int n = 0;
        while (n < stringArray.length) {
            stringArray2[n] = GwoyeuRomatzyhTranslator.convertHanyuPinyinToGwoyeuRomatzyh((String)stringArray[n]);
            ++n;
        }
        return stringArray2;
    }

    private static String[] convertToTargetPinyinStringArray(char c, PinyinRomanizationType pinyinRomanizationType) {
        String[] stringArray = PinyinHelper.getUnformattedHanyuPinyinStringArray(c);
        if (stringArray == null) return null;
        String[] stringArray2 = new String[stringArray.length];
        int n = 0;
        while (n < stringArray.length) {
            stringArray2[n] = PinyinRomanizationTranslator.convertRomanizationSystem((String)stringArray[n], (PinyinRomanizationType)PinyinRomanizationType.HANYU_PINYIN, (PinyinRomanizationType)pinyinRomanizationType);
            ++n;
        }
        return stringArray2;
    }

    private static String getFirstHanyuPinyinString(char c, HanyuPinyinOutputFormat stringArray) throws BadHanyuPinyinOutputFormatCombination {
        if ((stringArray = PinyinHelper.getFormattedHanyuPinyinStringArray(c, (HanyuPinyinOutputFormat)stringArray)) == null) return null;
        if (stringArray.length <= 0) return null;
        return stringArray[0];
    }

    private static String[] getFormattedHanyuPinyinStringArray(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        String[] stringArray = PinyinHelper.getUnformattedHanyuPinyinStringArray(c);
        if (stringArray == null) return null;
        int n = 0;
        while (n < stringArray.length) {
            stringArray[n] = PinyinFormatter.formatHanyuPinyin((String)stringArray[n], (HanyuPinyinOutputFormat)hanyuPinyinOutputFormat);
            ++n;
        }
        return stringArray;
    }

    private static String[] getUnformattedHanyuPinyinStringArray(char c) {
        return ChineseToPinyinResource.getInstance().getHanyuPinyinStringArray(c);
    }

    public static String[] toGwoyeuRomatzyhStringArray(char c) {
        return PinyinHelper.convertToGwoyeuRomatzyhStringArray(c);
    }

    public static String toHanyuPinyinString(String string, HanyuPinyinOutputFormat hanyuPinyinOutputFormat, String string2) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < string.length()) {
            String string3 = PinyinHelper.getFirstHanyuPinyinString(string.charAt(n), hanyuPinyinOutputFormat);
            if (string3 != null) {
                stringBuffer.append(string3);
                if (n != string.length() - 1) {
                    stringBuffer.append(string2);
                }
            } else {
                stringBuffer.append(string.charAt(n));
            }
            ++n;
        }
        return stringBuffer.toString();
    }

    public static String[] toHanyuPinyinStringArray(char c) {
        return PinyinHelper.getUnformattedHanyuPinyinStringArray(c);
    }

    public static String[] toHanyuPinyinStringArray(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        return PinyinHelper.getFormattedHanyuPinyinStringArray(c, hanyuPinyinOutputFormat);
    }

    public static String[] toMPS2PinyinStringArray(char c) {
        return PinyinHelper.convertToTargetPinyinStringArray(c, PinyinRomanizationType.MPS2_PINYIN);
    }

    public static String[] toTongyongPinyinStringArray(char c) {
        return PinyinHelper.convertToTargetPinyinStringArray(c, PinyinRomanizationType.TONGYONG_PINYIN);
    }

    public static String[] toWadeGilesPinyinStringArray(char c) {
        return PinyinHelper.convertToTargetPinyinStringArray(c, PinyinRomanizationType.WADEGILES_PINYIN);
    }

    public static String[] toYalePinyinStringArray(char c) {
        return PinyinHelper.convertToTargetPinyinStringArray(c, PinyinRomanizationType.YALE_PINYIN);
    }
}
