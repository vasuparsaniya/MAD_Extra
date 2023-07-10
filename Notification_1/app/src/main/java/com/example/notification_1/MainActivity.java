package com.example.notification_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "Message";
    private static final int NOTIFICATION_ID = 100;
//    private static final int NOTIFICATION_ID1 = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn;

        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addNotification();
            }
        });
    }

        private void addNotification(){
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.icon, null);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;   //bitmap is store the image
            //in the case of bitmap only use png formate image
            Bitmap largeIcon = bitmapDrawable.getBitmap();      // use image png formate because png, svg image give transparent image. jpg not give transparent image


            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);  //type casting object to Notification manager
            Notification notification; //create object
            //This channel system work on version-8 above
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notification = new Notification.Builder(this)
                        .setLargeIcon(largeIcon)
                        .setSmallIcon(R.drawable.icon)
                        .setContentText("Hello Vasu Parsaniya")
                        .setSubText("New message of vasu")
                        .setChannelId(CHANNEL_ID)
                        .build();      //it is compulsory   //.setContentText() it is show title //.setSubText() it is sub title
                nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH)); //IMPORTANCE_HIGH it is priority that give latest notification first in notification list


            } else {
                notification = new Notification.Builder(this)
                        .setLargeIcon(largeIcon)
                        .setSmallIcon(R.drawable.icon)
                        .setContentText("New Message")
                        .setSubText("New message of Vasu")
                        .build();
            }

            /* message regarding notification we use ID
             * that is multiple notification come from same user then we throw notification through same id and in the notification pannel notification is updated*/

            nm.notify(NOTIFICATION_ID, notification);    //this code is write where we want to notify notification

//        nm.notify(NOTIFICATION_ID1, notification); //for different notification we give different id


            /*Above version-8 of Android it is provide notification channel that deloper build in their app
             * and user disable particular notification channel
             * For Example: user want to diable message notification then user can do.
             * Other notification related app doesnot disable.
             * -->We set channel id. and set that channel in notification manager*/
        }
}
