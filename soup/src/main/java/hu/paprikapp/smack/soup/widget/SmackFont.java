package hu.paprikapp.smack.soup.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import hu.paprikapp.smack.soup.R;

/**
 * @author Balazs Varga
 */
public class SmackFont {

    // TODO custom font extensions.
    private static final String FONT_EXTENSION = "ttf";
    /**
     * Map for fewer typeface allocation.
     */
    private static final Map<String, Typeface> mCachedFonts = new HashMap<String, Typeface>();

    private Context mContext;
    private View mView;

    /**
     * @param view
     */
    private SmackFont(@NonNull View view) {
        mContext = view.getContext().getApplicationContext();
        mView = view;
    }

    /**
     * @param view
     * @return
     */
    public static SmackFont in(@NonNull View view) {
        return new SmackFont(view);
    }

    /**
     * @param fontName
     */
    public void set(@NonNull final String fontName) {
        setTypeface(mView, createTypeface(fontName));
    }

    /**
     *
     * @param resId
     */
    public void set(@StringRes int resId) {
        set(mContext.getString(resId));
    }

    /**
     * @param attrs
     */
    protected void trySetFromAttrs(@Nullable AttributeSet attrs) {
        if (attrs != null)
            setFromAttrs(attrs);
    }

    /**
     * @param attrs
     */
    protected void setFromAttrs(@NonNull AttributeSet attrs) {
        if (mView.isInEditMode())
            return;

        TypedArray typedArray = mContext
                .obtainStyledAttributes(attrs, R.styleable.SmackView, 0, 0);

        String fontFamily = null;
        try {
            fontFamily = typedArray.getString(R.styleable.SmackView_font);
            if (fontFamily != null) {
                set(fontFamily);
            }
        } finally {
            typedArray.recycle();
        }
    }


    private static void setTypeface(@NonNull View view, @NonNull Typeface typeface) {
        if (view instanceof ViewGroup) {
            setTypeface((ViewGroup) view, typeface);
        } else if (view instanceof TextView) {
            setTypeface((TextView) view, typeface);
        }
    }

    private static void setTypeface(@NonNull TextView textView, @NonNull Typeface typeface) {
        textView.setTypeface(typeface);
        //For making the font anti-aliased.
        textView.setPaintFlags(textView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    private static void setTypeface(@NonNull ViewGroup viewGroup, @NonNull Typeface typeface) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            setTypeface(child, typeface);
        }
    }

    private Typeface createTypeface(@NonNull String fontFamily) {

        synchronized (mCachedFonts) {

            AssetManager assetManager = mContext.getAssets();

            if (!mCachedFonts.containsKey(fontFamily)) {
                Typeface typeface = Typeface.createFromAsset(assetManager, fontFileName(fontFamily));
                mCachedFonts.put(fontFamily, typeface);
            }
            return mCachedFonts.get(fontFamily);
        }
    }

    private static String fontFileName(String fontFamily) {
        return new StringBuilder()
                .append(fontFamily)
                .append(".")
                .append(FONT_EXTENSION)
                .toString();
    }
}