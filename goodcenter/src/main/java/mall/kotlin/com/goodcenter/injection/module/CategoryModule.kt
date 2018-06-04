package mall.kotlin.com.goodcenter.injection.module

import dagger.Module
import dagger.Provides
import mall.kotlin.com.goodcenter.service.CategoryService
import mall.kotlin.com.goodcenter.service.GoodsService
import mall.kotlin.com.goodcenter.service.impl.CategoryServiceImpl
import mall.kotlin.com.goodcenter.service.impl.GoodsServiceImpl

/**
 * @author Dsh  on 2018/4/16.
 */

@Module
class CategoryModule {
    @Provides
    fun provideCategoryService(service: CategoryServiceImpl): CategoryService {
        return service
    }

    @Provides
    fun provideGoodsService(service: GoodsServiceImpl): GoodsService {
        return service
    }

}