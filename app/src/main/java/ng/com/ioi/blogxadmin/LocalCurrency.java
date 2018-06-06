package ng.com.ioi.blogxadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class LocalCurrency extends AppCompatActivity {

    private DocumentReference dollarDB = FirebaseFirestore.getInstance().document("CurrencyDB/DollarValue");
    private DocumentReference nairaDB = FirebaseFirestore.getInstance().document("CurrencyDB/NairaValue");

    EditText dollarChange, nairaChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_currency);
    }

    public void UpdateDollar(View view) {

        dollarChange = findViewById(R.id.dollarChange);
        String dollarValue = dollarChange.getText().toString().trim();

        if (!TextUtils.isEmpty(dollarValue)) {

            Map<String, Object> postUpdate = new HashMap<>();
            postUpdate.put("DollarValue", "$"+dollarValue);

            dollarDB.set(postUpdate).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(LocalCurrency.this, "Update", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void UpdateNaira(View view) {

        nairaChange = findViewById(R.id.nairaChange);
        String nairaValue = nairaChange.getText().toString().trim();

        if (!TextUtils.isEmpty(nairaValue)) {

            Map<String, Object> postUpdate = new HashMap<>();
            postUpdate.put("NairaValue", "₦"+nairaValue);

            nairaDB.set(postUpdate).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(LocalCurrency.this, "Update", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
