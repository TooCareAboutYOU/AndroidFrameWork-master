package com.framework.android.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.framework.android.R;
import com.framework.android.ui.base.BaseActivity;

import butterknife.OnClick;

public class SetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
    }


    @OnClick(R.id.imgbtn_jumpMain)
    public void onViewClicked() {
        overridePendingTransition(R.anim.activity_out_from_right,R.anim.activity_in_from_right);
        SetActivity.this.finish();

    }

    @Override
    public void onClick(View v) {

    }
}
