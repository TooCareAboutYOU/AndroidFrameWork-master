package com.framework.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.framework.android.R;
import com.framework.android.ui.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgLeft.setOnClickListener(this);
        setToolBarTitle("首页");
        mImgRight.setOnClickListener(this);
    }

    @OnClick(R.id.img_jumpToSet)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, SetActivity.class));
        overridePendingTransition(R.anim.activity_in_from_right, R.anim.activity_out_from_right);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_left:
                finish();
                break;
            case R.id.toolbar_right:
                Toast.makeText(this, "点击菜单", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
