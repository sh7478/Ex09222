package com.example.ex09222;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author shaked hazan shaked1246@gmail.com
 * @version 1.0
 * @since 2024-07-29
 * this is the credits activity of the app, it shows the creator of the app.
 */
public class CreditsPage extends AppCompatActivity {

    /**
     * this function is called when the activity is created.
     * <p>
     *
     * @param savedInstanceState description
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_page);
    }

    /**
     * this function is called when the user clicks on the "back" button, it returns to the previous activity.
     * <p>
     *
     * @param view the button that was clicked.
     */
    public void goBack(View view) {
        finish();
    }
}
