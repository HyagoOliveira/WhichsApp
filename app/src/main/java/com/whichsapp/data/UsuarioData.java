package com.whichsapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.whichsapp.R;

import java.util.ArrayList;

/**
 * Created by hyago on 04/07/15.
 */
public class UsuarioData extends PortalData {
    private String username;
    private ArrayList<ContatoData> contatos;

    public UsuarioData(Context context) {
        super(context);
        loadPreferenceData();
        loadContatos();
    }

    private void loadContatos() {
        contatos = new ArrayList<>();

    }

    private void loadPreferenceData() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        username = sharedPref.getString(context.getString(R.string.pref_saved_username), null);
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<ContatoData> getContatos() {
        return contatos;
    }

    public boolean isDataLoaded() {
        return username != null;
    }
}
