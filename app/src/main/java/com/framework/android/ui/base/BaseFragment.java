package com.framework.android.ui.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.framework.android.utils.statusbar.StatusBarCompat;

import butterknife.ButterKnife;

/**
 * Created by J.K.Zhang on 2017/4/19.
 */

public abstract class BaseFragment extends Fragment {

    private View rootView;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }

    @Nullable
    @Override
    public   View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null){
            rootView=inflater.inflate(setLayoutRes(),container,false);
        }

        ViewGroup viewGroup = (ViewGroup) rootView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(rootView);
        }
        ButterKnife.bind(this, rootView);
        setLayoutView();

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            //Toast.makeText(getActivity(), "嘿嘿", Toast.LENGTH_SHORT).show();
        }else {
            //Toast.makeText(getActivity(), "呵呵", Toast.LENGTH_SHORT).show();
        }
        StatusBarCompat.translucentStatusBar(getActivity(), true);

        return rootView;
    }

    /**
     * 初始化视图
     */
    protected  void  setLayoutView() { }

    /**
     * fragment对应的xml布局
     * @return
     */
    protected abstract int setLayoutRes();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        StatusBarCompat.translucentStatusBar(getActivity(), false);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Fresco.getImagePipeline().clearMemoryCaches();
    }
}
