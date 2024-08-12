/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.ByteOrderedDataOutputStream
 *  androidx.camera.core.impl.utils.ExifAttribute
 *  androidx.camera.core.impl.utils.ExifData
 *  androidx.camera.core.impl.utils.ExifData$Builder
 *  androidx.camera.core.impl.utils.ExifOutputStream$JpegHeader
 *  androidx.camera.core.impl.utils.ExifTag
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ByteOrderedDataOutputStream;
import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.impl.utils.ExifTag;
import androidx.core.util.Preconditions;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public final class ExifOutputStream
extends FilterOutputStream {
    private static final short BYTE_ALIGN_II = 18761;
    private static final short BYTE_ALIGN_MM = 19789;
    private static final boolean DEBUG = false;
    private static final byte[] IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(ExifAttribute.ASCII);
    private static final int IFD_OFFSET = 8;
    private static final byte START_CODE = 42;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private final ByteBuffer mBuffer;
    private int mByteToCopy;
    private int mByteToSkip;
    private final ExifData mExifData;
    private final byte[] mSingleByteArray = new byte[1];
    private int mState = 0;

    public ExifOutputStream(OutputStream outputStream, ExifData exifData) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.mBuffer = ByteBuffer.allocate(4);
        this.mExifData = exifData;
    }

    private int requestByteToBuffer(int n, byte[] byArray, int n2, int n3) {
        n = Math.min(n3, n - this.mBuffer.position());
        this.mBuffer.put(byArray, n2, n);
        return n;
    }

    private void writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        int n;
        Object object;
        int n2;
        int[] nArray = new int[ExifData.EXIF_TAGS.length];
        Object object2 = new int[ExifData.EXIF_TAGS.length];
        Object object3 = ExifData.EXIF_POINTER_TAGS;
        int n3 = ((ExifTag[])object3).length;
        for (n2 = 0; n2 < n3; ++n2) {
            object = object3[n2];
            for (n = 0; n < ExifData.EXIF_TAGS.length; ++n) {
                this.mExifData.getAttributes(n).remove(((ExifTag)object).name);
            }
        }
        if (!this.mExifData.getAttributes(1).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(2).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(3).isEmpty()) {
            this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifData.getByteOrder()));
        }
        for (n2 = 0; n2 < ExifData.EXIF_TAGS.length; ++n2) {
            object = this.mExifData.getAttributes(n2).entrySet().iterator();
            n = 0;
            while (object.hasNext()) {
                n3 = ((ExifAttribute)((Map.Entry)object.next()).getValue()).size();
                if (n3 <= 4) continue;
                n += n3;
            }
            object2[n2] = object2[n2] + n;
        }
        n = 8;
        for (n3 = 0; n3 < ExifData.EXIF_TAGS.length; ++n3) {
            n2 = n;
            if (!this.mExifData.getAttributes(n3).isEmpty()) {
                nArray[n3] = n;
                n2 = n + (this.mExifData.getAttributes(n3).size() * 12 + 2 + 4 + object2[n3]);
            }
            n = n2;
        }
        if (!this.mExifData.getAttributes(1).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long)nArray[1], (ByteOrder)this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(2).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long)nArray[2], (ByteOrder)this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(3).isEmpty()) {
            this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long)nArray[3], (ByteOrder)this.mExifData.getByteOrder()));
        }
        byteOrderedDataOutputStream.writeUnsignedShort(n + 8);
        byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        short s = this.mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN ? (short)19789 : 18761;
        byteOrderedDataOutputStream.writeShort(s);
        byteOrderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        n2 = 0;
        while (true) {
            if (n2 >= ExifData.EXIF_TAGS.length) {
                byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
                return;
            }
            if (!this.mExifData.getAttributes(n2).isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mExifData.getAttributes(n2).size());
                n = nArray[n2] + 2 + this.mExifData.getAttributes(n2).size() * 12 + 4;
                object2 = this.mExifData.getAttributes(n2).entrySet().iterator();
                while (object2.hasNext()) {
                    Map.Entry entry = (Map.Entry)object2.next();
                    object = (ExifTag)((HashMap)ExifData.Builder.sExifTagMapsForWriting.get(n2)).get(entry.getKey());
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Tag not supported: ");
                    ((StringBuilder)object3).append((String)entry.getKey());
                    ((StringBuilder)object3).append(". Tag needs to be ported from ExifInterface to ExifData.");
                    int n4 = ((ExifTag)Preconditions.checkNotNull((Object)object, (Object)((StringBuilder)object3).toString())).number;
                    object = (ExifAttribute)entry.getValue();
                    byteOrderedDataOutputStream.writeUnsignedShort(n4);
                    byteOrderedDataOutputStream.writeUnsignedShort(((ExifAttribute)object).format);
                    byteOrderedDataOutputStream.writeInt(((ExifAttribute)object).numberOfComponents);
                    if (n3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt((long)n);
                        n += n3;
                        continue;
                    }
                    byteOrderedDataOutputStream.write(((ExifAttribute)object).bytes);
                    if (n3 >= 4) continue;
                    for (n3 = object.size(); n3 < 4; ++n3) {
                        byteOrderedDataOutputStream.writeByte(0);
                    }
                }
                byteOrderedDataOutputStream.writeUnsignedInt(0L);
                object = this.mExifData.getAttributes(n2).entrySet().iterator();
                while (object.hasNext()) {
                    object2 = (ExifAttribute)((Map.Entry)object.next()).getValue();
                    if (((ExifAttribute)object2).bytes.length <= 4) continue;
                    byteOrderedDataOutputStream.write(((ExifAttribute)object2).bytes, 0, ((ExifAttribute)object2).bytes.length);
                }
            }
            ++n2;
        }
    }

    @Override
    public void write(int n) throws IOException {
        byte[] byArray = this.mSingleByteArray;
        byArray[0] = (byte)(n & 0xFF);
        this.write(byArray);
    }

    @Override
    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) throws IOException {
        while ((this.mByteToSkip > 0 || this.mByteToCopy > 0 || this.mState != 2) && n2 > 0) {
            int n3 = this.mByteToSkip;
            int n4 = n;
            int n5 = n2;
            if (n3 > 0) {
                n4 = Math.min(n2, n3);
                n5 = n2 - n4;
                this.mByteToSkip -= n4;
                n4 = n + n4;
            }
            n3 = this.mByteToCopy;
            n = n4;
            n2 = n5;
            if (n3 > 0) {
                n = Math.min(n5, n3);
                this.out.write(byArray, n4, n);
                n2 = n5 - n;
                this.mByteToCopy -= n;
                n = n4 + n;
            }
            if (n2 == 0) {
                return;
            }
            n4 = this.mState;
            if (n4 != 0) {
                if (n4 != 1) continue;
                n4 = this.requestByteToBuffer(4, byArray, n, n2);
                n += n4;
                n2 -= n4;
                if (this.mBuffer.position() == 2 && this.mBuffer.getShort() == -39) {
                    this.out.write(this.mBuffer.array(), 0, 2);
                    this.mBuffer.rewind();
                }
                if (this.mBuffer.position() < 4) {
                    return;
                }
                this.mBuffer.rewind();
                short s = this.mBuffer.getShort();
                if (s == -31) {
                    this.mByteToSkip = (this.mBuffer.getShort() & 0xFFFF) - 2;
                    this.mState = 2;
                } else if (!JpegHeader.isSofMarker((short)s)) {
                    this.out.write(this.mBuffer.array(), 0, 4);
                    this.mByteToCopy = (this.mBuffer.getShort() & 0xFFFF) - 2;
                } else {
                    this.out.write(this.mBuffer.array(), 0, 4);
                    this.mState = 2;
                }
                this.mBuffer.rewind();
                continue;
            }
            n4 = this.requestByteToBuffer(2, byArray, n, n2);
            n += n4;
            n2 -= n4;
            if (this.mBuffer.position() < 2) {
                return;
            }
            this.mBuffer.rewind();
            if (this.mBuffer.getShort() != -40) throw new IOException("Not a valid jpeg image, cannot write exif");
            this.out.write(this.mBuffer.array(), 0, 2);
            this.mState = 1;
            this.mBuffer.rewind();
            ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(this.out, ByteOrder.BIG_ENDIAN);
            byteOrderedDataOutputStream.writeShort((short)-31);
            this.writeExifSegment(byteOrderedDataOutputStream);
        }
        if (n2 <= 0) return;
        this.out.write(byArray, n, n2);
    }
}
