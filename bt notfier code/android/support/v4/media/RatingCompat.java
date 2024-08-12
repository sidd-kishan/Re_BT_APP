/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.Rating
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 */
package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public final class RatingCompat
implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    RatingCompat(int n, float f) {
        this.mRatingStyle = n;
        this.mRatingValue = f;
    }

    public static RatingCompat fromRating(Object object) {
        Rating rating;
        Object object2 = rating = null;
        if (object == null) return object2;
        object2 = rating;
        if (Build.VERSION.SDK_INT < 19) return object2;
        object2 = (Rating)object;
        int n = object2.getRatingStyle();
        if (object2.isRated()) {
            switch (n) {
                default: {
                    return null;
                }
                case 6: {
                    object2 = RatingCompat.newPercentageRating(object2.getPercentRating());
                    break;
                }
                case 3: 
                case 4: 
                case 5: {
                    object2 = RatingCompat.newStarRating(n, object2.getStarRating());
                    break;
                }
                case 2: {
                    object2 = RatingCompat.newThumbRating(object2.isThumbUp());
                    break;
                }
                case 1: {
                    object2 = RatingCompat.newHeartRating(object2.hasHeart());
                    break;
                }
            }
        } else {
            object2 = RatingCompat.newUnratedRating(n);
        }
        object2.mRatingObj = object;
        return object2;
    }

    public static RatingCompat newHeartRating(boolean bl) {
        float f = bl ? 1.0f : 0.0f;
        return new RatingCompat(1, f);
    }

    public static RatingCompat newPercentageRating(float f) {
        if (!(f < 0.0f)) {
            if (!(f > 100.0f)) return new RatingCompat(6, f);
        }
        Log.e((String)TAG, (String)"Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int n, float f) {
        float f2;
        if (n != 3) {
            if (n != 4) {
                if (n != 5) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid rating style (");
                    stringBuilder.append(n);
                    stringBuilder.append(") for a star rating");
                    Log.e((String)TAG, (String)stringBuilder.toString());
                    return null;
                }
                f2 = 5.0f;
            } else {
                f2 = 4.0f;
            }
        } else {
            f2 = 3.0f;
        }
        if (!(f < 0.0f)) {
            if (!(f > f2)) return new RatingCompat(n, f);
        }
        Log.e((String)TAG, (String)"Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newThumbRating(boolean bl) {
        float f = bl ? 1.0f : 0.0f;
        return new RatingCompat(2, f);
    }

    public static RatingCompat newUnratedRating(int n) {
        switch (n) {
            default: {
                return null;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
        }
        return new RatingCompat(n, -1.0f);
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        if (this.mRatingStyle != 6) return -1.0f;
        if (this.isRated()) return this.mRatingValue;
        return -1.0f;
    }

    public Object getRating() {
        if (this.mRatingObj != null) return this.mRatingObj;
        if (Build.VERSION.SDK_INT < 19) return this.mRatingObj;
        if (this.isRated()) {
            int n = this.mRatingStyle;
            switch (n) {
                default: {
                    return null;
                }
                case 6: {
                    this.mRatingObj = Rating.newPercentageRating((float)this.getPercentRating());
                    break;
                }
                case 3: 
                case 4: 
                case 5: {
                    this.mRatingObj = Rating.newStarRating((int)n, (float)this.getStarRating());
                    break;
                }
                case 2: {
                    this.mRatingObj = Rating.newThumbRating((boolean)this.isThumbUp());
                    break;
                }
                case 1: {
                    this.mRatingObj = Rating.newHeartRating((boolean)this.hasHeart());
                    break;
                }
            }
        } else {
            this.mRatingObj = Rating.newUnratedRating((int)this.mRatingStyle);
        }
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int n = this.mRatingStyle;
        if (n != 3 && n != 4 && n != 5) {
            return -1.0f;
        }
        if (!this.isRated()) return -1.0f;
        return this.mRatingValue;
    }

    public boolean hasHeart() {
        int n = this.mRatingStyle;
        boolean bl = false;
        if (n != 1) {
            return false;
        }
        if (this.mRatingValue != 1.0f) return bl;
        bl = true;
        return bl;
    }

    public boolean isRated() {
        boolean bl = this.mRatingValue >= 0.0f;
        return bl;
    }

    public boolean isThumbUp() {
        int n = this.mRatingStyle;
        boolean bl = false;
        if (n != 2) {
            return false;
        }
        if (this.mRatingValue != 1.0f) return bl;
        bl = true;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rating:style=");
        stringBuilder.append(this.mRatingStyle);
        stringBuilder.append(" rating=");
        float f = this.mRatingValue;
        String string = f < 0.0f ? "unrated" : String.valueOf(f);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
