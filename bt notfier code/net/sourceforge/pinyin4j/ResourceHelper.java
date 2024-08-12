/*
 * Decompiled with CFR 0.152.
 */
package net.sourceforge.pinyin4j;

import java.io.BufferedInputStream;

class ResourceHelper {
    static Class class$net$sourceforge$pinyin4j$ResourceHelper;

    ResourceHelper() {
    }

    static /* synthetic */ Class class$(String object) {
        try {
            object = Class.forName((String)object);
            return object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    static BufferedInputStream getResourceInputStream(String string) {
        Class clazz;
        Class clazz2 = clazz = class$net$sourceforge$pinyin4j$ResourceHelper;
        if (clazz != null) return new BufferedInputStream(clazz2.getResourceAsStream(string));
        class$net$sourceforge$pinyin4j$ResourceHelper = clazz2 = ResourceHelper.class$("net.sourceforge.pinyin4j.ResourceHelper");
        return new BufferedInputStream(clazz2.getResourceAsStream(string));
    }
}
