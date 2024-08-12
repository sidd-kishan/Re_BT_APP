/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableContainer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.OpenHashSet
 */
package io.reactivex.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

public final class CompositeDisposable
implements Disposable,
DisposableContainer {
    volatile boolean disposed;
    OpenHashSet<Disposable> resources;

    public CompositeDisposable() {
    }

    public CompositeDisposable(Iterable<? extends Disposable> object) {
        ObjectHelper.requireNonNull(object, (String)"disposables is null");
        this.resources = new OpenHashSet();
        object = object.iterator();
        while (object.hasNext()) {
            Disposable disposable = (Disposable)object.next();
            ObjectHelper.requireNonNull((Object)disposable, (String)"A Disposable item in the disposables sequence is null");
            this.resources.add((Object)disposable);
        }
    }

    public CompositeDisposable(Disposable ... disposableArray) {
        ObjectHelper.requireNonNull((Object)disposableArray, (String)"disposables is null");
        this.resources = new OpenHashSet(disposableArray.length + 1);
        int n = disposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            Disposable disposable = disposableArray[n2];
            ObjectHelper.requireNonNull((Object)disposable, (String)"A Disposable in the disposables array is null");
            this.resources.add((Object)disposable);
            ++n2;
        }
    }

    public boolean add(Disposable disposable) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"disposable is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet openHashSet;
                    OpenHashSet openHashSet2 = openHashSet = this.resources;
                    if (openHashSet == null) {
                        this.resources = openHashSet2 = new OpenHashSet();
                    }
                    openHashSet2.add((Object)disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(Disposable ... disposableArray) {
        int n;
        block8: {
            ObjectHelper.requireNonNull((Object)disposableArray, (String)"disposables is null");
            boolean bl = this.disposed;
            n = 0;
            if (bl) break block8;
            synchronized (this) {
                OpenHashSet openHashSet;
                if (this.disposed) break block8;
                OpenHashSet openHashSet2 = openHashSet = this.resources;
                if (openHashSet == null) {
                    this.resources = openHashSet2 = new OpenHashSet(disposableArray.length + 1);
                }
                int n2 = disposableArray.length;
                while (n < n2) {
                    openHashSet = disposableArray[n];
                    ObjectHelper.requireNonNull((Object)openHashSet, (String)"A Disposable in the disposables array is null");
                    openHashSet2.add((Object)openHashSet);
                    ++n;
                }
                return true;
            }
        }
        int n3 = disposableArray.length;
        n = 0;
        while (n < n3) {
            disposableArray[n].dispose();
            ++n;
        }
        return false;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void clear() {
        OpenHashSet<Disposable> openHashSet;
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            openHashSet = this.resources;
            this.resources = null;
        }
        this.dispose(openHashSet);
    }

    public boolean delete(Disposable disposable) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"disposables is null");
        if (this.disposed) {
            return false;
        }
        synchronized (this) {
            if (this.disposed) {
                return false;
            }
            OpenHashSet<Disposable> openHashSet = this.resources;
            if (openHashSet == null) return false;
            if (openHashSet.remove((Object)disposable)) return true;
            return false;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void dispose() {
        OpenHashSet<Disposable> openHashSet;
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            openHashSet = this.resources;
            this.resources = null;
        }
        this.dispose(openHashSet);
    }

    void dispose(OpenHashSet<Disposable> openHashSet) {
        if (openHashSet == null) {
            return;
        }
        Object object = null;
        Object[] objectArray = openHashSet.keys();
        int n = objectArray.length;
        int n2 = 0;
        openHashSet = object;
        while (true) {
            if (n2 >= n) {
                if (openHashSet == null) return;
                if (openHashSet.size() != 1) throw new CompositeException(openHashSet);
                throw ExceptionHelper.wrapOrThrow((Throwable)((Throwable)openHashSet.get(0)));
            }
            Object object2 = objectArray[n2];
            object = openHashSet;
            if (object2 instanceof Disposable) {
                try {
                    ((Disposable)object2).dispose();
                    object = openHashSet;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    object = openHashSet;
                    if (openHashSet == null) {
                        object = new ArrayList();
                    }
                    object.add((Disposable)throwable);
                }
            }
            ++n2;
            openHashSet = object;
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean remove(Disposable disposable) {
        if (!this.delete(disposable)) return false;
        disposable.dispose();
        return true;
    }

    public int size() {
        boolean bl = this.disposed;
        int n = 0;
        if (bl) {
            return 0;
        }
        synchronized (this) {
            if (this.disposed) {
                return 0;
            }
            OpenHashSet<Disposable> openHashSet = this.resources;
            if (openHashSet == null) return n;
            n = openHashSet.size();
            return n;
        }
    }
}
