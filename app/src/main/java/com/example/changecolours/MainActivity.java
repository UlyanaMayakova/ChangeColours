package com.example.changecolours;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static @StyleRes
    int theme = R.style.AppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(theme);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        final TextView text = findViewById(R.id.text);
        Button ok = findViewById(R.id.button);
        final Spinner spinnerColours = findViewById(R.id.spinner_colours);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(
                this, R.array.colours, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColours.setAdapter(adapter1);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String language = spinner.getSelectedItem().toString();
                Locale locale = new Locale("ru");
                String chosenTheme = spinnerColours.getSelectedItem().toString();

                switch (language) {
                    case "Русский":
                        locale = new Locale("ru");
                        break;
                    case "English":
                        locale = new Locale("en");
                        break;
                }

                switch (chosenTheme) {
                    case "Зелёный":
                        theme = R.style.GreenTheme;
                        break;
                    case "Чёрный":
                        theme = R.style.BlackTheme;
                        break;
                    case "Синий":
                        theme = R.style.BlueTheme;
                        break;
                    case "Основная":
                        theme = R.style.AppTheme;
                }

                Configuration configuration = new Configuration();
                configuration.setLocale(locale);
                getResources().updateConfiguration(configuration, getBaseContext().
                        getResources().getDisplayMetrics());
                text.setText(R.string.text);
                recreate();
            }
        });
    }
}