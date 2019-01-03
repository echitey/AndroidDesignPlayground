package com.echitey.designcheatsheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.echitey.designcheatsheet.model.Player;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class XmlParsing extends AppCompatActivity {

    private TextView txtView;
    private Toolbar toolbar;
    String TAG = "XMLXML";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parsing);

        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);

        txtView = findViewById(R.id.textView);

        parseXML();
    }

    private void parseXML() {

        Log.v(TAG, "Parse XML method entered");

        XmlPullParserFactory parserFactory;

        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("data.xml");
            Log.v(TAG, "data.xml Input Stream");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);

        }catch (XmlPullParserException e){

        }catch (IOException e){

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {

        Log.v(TAG, "Processing parser");

        ArrayList<Player> players = new ArrayList<>();

        int eventType = parser.getEventType();

        Player player = null;

        Log.v(TAG, "Entering While");

        while(eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    Log.v(TAG, "Getting "+ eltName);

                    if("player".equals(eltName)){
                        player = new Player();
                        players.add(player);
                    }else if(player != null) {
                        if("name".equals(eltName)) {
                            player.name = parser.nextText();
                        } else if("age".equals(eltName)) {
                            player.age = parser.nextText();
                        } else if("position".equals(eltName)) {
                            player.position = parser.nextText();
                        }
                    }
                    break;
            }

            eventType = parser.next();
        }

        printPlayers(players);

    }

    private void printPlayers(ArrayList<Player> players) {

        StringBuilder builder = new StringBuilder();

        for(Player player : players){
            builder.append(player.name).append("\n")
                    .append(player.age).append("\n")
                    .append(player.position).append("\n\n");
        }

        txtView.setText(builder.toString());
    }
}
