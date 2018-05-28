package anurag145.github.com.mycheckin20;

import com.facebook.network.connectionclass.ConnectionClassManager;
import com.facebook.network.connectionclass.ConnectionQuality;

public class ConnectionChangedListener
        implements ConnectionClassManager.ConnectionClassStateChangeListener {
    ConnectionQuality mConnectionClass = ConnectionQuality.UNKNOWN;


    @Override
    public void onBandwidthStateChange(ConnectionQuality bandwidthState) {
        mConnectionClass = bandwidthState;

    }


}