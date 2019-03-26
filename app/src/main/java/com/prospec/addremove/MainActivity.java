package com.prospec.addremove;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {

    EditText textIn, textIn1, textIn2;
    ImageView Add;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textIn = (EditText) findViewById(R.id.textin);
        textIn1 = (EditText) findViewById(R.id.textin1);
        textIn2 = (EditText) findViewById(R.id.textin2);
        Add = (ImageView) findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);

        Add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);

                TextView textOut = (TextView) addView.findViewById(R.id.textout);
                TextView textOut1 = (TextView) addView.findViewById(R.id.textout1);
                TextView textOut2 = (TextView) addView.findViewById(R.id.textout2);

                textOut.setText(textIn.getText().toString());
                textOut1.setText(textIn1.getText().toString());
                textOut2.setText(textIn2.getText().toString());
                ImageView Remove = (ImageView) addView.findViewById(R.id.remove);
                Remove.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                });

                container.addView(addView);
            }
        });
    }//Method
}//Main Class