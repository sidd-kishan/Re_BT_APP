/*
 * Decompiled with CFR 0.152.
 */
package net.sourceforge.pinyin4j.format;

public class HanyuPinyinVCharType {
    public static final HanyuPinyinVCharType WITH_U_AND_COLON = new HanyuPinyinVCharType("WITH_U_AND_COLON");
    public static final HanyuPinyinVCharType WITH_U_UNICODE;
    public static final HanyuPinyinVCharType WITH_V;
    protected String name;

    static {
        WITH_V = new HanyuPinyinVCharType("WITH_V");
        WITH_U_UNICODE = new HanyuPinyinVCharType("WITH_U_UNICODE");
    }

    protected HanyuPinyinVCharType(String string) {
        this.setName(string);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String string) {
        this.name = string;
    }
}
