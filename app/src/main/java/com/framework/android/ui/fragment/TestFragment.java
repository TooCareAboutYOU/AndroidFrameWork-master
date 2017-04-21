package com.framework.android.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.widget.SeekBar;

import com.framework.android.R;
import com.framework.android.ui.activity.MainActivity;
import com.framework.android.ui.base.BaseFragment;
import com.framework.android.utils.statusbar.StatusBarCompat;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by J.K.Zhang on 2017/4/19.
 */

public class TestFragment extends BaseFragment {

    private static final String TAG = TestFragment.class.getSimpleName();

    @Bind(R.id.seek_bar)
    SeekBar mSeekBar;

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_test;
    }

    @Override
    protected void setLayoutView() {
        super.setLayoutView();
        initView();
    }

    private void initView() {
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {
                StatusBarCompat.setStatusBarColor(getActivity(),Color.GRAY,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            StatusBarCompat.setStatusBarColor(getActivity(), Color.GRAY);
            //StatusBarCompat.setStatusBarColor(getActivity(),Color.parseColor("#ffffff"));
        }
    }

    @OnClick(R.id.img_jump)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}
