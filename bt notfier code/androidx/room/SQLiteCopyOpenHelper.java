/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.room.DatabaseConfiguration
 *  androidx.room.util.FileUtil
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteOpenHelper
 */
package androidx.room;

import android.content.Context;
import androidx.room.DatabaseConfiguration;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

class SQLiteCopyOpenHelper
implements SupportSQLiteOpenHelper {
    private final Context mContext;
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    SQLiteCopyOpenHelper(Context context, String string, File file, int n, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = string;
        this.mCopyFromFile = file;
        this.mDatabaseVersion = n;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    private void copyDatabaseFile(File file) throws IOException {
        Object object;
        if (this.mCopyFromAssetPath != null) {
            object = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else {
            if (this.mCopyFromFile == null) throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            object = new FileInputStream(this.mCopyFromFile).getChannel();
        }
        File file2 = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        file2.deleteOnExit();
        FileUtil.copy((ReadableByteChannel)object, (FileChannel)new FileOutputStream(file2).getChannel());
        object = file.getParentFile();
        if (object != null && !((File)object).exists() && !((File)object).mkdirs()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to create directories for ");
            ((StringBuilder)object).append(file.getAbsolutePath());
            throw new IOException(((StringBuilder)object).toString());
        }
        if (file2.renameTo(file)) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Failed to move intermediate file (");
        ((StringBuilder)object).append(file2.getAbsolutePath());
        ((StringBuilder)object).append(") to destination (");
        ((StringBuilder)object).append(file.getAbsolutePath());
        ((StringBuilder)object).append(").");
        throw new IOException(((StringBuilder)object).toString());
    }

    /*
     * Exception decompiling
     */
    private void verifyDatabaseFile() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 9[CATCHBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void close() {
        synchronized (this) {
            this.mDelegate.close();
            this.mVerified = false;
            return;
        }
    }

    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        synchronized (this) {
            if (!this.mVerified) {
                this.verifyDatabaseFile();
                this.mVerified = true;
            }
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegate.getReadableDatabase();
            return supportSQLiteDatabase;
        }
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        synchronized (this) {
            if (!this.mVerified) {
                this.verifyDatabaseFile();
                this.mVerified = true;
            }
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegate.getWritableDatabase();
            return supportSQLiteDatabase;
        }
    }

    void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    public void setWriteAheadLoggingEnabled(boolean bl) {
        this.mDelegate.setWriteAheadLoggingEnabled(bl);
    }
}
