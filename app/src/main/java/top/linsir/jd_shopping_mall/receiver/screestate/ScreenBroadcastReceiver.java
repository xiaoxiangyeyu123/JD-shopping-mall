package top.linsir.jd_shopping_mall.receiver.screestate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * 作者：潇湘夜雨 on 2018/1/29.
 * 邮箱：879689064@qq.com
 */

public class ScreenBroadcastReceiver extends BroadcastReceiver {
    private static ScreenStateListener mScreenObservers;
    private String action = null;
    private static ScreenBroadcastReceiver mScreenReceiver;

    private static BroadcastReceiver getReceiver() {
        if (null == mScreenReceiver) {
            synchronized (ScreenBroadcastReceiver.class) {
                if (null == mScreenReceiver) {
                    mScreenReceiver = new ScreenBroadcastReceiver();
                }
            }
        }
        return mScreenReceiver;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        action = intent.getAction();
        // ----------------开屏时调用---------------
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            mScreenObservers.onScreenOn();
        }
        // ----------------锁屏时调用---------------
        else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            mScreenObservers.onScreenOff();
        }
        // ----------------解锁时调用---------------
        else if (Intent.ACTION_USER_PRESENT.equals(action)) {
            mScreenObservers.onUserPresent();
        }

    }

    public static void registerNetworkStateReceiver(Context mContext) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        mContext.getApplicationContext().registerReceiver(getReceiver(), filter);
    }

    //销毁广播
    private void unregisterListener(Context mContext) {
        if (mScreenReceiver != null) {
            try {
                mContext.getApplicationContext().unregisterReceiver(mScreenReceiver);
            } catch (Exception e) {

            }
        }
    }

    public static void registerObserver(ScreenStateListener screenStateListener) {
        mScreenObservers = screenStateListener;
    }

    public static void removeRegisterObserver() {
        mScreenObservers = null;
    }

}
