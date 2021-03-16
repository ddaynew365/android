package coms.example.allinonelowfiproject.slidingRootNav.srnUtil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import coms.example.allinonelowfiproject.slidingRootNav.SlidingRootNavLayout;

/**
 * Created by yarolegovich on 26.03.2017.
 */

public class HiddenMenuClickConsumer extends View {

    private SlidingRootNavLayout menuHost;

    public HiddenMenuClickConsumer(Context context) {
        super(context);
    }

    @Override
    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent event) {
        return menuHost.isMenuClosed();
    }

    public void setMenuHost(SlidingRootNavLayout layout) {
        this.menuHost = layout;
    }
}