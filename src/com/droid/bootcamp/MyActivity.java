package com.droid.bootcamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Hakuna Matata", "Got Result");
        if(requestCode == 1){
            TextView result = (TextView) findViewById(R.id.result);
            result.setText("The result is: " + String.valueOf(data.getExtras().getFloat("result")));
        }
    }

    public void add(View view) {
        float operand1 = getFloat(R.id.first_operand);
        float operand2 = getFloat(R.id.second_operand);
        float result = operand1 + operand2;

        Intent sumIntent = new Intent(this, SumActivity.class);
        sumIntent.putExtra("result", result);

        startActivityForResult(sumIntent, 1);
    }

    private float getFloat(int id) {
        return Float.parseFloat(((EditText) findViewById(id)).getText().toString());
    }
}
