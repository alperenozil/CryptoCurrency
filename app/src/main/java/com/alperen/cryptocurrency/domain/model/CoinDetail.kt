package com.alperen.cryptocurrency.domain.model

import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.Tag
import com.alperen.cryptocurrency.data.remote.dto.coin_details_dto.TeamMember

data class CoinDetail(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val description: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>
)