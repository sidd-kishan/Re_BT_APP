/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 *  com.bumptech.glide.gifdecoder.GifDecoder
 *  com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
 *  com.bumptech.glide.gifdecoder.GifFrame
 *  com.bumptech.glide.gifdecoder.GifHeader
 *  com.bumptech.glide.gifdecoder.GifHeaderParser
 */
package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifFrame;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class StandardGifDecoder
implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = StandardGifDecoder.class.getSimpleName();
    private int[] act;
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct = new int[256];
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider) {
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int n) {
        this(bitmapProvider);
        this.setData(gifHeader, byteBuffer, n);
    }

    private int averageColorsNear(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        byte[] byArray;
        int n9;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        for (n9 = n; n9 < this.sampleSize + n && n9 < (byArray = this.mainPixels).length && n9 < n2; ++n9) {
            n8 = byArray[n9];
            int n15 = this.act[n8 & 0xFF];
            n7 = n10;
            n6 = n11;
            n5 = n12;
            n4 = n13;
            n8 = n14;
            if (n15 != 0) {
                n7 = n10 + (n15 >> 24 & 0xFF);
                n6 = n11 + (n15 >> 16 & 0xFF);
                n5 = n12 + (n15 >> 8 & 0xFF);
                n4 = n13 + (n15 & 0xFF);
                n8 = n14 + 1;
            }
            n10 = n7;
            n11 = n6;
            n12 = n5;
            n13 = n4;
            n14 = n8;
        }
        n4 = n10;
        for (n = n6 = n + n3; n < this.sampleSize + n6 && n < (byArray = this.mainPixels).length && n < n2; ++n) {
            n3 = byArray[n];
            n7 = this.act[n3 & 0xFF];
            n5 = n4;
            n8 = n11;
            n9 = n12;
            n10 = n13;
            n3 = n14;
            if (n7 != 0) {
                n5 = n4 + (n7 >> 24 & 0xFF);
                n8 = n11 + (n7 >> 16 & 0xFF);
                n9 = n12 + (n7 >> 8 & 0xFF);
                n10 = n13 + (n7 & 0xFF);
                n3 = n14 + 1;
            }
            n4 = n5;
            n11 = n8;
            n12 = n9;
            n13 = n10;
            n14 = n3;
        }
        if (n14 != 0) return n4 / n14 << 24 | n11 / n14 << 16 | n12 / n14 << 8 | n13 / n14;
        return 0;
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int[] nArray = this.mainScratch;
        int n = gifFrame.ih / this.sampleSize;
        int n2 = gifFrame.iy / this.sampleSize;
        int n3 = gifFrame.iw / this.sampleSize;
        int n4 = gifFrame.ix / this.sampleSize;
        int n5 = this.framePointer;
        Boolean bl = true;
        boolean bl2 = n5 == 0;
        int n6 = this.sampleSize;
        int n7 = this.downsampledWidth;
        int n8 = this.downsampledHeight;
        byte[] byArray = this.mainPixels;
        int[] nArray2 = this.act;
        Boolean bl3 = this.isFirstFrameTransparent;
        int n9 = 8;
        int n10 = 0;
        int n11 = 0;
        n5 = 1;
        while (true) {
            Boolean bl4;
            int n12;
            int n13;
            block25: {
                int n14;
                int n15;
                int n16;
                block23: {
                    block24: {
                        block22: {
                            block20: {
                                block21: {
                                    if (n10 >= n) break block20;
                                    if (gifFrame.interlace) {
                                        if (n11 >= n) {
                                            if (++n5 != 2) {
                                                if (n5 != 3) {
                                                    if (n5 == 4) {
                                                        n11 = 1;
                                                        n9 = 2;
                                                    }
                                                } else {
                                                    n11 = 2;
                                                    n9 = 4;
                                                }
                                            } else {
                                                n11 = 4;
                                            }
                                        }
                                        n13 = n11 + n9;
                                        n16 = n11;
                                        n12 = n5;
                                    } else {
                                        n16 = n10;
                                        n12 = n5;
                                        n13 = n11;
                                    }
                                    n11 = n16 + n2;
                                    n5 = n6 == 1 ? 1 : 0;
                                    if (n11 >= n8) break block21;
                                    n16 = n11 * n7;
                                    n15 = n16 + n4;
                                    n11 = n15 + n3;
                                    n14 = n16 + n7;
                                    n16 = n11;
                                    if (n14 < n11) {
                                        n16 = n14;
                                    }
                                    n14 = n10 * n6 * gifFrame.iw;
                                    if (n5 != 0) break block22;
                                    break block23;
                                }
                                bl4 = bl3;
                                n5 = n2;
                                break block24;
                            }
                            if (this.isFirstFrameTransparent != null) return;
                            boolean bl5 = bl3 == null ? false : bl3;
                            this.isFirstFrameTransparent = bl5;
                            return;
                        }
                        n11 = n15;
                        while (true) {
                            n5 = n2;
                            bl4 = bl3;
                            if (n11 >= n16) break;
                            n5 = nArray2[byArray[n14] & 0xFF];
                            if (n5 != 0) {
                                nArray[n11] = n5;
                                bl4 = bl3;
                            } else {
                                bl4 = bl3;
                                if (bl2) {
                                    bl4 = bl3;
                                    if (bl3 == null) {
                                        bl4 = bl;
                                    }
                                }
                            }
                            n14 += n6;
                            ++n11;
                            bl3 = bl4;
                        }
                    }
                    n11 = n5;
                    n5 = n3;
                    break block25;
                }
                int n17 = n2;
                n11 = n15;
                n5 = n14;
                n2 = n3;
                n3 = n11;
                while (true) {
                    int n18 = n5;
                    n11 = n17;
                    bl4 = bl3;
                    n5 = n2;
                    if (n3 >= n16) break;
                    n5 = this.averageColorsNear(n18, (n16 - n15) * n6 + n14, gifFrame.iw);
                    if (n5 != 0) {
                        nArray[n3] = n5;
                        bl4 = bl3;
                    } else {
                        bl4 = bl3;
                        if (bl2) {
                            bl4 = bl3;
                            if (bl3 == null) {
                                bl4 = bl;
                            }
                        }
                    }
                    n5 = n18 + n6;
                    ++n3;
                    bl3 = bl4;
                }
            }
            bl3 = bl4;
            ++n10;
            n2 = n11;
            n11 = n13;
            n3 = n5;
            n5 = n12;
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        int[] nArray = this.mainScratch;
        int n = gifFrame.ih;
        int n2 = gifFrame.iy;
        int n3 = gifFrame.iw;
        int n4 = gifFrame.ix;
        boolean bl = this.framePointer == 0;
        int n5 = this.downsampledWidth;
        byte[] byArray = this.mainPixels;
        int[] nArray2 = this.act;
        int n6 = 0;
        int n7 = -1;
        while (true) {
            int n8;
            int n9;
            int n10;
            int n11;
            if (n6 < n) {
                n11 = (n6 + n2) * n5;
                n10 = n11 + n4;
                n9 = n10 + n3;
                n8 = n11 + n5;
                n11 = n9;
                if (n8 < n9) {
                    n11 = n8;
                }
                n9 = gifFrame.iw * n6;
            } else {
                boolean bl2 = this.isFirstFrameTransparent == null && bl && n7 != -1;
                this.isFirstFrameTransparent = bl2;
                return;
            }
            while (n10 < n11) {
                int n12 = byArray[n9];
                int n13 = n12 & 0xFF;
                n8 = n7;
                if (n13 != n7) {
                    n8 = nArray2[n13];
                    if (n8 != 0) {
                        nArray[n10] = n8;
                        n8 = n7;
                    } else {
                        n8 = n12;
                    }
                }
                ++n9;
                ++n10;
                n7 = n8;
            }
            ++n6;
        }
    }

    private void decodeBitmapData(GifFrame object) {
        int n;
        int n2;
        if (object != null) {
            this.rawData.position(object.bufferFrameStart);
        }
        if (object == null) {
            n2 = this.header.width * this.header.height;
        } else {
            n = object.iw;
            n2 = object.ih * n;
        }
        object = this.mainPixels;
        if (object == null || ((GifFrame)object).length < n2) {
            this.mainPixels = this.bitmapProvider.obtainByteArray(n2);
        }
        byte[] byArray = this.mainPixels;
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        short[] sArray = this.prefix;
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        byte[] byArray2 = this.suffix;
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        object = this.pixelStack;
        n = this.readByte();
        int n3 = 1 << n;
        int n4 = n3 + 2;
        int n5 = n + 1;
        int n6 = (1 << n5) - 1;
        int n7 = 0;
        for (n = 0; n < n3; ++n) {
            sArray[n] = 0;
            byArray2[n] = (byte)n;
        }
        byte[] byArray3 = this.block;
        n = n5;
        int n8 = n4;
        int n9 = n6;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = -1;
        int n16 = 0;
        int n17 = 0;
        block1: while (n7 < n2) {
            int n18;
            int n19 = n10;
            if (n10 == 0) {
                n19 = this.readBlock();
                if (n19 <= 0) {
                    this.status = 3;
                    break;
                }
                n11 = 0;
            }
            n13 += (byArray3[n11] & 0xFF) << n12;
            int n20 = n11 + 1;
            int n21 = n19 - 1;
            n19 = n12 + 8;
            n12 = n8;
            n8 = n;
            n = n15;
            n11 = n16;
            n10 = n7;
            n15 = n4;
            n16 = n12;
            n4 = n11;
            n12 = n19;
            while (n12 >= n8) {
                byte by;
                n11 = n13 & n9;
                n13 >>= n8;
                n12 -= n8;
                if (n11 == n3) {
                    n9 = n6;
                    n8 = n5;
                    n11 = n15;
                    n = -1;
                    n16 = n15;
                    n15 = n11;
                    continue;
                }
                if (n11 == n3 + 1) {
                    n19 = n4;
                    n4 = n15;
                    n15 = n;
                    n = n8;
                    n7 = n10;
                    n10 = n21;
                    n11 = n20;
                    n8 = n16;
                    n16 = n19;
                    continue block1;
                }
                if (n == -1) {
                    object[n17] = (GifFrame)byArray2[n11];
                    ++n17;
                    n4 = n = n11;
                    continue;
                }
                if (n11 >= n16) {
                    object[n17] = (GifFrame)((byte)n4);
                    ++n17;
                    n4 = n;
                } else {
                    n4 = n11;
                }
                while (n4 >= n3) {
                    object[n17] = (GifFrame)byArray2[n4];
                    ++n17;
                    n4 = sArray[n4];
                }
                n4 = byArray2[n4] & 0xFF;
                byArray[n14] = by = (byte)n4;
                while (true) {
                    ++n14;
                    ++n10;
                    if (n17 <= 0) break;
                    byArray[n14] = (byte)object[--n17];
                }
                n18 = n16;
                n19 = n8;
                n7 = n9;
                if (n16 < 4096) {
                    sArray[n16] = (short)n;
                    byArray2[n16] = by;
                    n18 = n = n16 + 1;
                    n19 = n8;
                    n7 = n9;
                    if ((n & n9) == 0) {
                        n18 = n;
                        n19 = n8;
                        n7 = n9;
                        if (n < 4096) {
                            n19 = n8 + 1;
                            n7 = n9 + n;
                            n18 = n;
                        }
                    }
                }
                n = n11;
                n16 = n18;
                n8 = n19;
                n9 = n7;
            }
            n19 = n;
            n = n16;
            n16 = n4;
            n18 = n8;
            n4 = n15;
            n7 = n10;
            n10 = n21;
            n11 = n20;
            n8 = n;
            n = n18;
            n15 = n19;
        }
        Arrays.fill(byArray, n14, n2, (byte)0);
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser != null) return this.parser;
        this.parser = new GifHeaderParser();
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean bl = this.isFirstFrameTransparent;
        bl = bl != null && !bl.booleanValue() ? this.bitmapConfig : Bitmap.Config.ARGB_8888;
        bl = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (Bitmap.Config)bl);
        bl.setHasAlpha(true);
        return bl;
    }

    private int readBlock() {
        int n = this.readByte();
        if (n <= 0) {
            return n;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(n, byteBuffer.remaining()));
        return n;
    }

    private int readByte() {
        return this.rawData.get() & 0xFF;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int[] nArray = this.mainScratch;
        int n = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap = this.previousImage;
            if (bitmap != null) {
                this.bitmapProvider.release(bitmap);
            }
            this.previousImage = null;
            Arrays.fill(nArray, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(nArray, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose > 0) {
            if (gifFrame2.dispose != 2) {
                if (gifFrame2.dispose == 3 && (gifFrame2 = this.previousImage) != null) {
                    n = this.downsampledWidth;
                    gifFrame2.getPixels(nArray, 0, n, 0, 0, n, this.downsampledHeight);
                }
            } else {
                int n2;
                int n3;
                if (!gifFrame.transparency) {
                    n3 = this.header.bgColor;
                    if (gifFrame.lct != null && this.header.bgIndex == gifFrame.transIndex) {
                        n3 = n;
                    }
                } else {
                    n3 = n;
                    if (this.framePointer == 0) {
                        this.isFirstFrameTransparent = true;
                        n3 = n;
                    }
                }
                int n4 = gifFrame2.ih / this.sampleSize;
                n = gifFrame2.iy / this.sampleSize;
                int n5 = gifFrame2.iw / this.sampleSize;
                int n6 = gifFrame2.ix / this.sampleSize;
                int n7 = this.downsampledWidth;
                for (n = n2 = n * n7 + n6; n < n4 * n7 + n2; n += this.downsampledWidth) {
                    for (n6 = n; n6 < n + n5; ++n6) {
                        nArray[n6] = n3;
                    }
                }
            }
        }
        this.decodeBitmapData(gifFrame);
        if (!gifFrame.interlace && this.sampleSize == 1) {
            this.copyIntoScratchFast(gifFrame);
        } else {
            this.copyCopyIntoScratchRobust(gifFrame);
        }
        if (this.savePrevious && (gifFrame.dispose == 0 || gifFrame.dispose == 1)) {
            if (this.previousImage == null) {
                this.previousImage = this.getNextBitmap();
            }
            gifFrame = this.previousImage;
            n = this.downsampledWidth;
            gifFrame.setPixels(nArray, 0, n, 0, 0, n, this.downsampledHeight);
        }
        gifFrame = this.getNextBitmap();
        n = this.downsampledWidth;
        gifFrame.setPixels(nArray, 0, n, 0, 0, n, this.downsampledHeight);
        return gifFrame;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        Object object = this.mainPixels;
        if (object != null) {
            this.bitmapProvider.release(object);
        }
        if ((object = (Object)this.mainScratch) != null) {
            this.bitmapProvider.release((int[])object);
        }
        if ((object = (Object)this.previousImage) != null) {
            this.bitmapProvider.release((Bitmap)object);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        object = this.block;
        if (object == null) return;
        this.bitmapProvider.release(object);
    }

    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + this.mainScratch.length * 4;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getDelay(int n) {
        n = n >= 0 && n < this.header.frameCount ? ((GifFrame)this.header.frames.get((int)n)).delay : -1;
        return n;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @Deprecated
    public int getLoopCount() {
        if (this.header.loopCount != -1) return this.header.loopCount;
        return 1;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        if (this.header.frameCount <= 0) return 0;
        int n = this.framePointer;
        if (n >= 0) return this.getDelay(n);
        return 0;
    }

    public Bitmap getNextFrame() {
        synchronized (this) {
            CharSequence charSequence;
            Object object;
            if (this.header.frameCount <= 0 || this.framePointer < 0) {
                if (Log.isLoggable((String)TAG, (int)3)) {
                    object = TAG;
                    charSequence = new StringBuilder();
                    charSequence.append("Unable to decode frame, frameCount=");
                    charSequence.append(this.header.frameCount);
                    charSequence.append(", framePointer=");
                    charSequence.append(this.framePointer);
                    Log.d((String)object, (String)charSequence.toString());
                }
                this.status = 1;
            }
            if (this.status != 1 && this.status != 2) {
                this.status = 0;
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                GifFrame gifFrame = (GifFrame)this.header.frames.get(this.framePointer);
                int n = this.framePointer - 1;
                charSequence = n >= 0 ? (GifFrame)this.header.frames.get(n) : null;
                object = gifFrame.lct != null ? (Object)gifFrame.lct : (Object)this.header.gct;
                this.act = (int[])object;
                if (object == null) {
                    if (Log.isLoggable((String)TAG, (int)3)) {
                        charSequence = TAG;
                        object = new StringBuilder();
                        ((StringBuilder)object).append("No valid color table found for frame #");
                        ((StringBuilder)object).append(this.framePointer);
                        Log.d((String)charSequence, (String)((StringBuilder)object).toString());
                    }
                    this.status = 1;
                    return null;
                }
                if (gifFrame.transparency) {
                    System.arraycopy(this.act, 0, this.pct, 0, this.act.length);
                    object = this.pct;
                    this.act = (int[])object;
                    object[gifFrame.transIndex] = false;
                }
                charSequence = this.setPixels(gifFrame, (GifFrame)charSequence);
                return charSequence;
            }
            if (!Log.isLoggable((String)TAG, (int)3)) return null;
            charSequence = TAG;
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to decode frame, status=");
            ((StringBuilder)object).append(this.status);
            Log.d((String)charSequence, (String)((StringBuilder)object).toString());
            return null;
        }
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalIterationCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        if (this.header.loopCount != 0) return this.header.loopCount + 1;
        return 0;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int n) {
        if (inputStream != null) {
            n = n > 0 ? (n += 4096) : 16384;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n);
                byte[] byArray = new byte[16384];
                while ((n = inputStream.read(byArray, 0, 16384)) != -1) {
                    byteArrayOutputStream.write(byArray, 0, n);
                }
                byteArrayOutputStream.flush();
                this.read(byteArrayOutputStream.toByteArray());
            }
            catch (IOException iOException) {
                Log.w((String)TAG, (String)"Error reading data from stream", (Throwable)iOException);
            }
        } else {
            this.status = 2;
        }
        if (inputStream == null) return this.status;
        try {
            inputStream.close();
        }
        catch (IOException iOException) {
            Log.w((String)TAG, (String)"Error closing stream", (Throwable)iOException);
        }
        return this.status;
    }

    public int read(byte[] byArray) {
        synchronized (this) {
            GifHeader gifHeader;
            this.header = gifHeader = this.getHeaderParser().setData(byArray).parseHeader();
            if (byArray != null) {
                this.setData(gifHeader, byArray);
            }
            int n = this.status;
            return n;
        }
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(GifHeader gifHeader, ByteBuffer byteBuffer) {
        synchronized (this) {
            this.setData(gifHeader, byteBuffer, 1);
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void setData(GifHeader var1_1, ByteBuffer var2_3, int var3_4) {
        synchronized (this) {
            if (var3_4 <= 0) ** GOTO lbl26
            try {
                var3_4 = Integer.highestOneBit(var3_4);
                this.status = 0;
                this.header = var1_1;
                this.framePointer = -1;
                var2_3 = var2_3.asReadOnlyBuffer();
                this.rawData = var2_3;
                var2_3.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                var2_3 = var1_1.frames.iterator();
                while (var2_3.hasNext()) {
                    if (((GifFrame)var2_3.next()).dispose != 3) continue;
                    this.savePrevious = true;
                    break;
                }
                this.sampleSize = var3_4;
                this.downsampledWidth = var1_1.width / var3_4;
                this.downsampledHeight = var1_1.height / var3_4;
                this.mainPixels = this.bitmapProvider.obtainByteArray(var1_1.width * var1_1.height);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
                return;
lbl26:
                // 1 sources

                var1_1 = new StringBuilder();
                var1_1.append("Sample size must be >=0, not: ");
                var1_1.append(var3_4);
                var2_3 = new Iterator<E>(var1_1.toString());
                throw var2_3;
            }
            catch (Throwable var1_2) {}
        }
        throw var1_2;
    }

    public void setData(GifHeader gifHeader, byte[] byArray) {
        synchronized (this) {
            this.setData(gifHeader, ByteBuffer.wrap(byArray));
            return;
        }
    }

    public void setDefaultBitmapConfig(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported format: ");
            stringBuilder.append(config);
            stringBuilder.append(", must be one of ");
            stringBuilder.append(Bitmap.Config.ARGB_8888);
            stringBuilder.append(" or ");
            stringBuilder.append(Bitmap.Config.RGB_565);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.bitmapConfig = config;
    }
}
