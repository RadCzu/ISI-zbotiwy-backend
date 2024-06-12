package com.amw.backend.repository

import com.amw.backend.model.SoundPiece
import org.springframework.data.mongodb.repository.MongoRepository

interface SoundPieceRepository : MongoRepository<SoundPiece?, String?>