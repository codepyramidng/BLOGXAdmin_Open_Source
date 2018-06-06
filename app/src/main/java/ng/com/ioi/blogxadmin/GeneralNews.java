package ng.com.ioi.blogxadmin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class GeneralNews extends AppCompatActivity {

    EditText newsTitle, newsContent;

    FirebaseFirestore newsDB = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_news);

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        newsDB.setFirestoreSettings(settings);

    }

    public void PostNews(View view) {

        newsTitle = findViewById(R.id.newsTitle);
        final String news_title = newsTitle.getText().toString().trim();
        newsContent = findViewById(R.id.newsContent);
        final String news_content = newsContent.getText().toString().trim();

        if (!TextUtils.isEmpty(news_title) && !TextUtils.isEmpty(news_content)) {

            Map<String, Object> newPost = new HashMap<>();

            newPost.put("NewsTitle", news_title);
            newPost.put("NewsContent", news_content);
            newPost.put("PostTime", FieldValue.serverTimestamp());

            newsDB.collection("NewsDB")
                    .add(newPost)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(GeneralNews.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
