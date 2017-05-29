package com.example.kimsoohyeong.week13;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TodayLOL extends AppCompatActivity {
    EditText et;
    ImageView iv;
    TextView tv;
    Task task;
    int changeSec = 1;
    int imageNo = 0;
    boolean isStart = false;
    boolean isSelected = false;

    final int imageCount = 7;
    String imageNames[];
    int imageRes[] = new int[imageCount];

    int logoRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_lol);

        setTitle("오늘 무슨 포지션가지?");

        init();
    }

    private void init() {
        et = (EditText) findViewById(R.id.et1);
        iv = (ImageView) findViewById(R.id.image);
        tv = (TextView) findViewById(R.id.text);

        imageNames = getResources().getStringArray(R.array.position);
        logoRes = getResources().getIdentifier("logo",
                "drawable", getPackageName());

        for (int i = 0; i < imageCount; i++) {
            imageRes[i] = getResources().getIdentifier(imageNames[i].substring(0, imageNames[i].length()-4),
                    "drawable", getPackageName());
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            isSelected = false;
            isStart = false;
            changeSec = 1;
            imageNo = 0;
            tv.setText("");
            iv.setImageResource(logoRes);
        } else {
            if (isStart) {
                isSelected = true;
                task.onPostExecute(task.getSec());
            } else {
                isStart = true;
                changeSec = Integer.parseInt(et.getText().toString());
                task = new Task();
                task.execute(changeSec);
            }
        }
    }

    class Task extends AsyncTask<Integer, Integer, Integer> {
        private int sec = 0;

        public int getSec() { return sec; }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            int i;
            for (i = 0; ; i++) {
                try {
                    sec = i;
                    if (isCancelled()) break;
                    if (isSelected) return i - 1;
                    publishProgress(i, i % changeSec);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText("시작부터 " + values[0] + "초");
            if (values[1] == 0) {
                iv.setImageResource(imageRes[imageNo]);
                imageNo = (imageNo + 1) % imageCount;
            }
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            int idx = (imageNo + imageCount - 1) % imageCount;
//            Log.d("PRINT", imageNames[idx].substring(0, imageNames[idx].length() - 4));
            tv.setText(imageNames[idx].substring(0, imageNames[idx].length() - 4) +
                    "선택 (" + integer + " 초)");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
