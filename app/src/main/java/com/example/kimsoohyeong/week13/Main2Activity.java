//package com.example.kimsoohyeong.week13;
//
//import android.content.Intent;
//import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class Main2Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(Main2Activity.this,
//                        Main4Activity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 3000);
//    }
//}
