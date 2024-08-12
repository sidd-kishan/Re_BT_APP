/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinToneType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
 */
package net.sourceforge.pinyin4j.format;

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

public final class HanyuPinyinOutputFormat {
    private HanyuPinyinCaseType caseType;
    private HanyuPinyinToneType toneType;
    private HanyuPinyinVCharType vCharType;

    public HanyuPinyinOutputFormat() {
        this.restoreDefault();
    }

    public HanyuPinyinCaseType getCaseType() {
        return this.caseType;
    }

    public HanyuPinyinToneType getToneType() {
        return this.toneType;
    }

    public HanyuPinyinVCharType getVCharType() {
        return this.vCharType;
    }

    public void restoreDefault() {
        this.vCharType = HanyuPinyinVCharType.WITH_U_AND_COLON;
        this.caseType = HanyuPinyinCaseType.LOWERCASE;
        this.toneType = HanyuPinyinToneType.WITH_TONE_NUMBER;
    }

    public void setCaseType(HanyuPinyinCaseType hanyuPinyinCaseType) {
        this.caseType = hanyuPinyinCaseType;
    }

    public void setToneType(HanyuPinyinToneType hanyuPinyinToneType) {
        this.toneType = hanyuPinyinToneType;
    }

    public void setVCharType(HanyuPinyinVCharType hanyuPinyinVCharType) {
        this.vCharType = hanyuPinyinVCharType;
    }
}
