package com.saracawley.draganddraw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by scawley on 4/6/16.
 */
public class DragAndDrawFragment extends Fragment {
    public static DragAndDrawFragment newInstance(){
        return new DragAndDrawFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drag_and_draw,container,false);
        return v;
    }
}
