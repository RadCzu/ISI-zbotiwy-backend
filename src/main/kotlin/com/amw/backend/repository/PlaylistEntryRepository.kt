package com.amw.backend.repository

import com.amw.backend.model.PlaylistEntry

import org.springframework.data.mongodb.repository.MongoRepository

interface PlaylistEntryRepository : MongoRepository<PlaylistEntry?, String?>