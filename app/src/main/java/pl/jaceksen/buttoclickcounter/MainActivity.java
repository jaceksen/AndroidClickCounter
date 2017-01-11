package pl.jaceksen.buttoclickcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button button;
    private TextView textView;

    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        //czyszczenie pola TextView
        //ustawiamy setText a nie append
        textView.setText("");
        //włączamy scrollbar dla TextView
        //ale i tak musi być dodany verticalscroll in the layout
        textView.setMovementMethod(new ScrollingMovementMethod());

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTimesClicked = numTimesClicked + 1;
                String result = "The button got tapped " + numTimesClicked + " time\n";
                if(numTimesClicked != 1){
                    result += "s";
                }
                textView.append(result);
            }
        };
        button.setOnClickListener(ourOnClickListener);
    }
}

