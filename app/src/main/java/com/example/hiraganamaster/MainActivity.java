package com.example.hiraganamaster;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.hiraganamaster.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
private ActivityMainBinding binding;

    TextView hiraganaView;
    TextView hintView;
    EditText editText;
    KanaData kanaData;
    Kana currentKana;
    boolean secondAttempt = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hiraganaView = findViewById(R.id.textView);
        editText = findViewById(R.id.inputEt);
        hintView = findViewById(R.id.hintTV);
        kanaData = KanaData.getInstance();

        GenerateNewKana();

        editText.setOnEditorActionListener((v, actionId, event) -> {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEND) {
                    // Code to execute when the user presses "Done" or "Send"

                    String input = v.getText().toString();
                    CheckAnswer(input);
                    return true; // Return true to indicate that you have handled the event
                }
                return false;
            });
    }

@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void GenerateNewKana()
    {
        currentKana = kanaData.getNextKana();
        hiraganaView.setText(currentKana.getKana());
        editText.setText("");
    }

    private void CheckAnswer(String input)
    {
        if(currentKana.getRomanji().equals(input) && !secondAttempt)
        {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            kanaData.correctKana();
            GenerateNewKana();
        }
        else if(currentKana.getRomanji().equals(input) && secondAttempt)
        {
            kanaData.falseKana();
            secondAttempt = false;
            HideAnswer();
            GenerateNewKana();
        }
        else if(secondAttempt)
        {
            DisplayAnswer();
            AnimationUtils.shakeEditText(editText);
        }
        else
        {
            AnimationUtils.shakeEditText(editText);
            secondAttempt = true;
        }
    }

    private void DisplayAnswer()
    {
        hintView.setText(currentKana.getRomanji());
        hintView.setVisibility(View.VISIBLE);
    }

    private void HideAnswer()
    {
        hintView.setText("");
        hintView.setVisibility(View.INVISIBLE);
    }
}