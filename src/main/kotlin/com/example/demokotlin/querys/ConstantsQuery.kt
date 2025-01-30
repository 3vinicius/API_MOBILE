package com.example.demokotlin.querys

object ConstantsQuery {
    const val buscarMusicas= "SELECT " +
            "    MUSICS.id, " +
            "    MUSICS.title, " +
            "    MUSICS.link, " +
            "    MUSICS.THUMBNAIL, " +
            "    COUNT(L.IDUSER) AS totalLikes, " +
            "    CASE " +
            "        WHEN L.IDUSER IS NOT NULL THEN 1 " +
            "        END AS likedUser " +
            "FROM " +
            "    MUSICS " +
            "        LEFT JOIN " +
            "    LIKEMUSICS L ON MUSICS.ID = L.IDMUSIC AND L.IDUSER = :idUser " +
            "        LEFT JOIN " +
            "    LIKEMUSICS L2 ON MUSICS.ID = L2.IDMUSIC " +
            "GROUP BY " +
            "    MUSICS.id, MUSICS.title, MUSICS.link, MUSICS.THUMBNAIL, l.IDUSER; "




}