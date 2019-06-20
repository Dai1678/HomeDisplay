package com.dai1678.homedisplay.entity

import com.squareup.moshi.Json

data class RemoResponse (
    val name: String,
    val id: String,
    val created_at: String,
    val updated_at: String,
    val mac_address: String,
    val serial_number: String,
    val firmware_version: String,
    val temperature_offset: Int,
    val humidity_offset: Int,
    val users: List<User>,
    val newest_events: Event
)

data class User (
    val id: String,
    val nickname: String,
    val superuser: Boolean
)

data class Event (
    val hu: Hu,
    val il: Il,
    val te: Te
)

// 湿度
data class Hu (
    @Json(name = "val")
    val value: Int,
    val created_at: String
)

// 照度
data class Il (
    @Json(name = "val")
    val value: Int,
    val created_at: String
)

// 温度
data class Te (
    @Json(name = "val")
    val value: Float,
    val created_at: String
)
