package com.embibe.app.embibetvapp.recommendation;


import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;

import androidx.recommendation.app.ContentRecommendation;

import com.bumptech.glide.Glide;
import com.embibe.app.embibetvapp.R;
import com.embibe.app.embibetvapp.activity.DashBoardActivity;

import java.util.concurrent.ExecutionException;

public class UpdateRecommendationsService extends IntentService {
    private static final String TAG = "RecommendationService";
    private static final int MAX_RECOMMENDATIONS = 3;
    //private static final VideoCursorMapper mVideoCursorMapper = new VideoCursorMapper();

    private NotificationManager mNotifManager;

    public UpdateRecommendationsService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (mNotifManager == null) {
            mNotifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Generate recommendations, but only if recommendations are enabled
  /*      SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!sharedPreferences.getBoolean(getString(R.string.pref_key_recommendations), true)) {
            Log.d(TAG, "Recommendations disabled");
            mNotifManager.cancelAll();
            return;
        }*/
        Resources res = getResources();
        int cardWidth = res.getDimensionPixelSize(R.dimen.card_width);
        int cardHeight = res.getDimensionPixelSize(R.dimen.card_height);
        ContentRecommendation.Builder builder = new ContentRecommendation.Builder()
                .setBadgeIcon(R.drawable.app_icon_your_company);

     /*   Cursor cursor = getContentResolver().query(
                VideoContract.VideoEntry.CONTENT_URI,
                null, // projection
                null, // selection
                null, // selection clause
                "RANDOM() LIMIT " + MAX_RECOMMENDATIONS // sort order
        );*/

/*
        if (cursor != null && cursor.moveToNext()) {
*/
        builder.setIdTag("Video" + "01101")
                .setTitle("Sample")
                .setText("Sample desciption")
                .setContentIntentData(ContentRecommendation.INTENT_TYPE_ACTIVITY,
                        buildPendingIntent(), 0, null);

        Bitmap bitmap = null;
        try {
            bitmap = Glide.with(getApplication())
                    .asBitmap()
                    .load("https://qphs.fs.quoracdn.net/main-thumb-22476875-200-hbvbrkzitektsxeghxxwxxwkmcmvqxaz.jpeg")
                    .submit(cardWidth, cardHeight) // Only use for synchronous .get()
                    .get();
            builder.setContentImage(bitmap);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // Create an object holding all the information used to recommend the content.
        ContentRecommendation rec = builder.build();
        Notification notification = rec.getNotificationObject(getApplicationContext());

        //if (BuildConfig.DEBUG) Log.d(TAG, "Recommending video " + video.title);

        // Recommend the content by publishing the notification.
        mNotifManager.notify(10001, notification);

    }

    private Intent buildPendingIntent() {
        Intent detailsIntent = new Intent(this, DashBoardActivity.class);
        return detailsIntent;
    }
}

