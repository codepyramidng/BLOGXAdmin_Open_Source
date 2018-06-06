package ng.com.ioi.blogxadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;

public class CryptoCurrency extends AppCompatActivity {

    private DocumentReference bitcoinDB = FirebaseFirestore.getInstance().document("CurrencyDB/BitcoinValue");
    private DocumentReference litecoinDB = FirebaseFirestore.getInstance().document("CurrencyDB/LitecoinValue");
    private DocumentReference ethereumDB = FirebaseFirestore.getInstance().document("CurrencyDB/EthereumValue");

    EditText bitCoin, litecoin, ethereum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_currency);

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        bitcoinDB.set(settings);
    }

    public void bitcoinUpdate(View view) {

        bitCoin = findViewById(R.id.bitcoin);
        String bitcoinValue = bitCoin.getText().toString().trim();

        if (!TextUtils.isEmpty(bitcoinValue)) {

            Map<String, Object> postUpdate = new HashMap<>();
            postUpdate.put("BitcoinValue", "$"+bitcoinValue);

            bitcoinDB.set(postUpdate).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(CryptoCurrency.this, "Update", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void litecoinUpdate(View view) {

        litecoin = findViewById(R.id.litecoin);
        String litecoinValue = litecoin.getText().toString().trim();

        if (!TextUtils.isEmpty(litecoinValue)) {

            Map<String, Object> postUpdate = new HashMap<>();
            postUpdate.put("LitecoinValue", "$"+litecoinValue);

            litecoinDB.set(postUpdate).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(CryptoCurrency.this, "Update", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void ethereumUpdate(View view) {

        ethereum = findViewById(R.id.ethereum);
        String ethereumValue = ethereum.getText().toString().trim();

        if (!TextUtils.isEmpty(ethereumValue)) {

            Map<String, Object> postUpdate = new HashMap<>();
            postUpdate.put("EthereumValue", "$"+ethereumValue);

            ethereumDB.set(postUpdate).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(CryptoCurrency.this, "Update", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}