package alexander.skornyakov.generalapplication.data

interface Storage {
    fun getString(key: String):String
    fun putString(key: String, value: String)
}