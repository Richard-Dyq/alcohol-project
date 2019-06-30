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
public class HomeActivity extends AppCompatActivity{
    private Button logout;
    private Button ecl_button;
    private Button cannanisRecordOrderByDate;
    private Button cannanisRecordOrderByLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        setupUI();
    }

    /**
     * set up the ui
     */

    private void setupUI(){
        setUpCannabiesButton();
        setUpLogoutButton();
        setUpCannabiesRecordOrderByDate();
        setUpCannabiesRecordOrderByLevel();
    }

    /**
     * set up the Cannabies order by date
     */
    private void setUpCannabiesRecordOrderByDate(){
        cannanisRecordOrderByDate = (Button) this.findViewById(R.id.cannais_ordered_by_date);
        cannanisRecordOrderByDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CannabisDateOrderedListActivity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * set up the Cannabies order by Level
     */
    private void setUpCannabiesRecordOrderByLevel(){
        cannanisRecordOrderByLevel = (Button) this.findViewById(R.id.cannais_ordered_by_level);
        cannanisRecordOrderByLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CannabisLevelOrderedListActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * A submitButton "Enter" links to the intake input page (ECL_active)
     */
    private void setUpCannabiesButton(){
        ecl_button = (Button) this.findViewById(R.id.ecl_button);

        ecl_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ECL_Activity.class);
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
                Toast.makeText(HomeActivity.this, "Successfully HomeActivity", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

