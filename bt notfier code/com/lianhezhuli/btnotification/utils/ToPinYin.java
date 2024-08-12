/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sourceforge.pinyin4j.PinyinHelper
 *  net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
 *  net.sourceforge.pinyin4j.format.HanyuPinyinToneType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
 *  net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination
 */
package com.lianhezhuli.btnotification.utils;

import java.util.ArrayList;
import java.util.List;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ToPinYin {
    private static HanyuPinyinOutputFormat getDefaultOutputFormat() {
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
        return hanyuPinyinOutputFormat;
    }

    public static String getPinYin(String string) throws BadHanyuPinyinOutputFormatCombination {
        char[] cArray = string.toCharArray();
        string = "";
        int n = 0;
        while (n < cArray.length) {
            Object object = PinyinHelper.toHanyuPinyinStringArray((char)cArray[n], (HanyuPinyinOutputFormat)ToPinYin.getDefaultOutputFormat());
            if (object != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append((String)object[0]);
                string = stringBuilder.toString();
            } else {
                object = new StringBuilder();
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(cArray[n]);
                string = ((StringBuilder)object).toString();
            }
            ++n;
        }
        return string;
    }

    public static List<String> getPinyinList(List<String> object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        object = object.iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            try {
                arrayList.add(ToPinYin.getPinYin(string));
            }
            catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                badHanyuPinyinOutputFormatCombination.printStackTrace();
            }
        }
        return arrayList;
    }
}
