package com.deh.lumen.core_data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.deh.lumen.core_data.CoreDataConstants
import com.deh.lumen.core_data.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM ${CoreDataConstants.USER_TABLE_NAME} LIMIT 1")
    fun observeUser(): Flow<User?>

    @Query("SELECT * FROM ${CoreDataConstants.USER_TABLE_NAME} LIMIT 1")
    suspend fun getUser(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("DELETE FROM ${CoreDataConstants.USER_TABLE_NAME}")
    suspend fun deleteUser()
}