package com.week3.bloodbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        // Initialize views
        mUsernameEditText = findViewById(R.id.usernameEditText);
        mPasswordEditText = findViewById(R.id.passwordEditText);
        mLoginButton = findViewById(R.id.loginButton);

        // Set click listener for login button
        mLoginButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            login();
        }
    }

    private void login() {
        String username = mUsernameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();

        // Check if username and password are correct
        if (username.equals("android") && password.equals("1234")) {
//            // If login is successful, save the username and password in a MongoDB collection and start MainActivity
//            ConnectionString connectionString = new ConnectionString("mongodb+srv://1234:1234@test.lfaizqd.mongodb.net/BloodBankApp?retryWrites=true&w=majority");
//            MongoClientSettings settings = MongoClientSettings.builder()
//                    .applyConnectionString(connectionString)
//                    .build();
//            com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
//            MongoDatabase database = mongoClient.getDatabase("BloodBankApp");
//            MongoCollection<Document> collection = database.getCollection("Users");
//
//            Document document = new Document("username", username)
//                    .append("password", password);
//            collection.insertOne(document);

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            // If login is unsuccessful, display error message
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
