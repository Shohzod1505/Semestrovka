package ru.itis.kpfu.core.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.itis.kpfu.core.database.data.entity.AccountEntity

@Dao
internal interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(account: AccountEntity)

}
