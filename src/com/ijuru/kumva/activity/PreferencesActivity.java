package com.ijuru.kumva.activity;

import com.ijuru.kumva.R;
import com.ijuru.kumva.util.Utils;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.widget.Toast;

/**
 * Preferences activity screen
 */
public class PreferencesActivity extends PreferenceActivity implements OnPreferenceChangeListener {

	private EditTextPreference maxResultsPref;
	
	/**
	 * Valid range for maximum results preference
	 */
	private final int MIN_MAX_RESULTS = 1;
	private final int MAX_MAX_RESULTS = 100;
	
	/**
	 * @see android.preference.PreferenceActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		
		maxResultsPref = (EditTextPreference)getPreferenceScreen().findPreference("max_results");
		maxResultsPref.setOnPreferenceChangeListener(this);
		maxResultsPref.setSummary(maxResultsPref.getText());
	}

	@Override
	public boolean onPreferenceChange(Preference pref, Object value) {
		if (maxResultsPref == pref) {
			Integer max = Utils.parseInteger(value.toString());
			if (max == null || max < MIN_MAX_RESULTS || max > MAX_MAX_RESULTS) {
				String message = String.format(getString(R.string.err_numberrange), MIN_MAX_RESULTS, MAX_MAX_RESULTS);
				Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		
		pref.setSummary(value.toString());
		return true;
	}
}
