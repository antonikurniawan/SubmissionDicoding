package com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieResponse(
		var id: String,
		var title: String,
		var overview: String,
		var poster_path: String,
): Parcelable
