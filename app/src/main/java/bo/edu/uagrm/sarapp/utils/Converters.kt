package bo.edu.uagrm.sarapp.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.DecimalFormat
import java.util.*





class Converters {
    val gson: Gson = Gson()

    @TypeConverter
    fun stringToMutableList(data: String?): MutableList<String> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<MutableList<String>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun MutableListToString(someObjects: MutableList<String>): String {
        return gson.toJson(someObjects)
    }

    companion object {
        fun roundTwoDecimals(d: Double): Double {
            val twoDForm = DecimalFormat("#.##")
            return java.lang.Double.valueOf(twoDForm.format(d))
        }
    }
}