package com.roberto.manfreda.live.chat.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.roberto.manfreda.live.chat.R;
import com.roberto.manfreda.live.chat.views.MainView;

import org.java_websocket.WebSocket;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class MainActivity extends AppCompatActivity {
    protected static final String TAG = MainActivity.class.getSimpleName();

    private static final String URI = "ws://ip:port/user-endpoint/websocket";
    private StompClient stompClient = null;

    private int room = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        connectToWebSocket();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (stompClient.isConnected()) {
            stompClient.disconnect();
        }
    }

    private void connectToWebSocket() {
        stompClient = Stomp.over(WebSocket.class, URI);
        subscribeToTopic();
        stompClient.connect();
    }

    private void subscribeToTopic() {
        stompClient.topic("/topic/" + room).subscribe(topicMessage ->
                Log.d(TAG, topicMessage.getPayload())
        );
    }


    public void sendMessage() {

        /*Object to send*/

        Gson gson = new Gson();
        String json = gson.toJson(/*Sending Object*/"test");

        stompClient.send("/app/chat-mapping/" + room, json).subscribe();
    }

    public MainView getMainView() {
        return (MainView) this.getSupportFragmentManager().findFragmentById(R.id.mainView);
    }
}
