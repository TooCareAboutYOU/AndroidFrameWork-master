package com.framework.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.framework.android.R;
import com.framework.android.ui.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setToolBarTitle("首页");
        return super.onCreateOptionsMenu(menu);
    }



    @OnClick(R.id.img_jumpToSet)
    public void onViewClicked() {
        Toast.makeText(this, "跳转", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, SetActivity.class));
        overridePendingTransition(R.anim.activity_in_from_right, R.anim.activity_out_from_right);
    }
}
