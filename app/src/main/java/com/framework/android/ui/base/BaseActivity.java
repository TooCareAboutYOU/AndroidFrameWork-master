package com.framework.android.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.framework.android.R;
import com.framework.android.utils.statusbar.StatusBarCompat;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by J.K.Zhang on 2017/4/19.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @Bind(R.id.toolbar_base)
    Toolbar mToolbar;

    @Nullable
    @Bind(R.id.contains_left)
    RelativeLayout containsLeft;  //左边

    @Nullable
    @Bind(R.id.toolbar_left)
    ImageView mImgLeft;


    @Nullable
    @Bind(R.id.contains_center)
    RelativeLayout containsCenter;   //标题

    @Nullable
    @Bind(R.id.toolbar_center)
    TextView mTvCenter;

    @Nullable
    @Bind(R.id.contains_right)
    RelativeLayout containsRight;  //右边

    @Nullable
    @Bind(R.id.toolbar_right)
    ImageView mImgRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setToolBar();
        StatusBarCompat.translucentStatusBar(this, true);
    }


    /**
     * 配置ToolBar
     */
    protected void setToolBar(){
        if (mToolbar != null){
            setSupportActionBar(mToolbar);
        }
    }

    /**
     * 设置ToolBar左边视图
     */
    protected void setToolBarBack(int img){
        if (mImgLeft != null){
            mImgLeft.setImageResource(img);
        }
    }

    /**
     * 设置ToolBar中间标题视图
     */
    protected void setToolBarTitle(String title){
        if (mTvCenter != null){
            mTvCenter.setText(title);
        }
    }

    /**
     * 设置ToolBar右边视图
     */
    protected void setToolBarMenu(int img){
        if (mImgRight != null){
            mImgRight.setImageResource(img);
        }
    }

    /**
     * 设置ToolBar左边视图 隐藏
     */
    protected void setHideBack(boolean isShow){
        if (containsLeft != null){
            containsLeft.setVisibility(isShow? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 设置ToolBar中间标题 隐藏
     */
    protected void setHideTitle(boolean isShow){
        if (containsCenter != null){
            containsCenter.setVisibility(isShow? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 设置ToolBar右边视图 隐藏
     */
    protected void setHideMenu(boolean isShow){
        if (containsRight != null){
            containsRight.setVisibility(isShow? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Fresco.getImagePipeline().clearMemoryCaches();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
