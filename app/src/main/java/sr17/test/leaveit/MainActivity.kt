package sr17.test.leaveit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var unInitializedVariable: String
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callToCrashApp()
        setContentView(R.layout.activity_main)
    }

    private fun loadLateInItVariables() {
        firebaseAnalytics = Firebase.analytics
    }

    private fun callToCrashApp() {
        FirebaseCrashlytics.getInstance().setCustomKey("justForTesting","testing 003")
        Log.e("Called", unInitializedVariable)
    }

    private fun logAnalyticsEvents() {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
            param(FirebaseAnalytics.Param.ITEM_ID, "sr17")
            param(FirebaseAnalytics.Param.ITEM_NAME, "first analytics event")
            param(FirebaseAnalytics.Param.CONTENT_TYPE, "nothing")
        }
    }

    private fun turnOffMobile() {
        finish()
    }
}