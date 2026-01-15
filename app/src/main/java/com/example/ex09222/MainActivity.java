package com.example.ex09222;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    final String[] types = {"movie", "restaurant", "show", "late night trip"};
    TextView tv;
    LinearLayout mainPage;
    AlertDialog.Builder adb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.outputTV);
        mainPage = findViewById(R.id.main);
    }

    public void choseType(View view) {
        tv.setText("");
        adb = new AlertDialog.Builder(this);
        adb.setTitle("List of types of activities choose one");
        adb.setItems(types, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("the chosen activity is: "+types[which]);
                switch (which) {
                    case 0:
                        mainPage.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        mainPage.setBackgroundColor(Color.CYAN);
                        break;
                    case 2:
                        mainPage.setBackgroundColor(Color.MAGENTA);
                        break;
                    case 3:
                        mainPage.setBackgroundColor(Color.GRAY);
                        break;
                }

            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
}