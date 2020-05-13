package alexander.skornyakov.generalapplication.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class ApplicationStorage constructor(private val context: Context) : Storage{

    private val sharedPreferences = context.getSharedPreferences("Preferences", MODE_PRIVATE)

    override fun getString(key: String): String {
        return sharedPreferences.getString(key,"")!!
    }

    override fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key,value).apply()
    }

}