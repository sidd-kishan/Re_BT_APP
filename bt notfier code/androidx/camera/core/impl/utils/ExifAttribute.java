/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.ByteOrderedDataInputStream
 *  androidx.camera.core.impl.utils.LongRational
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ByteOrderedDataInputStream;
import androidx.camera.core.impl.utils.LongRational;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class ExifAttribute {
    static final Charset ASCII = StandardCharsets.US_ASCII;
    public static final long BYTES_OFFSET_UNKNOWN = -1L;
    static final byte[] EXIF_ASCII_PREFIX;
    static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
    static final int IFD_FORMAT_DOUBLE = 12;
    static final String[] IFD_FORMAT_NAMES;
    static final int IFD_FORMAT_SBYTE = 6;
    static final int IFD_FORMAT_SINGLE = 11;
    static final int IFD_FORMAT_SLONG = 9;
    static final int IFD_FORMAT_SRATIONAL = 10;
    static final int IFD_FORMAT_SSHORT = 8;
    static final int IFD_FORMAT_STRING = 2;
    static final int IFD_FORMAT_ULONG = 4;
    static final int IFD_FORMAT_UNDEFINED = 7;
    static final int IFD_FORMAT_URATIONAL = 5;
    static final int IFD_FORMAT_USHORT = 3;
    private static final String TAG = "ExifAttribute";
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    static {
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
    }

    ExifAttribute(int n, int n2, long l, byte[] byArray) {
        this.format = n;
        this.numberOfComponents = n2;
        this.bytesOffset = l;
        this.bytes = byArray;
    }

    ExifAttribute(int n, int n2, byte[] byArray) {
        this(n, n2, -1L, byArray);
    }

    public static ExifAttribute createByte(String object) {
        if (((String)object).length() == 1 && ((String)object).charAt(0) >= '0' && ((String)object).charAt(0) <= '1') {
            return new ExifAttribute(1, 1, new byte[]{(byte)(((String)object).charAt(0) - 48)});
        }
        object = ((String)object).getBytes(ASCII);
        return new ExifAttribute(1, ((Object)object).length, (byte[])object);
    }

    public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
        return ExifAttribute.createDouble(new double[]{d}, byteOrder);
    }

    public static ExifAttribute createDouble(double[] dArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[12] * dArray.length]);
        byteBuffer.order(byteOrder);
        int n = dArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putDouble(dArray[n2]);
            ++n2;
        }
        return new ExifAttribute(12, dArray.length, byteBuffer.array());
    }

    public static ExifAttribute createSLong(int n, ByteOrder byteOrder) {
        return ExifAttribute.createSLong(new int[]{n}, byteOrder);
    }

    public static ExifAttribute createSLong(int[] nArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[9] * nArray.length]);
        byteBuffer.order(byteOrder);
        int n = nArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putInt(nArray[n2]);
            ++n2;
        }
        return new ExifAttribute(9, nArray.length, byteBuffer.array());
    }

    public static ExifAttribute createSRational(LongRational longRational, ByteOrder byteOrder) {
        return ExifAttribute.createSRational(new LongRational[]{longRational}, byteOrder);
    }

    public static ExifAttribute createSRational(LongRational[] longRationalArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[10] * longRationalArray.length]);
        byteBuffer.order(byteOrder);
        int n = longRationalArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteOrder = longRationalArray[n2];
            byteBuffer.putInt((int)byteOrder.getNumerator());
            byteBuffer.putInt((int)byteOrder.getDenominator());
            ++n2;
        }
        return new ExifAttribute(10, longRationalArray.length, byteBuffer.array());
    }

    public static ExifAttribute createString(String object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append('\u0000');
        object = stringBuilder.toString().getBytes(ASCII);
        return new ExifAttribute(2, ((Object)object).length, (byte[])object);
    }

    public static ExifAttribute createULong(long l, ByteOrder byteOrder) {
        return ExifAttribute.createULong(new long[]{l}, byteOrder);
    }

    public static ExifAttribute createULong(long[] lArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[4] * lArray.length]);
        byteBuffer.order(byteOrder);
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putInt((int)lArray[n2]);
            ++n2;
        }
        return new ExifAttribute(4, lArray.length, byteBuffer.array());
    }

    public static ExifAttribute createURational(LongRational longRational, ByteOrder byteOrder) {
        return ExifAttribute.createURational(new LongRational[]{longRational}, byteOrder);
    }

    public static ExifAttribute createURational(LongRational[] longRationalArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[5] * longRationalArray.length]);
        byteBuffer.order(byteOrder);
        int n = longRationalArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteOrder = longRationalArray[n2];
            byteBuffer.putInt((int)byteOrder.getNumerator());
            byteBuffer.putInt((int)byteOrder.getDenominator());
            ++n2;
        }
        return new ExifAttribute(5, longRationalArray.length, byteBuffer.array());
    }

    public static ExifAttribute createUShort(int n, ByteOrder byteOrder) {
        return ExifAttribute.createUShort(new int[]{n}, byteOrder);
    }

    public static ExifAttribute createUShort(int[] nArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[3] * nArray.length]);
        byteBuffer.order(byteOrder);
        int n = nArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putShort((short)nArray[n2]);
            ++n2;
        }
        return new ExifAttribute(3, nArray.length, byteBuffer.array());
    }

    public double getDoubleValue(ByteOrder longRationalArray) {
        if ((longRationalArray = this.getValue((ByteOrder)longRationalArray)) == null) throw new NumberFormatException("NULL can't be converted to a double value");
        if (longRationalArray instanceof String) {
            return Double.parseDouble((String)longRationalArray);
        }
        if (longRationalArray instanceof long[]) {
            if ((longRationalArray = (LongRational[])((long[])longRationalArray)).length != 1) throw new NumberFormatException("There are more than one component");
            return (double)longRationalArray[0];
        }
        if (longRationalArray instanceof int[]) {
            if ((longRationalArray = (LongRational[])((int[])longRationalArray)).length != 1) throw new NumberFormatException("There are more than one component");
            return (double)longRationalArray[0];
        }
        if (longRationalArray instanceof double[]) {
            if ((longRationalArray = (LongRational[])((double[])longRationalArray)).length != 1) throw new NumberFormatException("There are more than one component");
            return (double)longRationalArray[0];
        }
        if (!(longRationalArray instanceof LongRational[])) throw new NumberFormatException("Couldn't find a double value");
        if ((longRationalArray = (LongRational[])longRationalArray).length != 1) throw new NumberFormatException("There are more than one component");
        return longRationalArray[0].toDouble();
    }

    public int getIntValue(ByteOrder object) {
        if ((object = this.getValue((ByteOrder)object)) == null) throw new NumberFormatException("NULL can't be converted to a integer value");
        if (object instanceof String) {
            return Integer.parseInt((String)object);
        }
        if (object instanceof long[]) {
            if (((Object)(object = (Object)((long[])object))).length != 1) throw new NumberFormatException("There are more than one component");
            return (int)object[0];
        }
        if (!(object instanceof int[])) throw new NumberFormatException("Couldn't find a integer value");
        if (((Object)(object = (Object)((int[])object))).length != 1) throw new NumberFormatException("There are more than one component");
        return (int)object[0];
    }

    public String getStringValue(ByteOrder object) {
        Object object2 = this.getValue((ByteOrder)object);
        if (object2 == null) {
            return null;
        }
        if (object2 instanceof String) {
            return (String)object2;
        }
        object = new StringBuilder();
        boolean bl = object2 instanceof long[];
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (bl) {
            object2 = (long[])object2;
            n3 = n4;
            while (n3 < ((Object)object2).length) {
                ((StringBuilder)object).append((long)object2[n3]);
                n3 = n4 = n3 + 1;
                if (n4 == ((LongRational[])object2).length) continue;
                ((StringBuilder)object).append(",");
                n3 = n4;
            }
            return ((StringBuilder)object).toString();
        }
        if (object2 instanceof int[]) {
            object2 = (int[])object2;
            n3 = n;
            while (n3 < ((Object)object2).length) {
                ((StringBuilder)object).append((int)object2[n3]);
                n3 = n4 = n3 + 1;
                if (n4 == ((LongRational[])object2).length) continue;
                ((StringBuilder)object).append(",");
                n3 = n4;
            }
            return ((StringBuilder)object).toString();
        }
        if (object2 instanceof double[]) {
            object2 = (double[])object2;
            n3 = n2;
            while (n3 < ((LongRational[])object2).length) {
                ((StringBuilder)object).append((double)object2[n3]);
                n3 = n4 = n3 + 1;
                if (n4 == ((LongRational[])object2).length) continue;
                ((StringBuilder)object).append(",");
                n3 = n4;
            }
            return ((StringBuilder)object).toString();
        }
        if (!(object2 instanceof LongRational[])) return null;
        object2 = object2;
        while (n3 < ((LongRational[])object2).length) {
            ((StringBuilder)object).append(object2[n3].getNumerator());
            ((StringBuilder)object).append('/');
            ((StringBuilder)object).append(object2[n3].getDenominator());
            n3 = n4 = n3 + 1;
            if (n4 == ((LongRational[])object2).length) continue;
            ((StringBuilder)object).append(",");
            n3 = n4;
        }
        return ((StringBuilder)object).toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    Object getValue(ByteOrder var1_1) {
        block73: {
            block74: {
                block75: {
                    var13_7 = null;
                    var14_21 /* !! */  = new ByteOrderedDataInputStream(this.bytes);
                    var13_7 = var14_21 /* !! */ ;
                    ** try [egrp 1[TRYBLOCK] [2, 3 : 21->37)] { 
lbl6:
                    // 1 sources

                    break block75;
lbl7:
                    // 1 sources

                    catch (Throwable var1_5) {
                        // empty catch block
                        break block73;
                    }
                    catch (Throwable var1_3) {
                        break block73;
                    }
                    catch (IOException var14_22) {
                        var1_1 = null;
                        break block74;
                    }
                }
                var14_21 /* !! */ .setByteOrder((ByteOrder)var1_1);
                var13_7 = var14_21 /* !! */ ;
                var12_23 = this.format;
                var5_24 = 1;
                var7_25 = 0;
                var3_26 = 0;
                var10_27 = 0;
                var9_28 = 0;
                var8_29 = 0;
                var2_30 = 0;
                var6_31 = 0;
                var4_32 = 0;
                var11_33 = 0;
                switch (var12_23) {
                    default: {
                        break;
                    }
                    case 12: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new double[this.numberOfComponents];
                        var2_30 = var11_33;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = (LongRational)var14_21 /* !! */ .readDouble();
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_8) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_8);
                        }
                        return var1_1;
                    }
                    case 11: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new double[this.numberOfComponents];
                        var2_30 = var7_25;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = (LongRational)((double)var14_21 /* !! */ .readFloat());
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_9) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_9);
                        }
                        return var1_1;
                    }
                    case 10: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new LongRational[this.numberOfComponents];
                        var2_30 = var3_26;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = new LongRational((long)var14_21 /* !! */ .readInt(), (long)var14_21 /* !! */ .readInt());
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_10) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_10);
                        }
                        return var1_1;
                    }
                    case 9: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new int[this.numberOfComponents];
                        var2_30 = var10_27;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = (LongRational)var14_21 /* !! */ .readInt();
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_11) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_11);
                        }
                        return var1_1;
                    }
                    case 8: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new int[this.numberOfComponents];
                        var2_30 = var9_28;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = (LongRational)var14_21 /* !! */ .readShort();
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_12) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_12);
                        }
                        return var1_1;
                    }
                    case 5: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new LongRational[this.numberOfComponents];
                        var2_30 = var8_29;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = new LongRational(var14_21 /* !! */ .readUnsignedInt(), var14_21 /* !! */ .readUnsignedInt());
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_13) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_13);
                        }
                        return var1_1;
                    }
                    case 4: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new long[this.numberOfComponents];
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = (LongRational)var14_21 /* !! */ .readUnsignedInt();
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_14) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_14);
                        }
                        return var1_1;
                    }
                    case 3: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new int[this.numberOfComponents];
                        var2_30 = var6_31;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_30] = (LongRational)var14_21 /* !! */ .readUnsignedShort();
                            ++var2_30;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_15) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_15);
                        }
                        return var1_1;
                    }
                    case 2: 
                    case 7: {
                        var2_30 = var4_32;
                        var13_7 = var14_21 /* !! */ ;
                        if (this.numberOfComponents < ExifAttribute.EXIF_ASCII_PREFIX.length) ** GOTO lbl196
                        var2_30 = 0;
                        while (true) {
                            var3_26 = var5_24;
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= ExifAttribute.EXIF_ASCII_PREFIX.length) break;
                            var13_7 = var14_21 /* !! */ ;
                            if (this.bytes[var2_30] != ExifAttribute.EXIF_ASCII_PREFIX[var2_30]) {
                                var3_26 = 0;
                                break;
                            }
                            ++var2_30;
                        }
                        var2_30 = var4_32;
                        if (var3_26 == 0) ** GOTO lbl196
                        var13_7 = var14_21 /* !! */ ;
                        var2_30 = ExifAttribute.EXIF_ASCII_PREFIX.length;
lbl196:
                        // 3 sources

                        var13_7 = var14_21 /* !! */ ;
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new StringBuilder();
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_30 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var3_26 = this.bytes[var2_30];
                            if (var3_26 == 0) break;
                            if (var3_26 >= 32) {
                                var13_7 = var14_21 /* !! */ ;
                                var1_1.append((char)var3_26);
                            } else {
                                var13_7 = var14_21 /* !! */ ;
                                var1_1.append('?');
                            }
                            ++var2_30;
                        }
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = var1_1.toString();
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_16) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_16);
                        }
                        return var1_1;
                    }
                    case 1: 
                    case 6: {
                        var13_7 = var14_21 /* !! */ ;
                        if (this.bytes.length != 1) ** GOTO lbl240
                        var13_7 = var14_21 /* !! */ ;
                        if (this.bytes[0] < 0) ** GOTO lbl240
                        var13_7 = var14_21 /* !! */ ;
                        if (this.bytes[0] > 1) ** GOTO lbl240
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new String(new char[]{(char)(this.bytes[0] + 48)});
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_17) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_17);
                        }
                        return var1_1;
lbl240:
                        // 3 sources

                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new String(this.bytes, ExifAttribute.ASCII);
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_18) {
                            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_18);
                        }
                        return var1_1;
                    }
                }
                try {
                    var14_21 /* !! */ .close();
                }
                catch (IOException var1_2) {
                    Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var1_2);
                }
                return null;
lbl255:
                // 14 sources

                catch (IOException var13_19) {
                    var1_1 = var14_21 /* !! */ ;
                    var14_21 /* !! */  = var13_19;
                }
            }
            var13_7 = var1_1;
            {
                Logger.w((String)"ExifAttribute", (String)"IOException occurred during reading a value", (Throwable)var14_21 /* !! */ );
                if (var1_1 == null) return null;
            }
            try {
                var1_1.close();
            }
            catch (IOException var1_4) {
                Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var1_4);
            }
            return null;
        }
        if (var13_7 == null) throw var1_6;
        try {
            var13_7.close();
        }
        catch (IOException var13_20) {
            Logger.e((String)"ExifAttribute", (String)"IOException occurred while closing InputStream", (Throwable)var13_20);
        }
        throw var1_6;
    }

    public int size() {
        return IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(IFD_FORMAT_NAMES[this.format]);
        stringBuilder.append(", data length:");
        stringBuilder.append(this.bytes.length);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
