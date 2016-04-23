package com.saracawley.draganddraw;

import android.graphics.PointF;

/**
 * Created by sara on 4/22/2016.
 */
public class Box {
    private PointF mOrigin;
    private PointF mCurrent;

    public Box (PointF origin){
        mOrigin = origin;
        mCurrent = origin;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    public void setOrigin(PointF origin) {
        mOrigin = origin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF current) {
        mCurrent = current;
    }
}
