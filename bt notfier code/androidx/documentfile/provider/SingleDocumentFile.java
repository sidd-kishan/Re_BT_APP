/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  androidx.documentfile.provider.DocumentFile
 *  androidx.documentfile.provider.DocumentsContractApi19
 */
package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.documentfile.provider.DocumentFile;
import androidx.documentfile.provider.DocumentsContractApi19;

class SingleDocumentFile
extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    SingleDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead((Context)this.mContext, (Uri)this.mUri);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite((Context)this.mContext, (Uri)this.mUri);
    }

    public DocumentFile createDirectory(String string) {
        throw new UnsupportedOperationException();
    }

    public DocumentFile createFile(String string, String string2) {
        throw new UnsupportedOperationException();
    }

    public boolean delete() {
        try {
            boolean bl = DocumentsContract.deleteDocument((ContentResolver)this.mContext.getContentResolver(), (Uri)this.mUri);
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public boolean exists() {
        return DocumentsContractApi19.exists((Context)this.mContext, (Uri)this.mUri);
    }

    public String getName() {
        return DocumentsContractApi19.getName((Context)this.mContext, (Uri)this.mUri);
    }

    public String getType() {
        return DocumentsContractApi19.getType((Context)this.mContext, (Uri)this.mUri);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory((Context)this.mContext, (Uri)this.mUri);
    }

    public boolean isFile() {
        return DocumentsContractApi19.isFile((Context)this.mContext, (Uri)this.mUri);
    }

    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual((Context)this.mContext, (Uri)this.mUri);
    }

    public long lastModified() {
        return DocumentsContractApi19.lastModified((Context)this.mContext, (Uri)this.mUri);
    }

    public long length() {
        return DocumentsContractApi19.length((Context)this.mContext, (Uri)this.mUri);
    }

    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }

    public boolean renameTo(String string) {
        throw new UnsupportedOperationException();
    }
}
