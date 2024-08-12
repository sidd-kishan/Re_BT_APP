/*
 * Decompiled with CFR 0.152.
 */
package net.sourceforge.pinyin4j.format;

public class HanyuPinyinCaseType {
    public static final HanyuPinyinCaseType LOWERCASE;
    public static final HanyuPinyinCaseType UPPERCASE;
    protected String name;

    static {
        UPPERCASE = new HanyuPinyinCaseType("UPPERCASE");
        LOWERCASE = new HanyuPinyinCaseType("LOWERCASE");
    }

    protected HanyuPinyinCaseType(String string) {
        this.setName(string);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String string) {
        this.name = string;
    }
}
