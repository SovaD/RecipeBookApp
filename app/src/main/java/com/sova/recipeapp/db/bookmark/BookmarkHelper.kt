package com.sova.recipeapp.db.bookmark

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sova.recipeapp.db.DBRecipeHelper
import com.sova.recipeapp.db.bookmark.BookmarkContract.BookmarkColumns.Companion.IDMEAL
import com.sova.recipeapp.db.bookmark.BookmarkContract.BookmarkColumns.Companion.STRMEAL
import com.sova.recipeapp.db.bookmark.BookmarkContract.BookmarkColumns.Companion.STRMEALTHUMB
import com.sova.recipeapp.model.Filter
import java.sql.SQLException

class BookmarkHelper(context: Context) {
    val DATABASE_TABLE = BookmarkContract().TABLE_BOOKMARK
    var databaseHelper = DBRecipeHelper(context)
    lateinit var database: SQLiteDatabase

    companion object {

        @Volatile
        private var INSTANCE: BookmarkHelper? = null

        fun getInstance(context: Context): BookmarkHelper =
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                        ?: BookmarkHelper(
                            context
                        )
                }
    }


    @Throws(SQLException::class)
    fun open() {
        database = databaseHelper.writableDatabase
    }

    fun close() {
        databaseHelper.close()

        if (database.isOpen)
            database.close()
    }

    fun getAllRecipe(): ArrayList<Filter> {
        val arrayList = ArrayList<Filter>()
        val cursor = database.query(
            DATABASE_TABLE,
            null, null, null, null, null,
            null, null
        )
        cursor.moveToFirst()
        var recipe: Filter
        if (cursor.count > 0) {
            do {
                recipe = Filter(
                    cursor.getString(cursor.getColumnIndexOrThrow(IDMEAL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(STRMEAL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(STRMEALTHUMB))
                )

                arrayList.add(recipe)
                cursor.moveToNext()

            } while (!cursor.isAfterLast)
        }
        cursor.close()
        return arrayList
    }

    fun isBookmarked(id: String): Boolean {
        val cursor = database.query(
            DATABASE_TABLE,
            null, "$IDMEAL = '$id'", null, null, null,
            null, null
        )
        cursor.moveToFirst()
        if (cursor.count > 0) {
            return true
        }
        return false

    }

    fun insertRecipe(recipe: Filter): Long {
        val args = ContentValues()
        args.put(IDMEAL, recipe.idMeal)
        args.put(STRMEAL, recipe.strMeal)
        args.put(STRMEALTHUMB, recipe.strMealThumb)

        return database.insert(DATABASE_TABLE, null, args)
    }

    fun deleteRecipe(id: String): Int {
        return database.delete(BookmarkContract().TABLE_BOOKMARK, "$IDMEAL = '$id'", null)
    }

}