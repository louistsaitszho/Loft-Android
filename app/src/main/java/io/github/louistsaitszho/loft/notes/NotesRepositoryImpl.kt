/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.louistsaitszho.loft.notes

import android.arch.paging.PagedList
import io.github.louistsaitszho.loft.api.LoftApi
import io.github.louistsaitszho.loft.common.model.Note

class NotesRepositoryImpl(val api: LoftApi) : NotesRepository {
    override suspend fun getNotesTemp(): List<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun createNote(content: String): Note {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNotesInPages(): PagedList<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}