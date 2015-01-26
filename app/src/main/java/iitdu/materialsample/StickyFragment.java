package iitdu.materialsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
/**
 * Created by U on 1/26/2015.
 */
public class StickyFragment extends Fragment implements ObservableScrollView.Callbacks {
    private TextView mStickyView;
    private View mPlaceholderView;
    private ObservableScrollView mObservableScrollView;

    public StickyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_content, container, false);

        mObservableScrollView = (ObservableScrollView) rootView.findViewById(R.id.scroll_view);
        mObservableScrollView.setCallbacks(this);

        mStickyView = (TextView) rootView.findViewById(R.id.sticky);
        mStickyView.setText(R.string.sticky_item);
        mPlaceholderView = rootView.findViewById(R.id.placeholder);

        mObservableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        onScrollChanged(mObservableScrollView.getScrollY());
                    }
                });

        return rootView;
    }

    @Override
    public void onScrollChanged(int scrollY) {
        mStickyView.setTranslationY(Math.max(mPlaceholderView.getTop(), scrollY));
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent() {
    }
}
