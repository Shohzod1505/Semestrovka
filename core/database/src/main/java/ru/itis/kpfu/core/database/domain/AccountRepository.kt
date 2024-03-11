package ru.itis.kpfu.core.database.domain

import ru.itis.kpfu.core.database.data.entity.AccountEntity

interface AccountRepository {
    suspend fun saveAccount(account: AccountEntity)
}
