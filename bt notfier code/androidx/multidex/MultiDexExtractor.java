/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.multidex.MultiDexExtractor$ExtractedDex
 *  androidx.multidex.ZipUtil
 */
package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import androidx.multidex.MultiDexExtractor;
import androidx.multidex.ZipUtil;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor
implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1L;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     */
    MultiDexExtractor(File file, File object) throws IOException {
        void var1_9;
        block9: {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MultiDexExtractor(");
            stringBuilder.append(file.getPath());
            stringBuilder.append(", ");
            stringBuilder.append(((File)object).getPath());
            stringBuilder.append(")");
            Log.i((String)TAG, (String)stringBuilder.toString());
            this.sourceApk = file;
            this.dexDir = object;
            this.sourceCrc = MultiDexExtractor.getZipCrc(file);
            file = new File((File)object, LOCK_FILENAME);
            this.lockRaf = object = new RandomAccessFile(file, "rw");
            try {
                this.lockChannel = ((RandomAccessFile)object).getChannel();
            }
            catch (Error error) {
                break block9;
            }
            catch (RuntimeException runtimeException) {
                break block9;
            }
            catch (IOException iOException) {
                // empty catch block
                break block9;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Blocking on lock ");
            ((StringBuilder)object).append(file.getPath());
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            this.cacheLock = this.lockChannel.lock();
            {
                void var1_5;
                block10: {
                    catch (Error error) {
                        break block10;
                    }
                    catch (RuntimeException runtimeException) {
                        break block10;
                    }
                    catch (IOException iOException) {
                        // empty catch block
                        break block10;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append(file.getPath());
                    ((StringBuilder)object).append(" locked");
                    Log.i((String)TAG, (String)((StringBuilder)object).toString());
                    return;
                }
                MultiDexExtractor.closeQuietly(this.lockChannel);
                throw var1_5;
            }
        }
        MultiDexExtractor.closeQuietly(this.lockRaf);
        throw var1_9;
    }

    private void clearDexDir() {
        File[] fileArray = this.dexDir.listFiles((FileFilter)new /* Unavailable Anonymous Inner Class!! */);
        if (fileArray == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to list secondary dex dir content (");
            stringBuilder.append(this.dexDir.getPath());
            stringBuilder.append(").");
            Log.w((String)TAG, (String)stringBuilder.toString());
            return;
        }
        int n = fileArray.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to delete old file ");
            stringBuilder.append(file.getPath());
            stringBuilder.append(" of size ");
            stringBuilder.append(file.length());
            Log.i((String)TAG, (String)stringBuilder.toString());
            if (!file.delete()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to delete old file ");
                stringBuilder.append(file.getPath());
                Log.w((String)TAG, (String)stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Deleted old file ");
                stringBuilder.append(file.getPath());
                Log.i((String)TAG, (String)stringBuilder.toString());
            }
            ++n2;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        }
        catch (IOException iOException) {
            Log.w((String)TAG, (String)"Failed to close resource", (Throwable)iOException);
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private static void extract(ZipFile closeable, ZipEntry object, File file, String object2) throws IOException, FileNotFoundException {
        closeable = ((ZipFile)closeable).getInputStream((ZipEntry)object);
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("tmp-");
        ((StringBuilder)object3).append((String)object2);
        object2 = File.createTempFile(((StringBuilder)object3).toString(), EXTRACTED_SUFFIX, file.getParentFile());
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Extracting ");
        ((StringBuilder)object3).append(((File)object2).getPath());
        Log.i((String)TAG, (String)((StringBuilder)object3).toString());
        FileOutputStream fileOutputStream = new FileOutputStream((File)object2);
        Object object4 = new BufferedOutputStream(fileOutputStream);
        object3 = new ZipOutputStream((OutputStream)object4);
        object4 = new ZipEntry("classes.dex");
        ((ZipEntry)object4).setTime(((ZipEntry)object).getTime());
        ((ZipOutputStream)object3).putNextEntry((ZipEntry)object4);
        object = new byte[16384];
        int n = ((InputStream)closeable).read((byte[])object);
        while (n != -1) {
            ((ZipOutputStream)object3).write((byte[])object, 0, n);
            n = ((InputStream)closeable).read((byte[])object);
        }
        ((ZipOutputStream)object3).closeEntry();
        {
            catch (Throwable throwable) {
                ((ZipOutputStream)object3).close();
                throw throwable;
            }
        }
        try {
            ((ZipOutputStream)object3).close();
            if (((File)object2).setReadOnly()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Renaming to ");
                ((StringBuilder)object).append(file.getPath());
                Log.i((String)TAG, (String)((StringBuilder)object).toString());
                boolean bl = ((File)object2).renameTo(file);
                if (bl) {
                    return;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Failed to rename \"");
                ((StringBuilder)object3).append(((File)object2).getAbsolutePath());
                ((StringBuilder)object3).append("\" to \"");
                ((StringBuilder)object3).append(file.getAbsolutePath());
                ((StringBuilder)object3).append("\"");
                object = new IOException(((StringBuilder)object3).toString());
                throw object;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Failed to mark readonly \"");
            ((StringBuilder)object3).append(((File)object2).getAbsolutePath());
            ((StringBuilder)object3).append("\" (tmp of \"");
            ((StringBuilder)object3).append(file.getAbsolutePath());
            ((StringBuilder)object3).append("\")");
            object = new IOException(((StringBuilder)object3).toString());
            throw object;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            MultiDexExtractor.closeQuietly(closeable);
            ((File)object2).delete();
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        int n = Build.VERSION.SDK_INT < 11 ? 0 : 4;
        return context.getSharedPreferences(PREFS_FILE, n);
    }

    private static long getTimeStamp(File file) {
        long l;
        long l2 = l = file.lastModified();
        if (l != -1L) return l2;
        l2 = l - 1L;
        return l2;
    }

    private static long getZipCrc(File file) throws IOException {
        long l;
        long l2 = l = ZipUtil.getZipCrc((File)file);
        if (l != -1L) return l2;
        l2 = l - 1L;
        return l2;
    }

    /*
     * Enabled force condition propagation
     */
    private static boolean isModified(Context context, File serializable, long l, String string) {
        context = MultiDexExtractor.getMultiDexPreferences(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(KEY_TIME_STAMP);
        if (context.getLong(stringBuilder.toString(), -1L) != MultiDexExtractor.getTimeStamp((File)serializable)) return true;
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append(KEY_CRC);
        if (context.getLong(((StringBuilder)serializable).toString(), -1L) != l) return true;
        return false;
    }

    private List<ExtractedDex> loadExistingExtractions(Context object, String string) throws IOException {
        long l;
        long l2;
        long l3;
        CharSequence charSequence;
        block3: {
            Log.i((String)TAG, (String)"loading existing secondary dex files");
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append(this.sourceApk.getName());
            charSequence2.append(EXTRACTED_NAME_EXT);
            charSequence2 = charSequence2.toString();
            object = MultiDexExtractor.getMultiDexPreferences((Context)object);
            Serializable serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append(KEY_DEX_NUMBER);
            int n = object.getInt(((StringBuilder)serializable).toString(), 1);
            serializable = new ArrayList(n - 1);
            int n2 = 2;
            while (n2 <= n) {
                charSequence = new StringBuilder();
                charSequence.append((String)charSequence2);
                charSequence.append(n2);
                charSequence.append(EXTRACTED_SUFFIX);
                charSequence = charSequence.toString();
                charSequence = new ExtractedDex(this.dexDir, (String)charSequence);
                if (!charSequence.isFile()) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Missing extracted secondary dex file '");
                    ((StringBuilder)object).append(charSequence.getPath());
                    ((StringBuilder)object).append("'");
                    throw new IOException(((StringBuilder)object).toString());
                }
                ((ExtractedDex)charSequence).crc = MultiDexExtractor.getZipCrc((File)((Object)charSequence));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(KEY_DEX_CRC);
                stringBuilder.append(n2);
                l3 = object.getLong(stringBuilder.toString(), -1L);
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(KEY_DEX_TIME);
                stringBuilder.append(n2);
                l2 = object.getLong(stringBuilder.toString(), -1L);
                l = charSequence.lastModified();
                if (l2 == l && l3 == ((ExtractedDex)charSequence).crc) {
                    serializable.add(charSequence);
                    ++n2;
                    continue;
                }
                break block3;
            }
            return serializable;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid extracted dex: ");
        ((StringBuilder)object).append((Object)charSequence);
        ((StringBuilder)object).append(" (key \"");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("\"), expected modification time: ");
        ((StringBuilder)object).append(l2);
        ((StringBuilder)object).append(", modification time: ");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(", expected crc: ");
        ((StringBuilder)object).append(l3);
        ((StringBuilder)object).append(", file crc: ");
        ((StringBuilder)object).append(((ExtractedDex)charSequence).crc);
        throw new IOException(((StringBuilder)object).toString());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private List<ExtractedDex> performExtractions() throws IOException {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(this.sourceApk.getName());
        ((StringBuilder)object).append(EXTRACTED_NAME_EXT);
        String string = ((StringBuilder)object).toString();
        this.clearDexDir();
        ArrayList<ExtractedDex> arrayList = new ArrayList<ExtractedDex>();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        try {
            object = new StringBuilder();
            ((StringBuilder)object).append(DEX_PREFIX);
            ((StringBuilder)object).append(2);
            ((StringBuilder)object).append(DEX_SUFFIX);
            object = zipFile.getEntry(((StringBuilder)object).toString());
            int n = 2;
            while (object != null) {
                CharSequence charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append(n);
                ((StringBuilder)charSequence).append(EXTRACTED_SUFFIX);
                charSequence = ((StringBuilder)charSequence).toString();
                ExtractedDex extractedDex = new ExtractedDex(this.dexDir, (String)charSequence);
                arrayList.add(extractedDex);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Extraction is needed for file ");
                ((StringBuilder)charSequence).append(extractedDex);
                Log.i((String)TAG, (String)((StringBuilder)charSequence).toString());
                boolean bl = false;
                for (int i = 0; i < 3 && !bl; ++i) {
                    MultiDexExtractor.extract(zipFile, (ZipEntry)object, (File)extractedDex, string);
                    try {
                        extractedDex.crc = MultiDexExtractor.getZipCrc((File)extractedDex);
                        bl = true;
                    }
                    catch (IOException iOException) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Failed to read crc from ");
                        ((StringBuilder)charSequence).append(extractedDex.getAbsolutePath());
                        Log.w((String)TAG, (String)((StringBuilder)charSequence).toString(), (Throwable)iOException);
                        bl = false;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Extraction ");
                    charSequence = bl ? "succeeded" : "failed";
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append(" '");
                    stringBuilder.append(extractedDex.getAbsolutePath());
                    stringBuilder.append("': length ");
                    stringBuilder.append(extractedDex.length());
                    stringBuilder.append(" - crc: ");
                    stringBuilder.append(extractedDex.crc);
                    Log.i((String)TAG, (String)stringBuilder.toString());
                    if (bl) continue;
                    extractedDex.delete();
                    if (!extractedDex.exists()) continue;
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("Failed to delete corrupted secondary dex '");
                    ((StringBuilder)charSequence).append(extractedDex.getPath());
                    ((StringBuilder)charSequence).append("'");
                    Log.w((String)TAG, (String)((StringBuilder)charSequence).toString());
                }
                if (bl) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(DEX_PREFIX);
                    ((StringBuilder)object).append(++n);
                    ((StringBuilder)object).append(DEX_SUFFIX);
                    object = zipFile.getEntry(((StringBuilder)object).toString());
                    continue;
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Could not create zip file ");
                ((StringBuilder)charSequence).append(extractedDex.getAbsolutePath());
                ((StringBuilder)charSequence).append(" for secondary dex (");
                ((StringBuilder)charSequence).append(n);
                ((StringBuilder)charSequence).append(")");
                object = new IOException(((StringBuilder)charSequence).toString());
                throw object;
            }
        }
        catch (Throwable throwable) {
            try {
                zipFile.close();
                throw throwable;
            }
            catch (IOException iOException) {
                Log.w((String)TAG, (String)"Failed to close resource", (Throwable)iOException);
                throw throwable;
            }
        }
        try {
            zipFile.close();
            return arrayList;
        }
        catch (IOException iOException) {
            Log.w((String)TAG, (String)"Failed to close resource", (Throwable)iOException);
        }
        return arrayList;
    }

    private static void putStoredApkInfo(Context context, String string, long l, long l2, List<ExtractedDex> object) {
        context = MultiDexExtractor.getMultiDexPreferences(context).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(KEY_TIME_STAMP);
        context.putLong(stringBuilder.toString(), l);
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(KEY_CRC);
        context.putLong(stringBuilder.toString(), l2);
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(KEY_DEX_NUMBER);
        context.putInt(stringBuilder.toString(), object.size() + 1);
        object = object.iterator();
        int n = 2;
        while (true) {
            if (!object.hasNext()) {
                context.commit();
                return;
            }
            stringBuilder = (ExtractedDex)object.next();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(KEY_DEX_CRC);
            stringBuilder2.append(n);
            context.putLong(stringBuilder2.toString(), ((ExtractedDex)stringBuilder).crc);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(KEY_DEX_TIME);
            stringBuilder2.append(n);
            context.putLong(stringBuilder2.toString(), stringBuilder.lastModified());
            ++n;
        }
    }

    @Override
    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    List<? extends File> load(Context object, String charSequence, boolean bl) throws IOException {
        List<ExtractedDex> list = new StringBuilder();
        ((StringBuilder)((Object)list)).append("MultiDexExtractor.load(");
        ((StringBuilder)((Object)list)).append(this.sourceApk.getPath());
        ((StringBuilder)((Object)list)).append(", ");
        ((StringBuilder)((Object)list)).append(bl);
        ((StringBuilder)((Object)list)).append(", ");
        ((StringBuilder)((Object)list)).append((String)charSequence);
        ((StringBuilder)((Object)list)).append(")");
        Log.i((String)TAG, (String)((StringBuilder)((Object)list)).toString());
        if (!this.cacheLock.isValid()) throw new IllegalStateException("MultiDexExtractor was closed");
        if (!bl && !MultiDexExtractor.isModified((Context)object, this.sourceApk, this.sourceCrc, (String)charSequence)) {
            try {
                list = this.loadExistingExtractions((Context)object, (String)charSequence);
                object = list;
            }
            catch (IOException iOException) {
                Log.w((String)TAG, (String)"Failed to reload existing extracted secondary dex files, falling back to fresh extraction", (Throwable)iOException);
                List<ExtractedDex> list2 = this.performExtractions();
                MultiDexExtractor.putStoredApkInfo((Context)object, (String)charSequence, MultiDexExtractor.getTimeStamp(this.sourceApk), this.sourceCrc, list2);
                object = list2;
            }
        } else {
            if (bl) {
                Log.i((String)TAG, (String)"Forced extraction must be performed.");
            } else {
                Log.i((String)TAG, (String)"Detected that extraction must be performed.");
            }
            list = this.performExtractions();
            MultiDexExtractor.putStoredApkInfo((Context)object, (String)charSequence, MultiDexExtractor.getTimeStamp(this.sourceApk), this.sourceCrc, list);
            object = list;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("load found ");
        ((StringBuilder)charSequence).append(object.size());
        ((StringBuilder)charSequence).append(" secondary dex files");
        Log.i((String)TAG, (String)((StringBuilder)charSequence).toString());
        return object;
    }
}
