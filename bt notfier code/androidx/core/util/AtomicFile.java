/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(File file) {
        this.mBaseName = file;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".new");
        this.mNewName = new File(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".bak");
        this.mLegacyBackupName = new File(stringBuilder.toString());
    }

    private static void rename(File file, File file2) {
        StringBuilder stringBuilder;
        if (file2.isDirectory() && !file2.delete()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to delete file which is a directory ");
            stringBuilder.append(file2);
            Log.e((String)LOG_TAG, (String)stringBuilder.toString());
        }
        if (file.renameTo(file2)) return;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to rename ");
        stringBuilder.append(file);
        stringBuilder.append(" to ");
        stringBuilder.append(file2);
        Log.e((String)LOG_TAG, (String)stringBuilder.toString());
    }

    private static boolean sync(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(FileOutputStream object) {
        if (object == null) {
            return;
        }
        if (!AtomicFile.sync((FileOutputStream)object)) {
            Log.e((String)LOG_TAG, (String)"Failed to sync file output stream");
        }
        try {
            ((FileOutputStream)object).close();
        }
        catch (IOException iOException) {
            Log.e((String)LOG_TAG, (String)"Failed to close file output stream", (Throwable)iOException);
        }
        if (this.mNewName.delete()) return;
        object = new StringBuilder();
        ((StringBuilder)object).append("Failed to delete new file ");
        ((StringBuilder)object).append(this.mNewName);
        Log.e((String)LOG_TAG, (String)((StringBuilder)object).toString());
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!AtomicFile.sync(fileOutputStream)) {
            Log.e((String)LOG_TAG, (String)"Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            Log.e((String)LOG_TAG, (String)"Failed to close file output stream", (Throwable)iOException);
        }
        AtomicFile.rename(this.mNewName, this.mBaseName);
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }
        if (!this.mNewName.exists()) return new FileInputStream(this.mBaseName);
        if (!this.mBaseName.exists()) return new FileInputStream(this.mBaseName);
        if (this.mNewName.delete()) return new FileInputStream(this.mBaseName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to delete outdated new file ");
        stringBuilder.append(this.mNewName);
        Log.e((String)LOG_TAG, (String)stringBuilder.toString());
        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() throws IOException {
        int n;
        int n2;
        byte[] byArray;
        FileInputStream fileInputStream = this.openRead();
        try {
            byArray = new byte[fileInputStream.available()];
            n2 = 0;
            while (true) {
                if ((n = fileInputStream.read(byArray, n2, byArray.length - n2)) > 0) break block4;
                break;
            }
        }
        catch (Throwable throwable) {
            fileInputStream.close();
            throw throwable;
        }
        {
            block4: {
                fileInputStream.close();
                return byArray;
            }
            n = n2 + n;
            int n3 = fileInputStream.available();
            n2 = n;
            if (n3 <= byArray.length - n) continue;
            byte[] byArray2 = new byte[n3 + n];
            System.arraycopy(byArray, 0, byArray2, 0, n);
            byArray = byArray2;
            n2 = n;
            continue;
        }
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.mNewName);
            return fileOutputStream;
        }
        catch (FileNotFoundException fileNotFoundException) {
            if (!this.mNewName.getParentFile().mkdirs()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to create directory for ");
                stringBuilder.append(this.mNewName);
                throw new IOException(stringBuilder.toString());
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mNewName);
                return fileOutputStream;
            }
            catch (FileNotFoundException fileNotFoundException2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to create new file ");
                stringBuilder.append(this.mNewName);
                throw new IOException(stringBuilder.toString(), fileNotFoundException2);
            }
        }
    }
}
