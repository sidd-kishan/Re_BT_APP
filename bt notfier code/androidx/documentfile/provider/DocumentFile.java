/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.DocumentsContract
 *  androidx.documentfile.provider.RawDocumentFile
 *  androidx.documentfile.provider.SingleDocumentFile
 *  androidx.documentfile.provider.TreeDocumentFile
 */
package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.documentfile.provider.RawDocumentFile;
import androidx.documentfile.provider.SingleDocumentFile;
import androidx.documentfile.provider.TreeDocumentFile;
import java.io.File;

public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    DocumentFile(DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        return new RawDocumentFile(null, file);
    }

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 19) return null;
        return new SingleDocumentFile(null, context, uri);
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 21) return null;
        return new TreeDocumentFile(null, context, DocumentsContract.buildDocumentUriUsingTree((Uri)uri, (String)DocumentsContract.getTreeDocumentId((Uri)uri)));
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 19) return false;
        return DocumentsContract.isDocumentUri((Context)context, (Uri)uri);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String var1);

    public abstract DocumentFile createFile(String var1, String var2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String string) {
        DocumentFile[] documentFileArray = this.listFiles();
        int n = documentFileArray.length;
        int n2 = 0;
        while (n2 < n) {
            DocumentFile documentFile = documentFileArray[n2];
            if (string.equals(documentFile.getName())) {
                return documentFile;
            }
            ++n2;
        }
        return null;
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String var1);
}
