/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.ParseException
 *  net.sourceforge.pinyin4j.PinyinRomanizationResource
 *  net.sourceforge.pinyin4j.PinyinRomanizationType
 *  net.sourceforge.pinyin4j.TextHelper
 */
package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;
import net.sourceforge.pinyin4j.PinyinRomanizationResource;
import net.sourceforge.pinyin4j.PinyinRomanizationType;
import net.sourceforge.pinyin4j.TextHelper;

class PinyinRomanizationTranslator {
    PinyinRomanizationTranslator() {
    }

    static String convertRomanizationSystem(String charSequence, PinyinRomanizationType object, PinyinRomanizationType pinyinRomanizationType) {
        String string = TextHelper.extractPinyinString((String)charSequence);
        String string2 = TextHelper.extractToneNumber((String)charSequence);
        Object var3_6 = null;
        try {
            charSequence = new StringBuffer();
            ((StringBuffer)charSequence).append("//");
            ((StringBuffer)charSequence).append(object.getTagName());
            ((StringBuffer)charSequence).append("[text()='");
            ((StringBuffer)charSequence).append(string);
            ((StringBuffer)charSequence).append("']");
            charSequence = ((StringBuffer)charSequence).toString();
            object = PinyinRomanizationResource.getInstance().getPinyinMappingDoc().xpathSelectElement((String)charSequence);
            charSequence = var3_6;
            if (object == null) return charSequence;
            charSequence = new StringBuffer();
            ((StringBuffer)charSequence).append("../");
            ((StringBuffer)charSequence).append(pinyinRomanizationType.getTagName());
            ((StringBuffer)charSequence).append("/text()");
            charSequence = object.xpathSelectString(((StringBuffer)charSequence).toString());
            object = new StringBuffer();
            ((StringBuffer)object).append((String)charSequence);
            ((StringBuffer)object).append(string2);
            charSequence = ((StringBuffer)object).toString();
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            charSequence = var3_6;
        }
        return charSequence;
    }
}
