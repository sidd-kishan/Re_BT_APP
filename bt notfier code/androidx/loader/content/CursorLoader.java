/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.net.Uri
 *  androidx.core.content.ContentResolverCompat
 *  androidx.core.os.CancellationSignal
 *  androidx.core.os.OperationCanceledException
 *  androidx.loader.content.AsyncTaskLoader
 *  androidx.loader.content.Loader
 *  androidx.loader.content.Loader$ForceLoadContentObserver
 */
package androidx.loader.content;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader
extends AsyncTaskLoader<Cursor> {
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final Loader.ForceLoadContentObserver mObserver = new Loader.ForceLoadContentObserver((Loader)this);
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;

    public CursorLoader(Context context) {
        super(context);
    }

    public CursorLoader(Context context, Uri uri, String[] stringArray, String string, String[] stringArray2, String string2) {
        super(context);
        this.mUri = uri;
        this.mProjection = stringArray;
        this.mSelection = string;
        this.mSelectionArgs = stringArray2;
        this.mSortOrder = string2;
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.mCancellationSignal == null) return;
            this.mCancellationSignal.cancel();
            return;
        }
    }

    public void deliverResult(Cursor cursor) {
        if (this.isReset()) {
            if (cursor == null) return;
            cursor.close();
            return;
        }
        Cursor cursor2 = this.mCursor;
        this.mCursor = cursor;
        if (this.isStarted()) {
            super.deliverResult((Object)cursor);
        }
        if (cursor2 == null) return;
        if (cursor2 == cursor) return;
        if (cursor2.isClosed()) return;
        cursor2.close();
    }

    @Deprecated
    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        super.dump(string, fileDescriptor, printWriter, stringArray);
        printWriter.print(string);
        printWriter.print("mUri=");
        printWriter.println(this.mUri);
        printWriter.print(string);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.mProjection));
        printWriter.print(string);
        printWriter.print("mSelection=");
        printWriter.println(this.mSelection);
        printWriter.print(string);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.mSelectionArgs));
        printWriter.print(string);
        printWriter.print("mSortOrder=");
        printWriter.println(this.mSortOrder);
        printWriter.print(string);
        printWriter.print("mCursor=");
        printWriter.println(this.mCursor);
        printWriter.print(string);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

    public Uri getUri() {
        return this.mUri;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public Cursor loadInBackground() {
        CancellationSignal cancellationSignal;
        synchronized (this) {
            if (this.isLoadInBackgroundCanceled()) {
                OperationCanceledException operationCanceledException = new OperationCanceledException();
                throw operationCanceledException;
            }
            this.mCancellationSignal = cancellationSignal = new CancellationSignal();
        }
        try {
            cancellationSignal = ContentResolverCompat.query((ContentResolver)this.getContext().getContentResolver(), (Uri)this.mUri, (String[])this.mProjection, (String)this.mSelection, (String[])this.mSelectionArgs, (String)this.mSortOrder, (CancellationSignal)this.mCancellationSignal);
            if (cancellationSignal == null) return cancellationSignal;
            try {
                cancellationSignal.getCount();
                cancellationSignal.registerContentObserver((ContentObserver)this.mObserver);
                return cancellationSignal;
            }
            catch (RuntimeException runtimeException) {
                cancellationSignal.close();
                throw runtimeException;
            }
        }
        finally {
            synchronized (this) {
                this.mCancellationSignal = null;
            }
        }
    }

    public void onCanceled(Cursor cursor) {
        if (cursor == null) return;
        if (cursor.isClosed()) return;
        cursor.close();
    }

    protected void onReset() {
        super.onReset();
        this.onStopLoading();
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            this.mCursor.close();
        }
        this.mCursor = null;
    }

    protected void onStartLoading() {
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            this.deliverResult(cursor);
        }
        if (!this.takeContentChanged()) {
            if (this.mCursor != null) return;
        }
        this.forceLoad();
    }

    protected void onStopLoading() {
        this.cancelLoad();
    }

    public void setProjection(String[] stringArray) {
        this.mProjection = stringArray;
    }

    public void setSelection(String string) {
        this.mSelection = string;
    }

    public void setSelectionArgs(String[] stringArray) {
        this.mSelectionArgs = stringArray;
    }

    public void setSortOrder(String string) {
        this.mSortOrder = string;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }
}
