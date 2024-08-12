/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.multidex.ZipUtil$CentralDirectory
 */
package androidx.multidex;

import androidx.multidex.ZipUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    ZipUtil() {
    }

    static long computeCrcOfCentralDir(RandomAccessFile randomAccessFile, CentralDirectory object) throws IOException {
        CRC32 cRC32 = new CRC32();
        long l = object.size;
        randomAccessFile.seek(object.offset);
        int n = (int)Math.min(16384L, l);
        object = new byte[16384];
        n = randomAccessFile.read((byte[])object, 0, n);
        while (n != -1) {
            cRC32.update((byte[])object, 0, n);
            if ((l -= (long)n) == 0L) {
                return cRC32.getValue();
            }
            n = randomAccessFile.read((byte[])object, 0, (int)Math.min(16384L, l));
        }
        return cRC32.getValue();
    }

    static CentralDirectory findCentralDirectory(RandomAccessFile object) throws IOException, ZipException {
        long l = ((RandomAccessFile)object).length() - 22L;
        long l2 = 0L;
        if (l < 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File too short to be a zip file: ");
            stringBuilder.append(((RandomAccessFile)object).length());
            object = new ZipException(stringBuilder.toString());
            throw object;
        }
        long l3 = l - 65536L;
        if (l3 >= 0L) {
            l2 = l3;
        }
        int n = Integer.reverseBytes(101010256);
        while (true) {
            ((RandomAccessFile)object).seek(l);
            if (((RandomAccessFile)object).readInt() == n) {
                ((RandomAccessFile)object).skipBytes(2);
                ((RandomAccessFile)object).skipBytes(2);
                ((RandomAccessFile)object).skipBytes(2);
                ((RandomAccessFile)object).skipBytes(2);
                CentralDirectory centralDirectory = new CentralDirectory();
                centralDirectory.size = (long)Integer.reverseBytes(((RandomAccessFile)object).readInt()) & 0xFFFFFFFFL;
                centralDirectory.offset = (long)Integer.reverseBytes(((RandomAccessFile)object).readInt()) & 0xFFFFFFFFL;
                return centralDirectory;
            }
            if (--l < l2) throw new ZipException("End Of Central Directory signature not found");
        }
    }

    static long getZipCrc(File object) throws IOException {
        object = new RandomAccessFile((File)object, "r");
        try {
            long l = ZipUtil.computeCrcOfCentralDir((RandomAccessFile)object, ZipUtil.findCentralDirectory((RandomAccessFile)object));
            return l;
        }
        finally {
            ((RandomAccessFile)object).close();
        }
    }
}
