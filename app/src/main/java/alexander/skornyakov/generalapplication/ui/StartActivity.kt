package alexander.skornyakov.generalapplication.ui

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.data.ApplicationStorage
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import alexander.skornyakov.generalapplication.ui.start.StartFragment
import android.content.Intent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, StartFragment.newInstance())
                .commitNow()
        }
    }


}
