package ru.geekbrains.kotlin_2.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import ru.geekbrains.kotlin_2.data.entity.Note
import java.util.UUID


object NotesRepository {

    private val notesLiveData = MutableLiveData<List<Note>>()

    val notes: MutableList<Note> = mutableListOf(
        Note(
            UUID.randomUUID().toString(),
            "Первая заметка",
            "Текст первой заметки. Не очень длинный, но интересный",
            color = Note.Color.WHITE
        ),
        Note(
            UUID.randomUUID().toString(),
            "Вторая заметка",
            "Текст второй заметки. Не очень длинный, но интересный",
            color = Note.Color.YELLOW
        ),
        Note(
            UUID.randomUUID().toString(),
            "Третья заметка",
            "Текст третьей заметки. Не очень длинный, но интересный",
            color = Note.Color.GREEN
        ),
        Note(
            UUID.randomUUID().toString(),
            "Четвертая заметка",
            "Текст четвертой заметки. Не очень длинный, но интересный",
            color = Note.Color.BLUE
        ),
        Note(
            UUID.randomUUID().toString(),
            "Пятая заметка",
            "Текст пятой заметки. Не очень длинный, но интересный",
            color = Note.Color.RED
        ),
        Note(
            UUID.randomUUID().toString(),
            "Шестая заметка",
            "Текст шестой заметки. Не очень длинный, но интересный",
            color = Note.Color.VIOLET
        )
    )

    init {
        notesLiveData.value = notes
    }

    fun getNotes(): LiveData<List<Note>> {
        return notesLiveData
    }

    fun saveNote(note: Note) {
        addOrReplace(note)
        notesLiveData.value = notes
    }

    private fun addOrReplace(note: Note) {
        for (i in 0 until notes.size) {
            if (notes[i] == note) {
                notes[i] = note
                return
            }
        }
        notes.add(note)
    }
}