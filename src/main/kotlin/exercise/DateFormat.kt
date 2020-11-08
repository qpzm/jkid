package ru.yole.jkid

import ru.yole.jkid.deserialization.JKidException
import java.text.SimpleDateFormat
import java.util.*

@Target(AnnotationTarget.PROPERTY)
annotation class DateFormat(val format: String)

class DateSerializer(format: String) : ValueSerializer<Date> {
    private val simpleDateFormat = SimpleDateFormat(format)

    override fun fromJsonValue(jsonValue: Any?): Date {
        if (jsonValue !is Date) throw JKidException("Expected date, was: $jsonValue")
        return jsonValue
    }

    override fun toJsonValue(value: Date): String = simpleDateFormat.format(value)
}