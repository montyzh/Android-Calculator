package com.example.kyrieirving.android_cacu;

/**
 * Created by Kyrie Irving on 2018/4/9.
 */



import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.OrientationEventListener;

import java.lang.ref.WeakReference;

 class MySensorHelper {
    private static final String TAG = MySensorHelper.class.getSimpleName();
//两个不同的监听器
    private OrientationEventListener mLandOrientationListener;
    private OrientationEventListener mPortOrientationListener;
//弱引用
//存放当前activity的引用
    private WeakReference<Activity> mActivityWeakRef;
//屏幕切换锁
    private boolean isPortLock = false;
    private boolean isLandLock=false;

//构造函数
    public MySensorHelper(final Activity activity) {
//保存当前activity
        this.mActivityWeakRef = new WeakReference(activity);

    }

//切换为横屏的函数
//根据重力感应切换activity
public  void cross(final Activity activity){

        //注册监听器
    this.mLandOrientationListener = new OrientationEventListener(activity, 3) {
        @Override
        //重写屏幕旋转函数
        public void onOrientationChanged(int rotation) {

//判断感应参数
            if(((rotation > 45) && (rotation < 135))||((rotation>225)&&(rotation<315))
                    /*orientation < 100 && orientation > 80 || orientation < 280 && orientation > 260*/) {
//判断是否锁住
                if(!isLandLock){


//得到之前保存的activity
                    Activity mActivity = (Activity)MySensorHelper.this.mActivityWeakRef.get();
//如果不为空则执行
                    if(mActivity != null) {
//实例化Intent的对象用于切换activity
                        Intent intent=new Intent();
                        intent.setClass(activity,Main2Activity.class);
                        mActivity.startActivities(new Intent[]{intent});


                        // mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                    }

                    isLandLock = true;
                }


            }

        }
    };
//开启切换
    this.mLandOrientationListener.enable();
}

//切换为竖屏的函数
//根据重力感应切换activity
public  void vertical(final Activity activity){



    this.mPortOrientationListener = new OrientationEventListener(activity, 3) {
        //重写屏幕旋转函数
        @Override
        public void onOrientationChanged(int rotation) {

            if(((rotation >= 0) && (rotation <= 45)) || (rotation >= 315)||((rotation>=135)&&(rotation<=225))
                    /*orientation < 10 || orientation > 350 || orientation < 190 && orientation > 170 */) {

                if(!isPortLock){
                    Activity mActivity = (Activity)MySensorHelper.this.mActivityWeakRef.get();
                    if(mActivity != null) {


                        Intent intent=new Intent();
                        intent.setClass(activity,MainActivity.class);
                        mActivity.startActivities(new Intent[]{intent});


                    }
                    isPortLock = true;
                }


             }

         }
        };
    this.mPortOrientationListener.enable();
    }

}