/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  android.util.Log
 *  androidx.documentfile.provider.DocumentFile
 *  androidx.documentfile.provider.DocumentsContractApi19
 */
package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import androidx.documentfile.provider.DocumentsContractApi19;
import java.util.ArrayList;

class TreeDocumentFile
extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable == null) return;
        try {
            autoCloseable.close();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
        }
    }

    private static Uri createFile(Context context, Uri uri, String string, String string2) {
        try {
            context = DocumentsContract.createDocument((ContentResolver)context.getContentResolver(), (Uri)uri, (String)string, (String)string2);
            return context;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead((Context)this.mContext, (Uri)this.mUri);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite((Context)this.mContext, (Uri)this.mUri);
    }

    public DocumentFile createDirectory(String object) {
        object = (object = TreeDocumentFile.createFile(this.mContext, this.mUri, "vnd.android.document/directory", object)) != null ? new TreeDocumentFile(this, this.mContext, (Uri)object) : null;
        return object;
    }

    public DocumentFile createFile(String object, String string) {
        object = (object = TreeDocumentFile.createFile(this.mContext, this.mUri, object, string)) != null ? new TreeDocumentFile(this, this.mContext, (Uri)object) : null;
        return object;
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

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public DocumentFile[] listFiles() {
        var4_1 = this.mContext.getContentResolver();
        var2_2 /* !! */  = this.mUri;
        var5_4 /* !! */  = DocumentsContract.buildChildDocumentsUriUsingTree((Uri)var2_2 /* !! */ , (String)DocumentsContract.getDocumentId((Uri)var2_2 /* !! */ ));
        var6_6 = new ArrayList<Uri>();
        var1_7 = 0;
        var2_2 /* !! */  = null;
        var3_8 = null;
        var4_1 = var4_1.query(var5_4 /* !! */ , new String[]{"document_id"}, null, null, null);
        while (true) {
            var5_4 /* !! */  = var4_1;
            var3_8 = var4_1;
            var2_2 /* !! */  = var4_1;
            if (!var4_1.moveToNext()) break;
            var3_8 = var4_1;
            var2_2 /* !! */  = var4_1;
            var5_4 /* !! */  = var4_1.getString(0);
            var3_8 = var4_1;
            var2_2 /* !! */  = var4_1;
            var6_6.add(DocumentsContract.buildDocumentUriUsingTree((Uri)this.mUri, (String)var5_4 /* !! */ ));
        }
lbl23:
        // 2 sources

        while (true) {
            continue;
            break;
        }
        {
            catch (Throwable var2_3) {
            }
            catch (Exception var5_5) {}
            var3_8 = var2_2 /* !! */ ;
            {
                var3_8 = var2_2 /* !! */ ;
                var4_1 = new StringBuilder();
                var3_8 = var2_2 /* !! */ ;
                var4_1.append("Failed query: ");
                var3_8 = var2_2 /* !! */ ;
                var4_1.append(var5_5);
                var3_8 = var2_2 /* !! */ ;
                Log.w((String)"DocumentFile", (String)var4_1.toString());
                var5_4 /* !! */  = var2_2 /* !! */ ;
                ** continue;
            }
        }
        TreeDocumentFile.closeQuietly((AutoCloseable)var5_4 /* !! */ );
        var2_2 /* !! */  = var6_6.toArray(new Uri[var6_6.size()]);
        var3_8 = new DocumentFile[var2_2 /* !! */ .length];
        while (var1_7 < var2_2 /* !! */ .length) {
            var3_8[var1_7] = new TreeDocumentFile(this, this.mContext, var2_2 /* !! */ [var1_7]);
            ++var1_7;
        }
        return var3_8;
        TreeDocumentFile.closeQuietly((AutoCloseable)var3_8);
        throw var2_3;
    }

    public boolean renameTo(String string) {
        try {
            string = DocumentsContract.renameDocument((ContentResolver)this.mContext.getContentResolver(), (Uri)this.mUri, (String)string);
            if (string == null) return false;
            this.mUri = string;
            return true;
        }
        catch (Exception exception) {
        }
        return false;
    }
}
