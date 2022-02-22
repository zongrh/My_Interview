package cn.my.interview.ui.mvptest;

import android.os.Handler;
import android.os.Message;

/**
 * FileName: HttpModel
 * Author: nanzong
 * Date: 2022/2/18 3:49 上午
 * Description:
 * History:
 */
class HttpModel {
    private Callback mCallback;

    public HttpModel(Callback callback) {
        mCallback = callback;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCallback.onResult((String) msg.obj);
        }
    };

    public void request() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Message msg = handler.obtainMessage();
                    msg.obj = "从网络获取到的数据";
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
