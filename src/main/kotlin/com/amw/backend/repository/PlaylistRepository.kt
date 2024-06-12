package com.amw.backend.repository

import com.amw.backend.model.Playlist
import org.springframework.data.mongodb.repository.MongoRepository

interface PlaylistRepository : MongoRepository<Playlist?, String?>