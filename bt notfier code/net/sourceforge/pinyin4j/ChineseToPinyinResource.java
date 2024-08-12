/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sourceforge.pinyin4j.ChineseToPinyinResource$ChineseToPinyinResourceHolder
 *  net.sourceforge.pinyin4j.ResourceHelper
 */
package net.sourceforge.pinyin4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import net.sourceforge.pinyin4j.ChineseToPinyinResource;
import net.sourceforge.pinyin4j.ResourceHelper;

class ChineseToPinyinResource {
    private Properties unicodeToHanyuPinyinTable = null;

    private ChineseToPinyinResource() {
        this.initializeResource();
    }

    private String getHanyuPinyinRecordFromChar(char c) {
        String string = Integer.toHexString(c).toUpperCase();
        string = this.getUnicodeToHanyuPinyinTable().getProperty(string);
        if (this.isValidRecord(string)) return string;
        string = null;
        return string;
    }

    static ChineseToPinyinResource getInstance() {
        return ChineseToPinyinResourceHolder.theInstance;
    }

    private Properties getUnicodeToHanyuPinyinTable() {
        return this.unicodeToHanyuPinyinTable;
    }

    private void initializeResource() {
        try {
            Properties properties = new Properties();
            this.setUnicodeToHanyuPinyinTable(properties);
            this.getUnicodeToHanyuPinyinTable().load(ResourceHelper.getResourceInputStream((String)"/pinyindb/unicode_to_hanyu_pinyin.txt"));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private boolean isValidRecord(String string) {
        if (string == null) return false;
        if (string.equals("(none0)")) return false;
        if (!string.startsWith("(")) return false;
        if (!string.endsWith(")")) return false;
        return true;
    }

    private void setUnicodeToHanyuPinyinTable(Properties properties) {
        this.unicodeToHanyuPinyinTable = properties;
    }

    String[] getHanyuPinyinStringArray(char c) {
        String string = this.getHanyuPinyinRecordFromChar(c);
        if (string == null) return null;
        return string.substring(string.indexOf("(") + 1, string.lastIndexOf(")")).split(",");
    }
}
