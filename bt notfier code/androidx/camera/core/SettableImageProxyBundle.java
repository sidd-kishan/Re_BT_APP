/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.impl.ImageProxyBundle
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import android.util.SparseArray;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class SettableImageProxyBundle
implements ImageProxyBundle {
    private final List<Integer> mCaptureIdList;
    private boolean mClosed = false;
    final SparseArray<CallbackToFutureAdapter.Completer<ImageProxy>> mCompleters;
    private final SparseArray<ListenableFuture<ImageProxy>> mFutureResults;
    final Object mLock = new Object();
    private final List<ImageProxy> mOwnedImageProxies;
    private String mTagBundleKey = null;

    SettableImageProxyBundle(List<Integer> list, String string) {
        this.mCompleters = new SparseArray();
        this.mFutureResults = new SparseArray();
        this.mOwnedImageProxies = new ArrayList<ImageProxy>();
        this.mCaptureIdList = list;
        this.mTagBundleKey = string;
        this.setup();
    }

    private void setup() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                Iterator<Integer> iterator = this.mCaptureIdList.iterator();
                while (iterator.hasNext()) {
                    int n = iterator.next();
                    Object object2 = new /* Unavailable Anonymous Inner Class!! */;
                    object2 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)object2);
                    this.mFutureResults.put(n, object2);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void addImageProxy(ImageProxy object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            if (this.mClosed) {
                return;
            }
            Integer n = object.getImageInfo().getTagBundle().getTag(this.mTagBundleKey);
            if (n == null) {
                object = new IllegalArgumentException("CaptureId is null.");
                throw object;
            }
            Object object3 = (CallbackToFutureAdapter.Completer)this.mCompleters.get(n.intValue());
            if (object3 != null) {
                this.mOwnedImageProxies.add((ImageProxy)object);
                object3.set(object);
                return;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("ImageProxyBundle does not contain this id: ");
            ((StringBuilder)object3).append(n);
            object = new IllegalArgumentException(((StringBuilder)object3).toString());
            throw object;
        }
    }

    void close() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                if (this.mClosed) {
                    return;
                }
                Iterator<ImageProxy> iterator = this.mOwnedImageProxies.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.mOwnedImageProxies.clear();
                        this.mFutureResults.clear();
                        this.mCompleters.clear();
                        this.mClosed = true;
                        return;
                    }
                    iterator.next().close();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public List<Integer> getCaptureIds() {
        return Collections.unmodifiableList(this.mCaptureIdList);
    }

    public ListenableFuture<ImageProxy> getImageProxy(int n) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mClosed) {
                IllegalStateException illegalStateException = new IllegalStateException("ImageProxyBundle already closed.");
                throw illegalStateException;
            }
            Object object2 = (ListenableFuture)this.mFutureResults.get(n);
            if (object2 != null) {
                return object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ImageProxyBundle does not contain this id: ");
            stringBuilder.append(n);
            object2 = new IllegalArgumentException(stringBuilder.toString());
            throw object2;
        }
    }

    void reset() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                if (this.mClosed) {
                    return;
                }
                Iterator<ImageProxy> iterator = this.mOwnedImageProxies.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.mOwnedImageProxies.clear();
                        this.mFutureResults.clear();
                        this.mCompleters.clear();
                        this.setup();
                        return;
                    }
                    iterator.next().close();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
