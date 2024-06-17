-keep class bitter.jnibridge.* { *; }
-keep class com.unity3d.player.* { *; }
-keep interface com.unity3d.player.IUnityPlayerLifecycleEvents { *; }
-keep class org.fmod.* { *; }
-keep class com.google.androidgamesdk.ChoreographerCallback { *; }
-keep class com.google.androidgamesdk.SwappyDisplayManager { *; }
-ignorewarnings

# don't warn if playcore plugin wasn't added to project
-dontwarn com.google.android.play.core.assetpacks.AssetPackLocation
-dontwarn com.google.android.play.core.assetpacks.AssetPackManager
-dontwarn com.google.android.play.core.assetpacks.AssetPackManagerFactory
-dontwarn com.google.android.play.core.assetpacks.AssetPackState
-dontwarn com.google.android.play.core.assetpacks.AssetPackStateUpdateListener
-dontwarn com.google.android.play.core.assetpacks.AssetPackStates
-dontwarn com.google.android.play.core.tasks.OnCompleteListener
-dontwarn com.google.android.play.core.tasks.OnSuccessListener
-dontwarn com.google.android.play.core.tasks.RuntimeExecutionException
-dontwarn com.google.android.play.core.tasks.Task
