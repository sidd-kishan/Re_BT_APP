/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.ParseException
 *  net.sourceforge.pinyin4j.GwoyeuRomatzyhResource
 *  net.sourceforge.pinyin4j.PinyinRomanizationType
 *  net.sourceforge.pinyin4j.TextHelper
 */
package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;
import net.sourceforge.pinyin4j.GwoyeuRomatzyhResource;
import net.sourceforge.pinyin4j.PinyinRomanizationType;
import net.sourceforge.pinyin4j.TextHelper;

class GwoyeuRomatzyhTranslator {
    private static String[] tones = new String[]{"_I", "_II", "_III", "_IV", "_V"};

    GwoyeuRomatzyhTranslator() {
    }

    static String convertHanyuPinyinToGwoyeuRomatzyh(String charSequence) {
        String string = TextHelper.extractPinyinString((String)charSequence);
        String string2 = TextHelper.extractToneNumber((String)charSequence);
        Object var1_4 = null;
        try {
            charSequence = new StringBuffer();
            ((StringBuffer)charSequence).append("//");
            ((StringBuffer)charSequence).append(PinyinRomanizationType.HANYU_PINYIN.getTagName());
            ((StringBuffer)charSequence).append("[text()='");
            ((StringBuffer)charSequence).append(string);
            ((StringBuffer)charSequence).append("']");
            charSequence = ((StringBuffer)charSequence).toString();
            string = GwoyeuRomatzyhResource.getInstance().getPinyinToGwoyeuMappingDoc().xpathSelectElement((String)charSequence);
            charSequence = var1_4;
            if (string == null) return charSequence;
            charSequence = new StringBuffer();
            ((StringBuffer)charSequence).append("../");
            ((StringBuffer)charSequence).append(PinyinRomanizationType.GWOYEU_ROMATZYH.getTagName());
            ((StringBuffer)charSequence).append(tones[Integer.parseInt(string2) - 1]);
            ((StringBuffer)charSequence).append("/text()");
            charSequence = string.xpathSelectString(((StringBuffer)charSequence).toString());
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            charSequence = var1_4;
        }
        return charSequence;
    }
}
