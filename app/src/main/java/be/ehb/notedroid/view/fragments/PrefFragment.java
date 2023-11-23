package be.ehb.notedroid.view.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import be.ehb.notedroid.R;

public class PrefFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
