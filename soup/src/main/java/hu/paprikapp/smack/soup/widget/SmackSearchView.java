package hu.paprikapp.smack.soup.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;

import hu.paprikapp.smack.soup.widget.SmackFont;

/**
 * @author Balazs Varga
 */
public class SmackSearchView extends SearchView {
    public SmackSearchView(Context context) {
        super(context);
        init(context, null, -1);
    }

    public SmackSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, -1);
    }

    public SmackSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        SmackFont.in(this).trySetFromAttrs(attrs);
    }
}
