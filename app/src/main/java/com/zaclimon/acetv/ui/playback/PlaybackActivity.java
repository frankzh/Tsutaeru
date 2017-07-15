package com.zaclimon.acetv.ui.playback;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.zaclimon.acetv.R;
import com.zaclimon.acetv.util.ActivityUtil;

/**
 * Activity responsible of playing a given {@link com.zaclimon.acetv.data.AvContent}
 *
 * @author zaclimon
 * Creation date: 02/07/17
 */

public class PlaybackActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ActivityUtil.isTvMode(this)) {
            setTheme(R.style.TvTheme);
        }

        setContentView(R.layout.activity_playback);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment playbackFragment = new PlaybackFragment();
        Bundle arguments = getIntent().getExtras();
        playbackFragment.setArguments(arguments);
        fragmentTransaction.add(R.id.activity_playback_fragment, playbackFragment);

        fragmentTransaction.commit();

    }
}