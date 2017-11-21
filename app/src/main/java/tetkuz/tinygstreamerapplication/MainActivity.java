package tetkuz.tinygstreamerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.freedesktop.gstreamer.GStreamer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            GStreamer.init(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.label)).setText(String.format("Welcome %s !", nativeGetGStreamerInfo()));
    }

    static {
        System.loadLibrary("gstreamer_android");
        System.loadLibrary("media_pipeline");
    }

    native final String nativeGetGStreamerInfo();
}
