package com.droid.bootcamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SumActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sum);

        TextView result = (TextView) findViewById(R.id.result);
        result.setText(String.valueOf(getIntent().getExtras().getFloat("result")));
    }

    public void minusTen(View view){
        float sum = getIntent().getExtras().getFloat("result");
        Intent backIntent = new Intent();
        backIntent.putExtra("result", (sum - 10));
        setResult(RESULT_OK, backIntent);
        finish();
    }
}