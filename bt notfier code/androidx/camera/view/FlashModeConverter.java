/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.view;

final class FlashModeConverter {
    private FlashModeConverter() {
    }

    public static String nameOf(int n) {
        if (n == 0) return "AUTO";
        if (n == 1) return "ON";
        if (n == 2) {
            return "OFF";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown flash mode ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int valueOf(String string) {
        if (string == null) throw new NullPointerException("name cannot be null");
        int n = -1;
        int n2 = string.hashCode();
        if (n2 != 2527) {
            if (n2 != 78159) {
                if (n2 == 2020783 && string.equals("AUTO")) {
                    n = 0;
                }
            } else if (string.equals("OFF")) {
                n = 2;
            }
        } else if (string.equals("ON")) {
            n = 1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) {
            return 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown flash mode name ");
        stringBuilder.append(string);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
