/*
 * Copyright (C) 2014 Paprikapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    private static final String FONT_EXTENSION = "ttf";
    /**
     * Map for fewer typeface allocation.
     */
    private static final Map<String, Typeface> mCachedFonts = new HashMap<>();

    private View mView;

    /**
     * @param view
     */
    private SmackFont(@NonNull View view) {
        mView = view;
    }

    private Context getContext() {
        return mView.getContext();
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
     * @param resId
     */
    public void set(@StringRes int resId) {
        set(getContext().getString(resId));
    }

    /**
     * @param attrs
     */
    protected void trySetFromAttrs(@Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (attrs != null) {
            setFromAttrs(attrs, defStyleAttr, defStyleRes);
        }
    }

    /**
     * @param attrs
     */
    protected void setFromAttrs(@NonNull AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (mView.isInEditMode())
            return;

        TypedArray typedArray = getContext()
                .obtainStyledAttributes(attrs, R.styleable.SmackView, defStyleAttr, defStyleRes);

        try {
            String fontFamily = typedArray.getString(R.styleable.SmackView_font);
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

            AssetManager assetManager = getContext().getAssets();

            if (!mCachedFonts.containsKey(fontFamily)) {
                Typeface typeface = Typeface.createFromAsset(assetManager, fontFileName(fontFamily));
                mCachedFonts.put(fontFamily, typeface);
            }
            return mCachedFonts.get(fontFamily);
        }
    }

    private static String fontFileName(String fontFamily) {
        return fontFamily + "." + FONT_EXTENSION;
    }
}
