package com.android.example.kinrai.Database
/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.android.example.kinrai.Resterant

@Dao
interface RestsDatabaseDao {

    @Insert
    fun insert(rest: Resterant)

    @Update
    fun update(rest: Resterant)

    @Query("SELECT * from rests_table WHERE restId = :key")
    fun get(key: Long): Resterant?

    @Query("DELETE FROM rests_table")
    fun clear()

    @Query("DELETE FROM rests_table WHERE name = :name")
    fun remove(name: String)

    @Query("SELECT * FROM rests_table ORDER BY restId DESC LIMIT 1")
    fun getToRest(): Resterant?

    @Query("SELECT * FROM rests_table ORDER BY restId DESC")
    fun getAllRests(): LiveData<List<Resterant>>

    @Query("SELECT name FROM rests_table ORDER BY restId DESC")
    fun getArray(): Array<String>



}