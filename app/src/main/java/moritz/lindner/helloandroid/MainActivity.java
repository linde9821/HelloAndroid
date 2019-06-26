package moritz.lindner.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nachricht;
    private Button weiterFertig;
    private EditText eingabe;
    private boolean ersterKlick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nachricht = findViewById(R.id.nachricht);
        weiterFertig = findViewById(R.id.weiter_fertig);
        eingabe = findViewById(R.id.eingabe);

        eingabe.setOnEditorActionListener((v, actionId, event) -> {
            if(weiterFertig.isEnabled())
                weiterFertig.performClick();

            return true;
        });

        nachricht.setText(R.string.wilkommen);
        weiterFertig.setText(R.string.weiter);

        ersterKlick = true;

        weiterFertig.setOnClickListener(v -> {
            if (ersterKlick){
                nachricht.setText(getString(R.string.hallo, eingabe.getText()));
                eingabe.setVisibility(View.INVISIBLE);
                weiterFertig.setText(R.string.fertig);
                ersterKlick = false;
            }else
                finish();
        });
    }
}
