package com.example.ex09222;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    final String[] types = {"movie", "restaurant", "show", "late night trip"};
    final String[] movieGear = {"popcorn", "snack", "chocolate", "nachos", "drinks", "3D glasses"};
    final String[] showGear = {"tickets", "phone", "ID", "portable charger", "deodorant", "manual fan"};
    final String[] tripGear = {"headLight", "spare batteries", "UV light", "map", "Mosquito spray", "plastic bag"};
    final String[] restaurantGear = {"wallet", "gum", "portable charger", "phone", "jacket", "glasses"};
    TextView tv;
    String output = "`";
    String name;
    LinearLayout mainPage;
    AlertDialog.Builder adb;
    int type = -1;

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
                tv.setText("the chosen activity is: " + types[which]);
                tv.append(" The items for the activity are: ");
                type = which;
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

    public void choseGear(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        output = "";
        if (type == -1) {
            adb.setTitle("Error");
            adb.setMessage("You have to choose an activity first");
            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog ad = adb.create();
            ad.show();
        } else {
            adb.setTitle("List of equipment choose one");
            switch (type) {
                case 0:
                    adb.setMultiChoiceItems(movieGear, null, new DialogInterface.OnMultiChoiceClickListener() {
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                output += movieGear[which] + ", ";
                            } else if (tv.toString().contains(movieGear[which])) {
                                output = output.replace(movieGear[which] + ", ", "");
                            }
                        }
                    });
                    break;
                case 1:
                    adb.setMultiChoiceItems(restaurantGear, null, new DialogInterface.OnMultiChoiceClickListener() {
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                output += restaurantGear[which] + ", ";
                            } else if (tv.toString().contains(restaurantGear[which])) {
                                output = output.replace(restaurantGear[which] + ", ", "");
                            }
                        }
                    });
                    break;
                case 2:
                    adb.setMultiChoiceItems(showGear, null, new DialogInterface.OnMultiChoiceClickListener() {
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                output += showGear[which] + ", ";
                            } else if (tv.toString().contains(showGear[which])) {
                                output = output.replace(showGear[which] + ", ", "");
                            }
                        }
                    });
                    break;
                case 3:
                    adb.setMultiChoiceItems(tripGear, null, new DialogInterface.OnMultiChoiceClickListener() {
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                output += tripGear[which] + ", ";
                            } else if (tv.toString().contains(tripGear[which])) {
                                output = output.replace(tripGear[which] + ", ", "");
                            }
                        }
                    });
                    break;
            }
            adb.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv.append(output.substring(0, output.length() - 2));
                    dialog.dismiss();
                }
            });
            adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog ad = adb.create();
            ad.show();
        }
    }

    public void privateMsg(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        name = "";
        if(type == -1 || output.equals("`")) {
            adb.setTitle("Error");
            if(output.equals("`")) {
                adb.setMessage("You have to choose equipment first");
            }
            else
            {
                adb.setMessage("You have to choose activity and equipment first");
            }
            adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        }
        else {
            adb.setTitle("Enter your name");
            final EditText eT = new EditText(this);
            adb.setView(eT);
            eT.setHint("Enter your name");
            adb.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    name = eT.getText().toString();
                    if (!name.equals("")) {
                        name = "enjoy " + name;
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "you have to enter your name first", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        }
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void resetAll(View view) {
        tv.setText("there is no hangout yet");
        type = -1;
        output = "`";
        mainPage.setBackgroundColor(Color.WHITE);
    }
}