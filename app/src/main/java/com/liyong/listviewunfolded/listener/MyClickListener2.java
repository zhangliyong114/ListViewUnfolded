package com.liyong.listviewunfolded.listener;

import android.view.View;

/**
 * Created by Administrator on 2017/4/19.
 */

public abstract class MyClickListener2 implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        myOnClick2((Integer) v.getTag(), v);
    }

    public abstract void myOnClick2(int position, View v);

}
