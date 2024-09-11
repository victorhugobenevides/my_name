package com.itbenevides.myname.data.repository

interface NameRepository {
    suspend fun getNameData(): String
}