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
 */
package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ListCompositeDisposable
implements Disposable,
DisposableContainer {
    volatile boolean disposed;
    List<Disposable> resources;

    public ListCompositeDisposable() {
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> object) {
        ObjectHelper.requireNonNull(object, (String)"resources is null");
        this.resources = new LinkedList<Disposable>();
        object = object.iterator();
        while (object.hasNext()) {
            Disposable disposable = (Disposable)object.next();
            ObjectHelper.requireNonNull((Object)disposable, (String)"Disposable item is null");
            this.resources.add(disposable);
        }
    }

    public ListCompositeDisposable(Disposable ... disposableArray) {
        ObjectHelper.requireNonNull((Object)disposableArray, (String)"resources is null");
        this.resources = new LinkedList<Disposable>();
        int n = disposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            Disposable disposable = disposableArray[n2];
            ObjectHelper.requireNonNull((Object)disposable, (String)"Disposable item is null");
            this.resources.add(disposable);
            ++n2;
        }
    }

    public boolean add(Disposable disposable) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    LinkedList<Disposable> linkedList;
                    LinkedList<Disposable> linkedList2 = linkedList = this.resources;
                    if (linkedList == null) {
                        linkedList2 = new LinkedList<Disposable>();
                        this.resources = linkedList2;
                    }
                    linkedList2.add(disposable);
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
            ObjectHelper.requireNonNull((Object)disposableArray, (String)"ds is null");
            boolean bl = this.disposed;
            n = 0;
            if (bl) break block8;
            synchronized (this) {
                Disposable disposable;
                if (this.disposed) break block8;
                Disposable disposable2 = disposable = this.resources;
                if (disposable == null) {
                    disposable2 = new LinkedList();
                    this.resources = disposable2;
                }
                int n2 = disposableArray.length;
                while (n < n2) {
                    disposable = disposableArray[n];
                    ObjectHelper.requireNonNull((Object)disposable, (String)"d is null");
                    disposable2.add(disposable);
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
        List<Disposable> list;
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            list = this.resources;
            this.resources = null;
        }
        this.dispose(list);
    }

    public boolean delete(Disposable disposable) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"Disposable item is null");
        if (this.disposed) {
            return false;
        }
        synchronized (this) {
            if (this.disposed) {
                return false;
            }
            List<Disposable> list = this.resources;
            if (list == null) return false;
            if (list.remove(disposable)) return true;
            return false;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void dispose() {
        List<Disposable> list;
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            list = this.resources;
            this.resources = null;
        }
        this.dispose(list);
    }

    void dispose(List<Disposable> object) {
        if (object == null) {
            return;
        }
        Object object2 = null;
        Iterator<Disposable> iterator = object.iterator();
        object = object2;
        while (true) {
            if (!iterator.hasNext()) {
                if (object == null) return;
                if (object.size() != 1) throw new CompositeException(object);
                throw ExceptionHelper.wrapOrThrow((Throwable)((Throwable)object.get(0)));
            }
            object2 = iterator.next();
            try {
                object2.dispose();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                object2 = object;
                if (object == null) {
                    object2 = new ArrayList();
                }
                object2.add(throwable);
                object = object2;
                continue;
            }
            break;
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
}
