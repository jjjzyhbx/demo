package com.Chlin.blog.dao;
import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.mapper.DishMapper;

import java.util.List;

/**
 * 菜单的Dao层
 */
public class DishDao {
    /**
     * 私有构造
     */
    private DishDao() {

    }

    public static DishDao getInstance() {
        return new DishDao();
    }

    /**
     * 基本crud
     */

    /**
     * 查找所有
     *
     * @param
     * @return
     */
    public List<Dish> selectAll(DishMapper dishMapper) {
        List<Dish> dishes = dishMapper.selectList(null);
        return dishes;
    }

    /**
     * 新增
     *
     * @param dishMapper
     * @param dish
     * @return
     */
    public int insertOrderData(DishMapper dishMapper, Dish dish) {
        return dishMapper.insert(dish);
    }

    /**
     * 根据id更新
     */
    public int upDataUserMassageById(DishMapper dishMapper, Dish dish) {
        return dishMapper.updateById(dish);
    }

    /**
     * 根据id删除
     */
    public int deleteUserMassageById(DishMapper dishMapper, Dish dish) {
        return dishMapper.deleteById(dish);
    }
}
