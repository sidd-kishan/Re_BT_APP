/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Observable$Observer
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public interface Observable<T> {
    public void addObserver(Executor var1, Observer<? super T> var2);

    public ListenableFuture<T> fetchData();

    public void removeObserver(Observer<? super T> var1);
}
