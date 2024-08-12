/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

private static class DiffUtil.PostponedUpdate {
    int currentPos;
    int posInOwnerList;
    boolean removal;

    DiffUtil.PostponedUpdate(int n, int n2, boolean bl) {
        this.posInOwnerList = n;
        this.currentPos = n2;
        this.removal = bl;
    }
}
