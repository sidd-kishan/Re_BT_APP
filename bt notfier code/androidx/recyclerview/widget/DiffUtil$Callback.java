/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

public static abstract class DiffUtil.Callback {
    public abstract boolean areContentsTheSame(int var1, int var2);

    public abstract boolean areItemsTheSame(int var1, int var2);

    public Object getChangePayload(int n, int n2) {
        return null;
    }

    public abstract int getNewListSize();

    public abstract int getOldListSize();
}
