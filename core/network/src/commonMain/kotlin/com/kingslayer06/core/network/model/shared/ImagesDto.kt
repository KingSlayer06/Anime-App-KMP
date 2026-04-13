package com.kingslayer06.core.network.model.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesDto(
    @SerialName("jpg") val jpg: ImageDto?,
)

@Serializable
data class ImageDto(
    @SerialName("image_url") val imageUrl: String?,
    @SerialName("large_image_url") val largeImageUrl: String?
)