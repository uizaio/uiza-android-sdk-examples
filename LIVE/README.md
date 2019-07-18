# uiza-android-sdk-examples
uiza-android-sdk-examples

First, you need edit config in file app/src/main/java/com/tungtt/sdk5/App.java

# public class App extends MultiDexApplication {
#    public static final String DF_DoMain_Api = "ap-southeast-1-api.uiza.co";
#    public static final String DF_TOKEN = "YOUR_TOKEN_API";
#   public static final String DF_AppId = "YOUR_APP_ID";
#    public static String entityIdDefaultLIVE_TRANSCODE = "YOUR_ENTITY_TRANSCODE";
#
#    @Override
#    public void onCreate() {
#        super.onCreate();
#        Constants.setDebugMode(false);
#        UZUtil.initWorkspace(this,4, DF_DoMain_Api, DF_TOKEN, DF_AppId);
#    }
# }

Second, register account follow the instructions: https://help.uiza.io/en/articles/2964404-register-account

Next, Login dashboard https://help.uiza.io/en/articles/2997622-login-to-admin-dashboard and generate "YOUR_TOKEN_API" https://docs.uiza.io/v4/#get-api-key.

Third, Coppy "YOUR_APP_ID" follow https://help.uiza.io/en/articles/2997625-organization-application-id-appid.

Now, we have "Token_APi" and AppId to edit in config livestream.

The last, we need create new event live stream to get "YOUR_ENTITY_TRANSCODE": https://help.uiza.io/en/articles/2998352-create-a-live-event-push-mode . Remember event must config is Live Push. 

On Url you can take entity_id your live stream. Example URl is: https://dashboard.uiza.io/appId/cabf011d622a474aa3a64187d7eff1b7/live-streaming/event/detail/7e471e36-4a07-41b5-8202-eee26ada3d64, "YOUR_ENTITY_TRANSCODE" live stream will be 7e471e36-4a07-41b5-8202-eee26ada3d64. 