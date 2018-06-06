package ng.com.ioi.blogxadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GeneralNews(View view) {
        startActivity(new Intent(this, GeneralNews.class));
    }

    public void CryptoCurrency(View view) {
        startActivity(new Intent(this, CryptoCurrency.class));
    }

    public void LocalCurrency(View view) {
        startActivity(new Intent(this, LocalCurrency.class));
    }
}
