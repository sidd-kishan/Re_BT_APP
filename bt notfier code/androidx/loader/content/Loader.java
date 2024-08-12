/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.util.DebugUtils
 *  androidx.loader.content.Loader$OnLoadCanceledListener
 *  androidx.loader.content.Loader$OnLoadCompleteListener
 */
package androidx.loader.content;

import android.content.Context;
import androidx.core.util.DebugUtils;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    OnLoadCompleteListener<D> mListener;
    OnLoadCanceledListener<D> mOnLoadCanceledListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    public Loader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        this.onAbandon();
    }

    public boolean cancelLoad() {
        return this.onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d, (StringBuilder)stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener == null) return;
        onLoadCanceledListener.onLoadCanceled(this);
    }

    public void deliverResult(D d) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.mListener;
        if (onLoadCompleteListener == null) return;
        onLoadCompleteListener.onLoadComplete(this, d);
    }

    @Deprecated
    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        printWriter.print(string);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(string);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (!this.mAbandoned) {
            if (!this.mReset) return;
        }
        printWriter.print(string);
        printWriter.print("mAbandoned=");
        printWriter.print(this.mAbandoned);
        printWriter.print(" mReset=");
        printWriter.println(this.mReset);
    }

    public void forceLoad() {
        this.onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    protected void onAbandon() {
    }

    protected boolean onCancelLoad() {
        return false;
    }

    public void onContentChanged() {
        if (this.mStarted) {
            this.forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    protected void onForceLoad() {
    }

    protected void onReset() {
    }

    protected void onStartLoading() {
    }

    protected void onStopLoading() {
    }

    public void registerListener(int n, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.mListener != null) throw new IllegalStateException("There is already a listener registered");
        this.mListener = onLoadCompleteListener;
        this.mId = n;
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.mOnLoadCanceledListener != null) throw new IllegalStateException("There is already a listener registered");
        this.mOnLoadCanceledListener = onLoadCanceledListener;
    }

    public void reset() {
        this.onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (!this.mProcessingChange) return;
        this.onContentChanged();
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        this.onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        this.onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean bl = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= bl;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.buildShortClassTag((Object)this, (StringBuilder)stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.mId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.mListener;
        if (onLoadCompleteListener2 == null) throw new IllegalStateException("No listener register");
        if (onLoadCompleteListener2 != onLoadCompleteListener) throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        this.mListener = null;
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener2 == null) throw new IllegalStateException("No listener register");
        if (onLoadCanceledListener2 != onLoadCanceledListener) throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        this.mOnLoadCanceledListener = null;
    }
}
