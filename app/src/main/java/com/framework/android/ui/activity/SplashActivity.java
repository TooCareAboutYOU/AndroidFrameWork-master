package com.framework.android.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.framework.android.R;
import com.framework.android.ui.base.BaseActivity;
import com.framework.android.ui.fragment.Test2Fragment;

public class SplashActivity extends BaseActivity {

    private FragmentManager mManager;
    private FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toast.makeText(this, "欢迎进入启动页", Toast.LENGTH_SHORT).show();

        initView();
    }


    private void initView() {
        mManager=getSupportFragmentManager();
        ft=mManager.beginTransaction();
        ft.add(R.id.contains_fragment, new Test2Fragment());
        ft.commit();
    }
}
