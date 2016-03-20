package com.elite.buylist.ui;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.support.v4.preference.PreferenceFragment;
import android.view.View;
import android.widget.Toast;

import com.elite.buylist.R;

/**
 * Create by wjc133
 * Date: 2015/11/9
 * Time: 14:10
 */
public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
    ListPreference preference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preference = (ListPreference) findPreference("pref_lab_env");
        preference.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Toast.makeText(getActivity(), "设置环境成功", Toast.LENGTH_SHORT).show();
        if (preference.getKey().equals("pref_lab_env")) {
            String value = (String) newValue;
            EnvHelper.setup(value);
            return true;
        }
        return false;
    }
}
