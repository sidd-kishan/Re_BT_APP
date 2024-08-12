/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory$Options
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  com.bumptech.glide.load.ImageHeaderParserUtils
 *  com.bumptech.glide.load.Option
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapResource
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding
 *  com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
 *  com.bumptech.glide.load.resource.bitmap.HardwareConfigState
 *  com.bumptech.glide.load.resource.bitmap.TransformationUtils
 *  com.bumptech.glide.util.LogTime
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT;
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY;
    private static final DecodeCallbacks EMPTY_CALLBACKS;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final int MARK_POSITION = 0xA00000;
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE;
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    static {
        DECODE_FORMAT = Option.memory((String)"com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", (Object)DecodeFormat.DEFAULT);
        DOWNSAMPLE_STRATEGY = Option.memory((String)"com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", (Object)DownsampleStrategy.DEFAULT);
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory((String)"com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", (Object)false);
        ALLOW_HARDWARE_CONFIG = Option.memory((String)"com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", null);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(WBMP_MIME_TYPE, ICO_MIME_TYPE)));
        EMPTY_CALLBACKS = new /* Unavailable Anonymous Inner Class!! */;
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue((int)0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics)Preconditions.checkNotNull((Object)displayMetrics);
        this.bitmapPool = (BitmapPool)Preconditions.checkNotNull((Object)bitmapPool);
        this.byteArrayPool = (ArrayPool)Preconditions.checkNotNull((Object)arrayPool);
    }

    private static int adjustTargetDensityForError(double d) {
        int n = Downsampler.getDensityMultiplier(d);
        double d2 = n;
        Double.isNaN(d2);
        int n2 = Downsampler.round(d2 * d);
        d2 = (float)n2 / (float)n;
        Double.isNaN(d2);
        d /= d2;
        d2 = n2;
        Double.isNaN(d2);
        return Downsampler.round(d * d2);
    }

    private void calculateConfig(InputStream object, DecodeFormat decodeFormat, boolean bl, boolean bl2, BitmapFactory.Options options, int n, int n2) {
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(n, n2, options, decodeFormat, bl, bl2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888 && decodeFormat != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE && Build.VERSION.SDK_INT != 16) {
            block4: {
                bl2 = false;
                try {
                    bl = ImageHeaderParserUtils.getType(this.parsers, (InputStream)object, (ArrayPool)this.byteArrayPool).hasAlpha();
                }
                catch (IOException iOException) {
                    bl = bl2;
                    if (!Log.isLoggable((String)TAG, (int)3)) break block4;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Cannot determine whether the image has alpha or not from header, format ");
                    ((StringBuilder)object).append(decodeFormat);
                    Log.d((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)iOException);
                    bl = bl2;
                }
            }
            object = bl ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = object;
            if (options.inPreferredConfig != Bitmap.Config.RGB_565) return;
            options.inDither = true;
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void calculateScaling(ImageHeaderParser.ImageType object, InputStream object2, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int object3, int n, int n2, int n3, int n4, BitmapFactory.Options options) throws IOException {
        block11: {
            double d;
            int n5;
            Object object4;
            float f;
            block13: {
                block17: {
                    float f2;
                    float f3;
                    block14: {
                        block16: {
                            block15: {
                                block12: {
                                    if (n <= 0 || n2 <= 0) break block11;
                                    f = object3 != 90 && object3 != 270 ? downsampleStrategy.getScaleFactor(n, n2, n3, n4) : downsampleStrategy.getScaleFactor(n2, n, n3, n4);
                                    if (f <= 0.0f) {
                                        object = new StringBuilder();
                                        ((StringBuilder)object).append("Cannot scale with factor: ");
                                        ((StringBuilder)object).append(f);
                                        ((StringBuilder)object).append(" from: ");
                                        ((StringBuilder)object).append(downsampleStrategy);
                                        ((StringBuilder)object).append(", source: [");
                                        ((StringBuilder)object).append(n);
                                        ((StringBuilder)object).append("x");
                                        ((StringBuilder)object).append(n2);
                                        ((StringBuilder)object).append("], target: [");
                                        ((StringBuilder)object).append(n3);
                                        ((StringBuilder)object).append("x");
                                        ((StringBuilder)object).append(n4);
                                        ((StringBuilder)object).append("]");
                                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                                    }
                                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(n, n2, n3, n4);
                                    if (sampleSizeRounding == null) throw new IllegalArgumentException("Cannot round with null rounding");
                                    f3 = n;
                                    object3 = Downsampler.round(f * f3);
                                    f2 = n2;
                                    object4 = Downsampler.round(f * f2);
                                    object3 = n / object3;
                                    object4 = n2 / object4;
                                    object3 = sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(object3, object4) : Math.min(object3, object4);
                                    if (Build.VERSION.SDK_INT <= 23 && NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options.outMimeType)) {
                                        n5 = 1;
                                    } else {
                                        n5 = object3 = Math.max(1, Integer.highestOneBit(object3));
                                        if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                                            n5 = object3;
                                            if ((float)object3 < 1.0f / f) {
                                                n5 = object3 << 1;
                                            }
                                        }
                                    }
                                    options.inSampleSize = n5;
                                    if (object != ImageHeaderParser.ImageType.JPEG) break block12;
                                    float f4 = Math.min(n5, 8);
                                    Object object5 = Math.ceil(f3 / f4);
                                    int n6 = (int)Math.ceil(f2 / f4);
                                    int n7 = n5 / 8;
                                    object3 = n6;
                                    object4 = object5;
                                    if (n7 > 0) {
                                        object4 = object5 / n7;
                                        object3 = n6 / n7;
                                    }
                                    break block13;
                                }
                                if (object == ImageHeaderParser.ImageType.PNG || object == ImageHeaderParser.ImageType.PNG_A) break block14;
                                if (object == ImageHeaderParser.ImageType.WEBP || object == ImageHeaderParser.ImageType.WEBP_A) break block15;
                                if (n % n5 == 0 && n2 % n5 == 0) {
                                    object4 = n / n5;
                                    object3 = n2 / n5;
                                } else {
                                    object = Downsampler.getDimensions((InputStream)object2, options, decodeCallbacks, bitmapPool);
                                    object4 = object[0];
                                    object3 = object[1];
                                }
                                break block13;
                            }
                            if (Build.VERSION.SDK_INT < 24) break block16;
                            float f5 = n5;
                            object4 = Math.round(f3 / f5);
                            object3 = Math.round(f2 / f5);
                            break block13;
                        }
                        float f6 = n5;
                        object4 = (int)Math.floor(f3 / f6);
                        d = Math.floor(f2 / f6);
                        break block17;
                    }
                    float f7 = n5;
                    object4 = (int)Math.floor(f3 / f7);
                    d = Math.floor(f2 / f7);
                }
                object3 = (int)d;
            }
            d = downsampleStrategy.getScaleFactor(object4, object3, n3, n4);
            if (Build.VERSION.SDK_INT >= 19) {
                options.inTargetDensity = Downsampler.adjustTargetDensityForError(d);
                options.inDensity = Downsampler.getDensityMultiplier(d);
            }
            if (Downsampler.isScaling(options)) {
                options.inScaled = true;
            } else {
                options.inTargetDensity = 0;
                options.inDensity = 0;
            }
            if (!Log.isLoggable((String)TAG, (int)2)) return;
            object = new StringBuilder();
            ((StringBuilder)object).append("Calculate scaling, source: [");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append("], target: [");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(n4);
            ((StringBuilder)object).append("], power of two scaled: [");
            ((StringBuilder)object).append((int)object4);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append((int)object3);
            ((StringBuilder)object).append("], exact scale factor: ");
            ((StringBuilder)object).append(f);
            ((StringBuilder)object).append(", power of 2 sample size: ");
            ((StringBuilder)object).append(n5);
            ((StringBuilder)object).append(", adjusted scale factor: ");
            ((StringBuilder)object).append(d);
            ((StringBuilder)object).append(", target density: ");
            ((StringBuilder)object).append(options.inTargetDensity);
            ((StringBuilder)object).append(", density: ");
            ((StringBuilder)object).append(options.inDensity);
            Log.v((String)TAG, (String)((StringBuilder)object).toString());
            return;
        }
        if (!Log.isLoggable((String)TAG, (int)3)) return;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unable to determine dimensions for: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" with target [");
        ((StringBuilder)object2).append(n3);
        ((StringBuilder)object2).append("x");
        ((StringBuilder)object2).append(n4);
        ((StringBuilder)object2).append("]");
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy object, DecodeFormat decodeFormat, boolean bl, int n, int n2, boolean bl2, DecodeCallbacks decodeCallbacks) throws IOException {
        long l = LogTime.getLogTime();
        Object object2 = Downsampler.getDimensions(inputStream, options, decodeCallbacks, this.bitmapPool);
        int n3 = 0;
        int n4 = object2[0];
        int n5 = object2[1];
        object2 = options.outMimeType;
        if (n4 == -1 || n5 == -1) {
            bl = false;
        }
        int n6 = ImageHeaderParserUtils.getOrientation(this.parsers, (InputStream)inputStream, (ArrayPool)this.byteArrayPool);
        int n7 = TransformationUtils.getExifOrientationDegrees((int)n6);
        boolean bl3 = TransformationUtils.isExifOrientationRequired((int)n6);
        int n8 = n == Integer.MIN_VALUE ? n4 : n;
        int n9 = n2 == Integer.MIN_VALUE ? n5 : n2;
        ImageHeaderParser.ImageType imageType = ImageHeaderParserUtils.getType(this.parsers, (InputStream)inputStream, (ArrayPool)this.byteArrayPool);
        Downsampler.calculateScaling(imageType, inputStream, decodeCallbacks, this.bitmapPool, (DownsampleStrategy)object, n7, n4, n5, n8, n9, options);
        this.calculateConfig(inputStream, decodeFormat, bl, bl3, options, n8, n9);
        if (Build.VERSION.SDK_INT >= 19) {
            n3 = 1;
        }
        if ((options.inSampleSize == 1 || n3 != 0) && this.shouldUsePool(imageType)) {
            if (n4 < 0 || n5 < 0 || !bl2 || n3 == 0) {
                float f = Downsampler.isScaling(options) ? (float)options.inTargetDensity / (float)options.inDensity : 1.0f;
                int n10 = options.inSampleSize;
                float f2 = n4;
                float f3 = n10;
                n9 = (int)Math.ceil(f2 / f3);
                n8 = (int)Math.ceil((float)n5 / f3);
                n3 = Math.round((float)n9 * f);
                n7 = Math.round((float)n8 * f);
                n8 = n3;
                n9 = n7;
                if (Log.isLoggable((String)TAG, (int)2)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Calculated target [");
                    ((StringBuilder)object).append(n3);
                    ((StringBuilder)object).append("x");
                    ((StringBuilder)object).append(n7);
                    ((StringBuilder)object).append("] for source [");
                    ((StringBuilder)object).append(n4);
                    ((StringBuilder)object).append("x");
                    ((StringBuilder)object).append(n5);
                    ((StringBuilder)object).append("], sampleSize: ");
                    ((StringBuilder)object).append(n10);
                    ((StringBuilder)object).append(", targetDensity: ");
                    ((StringBuilder)object).append(options.inTargetDensity);
                    ((StringBuilder)object).append(", density: ");
                    ((StringBuilder)object).append(options.inDensity);
                    ((StringBuilder)object).append(", density multiplier: ");
                    ((StringBuilder)object).append(f);
                    Log.v((String)TAG, (String)((StringBuilder)object).toString());
                    n9 = n7;
                    n8 = n3;
                }
            }
            if (n8 > 0 && n9 > 0) {
                Downsampler.setInBitmap(options, this.bitmapPool, n8, n9);
            }
        }
        object = Downsampler.decodeStream(inputStream, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, (Bitmap)object);
        if (Log.isLoggable((String)TAG, (int)2)) {
            Downsampler.logDecode(n4, n5, (String)object2, options, (Bitmap)object, n, n2, l);
        }
        inputStream = null;
        if (object == null) return inputStream;
        object.setDensity(this.displayMetrics.densityDpi);
        options = TransformationUtils.rotateImageExif((BitmapPool)this.bitmapPool, (Bitmap)object, (int)n6);
        inputStream = options;
        if (object.equals(options)) return inputStream;
        this.bitmapPool.put((Bitmap)object);
        inputStream = options;
        return inputStream;
    }

    /*
     * Exception decompiling
     */
    private static Bitmap decodeStream(InputStream var0, BitmapFactory.Options var1_3, DecodeCallbacks var2_4, BitmapPool var3_5) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [2 : 84->156)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    private static String getBitmapString(Bitmap bitmap) {
        CharSequence charSequence;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(" (");
            ((StringBuilder)charSequence).append(bitmap.getAllocationByteCount());
            ((StringBuilder)charSequence).append(")");
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(bitmap.getWidth());
        stringBuilder.append("x");
        stringBuilder.append(bitmap.getHeight());
        stringBuilder.append("] ");
        stringBuilder.append(bitmap.getConfig());
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static BitmapFactory.Options getDefaultOptions() {
        synchronized (Downsampler.class) {
            BitmapFactory.Options options;
            BitmapFactory.Options options2 = OPTIONS_QUEUE;
            synchronized (options2) {
                options = OPTIONS_QUEUE.poll();
            }
            options2 = options;
            if (options != null) return options2;
            options2 = new BitmapFactory.Options();
            Downsampler.resetOptions(options2);
            return options2;
        }
    }

    private static int getDensityMultiplier(double d) {
        if (d <= 1.0) return (int)Math.round(d * 2.147483647E9);
        d = 1.0 / d;
        return (int)Math.round(d * 2.147483647E9);
    }

    private static int[] getDimensions(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        Downsampler.decodeStream(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return Downsampler.getBitmapString(options.inBitmap);
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        boolean bl = options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
        return bl;
    }

    private static void logDecode(int n, int n2, String string, BitmapFactory.Options options, Bitmap bitmap, int n3, int n4, long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decoded ");
        stringBuilder.append(Downsampler.getBitmapString(bitmap));
        stringBuilder.append(" from [");
        stringBuilder.append(n);
        stringBuilder.append("x");
        stringBuilder.append(n2);
        stringBuilder.append("] ");
        stringBuilder.append(string);
        stringBuilder.append(" with inBitmap ");
        stringBuilder.append(Downsampler.getInBitmapString(options));
        stringBuilder.append(" for [");
        stringBuilder.append(n3);
        stringBuilder.append("x");
        stringBuilder.append(n4);
        stringBuilder.append("], sample size: ");
        stringBuilder.append(options.inSampleSize);
        stringBuilder.append(", density: ");
        stringBuilder.append(options.inDensity);
        stringBuilder.append(", target density: ");
        stringBuilder.append(options.inTargetDensity);
        stringBuilder.append(", thread: ");
        stringBuilder.append(Thread.currentThread().getName());
        stringBuilder.append(", duration: ");
        stringBuilder.append(LogTime.getElapsedMillis((long)l));
        Log.v((String)TAG, (String)stringBuilder.toString());
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int n, int n2, String string, BitmapFactory.Options options) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception decoding bitmap, outWidth: ");
        stringBuilder.append(n);
        stringBuilder.append(", outHeight: ");
        stringBuilder.append(n2);
        stringBuilder.append(", outMimeType: ");
        stringBuilder.append(string);
        stringBuilder.append(", inBitmap: ");
        stringBuilder.append(Downsampler.getInBitmapString(options));
        return new IOException(stringBuilder.toString(), illegalArgumentException);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        Downsampler.resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            OPTIONS_QUEUE.offer(options);
            return;
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d) {
        return (int)(d + 0.5);
    }

    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int n, int n2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26) {
            if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return;
            }
            config = options.outConfig;
        } else {
            config = null;
        }
        Bitmap.Config config2 = config;
        if (config == null) {
            config2 = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(n, n2, config2);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT < 19) return TYPES_THAT_USE_POOL_PRE_KITKAT.contains(imageType);
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int n, int n2, Options options) throws IOException {
        return this.decode(inputStream, n, n2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int n, int n2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Preconditions.checkArgument((boolean)inputStream.markSupported(), (String)"You must provide an InputStream that supports mark()");
        byte[] byArray = (byte[])this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options options2 = Downsampler.getDefaultOptions();
        options2.inTempStorage = byArray;
        DecodeFormat decodeFormat = (DecodeFormat)options.get(DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy)options.get(DOWNSAMPLE_STRATEGY);
        boolean bl = (Boolean)options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS);
        boolean bl2 = options.get(ALLOW_HARDWARE_CONFIG) != null && (Boolean)options.get(ALLOW_HARDWARE_CONFIG) != false;
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
            bl2 = false;
        }
        try {
            inputStream = BitmapResource.obtain((Bitmap)this.decodeFromWrappedStreams(inputStream, options2, downsampleStrategy, decodeFormat, bl2, n, n2, bl, decodeCallbacks), (BitmapPool)this.bitmapPool);
            return inputStream;
        }
        finally {
            Downsampler.releaseOptions(options2);
            this.byteArrayPool.put((Object)byArray);
        }
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }
}
