package com.sharmin.bdapps;

import com.sharmin.charging.AdsLib;
import com.sharmin.charging.bdapps.Robi;

public class ChargingInstance {
    private static AdsLib adsLib;
    private static String APP_ID = "";
    private static String APP_PASSWORD = "";
    private static String APP_PATH = "";
    private static String MSG_TEXT = "";
    private static String WINDOW_TEXT = "";

    public static synchronized AdsLib getAdsLib() {
        if (adsLib == null) {
            Robi robi= new Robi();
            robi.setAPP_ID(APP_ID);
            robi.setAPP_PASSWORD(APP_PASSWORD);
            robi.setAPP_PATH(APP_PATH);
            robi.setMSG_TEXT(MSG_TEXT);
            robi.setWINDOW_TEXT(WINDOW_TEXT);
            return new AdsLib(robi);
        }
        return adsLib;
    }
}
