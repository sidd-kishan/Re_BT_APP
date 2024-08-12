/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public class LensFacingConverter {
    private LensFacingConverter() {
    }

    public static String nameOf(int n) {
        if (n == 0) return "FRONT";
        if (n == 1) {
            return "BACK";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown lens facing ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int valueOf(String string) {
        if (string == null) throw new NullPointerException("name cannot be null");
        int n = -1;
        int n2 = string.hashCode();
        if (n2 != 2030823) {
            if (n2 == 67167753 && string.equals("FRONT")) {
                n = 0;
            }
        } else if (string.equals("BACK")) {
            n = 1;
        }
        if (n == 0) return 0;
        if (n == 1) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown len facing name ");
        stringBuilder.append(string);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static Integer[] values() {
        return new Integer[]{0, 1};
    }
}
