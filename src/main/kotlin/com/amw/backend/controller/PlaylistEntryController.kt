package com.amw.backend.controller
import com.amw.backend.model.PlaylistEntry
import com.amw.backend.repository.PlaylistEntryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/playlistEntry")
@CrossOrigin(origins = arrayOf("http://localhost:4200", "http://192.168.88.120:4200", "http://192.168.88.69:4200"))
class PlaylistEntryController {
    @Autowired
    private val playlistEntryRepository: PlaylistEntryRepository? = null

    @get:GetMapping
    val allPlaylistEntries: List<PlaylistEntry?>
        get() = playlistEntryRepository!!.findAll()

    @PostMapping
    fun createPlaylistEntry(@RequestBody playlistEntry: PlaylistEntry): PlaylistEntry {
        return playlistEntryRepository!!.save(playlistEntry)
    }

    @GetMapping("/{id}")
    fun getPlaylistEntryById(@PathVariable id: String): PlaylistEntry {
        return playlistEntryRepository!!.findById(id).orElse(null)!!
    }

    @PutMapping("/{id}")
    fun updatePlaylistEntry(@PathVariable id: String?, @RequestBody playlistEntry: PlaylistEntry): PlaylistEntry {
        playlistEntry.setId(id)
        return playlistEntryRepository!!.save(playlistEntry)
    }

    @DeleteMapping("/{id}")
    fun deletePlaylistEntry(@PathVariable id: String) {
        playlistEntryRepository!!.deleteById(id)
    }
}