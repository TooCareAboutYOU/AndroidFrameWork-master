package com.framework.android.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by J.K.Zhang on 2017/4/19.
 */

public class ProjcetApplication extends Application {

    public volatile static ProjcetApplication singleton;

    public static ProjcetApplication getInstance() {
        if (singleton == null) {
             synchronized (ProjcetApplication.class) {
                  if (singleton == null) {
                      singleton = new ProjcetApplication();
                  }
             }
         }
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ImagePipelineConfig config= OkHttpImagePipelineConfigFactory.newBuilder(this,
                new OkHttpClient())
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this,config);

    }

    //public static synchronized ProjcetApplication getInstance(){ return singleton; }

}
