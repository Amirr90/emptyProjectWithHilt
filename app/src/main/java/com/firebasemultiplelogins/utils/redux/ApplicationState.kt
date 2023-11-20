package com.firebasemultiplelogins.utils.redux


import android.net.Uri

data class ApplicationState(
    val favouriteProductIds: Set<Int> = emptySet(),
    val showDescriptionIds: Set<Int> = emptySet(),
    val cartProductIds: Set<Int> = emptySet(),
    val customerIds: Set<String> = emptySet(),
    val cartQuantitiesMap: Map<Int, Int> = emptyMap(),
    val showLoader: Boolean = false,
    val ledgerBalance: Long? = 0,


    val filterSort: Int = 0,
    val filterReminderDate: Set<Int> = emptySet(),
    val imageUri: Set<Uri> = emptySet()

)
