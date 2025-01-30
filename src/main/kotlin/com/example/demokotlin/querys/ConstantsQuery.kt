package com.example.demokotlin.querys

object ConstantsQuery {
    const val searchMusicasAndTotalLikes= "SELECT " +
            "    MUSICS.id, " +
            "    MUSICS.title, " +
            "    MUSICS.link, " +
            "    MUSICS.THUMBNAIL, " +
            "    COUNT(L.IDUSER) AS totalLikes, " +
            "    0 as likedUser " +
            "FROM " +
            "    MUSICS " +
            "        LEFT JOIN " +
            "    LIKEMUSICS L ON MUSICS.ID = L.IDMUSIC " +
            "GROUP BY " +
            "    MUSICS.id " +
            "ORDER BY MUSICS.ID;"

    const val searchLikedsByUser = "SELECT " +
            "    * " +
            "FROM " +
            "    likemusics " +
            "where IDUSER = :idUser;"
}