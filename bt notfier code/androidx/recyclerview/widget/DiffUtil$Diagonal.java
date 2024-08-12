/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

static class DiffUtil.Diagonal {
    public final int size;
    public final int x;
    public final int y;

    DiffUtil.Diagonal(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.size = n3;
    }

    int endX() {
        return this.x + this.size;
    }

    int endY() {
        return this.y + this.size;
    }
}
