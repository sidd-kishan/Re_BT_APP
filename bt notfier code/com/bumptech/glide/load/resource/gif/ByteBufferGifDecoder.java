/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.gifdecoder.GifDecoder
 *  com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
 *  com.bumptech.glide.gifdecoder.GifHeader
 *  com.bumptech.glide.gifdecoder.GifHeaderParser
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  com.bumptech.glide.load.ImageHeaderParserUtils
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.UnitTransformation
 *  com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$GifDecoderFactory
 *  com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$GifHeaderParserPool
 *  com.bumptech.glide.load.resource.gif.GifBitmapProvider
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.load.resource.gif.GifDrawableResource
 *  com.bumptech.glide.load.resource.gif.GifOptions
 *  com.bumptech.glide.util.LogTime
 */
package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableResource;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class ByteBufferGifDecoder
implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = new GifDecoderFactory();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.get((Context)context).getRegistry().getImageHeaderParsers(), Glide.get((Context)context).getBitmapPool(), Glide.get((Context)context).getArrayPool());
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.context = context.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory;
        this.provider = new GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private GifDrawableResource decode(ByteBuffer object, int n, int n2, GifHeaderParser object2, Options options) {
        long l;
        block5: {
            GifHeader gifHeader;
            block6: {
                l = LogTime.getLogTime();
                gifHeader = object2.parseHeader();
                if (gifHeader.getNumFrames() <= 0 || gifHeader.getStatus() != 0) break block5;
                object2 = options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int n3 = ByteBufferGifDecoder.getSampleSize(gifHeader, n, n2);
                object = this.gifDecoderFactory.build((GifDecoder.BitmapProvider)this.provider, gifHeader, (ByteBuffer)object, n3);
                object.setDefaultBitmapConfig((Bitmap.Config)object2);
                object.advance();
                options = object.getNextFrame();
                if (options != null) break block6;
                if (!Log.isLoggable((String)TAG, (int)2)) return null;
                object = new StringBuilder();
                ((StringBuilder)object).append("Decoded GIF from stream in ");
                ((StringBuilder)object).append(LogTime.getElapsedMillis((long)l));
                Log.v((String)TAG, (String)((StringBuilder)object).toString());
                return null;
            }
            object2 = UnitTransformation.get();
            gifHeader = new GifDrawable(this.context, (GifDecoder)object, (Transformation)object2, n, n2, (Bitmap)options);
            object2 = new GifDrawableResource((GifDrawable)gifHeader);
            return object2;
        }
        if (!Log.isLoggable((String)TAG, (int)2)) return null;
        object = new StringBuilder();
        ((StringBuilder)object).append("Decoded GIF from stream in ");
        ((StringBuilder)object).append(LogTime.getElapsedMillis((long)l));
        Log.v((String)TAG, (String)((StringBuilder)object).toString());
        return null;
        finally {
            if (Log.isLoggable((String)TAG, (int)2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Decoded GIF from stream in ");
                ((StringBuilder)object).append(LogTime.getElapsedMillis((long)l));
                Log.v((String)TAG, (String)((StringBuilder)object).toString());
            }
        }
    }

    private static int getSampleSize(GifHeader gifHeader, int n, int n2) {
        int n3 = Math.min(gifHeader.getHeight() / n2, gifHeader.getWidth() / n);
        n3 = n3 == 0 ? 0 : Integer.highestOneBit(n3);
        n3 = Math.max(1, n3);
        if (!Log.isLoggable((String)TAG, (int)2)) return n3;
        if (n3 <= 1) return n3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Downsampling GIF, sampleSize: ");
        stringBuilder.append(n3);
        stringBuilder.append(", target dimens: [");
        stringBuilder.append(n);
        stringBuilder.append("x");
        stringBuilder.append(n2);
        stringBuilder.append("], actual dimens: [");
        stringBuilder.append(gifHeader.getWidth());
        stringBuilder.append("x");
        stringBuilder.append(gifHeader.getHeight());
        stringBuilder.append("]");
        Log.v((String)TAG, (String)stringBuilder.toString());
        return n3;
    }

    public GifDrawableResource decode(ByteBuffer byteBuffer, int n, int n2, Options options) {
        GifHeaderParser gifHeaderParser = this.parserPool.obtain(byteBuffer);
        try {
            byteBuffer = this.decode(byteBuffer, n, n2, gifHeaderParser, options);
            return byteBuffer;
        }
        finally {
            this.parserPool.release(gifHeaderParser);
        }
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
        boolean bl = (Boolean)options.get(GifOptions.DISABLE_ANIMATION) == false && ImageHeaderParserUtils.getType(this.parsers, (ByteBuffer)byteBuffer) == ImageHeaderParser.ImageType.GIF;
        return bl;
    }
}
