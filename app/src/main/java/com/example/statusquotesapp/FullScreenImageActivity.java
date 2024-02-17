package com.example.statusquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullScreenImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        ImageView fullScreenImageView = findViewById(R.id.fullScreenImageView);

        // Get the image URL from the intent
        String imageUrl = getIntent().getStringExtra("image_url");

        // Load the image into a full-screen ImageView using Glide or your preferred library
        Glide.with(this)
                .load(imageUrl)
                .into(fullScreenImageView);

        // Example: Download the image when a download button is clicked
        Button downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse(imageUrl);

                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "image.jpg");

                    downloadManager.enqueue(request);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Log the exception
                    Log.e("DownloadError", "Error during download: " + e.getMessage());
                }
            }
        });
    }
}
