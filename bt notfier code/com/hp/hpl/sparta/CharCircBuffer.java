/*
 * Decompiled with CFR 0.152.
 */
package com.hp.hpl.sparta;

class CharCircBuffer {
    private final int[] buf_;
    private boolean enabled_ = true;
    private int next_ = 0;
    private int total_ = 0;

    CharCircBuffer(int n) {
        this.buf_ = new int[n];
    }

    private void addRaw(int n) {
        if (!this.enabled_) return;
        int[] nArray = this.buf_;
        int n2 = this.next_;
        nArray[n2] = n;
        this.next_ = (n2 + 1) % nArray.length;
        ++this.total_;
    }

    void addChar(char c) {
        this.addRaw(c);
    }

    void addInt(int n) {
        this.addRaw(n + 65536);
    }

    void addString(String object) {
        object = ((String)object).toCharArray();
        int n = ((Object)object).length;
        int n2 = 0;
        while (n2 < n) {
            this.addChar((char)object[n2]);
            ++n2;
        }
        return;
    }

    void disable() {
        this.enabled_ = false;
    }

    void enable() {
        this.enabled_ = true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.buf_.length * 11 / 10);
        int n = this.total_;
        int[] nArray = this.buf_;
        n = n < nArray.length ? nArray.length - n : 0;
        while (n < (nArray = this.buf_).length) {
            int n2 = nArray[(this.next_ + n) % nArray.length];
            if (n2 < 65536) {
                stringBuffer.append((char)n2);
            } else {
                stringBuffer.append(Integer.toString(n2 - 65536));
            }
            ++n;
        }
        return stringBuffer.toString();
    }
}
