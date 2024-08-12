/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.view;

public static final class WindowInsetsCompat.Type {
    static final int CAPTION_BAR = 4;
    static final int DISPLAY_CUTOUT = 128;
    static final int FIRST = 1;
    static final int IME = 8;
    static final int LAST = 256;
    static final int MANDATORY_SYSTEM_GESTURES = 32;
    static final int NAVIGATION_BARS = 2;
    static final int SIZE = 9;
    static final int STATUS_BARS = 1;
    static final int SYSTEM_GESTURES = 16;
    static final int TAPPABLE_ELEMENT = 64;
    static final int WINDOW_DECOR = 256;

    private WindowInsetsCompat.Type() {
    }

    static int all() {
        return -1;
    }

    public static int captionBar() {
        return 4;
    }

    public static int displayCutout() {
        return 128;
    }

    public static int ime() {
        return 8;
    }

    static int indexOf(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 4) return 2;
        if (n == 8) return 3;
        if (n == 16) return 4;
        if (n == 32) return 5;
        if (n == 64) return 6;
        if (n == 128) return 7;
        if (n == 256) {
            return 8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type needs to be >= FIRST and <= LAST, type=");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int mandatorySystemGestures() {
        return 32;
    }

    public static int navigationBars() {
        return 2;
    }

    public static int statusBars() {
        return 1;
    }

    public static int systemBars() {
        return 7;
    }

    public static int systemGestures() {
        return 16;
    }

    public static int tappableElement() {
        return 64;
    }
}
