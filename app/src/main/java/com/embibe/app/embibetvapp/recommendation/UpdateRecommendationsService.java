package com.embibe.app.embibetvapp.recommendation;

/*
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.recommendation.app.ContentRecommendation;

import com.bumptech.glide.Glide;
import com.embibe.app.embibetvapp.R;

import java.util.concurrent.ExecutionException;

class UpdateRecommendationsService extends IntentService {
    private static final String TAG = "RecommendationService";
    private static final int MAX_RECOMMENDATIONS = 3;
    private static final VideoCursorMapper mVideoCursorMapper = new VideoCursorMapper();

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
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!sharedPreferences.getBoolean(getString(R.string.pref_key_recommendations), true)) {
            Log.d(TAG, "Recommendations disabled");
            mNotifManager.cancelAll();
            return;
        }
        Resources res = getResources();
        int cardWidth = res.getDimensionPixelSize(R.dimen.card_width);
        int cardHeight = res.getDimensionPixelSize(R.dimen.card_height);
        ContentRecommendation.Builder builder = new ContentRecommendation.Builder()
                .setBadgeIcon(R.drawable.videos_by_google_icon);

        Cursor cursor = getContentResolver().query(
                VideoContract.VideoEntry.CONTENT_URI,
                null, // projection
                null, // selection
                null, // selection clause
                "RANDOM() LIMIT " + MAX_RECOMMENDATIONS // sort order
        );

        if (cursor != null && cursor.moveToNext()) {
            try {
                do {
                    Video video = (Video) mVideoCursorMapper.convert(cursor);
                    int id = Long.valueOf(video.id).hashCode();

                    builder.setIdTag("Video" + id)
                            .setTitle(video.title)
                            .setText(getString(R.string.popular_header))
                            .setContentIntentData(ContentRecommendation.INTENT_TYPE_ACTIVITY,
                                    buildPendingIntent(video, id), 0, null);

                    Bitmap bitmap = Glide.with(getApplication())
                            .asBitmap()
                            .load(video.cardImageUrl)
                            .submit(cardWidth, cardHeight) // Only use for synchronous .get()
                            .get();
                    builder.setContentImage(bitmap);

                    // Create an object holding all the information used to recommend the content.
                    ContentRecommendation rec = builder.build();
                    Notification notification = rec.getNotificationObject(getApplicationContext());

                    if (BuildConfig.DEBUG) Log.d(TAG, "Recommending video " + video.title);

                    // Recommend the content by publishing the notification.
                    mNotifManager.notify(id, notification);
                } while (cursor.moveToNext());
            } catch (InterruptedException | ExecutionException e) {
                Log.e(TAG, "Could not create recommendation.", e);
            } finally {
                cursor.close();
            }
        }
    }

    private Intent buildPendingIntent(Video video, int id) {
        Intent detailsIntent = new Intent(this, VideoDetailsActivity.class);
        detailsIntent.putExtra(VideoDetailsActivity.VIDEO, video);
        detailsIntent.putExtra(VideoDetailsActivity.NOTIFICATION_ID, id);
        detailsIntent.setAction(Long.toString(video.id));

        return detailsIntent;
    }
}
*/
