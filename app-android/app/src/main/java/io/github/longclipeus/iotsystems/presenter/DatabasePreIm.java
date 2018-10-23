package io.github.longclipeus.iotsystems.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabasePreIm implements DatabasePre{

    @Override
    public void getDbFirebase() {
        DatabaseReference dbRefer = FirebaseDatabase.getInstance().getReference();
        dbRefer.child("Temperature").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // tra ve view
                String str = dataSnapshot.getValue() + "";
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // tra ve view
            }
        });

    }
}
