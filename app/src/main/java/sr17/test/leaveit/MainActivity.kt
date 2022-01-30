package sr17.test.leaveit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var unInitializedVariable: String
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLateInItVariables()
        setContentView(R.layout.activity_main)
    }

    private fun callToCrashApp(){
        Log.e("Called", unInitializedVariable)
    }

    private fun loadLateInItVariables(){
        firebaseAnalytics = Firebase.analytics
    }

    private fun logAnalyticsEvents(){
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM){
            param(FirebaseAnalytics.Param.ITEM_ID, "sr17")
            param(FirebaseAnalytics.Param.ITEM_NAME, "first analytics event")
            param(FirebaseAnalytics.Param.CONTENT_TYPE, "nothing")
        }
    }
}