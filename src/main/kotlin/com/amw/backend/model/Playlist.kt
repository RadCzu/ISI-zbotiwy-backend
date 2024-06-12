package com.amw.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "playlists")
class Playlist {

    @Id
    private var id: String? = null
    private var title: String? = null
    private var description: String? = null
    private var user_id: String? = null

    public fun setId(id: String?) {
        this.id = id
    }

}