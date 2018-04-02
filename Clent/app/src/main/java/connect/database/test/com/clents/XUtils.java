package connect.database.test.com.clents;

import android.app.Application;

import org.xutils.x;

/**
 * Init Android Application
 * Created by wangj on 4/2/2018.
 */

public class XUtils extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        x.Ext.init(this);
    }
}
