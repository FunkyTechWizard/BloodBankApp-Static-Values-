package com.week3.bloodbankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutusactivity);

        drawerLayout=findViewById(R.id.drawer);

        // Find the TextView in the header layout
        LinearLayout headerLayout = findViewById(R.id.header_layout);
        TextView headerTextView = headerLayout.findViewById(R.id.header_text);

        // Set the text of the TextView to the activity's title
        String title = "About Us";
        headerTextView.setText(title);
        ImageView menuButton = findViewById(R.id.aboutusbutton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(AboutUsActivity.this, v);

                // Inflate the menu resource (e.g. R.menu.popup_menu)
                popupMenu.getMenuInflater().inflate(R.menu.aboutusmenu, popupMenu.getMenu());

                // Set a click listener for the menu items
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.about_us:
                                // Handle "About Us" item click
                                Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
                                startActivity(intent);
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                // Show the PopupMenu
                popupMenu.show();
            }
        });



    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickProfile(View view){
        redirectActivity(this, ProfileActivity.class);
    }
    public void ClickHome(View view){
        redirectActivity(this, HomeActivity.class);    }
    public void ClickDonorScheduling(View view){
        redirectActivity(this, DonorSchedulingActivity.class);
    }
    public void ClickDonorRegistration(View view){
        redirectActivity(this, DonorRegistrationActivity.class);    }
    public void ClickLogout(View view){
        redirectActivity(this, LoginActivity.class);
    }



    public static void redirectActivity(Activity activity,Class Class) {
        Intent intent= new Intent(activity,Class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

    //    public static void logout(Activity activity) {
//        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
//        builder.setTitle("Logout");
//        builder.setMessage("Are you sure you want to logout?");
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                activity.finishAffinity();
//                System.exit(0);
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        builder.show();
//    }
}


