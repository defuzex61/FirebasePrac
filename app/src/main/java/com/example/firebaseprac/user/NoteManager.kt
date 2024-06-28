package com.example.firebaseprac.user

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class NoteManager {
    var checkUser = MutableLiveData<String>()
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var notesRef: CollectionReference = db.collection("notes")

    fun saveNote(userId: String,note: String){

        var newNote: NoteFirebase = NoteFirebase(userId,note)
        notesRef.id
        notesRef.add(newNote)
            .addOnSuccessListener {
                checkUser.value = "Успех"
            }
            .addOnFailureListener {
                checkUser.value = "Не успех"
            }
    }
}