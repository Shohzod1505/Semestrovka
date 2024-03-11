package ru.itis.kpfu.core.database.data.repository

import ru.itis.kpfu.core.database.data.dao.AccountDao
import ru.itis.kpfu.core.database.data.entity.AccountEntity
import ru.itis.kpfu.core.database.domain.AccountRepository
import javax.inject.Inject

internal class AccountRepositoryImpl @Inject constructor(
    private val accountDao: AccountDao
) : AccountRepository {

    override suspend fun saveAccount(account: AccountEntity) {
        accountDao.save(account)
    }

}
