# BDapps-Charging

![Jitpack - Version](https://img.shields.io/jitpack/v/github/sharminsayed/BDapps-Charging?color=green)
![PyPI - Status](https://img.shields.io/pypi/status/django)
![APM](https://img.shields.io/apm/l/vim-mode) 

An android subscription library for BDapps.

### How to 



To get a Git project into your build:

Step 1. Add the JitPack repository to your build file 

Add it in your root build.gradle at the end of repositories:

     allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
    
    
Step 2. Add the dependency    

    dependencies {
              implementation 'com.github.sharminsayed:BDapps-Charging:0.1.0'
      }
    
Step 3. Create ChargingInstance.java in your app

    
    public class ChargingInstance {
        private static AdsLib adsLib;
        public static String APP_ID = ""; //BDAPPS APP_ID
        public static String APP_PASSWORD = ""; 
        public static String APP_PATH = ""; //http://appstore.bdappszone.com
        public static String MSG_TEXT = ""; //BDAPPS keyword
        public static String WINDOW_TEXT = ""; //অ্যাড রিমুভ করতে আপনার রবি অথবা এয়ারটেল সিম থেকে "+MSG_TEXT+" লিখে এসএমএস করুন ২১২১৩ নাম্বারে । চার্জ প্রতি দিন ২ টাকা

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
    
 Step 4.How to use ChargingInstance inside your code.
 
 
        //Initialize adslib
        AdsLib adsLib=ChargingInstance.getAdsLib();
        //Checking Subscription Status
        adsLib.checkSubStatus(SP.getSubCode());
        //Subscribe for this application
        adsLib.subscribe();
