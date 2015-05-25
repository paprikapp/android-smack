package hu.paprikapp.smack.soup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author Balazs Varga
 */
public class ProgressView extends FrameLayout {

    private View mEmptyView;
    private View mProgressView;
    private View mContentView;

    public ProgressView(@NonNull Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public ProgressView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public ProgressView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ProgressView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        SmackFont.in(this).trySetFromAttrs(attrs, defStyleAttr, defStyleRes);
    }

    public static ProgressView initAndGetContentView(Context context, @LayoutRes final int contentViewRes, @LayoutRes final int progressLayoutRes) {
        ProgressView progressView = new ProgressView(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        progressView.setLayoutParams(layoutParams);
        progressView.setContentView(contentViewRes);
        progressView.setProgressView(progressLayoutRes);
        return progressView;
    }

    public void startProgress() {
        if (mEmptyView != null)
            mEmptyView.setVisibility(GONE);
        if (mProgressView != null)
            mProgressView.setVisibility(VISIBLE);
        if (mContentView != null)
            mContentView.setVisibility(GONE);

        if (mProgressView instanceof LoaderIndicator) {
            ((LoaderIndicator) mProgressView).start();
        }
    }

    public void stopProgress(boolean noContent) {
        if (mEmptyView != null)
            mEmptyView.setVisibility(noContent ? VISIBLE : GONE);
        if (mProgressView != null)
            mProgressView.setVisibility(GONE);
        if (mContentView != null)
            mContentView.setVisibility(noContent ? GONE : VISIBLE);

        if (mProgressView instanceof LoaderIndicator) {
            ((LoaderIndicator) mProgressView).stop();
        }
    }

    public void stopProgress() {
        stopProgress(false);
    }

    public void setEmptyView(int viewId) {
        int index = getChildCount();
        View.inflate(getContext(), viewId, this);
        mEmptyView = getChildAt(index);
        stopProgress();
    }

    public void setEmptyView(View view) {
        mEmptyView = view;
        addView(view);
        stopProgress();
    }

    public void setContentView(int viewId) {
        int index = getChildCount();
        View.inflate(getContext(), viewId, this);
        mContentView = getChildAt(index);
        stopProgress();
    }

    public void setContentView(View view) {
        mContentView = view;
        addView(view);
        stopProgress();
    }

    public void setProgressView(int viewId) {
        int index = getChildCount();
        View.inflate(getContext(), viewId, this);
        mProgressView = getChildAt(index);
        stopProgress();
    }

    public void setProgressView(View view) {
        mProgressView = view;
        addView(view);
        stopProgress();
    }
}
