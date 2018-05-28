package anurag145.github.com.mycheckin20;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.network.connectionclass.ConnectionClassManager;
import com.facebook.network.connectionclass.ConnectionQuality;
import com.facebook.network.connectionclass.DeviceBandwidthSampler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ValueEventListener valueEventListener;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
       myRef = database.getReference("message");
        textView= findViewById(R.id.main);
        myRef.setValue("message", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {


                if(databaseError==null) {
                    textView.setText("Success");
                    myRef.addValueEventListener(valueEventListener);
                }
                else
                  textView.setText(databaseError.toString());
            }
        });
       valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                textView.setText(textView.getText()+"\n"+"in listener");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

      //  connectionQuality= ConnectionClassManager.getInstance().getCurrentBandwidthQuality();


    }



}
