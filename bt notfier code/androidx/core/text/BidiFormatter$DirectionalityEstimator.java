/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.text;

private static class BidiFormatter.DirectionalityEstimator {
    private static final byte[] DIR_TYPE_CACHE = new byte[1792];
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final CharSequence text;

    static {
        int n = 0;
        while (n < 1792) {
            BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE[n] = Character.getDirectionality(n);
            ++n;
        }
    }

    BidiFormatter.DirectionalityEstimator(CharSequence charSequence, boolean bl) {
        this.text = charSequence;
        this.isHtml = bl;
        this.length = charSequence.length();
    }

    private static byte getCachedDirectionality(char c) {
        byte by = c < '\u0700' ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        return by;
    }

    private byte skipEntityBackward() {
        int n;
        int n2 = this.charIndex;
        while ((n = this.charIndex) > 0) {
            char c;
            CharSequence charSequence = this.text;
            this.charIndex = --n;
            this.lastChar = c = charSequence.charAt(n);
            if (c == '&') {
                return 12;
            }
            if (c != ';') continue;
        }
        this.charIndex = n2;
        this.lastChar = (char)59;
        return 13;
    }

    private byte skipEntityForward() {
        int n;
        while ((n = this.charIndex) < this.length) {
            char c;
            CharSequence charSequence = this.text;
            this.charIndex = n + 1;
            this.lastChar = c = charSequence.charAt(n);
            if (c == ';') return 12;
        }
        return 12;
    }

    private byte skipTagBackward() {
        int n;
        int n2 = this.charIndex;
        block0: while ((n = this.charIndex) > 0) {
            int n3;
            char c;
            CharSequence charSequence = this.text;
            this.charIndex = --n;
            this.lastChar = c = charSequence.charAt(n);
            if (c == '<') {
                return 12;
            }
            if (c == '>') break;
            if (c != '\"' && c != '\'') continue;
            n = this.lastChar;
            while ((n3 = this.charIndex) > 0) {
                charSequence = this.text;
                this.charIndex = --n3;
                this.lastChar = c = charSequence.charAt(n3);
                if (c == n) continue block0;
            }
        }
        this.charIndex = n2;
        this.lastChar = (char)62;
        return 13;
    }

    /*
     * Unable to fully structure code
     */
    private byte skipTagForward() {
        var2_1 = this.charIndex;
        block0: while (true) {
            if ((var3_3 = this.charIndex) >= this.length) {
                this.charIndex = var2_1;
                this.lastChar = (char)60;
                return 13;
            }
            var5_5 = this.text;
            this.charIndex = var3_3 + 1;
            this.lastChar = var1_2 = var5_5.charAt(var3_3);
            if (var1_2 == '>') {
                return 12;
            }
            if (var1_2 != '\"' && var1_2 != '\'') continue;
            var4_4 = this.lastChar;
            while (true) {
                if ((var3_3 = this.charIndex) >= this.length) continue block0;
                var5_5 = this.text;
                this.charIndex = var3_3 + 1;
                this.lastChar = var1_2 = var5_5.charAt(var3_3);
                if (var1_2 != var4_4) ** break;
                continue block0;
            }
            break;
        }
    }

    byte dirTypeBackward() {
        byte by;
        char c;
        this.lastChar = c = this.text.charAt(this.charIndex - 1);
        if (Character.isLowSurrogate(c)) {
            int n = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(n);
            return Character.getDirectionality(n);
        }
        --this.charIndex;
        byte by2 = by = BidiFormatter.DirectionalityEstimator.getCachedDirectionality(this.lastChar);
        if (!this.isHtml) return by2;
        char c2 = this.lastChar;
        if (c2 == '>') {
            by2 = this.skipTagBackward();
        } else {
            by2 = by;
            if (c2 != ';') return by2;
            by2 = this.skipEntityBackward();
        }
        return by2;
    }

    byte dirTypeForward() {
        byte by;
        char c;
        this.lastChar = c = this.text.charAt(this.charIndex);
        if (Character.isHighSurrogate(c)) {
            int n = Character.codePointAt(this.text, this.charIndex);
            this.charIndex += Character.charCount(n);
            return Character.getDirectionality(n);
        }
        ++this.charIndex;
        byte by2 = by = BidiFormatter.DirectionalityEstimator.getCachedDirectionality(this.lastChar);
        if (!this.isHtml) return by2;
        char c2 = this.lastChar;
        if (c2 == '<') {
            by2 = this.skipTagForward();
        } else {
            by2 = by;
            if (c2 != '&') return by2;
            by2 = this.skipEntityForward();
        }
        return by2;
    }

    int getEntryDir() {
        this.charIndex = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (this.charIndex < this.length && n == 0) {
            block18: {
                block16: {
                    block17: {
                        byte by = this.dirTypeForward();
                        if (by == 0) break block16;
                        if (by == 1 || by == 2) break block17;
                        if (by == 9) continue;
                        switch (by) {
                            default: {
                                break block18;
                            }
                            case 18: {
                                --n3;
                                n2 = 0;
                                break;
                            }
                            case 16: 
                            case 17: {
                                ++n3;
                                n2 = 1;
                                break;
                            }
                            case 14: 
                            case 15: {
                                ++n3;
                                n2 = -1;
                                break;
                            }
                        }
                        continue;
                    }
                    if (n3 == 0) {
                        return 1;
                    }
                    break block18;
                }
                if (n3 == 0) {
                    return -1;
                }
            }
            n = n3;
        }
        if (n == 0) {
            return 0;
        }
        if (n2 != 0) {
            return n2;
        }
        block11: while (this.charIndex > 0) {
            switch (this.dirTypeBackward()) {
                default: {
                    continue block11;
                }
                case 18: {
                    ++n3;
                    continue block11;
                }
                case 16: 
                case 17: {
                    if (n != n3) break;
                    return 1;
                }
                case 14: 
                case 15: {
                    if (n != n3) break;
                    return -1;
                }
            }
            --n3;
        }
        return 0;
    }

    int getExitDir() {
        this.charIndex = this.length;
        int n = 0;
        int n2 = 0;
        block5: while (this.charIndex > 0) {
            block10: {
                block8: {
                    block9: {
                        byte by = this.dirTypeBackward();
                        if (by == 0) break block8;
                        if (by == 1 || by == 2) break block9;
                        if (by == 9) continue;
                        switch (by) {
                            default: {
                                if (n2 != 0) continue block5;
                                break block10;
                            }
                            case 18: {
                                ++n;
                                continue block5;
                            }
                            case 16: 
                            case 17: {
                                if (n2 != n) break;
                                return 1;
                            }
                            case 14: 
                            case 15: {
                                if (n2 != n) break;
                                return -1;
                            }
                        }
                        --n;
                        continue;
                    }
                    if (n == 0) {
                        return 1;
                    }
                    if (n2 != 0) continue;
                    break block10;
                }
                if (n == 0) {
                    return -1;
                }
                if (n2 != 0) continue;
            }
            n2 = n;
        }
        return 0;
    }
}
