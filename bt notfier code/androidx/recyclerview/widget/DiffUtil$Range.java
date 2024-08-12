/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

static class DiffUtil.Range {
    int newListEnd;
    int newListStart;
    int oldListEnd;
    int oldListStart;

    public DiffUtil.Range() {
    }

    public DiffUtil.Range(int n, int n2, int n3, int n4) {
        this.oldListStart = n;
        this.oldListEnd = n2;
        this.newListStart = n3;
        this.newListEnd = n4;
    }

    int newSize() {
        return this.newListEnd - this.newListStart;
    }

    int oldSize() {
        return this.oldListEnd - this.oldListStart;
    }
}
