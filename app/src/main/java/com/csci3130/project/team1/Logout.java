package com.csci3130.project.team1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**This class can let the user logout
  * @Yuqiao Du, Longhao Gao
  */
public class Logout extends AppCompatActivity{
    private Button logout;
    Button ecl_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        setupUI();
    }


    private void setupUI(){
        setUpCannabiesButton();
        setUpLogoutButton();
    }

    /**
     * A submitButton "Enter" links to the intake input page (ECL_active)
     */
    private void setUpCannabiesButton(){
        ecl_button = (Button) this.findViewById(R.id.ecl_button);

        ecl_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(Logout.this, ECL_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpLogoutButton(){
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            //logout and send a message if logout successfully
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Toast.makeText(Logout.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

