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
package io.github.louistsaitszho.loft.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.github.louistsaitszho.loft.database.entity.NoteEntity.Companion.TABLE_NAME
import java.util.*

/**
 *
 */
@Entity(tableName = TABLE_NAME)
internal data class NoteEntity(
        @PrimaryKey(autoGenerate = false) @ColumnInfo(name = COLUMN_ID) val id: UUID,
        @ColumnInfo(name = COLUMN_CONTENT) val content: String
) {
    companion object {
        const val TABLE_NAME = "notes"
        const val COLUMN_ID = "note_id"
        const val COLUMN_CONTENT = "content"
    }
}