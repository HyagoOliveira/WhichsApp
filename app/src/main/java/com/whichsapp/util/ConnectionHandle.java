package com.whichsapp.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.whichsapp.activities.MainActivity;

/**
 * Created by hyago on 04/07/15.
 */
public class ConnectionHandle {
    private static ConnectionHandle instance;
    private final String TAG = "DEFAULT_TAG";
    private RequestQueue queue;
    private ProgressDialog pDialog;

    public static ConnectionHandle getInstance() {
        return instance;
    }

    public static void initConnectionHandle(Context c){
        if (instance == null)
            instance = new ConnectionHandle();

        instance.queue = Volley.newRequestQueue(c);
        instance.pDialog = new ProgressDialog(c);
        instance.pDialog.setCancelable(false);
        instance.pDialog.setTitle("Aguarde...");
    }

    private ConnectionHandle() {

    }

    public void makeStringConnection(final TextView mTextView){
        pDialog.show();

//        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLS.SERVER,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        pDialog.dismiss();
//                        // Display the first 500 characters of the response string.
//                        mTextView.setText("Response is: " + response.substring(0, 500));
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                pDialog.dismiss();
//                mTextView.setText("That didn't work!");
//            }
//        });
//
//        stringRequest.setTag(TAG);
//        queue.add(stringRequest);
    }

    public void dismiss(){
        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }
}
