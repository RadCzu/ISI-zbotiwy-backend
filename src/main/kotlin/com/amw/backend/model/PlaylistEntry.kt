package com.amw.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "playlistentries")
class PlaylistEntry {
    @Id
    private var id: String? = null
    private var playlist_id: String? = null
    private var sound_id: String? = null

    fun setId(id: String?) {
        this.id = id
    }
}