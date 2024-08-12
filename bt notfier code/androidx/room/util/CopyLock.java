/*
 * Decompiled with CFR 0.152.
 */
package androidx.room.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CopyLock {
    private static final Map<String, Lock> sThreadLocks = new HashMap<String, Lock>();
    private final File mCopyLockFile;
    private final boolean mFileLevelLock;
    private FileChannel mLockChannel;
    private final Lock mThreadLock;

    public CopyLock(String object, File file, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(".lck");
        this.mCopyLockFile = object = new File(file, stringBuilder.toString());
        this.mThreadLock = CopyLock.getThreadLock(((File)object).getAbsolutePath());
        this.mFileLevelLock = bl;
    }

    private static Lock getThreadLock(String string) {
        Map<String, Lock> map = sThreadLocks;
        synchronized (map) {
            Lock lock;
            Lock lock2 = lock = sThreadLocks.get(string);
            if (lock != null) return lock2;
            lock2 = new ReentrantLock();
            sThreadLocks.put(string, lock2);
            return lock2;
        }
    }

    public void lock() {
        this.mThreadLock.lock();
        if (!this.mFileLevelLock) return;
        try {
            Closeable closeable = new FileOutputStream(this.mCopyLockFile);
            closeable = ((FileOutputStream)closeable).getChannel();
            this.mLockChannel = closeable;
            ((FileChannel)closeable).lock();
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Unable to grab copy lock.", iOException);
        }
    }

    public void unlock() {
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            }
            catch (IOException iOException) {}
        }
        this.mThreadLock.unlock();
    }
}
