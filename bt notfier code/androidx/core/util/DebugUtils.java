/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object object, StringBuilder stringBuilder) {
        block5: {
            String string;
            block7: {
                String string2;
                block6: {
                    block4: {
                        if (object != null) break block4;
                        stringBuilder.append("null");
                        break block5;
                    }
                    string2 = object.getClass().getSimpleName();
                    if (string2 == null) break block6;
                    string = string2;
                    if (string2.length() > 0) break block7;
                }
                string2 = object.getClass().getName();
                int n = string2.lastIndexOf(46);
                string = string2;
                if (n > 0) {
                    string = string2.substring(n + 1);
                }
            }
            stringBuilder.append(string);
            stringBuilder.append('{');
            stringBuilder.append(Integer.toHexString(System.identityHashCode(object)));
        }
    }
}
