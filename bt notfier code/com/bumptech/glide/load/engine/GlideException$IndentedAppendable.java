/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine;

import java.io.IOException;

private static final class GlideException.IndentedAppendable
implements Appendable {
    private static final String EMPTY_SEQUENCE = "";
    private static final String INDENT = "  ";
    private final Appendable appendable;
    private boolean printedNewLine = true;

    GlideException.IndentedAppendable(Appendable appendable) {
        this.appendable = appendable;
    }

    private CharSequence safeSequence(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        if (charSequence != null) return charSequence2;
        charSequence2 = EMPTY_SEQUENCE;
        return charSequence2;
    }

    @Override
    public Appendable append(char c) throws IOException {
        boolean bl = this.printedNewLine;
        boolean bl2 = false;
        if (bl) {
            this.printedNewLine = false;
            this.appendable.append(INDENT);
        }
        if (c == '\n') {
            bl2 = true;
        }
        this.printedNewLine = bl2;
        this.appendable.append(c);
        return this;
    }

    @Override
    public Appendable append(CharSequence charSequence) throws IOException {
        charSequence = this.safeSequence(charSequence);
        return this.append(charSequence, 0, charSequence.length());
    }

    @Override
    public Appendable append(CharSequence charSequence, int n, int n2) throws IOException {
        charSequence = this.safeSequence(charSequence);
        boolean bl = this.printedNewLine;
        boolean bl2 = false;
        if (bl) {
            this.printedNewLine = false;
            this.appendable.append(INDENT);
        }
        bl = bl2;
        if (charSequence.length() > 0) {
            bl = bl2;
            if (charSequence.charAt(n2 - 1) == '\n') {
                bl = true;
            }
        }
        this.printedNewLine = bl;
        this.appendable.append(charSequence, n, n2);
        return this;
    }
}
