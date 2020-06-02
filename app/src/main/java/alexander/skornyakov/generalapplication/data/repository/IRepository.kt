package alexander.skornyakov.generalapplication.data.repository

import alexander.skornyakov.generalapplication.data.model.MainFirstModel
import alexander.skornyakov.generalapplication.data.model.MainSecondModel
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAllFirstModels() : Flow<MainFirstModel>
    fun getAllSecondModels() : Flow<MainSecondModel>

}