//package com.example.kimsoohyeong.week13;
//
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//
//public class Main3Activity extends AppCompatActivity {
//    EditText et1, et2;
//    Handler mainHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            String str = (String) msg.obj;
//            et2.setText(str);
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//
//        et1 = (EditText) findViewById(R.id.et1);
//        et2 = (EditText) findViewById(R.id.et2);
//        subThread.start();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        subThread.subHandler.getLooper().quit();
//    }
//
//    SubThread subThread = new SubThread();
//
//    class SubHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            String name = (String) msg.obj;
//            name = "안녕하세요 " + name;
//
//            Message msg1 = Message.obtain();
//            msg1.obj = name;
//            mainHandler.sendMessageDelayed(msg1, 2000);
//        }
//    }
//
//    class SubThread extends Thread {
//        SubHandler subHandler = new SubHandler();
//
//        @Override
//        public void run() {
//            Looper.prepare();
//            Looper.loop();
//        }
//    }
//
//    public void onClick(View v) {
//        String name = et1.getText().toString();
//
//        Message msg = Message.obtain();
//        msg.obj = name;
//
//        subThread.subHandler.sendMessage(msg);
//    }
//}
