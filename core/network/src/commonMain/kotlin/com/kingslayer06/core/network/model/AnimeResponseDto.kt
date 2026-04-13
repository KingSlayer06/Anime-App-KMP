package com.kingslayer06.core.network.model

import com.kingslayer06.core.network.model.shared.GenreDto
import com.kingslayer06.core.network.model.shared.ImagesDto
import com.kingslayer06.core.network.model.shared.PaginationDto
import com.kingslayer06.core.network.model.shared.StudioDto
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

// ─────────────────────────────────────────────
// HOME / SEARCH / TOP / SEASONAL
// Endpoint: GET /top/anime
//           GET /seasons/now
//           GET /seasons/upcoming
//           GET /seasons/{year}/{season}
//           GET /anime?q=...
// ─────────────────────────────────────────────

@Serializable
data class AnimeResponseDto(
    @SerialName("pagination") val pagination: PaginationDto?,
    @SerialName("data") val data: List<AnimeDto>
)

@Serializable
data class AnimeDto(
    @SerialName("mal_id") val malId: Int,
    @SerialName("title") val title: String,
    @SerialName("title_english") val titleEnglish: String?,     // null if no english title
    @SerialName("images") val images: ImagesDto?,
    @SerialName("type") val type: String?,                      // TV, Movie, OVA, ONA, Special
    @SerialName("episodes") val episodes: Int?,                 // null if still airing
    @SerialName("status") val status: String?,                  // "Airing", "Finished Airing", "Not yet aired"
    @SerialName("score") val score: Double?,                    // null if not enough votes
    @SerialName("rank") val rank: Int?,                         // null if unranked
    @SerialName("synopsis") val synopsis: String?,              // null on incomplete entries
    @SerialName("season") val season: String?,                  // null for movies / older anime
    @SerialName("year") val year: Int?,                         // null for older anime
    @SerialName("genres") val genres: List<GenreDto>?,
    @SerialName("studios") val studios: List<StudioDto>?
)