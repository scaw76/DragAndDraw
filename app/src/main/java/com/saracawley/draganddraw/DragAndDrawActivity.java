package com.saracawley.draganddraw;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DragAndDrawActivity extends SingleFragmentActivity {

    public Fragment createFragment(){
        return DragAndDrawFragment.newInstance();
    }
}
