/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.amitghosh.modernandroidapparchitecture.utilities

import android.content.Context
import me.amitghosh.modernandroidapparchitecture.data.AppDatabase
import me.amitghosh.modernandroidapparchitecture.data.BookRepository
import me.amitghosh.modernandroidapparchitecture.viewModels.BooksViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {
    private fun getPlantRepository(context: Context): BookRepository {
        return BookRepository.getInstance(AppDatabase.getInstance(context).bookDao())
    }

    fun provideBooksViewModelFactory(context: Context): BooksViewModelFactory {
        val repository = getPlantRepository(context)
        return BooksViewModelFactory(repository)
    }
}
