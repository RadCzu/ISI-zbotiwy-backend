package com.amw.backend.controller

import com.amw.backend.model.SoundPiece
import com.amw.backend.repository.SoundPieceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/soundpieces")
@CrossOrigin(origins = arrayOf("http://localhost:4200", "http://192.168.88.120:4200", "http://192.168.88.69:4200"))
class SoundPieceController {
    @Autowired
    private val soundPieceRepository: SoundPieceRepository? = null

    @get:GetMapping
    val allSoundPieces: List<SoundPiece?>
        get() = soundPieceRepository!!.findAll()

    @PostMapping
    fun createSoundPiece(@RequestBody soundPiece: SoundPiece): SoundPiece {
        return soundPieceRepository!!.save(soundPiece)
    }

    @GetMapping("/{id}")
    fun getSoundPieceById(@PathVariable id: String): SoundPiece {
        return soundPieceRepository!!.findById(id).orElse(null)!!
    }

    @PutMapping("/{id}")
    fun updateSoundPiece(@PathVariable id: String?, @RequestBody soundPiece: SoundPiece): SoundPiece {
        soundPiece.setId(id)
        return soundPieceRepository!!.save(soundPiece)
    }

    @DeleteMapping("/{id}")
    fun deleteSoundPiece(@PathVariable id: String) {
        soundPieceRepository!!.deleteById(id)
    }
}