//package com.example.kimsoohyeong.week13;
//
//import android.os.Handler;
//import android.os.Message;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//    TextView text1;
//    int idx = 0;
//    Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            text1.setText("숫자 : " + idx);
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        text1 = (TextView) findViewById(R.id.text1);
//    }
//
//    class MyThread extends Thread {
//        @Override
//        public void run() {
//            for (idx = 1; idx <= 10; idx++) {
//                try {
//                    Thread.sleep(1000);
//                    Message msg = mHandler.obtainMessage();
//                    mHandler.sendMessage(msg);
////                    mHandler.post(new Runnable() {
////                        @Override
////                        public void run() {
////                            text1.setText("숫자 : " + idx);
////                        }
////                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void onClick(View v) {
//        MyThread th = new MyThread();
//        th.start();
//    }
//}
