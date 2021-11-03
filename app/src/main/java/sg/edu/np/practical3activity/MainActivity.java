package sg.edu.np.practical3activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Create Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Create Activity");

        User user = new User();
        TextView name = findViewById(R.id.textView3);
        TextView desc = findViewById(R.id.textView);
        name.setText("MAD");
        Button followed = findViewById(R.id.button);
        Button msg = findViewById(R.id.button2);

        Intent added = getIntent();
        String add = added.getStringExtra("addInt");
        name.setText(name.getText() + " " + add);
        followed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean follow = !user.isFollowed();
                if (follow){
                    followed.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", '0').show();
                }
                else{
                    followed.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", '0').show();
                }
                user.setFollowed(follow);

                System.out.println(follow);
            }
        });
    }
}