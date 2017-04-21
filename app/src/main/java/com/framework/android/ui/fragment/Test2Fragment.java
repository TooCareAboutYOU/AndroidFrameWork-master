package com.framework.android.ui.fragment;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.framework.android.R;
import com.framework.android.ui.activity.MainActivity;
import com.framework.android.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by J.K.Zhang on 2017/4/20.
 */

public class Test2Fragment extends BaseFragment {

    private static final String TAG = Test2Fragment.class.getSimpleName();

    @Bind(R.id.btn_isHide)
    Button mBtnIsHide;
    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_test2;
    }

    @Override
    protected void setLayoutView() {
        super.setLayoutView();

    }

    @OnClick(R.id.btn_isHide)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "跳转", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), MainActivity.class));

    }
}
