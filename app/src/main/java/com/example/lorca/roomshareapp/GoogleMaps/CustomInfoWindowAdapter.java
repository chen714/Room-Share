package com.example.lorca.roomshareapp.GoogleMaps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lorca.roomshareapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.w3c.dom.Text;

/**
 * Created by Lorca on 22/04/2018.
 */

/*************************************************
 * Title: Location Autosuggestions TextView - [Android Google Maps Course]
 * Author: CodingWithMitch
 * Date: Oct 11 2017
 * Code version: 6.0
 * Availability: Yhttps://www.youtube.com/watch?v=6Trdd9EnmqY&list=PLgCYzUzKIBE-vInwQhGSdnbyJ62nixHCt&index=8
 *************************************************/

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context context){
        mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    //Setting the data being pulled to the view
    private void renderWindowText(Marker marker, View view){
        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);

        if(!title.equals("")){
            tvTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView tvSnippet = (TextView) view.findViewById(R.id.snippet);

        if(!snippet.equals("")){
            tvSnippet.setText(snippet);
        }

    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }
}
