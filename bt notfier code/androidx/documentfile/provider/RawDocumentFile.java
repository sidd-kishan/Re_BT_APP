/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Log
 *  android.webkit.MimeTypeMap
 *  androidx.documentfile.provider.DocumentFile
 */
package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile
extends DocumentFile {
    private File mFile;

    RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.mFile = file;
    }

    private static boolean deleteContents(File fileArray) {
        fileArray = fileArray.listFiles();
        boolean bl = true;
        boolean bl2 = true;
        if (fileArray == null) return bl;
        int n = fileArray.length;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) return bl;
            File file = fileArray[n2];
            bl = bl2;
            if (file.isDirectory()) {
                bl = bl2 & RawDocumentFile.deleteContents(file);
            }
            bl2 = bl;
            if (!file.delete()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to delete ");
                stringBuilder.append(file);
                Log.w((String)"DocumentFile", (String)stringBuilder.toString());
                bl2 = false;
            }
            ++n2;
        }
    }

    private static String getTypeForName(String string) {
        int n = string.lastIndexOf(46);
        if (n < 0) return "application/octet-stream";
        string = string.substring(n + 1).toLowerCase();
        string = MimeTypeMap.getSingleton().getMimeTypeFromExtension(string);
        if (string == null) return "application/octet-stream";
        return string;
    }

    public boolean canRead() {
        return this.mFile.canRead();
    }

    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    public DocumentFile createDirectory(String object) {
        if (((File)(object = new File(this.mFile, (String)object))).isDirectory()) return new RawDocumentFile(this, (File)object);
        if (!((File)object).mkdir()) return null;
        return new RawDocumentFile(this, (File)object);
    }

    public DocumentFile createFile(String object, String charSequence) {
        String string = MimeTypeMap.getSingleton().getExtensionFromMimeType((String)object);
        object = charSequence;
        if (string != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(".");
            ((StringBuilder)object).append(string);
            object = ((StringBuilder)object).toString();
        }
        object = new File(this.mFile, (String)object);
        try {
            ((File)object).createNewFile();
            object = new RawDocumentFile(this, (File)object);
            return object;
        }
        catch (IOException iOException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Failed to createFile: ");
            ((StringBuilder)charSequence).append(iOException);
            Log.w((String)"DocumentFile", (String)((StringBuilder)charSequence).toString());
            return null;
        }
    }

    public boolean delete() {
        RawDocumentFile.deleteContents(this.mFile);
        return this.mFile.delete();
    }

    public boolean exists() {
        return this.mFile.exists();
    }

    public String getName() {
        return this.mFile.getName();
    }

    public String getType() {
        if (!this.mFile.isDirectory()) return RawDocumentFile.getTypeForName(this.mFile.getName());
        return null;
    }

    public Uri getUri() {
        return Uri.fromFile((File)this.mFile);
    }

    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    public boolean isFile() {
        return this.mFile.isFile();
    }

    public boolean isVirtual() {
        return false;
    }

    public long lastModified() {
        return this.mFile.lastModified();
    }

    public long length() {
        return this.mFile.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList<RawDocumentFile> arrayList = new ArrayList<RawDocumentFile>();
        File[] fileArray = this.mFile.listFiles();
        if (fileArray == null) return arrayList.toArray(new DocumentFile[arrayList.size()]);
        int n = fileArray.length;
        int n2 = 0;
        while (n2 < n) {
            arrayList.add(new RawDocumentFile(this, fileArray[n2]));
            ++n2;
        }
        return arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean renameTo(String object) {
        object = new File(this.mFile.getParentFile(), (String)object);
        if (!this.mFile.renameTo((File)object)) return false;
        this.mFile = object;
        return true;
    }
}
