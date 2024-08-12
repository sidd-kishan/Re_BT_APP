/*
 * Decompiled with CFR 0.152.
 */
package net.sourceforge.pinyin4j;

class TextHelper {
    TextHelper() {
    }

    static String extractPinyinString(String string) {
        return string.substring(0, string.length() - 1);
    }

    static String extractToneNumber(String string) {
        return string.substring(string.length() - 1);
    }
}
