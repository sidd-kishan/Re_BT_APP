/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

public static abstract class DiffUtil.ItemCallback<T> {
    public abstract boolean areContentsTheSame(T var1, T var2);

    public abstract boolean areItemsTheSame(T var1, T var2);

    public Object getChangePayload(T t, T t2) {
        return null;
    }
}
