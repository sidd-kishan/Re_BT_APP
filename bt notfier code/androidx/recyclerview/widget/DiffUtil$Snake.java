/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.DiffUtil$Diagonal
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;

static class DiffUtil.Snake {
    public int endX;
    public int endY;
    public boolean reverse;
    public int startX;
    public int startY;

    DiffUtil.Snake() {
    }

    int diagonalSize() {
        return Math.min(this.endX - this.startX, this.endY - this.startY);
    }

    boolean hasAdditionOrRemoval() {
        boolean bl = this.endY - this.startY != this.endX - this.startX;
        return bl;
    }

    boolean isAddition() {
        boolean bl = this.endY - this.startY > this.endX - this.startX;
        return bl;
    }

    DiffUtil.Diagonal toDiagonal() {
        if (!this.hasAdditionOrRemoval()) {
            int n = this.startX;
            return new DiffUtil.Diagonal(n, this.startY, this.endX - n);
        }
        if (this.reverse) {
            return new DiffUtil.Diagonal(this.startX, this.startY, this.diagonalSize());
        }
        if (!this.isAddition()) return new DiffUtil.Diagonal(this.startX + 1, this.startY, this.diagonalSize());
        return new DiffUtil.Diagonal(this.startX, this.startY + 1, this.diagonalSize());
    }
}
