package hu.paprikapp.smack.soup.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;

/**
 * @author Balazs Varga
 */
public class SmackSearchView extends SearchView {
    public SmackSearchView(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public SmackSearchView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public SmackSearchView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        SmackFont.in(this).trySetFromAttrs(attrs, defStyleAttr, 0);
    }
}
