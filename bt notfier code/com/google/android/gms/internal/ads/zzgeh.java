/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggj;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzgeh<E>
extends AbstractList<E>
implements zzggj<E> {
    private boolean zza = true;

    zzgeh() {
    }

    @Override
    public void add(int n, E e) {
        this.zzbH();
        super.add(n, e);
    }

    @Override
    public boolean add(E e) {
        this.zzbH();
        return super.add(e);
    }

    @Override
    public boolean addAll(int n, Collection<? extends E> collection) {
        this.zzbH();
        return super.addAll(n, collection);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        this.zzbH();
        return super.addAll(collection);
    }

    @Override
    public void clear() {
        this.zzbH();
        super.clear();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        if (!(object instanceof RandomAccess)) {
            return super.equals(object);
        }
        object = (List)object;
        int n = this.size();
        if (n != object.size()) return false;
        int n2 = 0;
        while (n2 < n) {
            if (!this.get(n2).equals(object.get(n2))) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n = this.size();
        int n2 = 1;
        int n3 = 0;
        while (n3 < n) {
            n2 = n2 * 31 + this.get(n3).hashCode();
            ++n3;
        }
        return n2;
    }

    @Override
    public E remove(int n) {
        this.zzbH();
        return super.remove(n);
    }

    @Override
    public final boolean remove(Object object) {
        this.zzbH();
        int n = this.indexOf(object);
        if (n == -1) {
            return false;
        }
        this.remove(n);
        return true;
    }

    @Override
    public final boolean removeAll(Collection<?> collection) {
        this.zzbH();
        return super.removeAll(collection);
    }

    @Override
    public final boolean retainAll(Collection<?> collection) {
        this.zzbH();
        return super.retainAll(collection);
    }

    @Override
    public E set(int n, E e) {
        this.zzbH();
        return super.set(n, e);
    }

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zza = false;
    }

    protected final void zzbH() {
        if (!this.zza) throw new UnsupportedOperationException();
    }
}
