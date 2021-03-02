package com.wisanti_18102072.praktikum10.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Quote(
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var category: String? = null,
    var date: String? = null
    //var medsos: String? = null,
    //var number: String? = null
) : Parcelable

