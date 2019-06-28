/**
 * Authors: James He, Zixuan Liu
 */
package com.csci3130.project.team1;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


public class LoginActivity extends AppCompatActivity {

    //attributes for connecting view and activity
    FirebaseFirestore database;
    Button loginButton;
    EditText emailEdit;
    EditText passWdEdit;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    /**
     *
     * @param user Firebase Autu user, passed by after login successful
     */
    public void updateUI(FirebaseUser user){
        if (user == null)
            return;
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        //assign reference
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        loginButton = findViewById(R.id.cirLoginButton);
        emailEdit = findViewById(R.id.editTextEmail);
        passWdEdit = findViewById(R.id.editTextPassword);
        database = FirebaseFirestore.getInstance();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email=emailEdit.getText().toString();
                String passWd=passWdEdit.getText().toString();
                if(!isUserNameAndPasswordValid(email, passWd)){
                    Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }else {
                    login(email, passWd);
                }
            }
        });
    }

    /**
     * Check if user name and password are valid
     * @param email
     * @param passWd
     * @return
     */
    public boolean isUserNameAndPasswordValid(String email, String passWd){
        return email.contains("@") && passWd.length()>2;
    }

    /**
     * Login in with email and password.
     * @param email
     * @param password
     */
    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}
