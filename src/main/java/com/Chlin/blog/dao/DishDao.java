package com.Chlin.blog.dao;
import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单的Dao层
 */
@Component
public class DishDao {
    /**
     * 私有构造
     */
    private static DishDao instance;

    private DishDao() {
        // 私有构造函数
    }

    public static DishDao getInstance() {
        if (instance == null) {
            instance = new DishDao();
        }
        return instance;
    }

    private DishMapper dishMapper;

    public void setDishMapper(DishMapper dishMapper) {
        this.dishMapper = dishMapper;
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
    public List<Dish> selectAll() {
        List<Dish> dishes = dishMapper.selectList(null);
        return dishes;
    }

    /**
     * 新增
     *
     * @param
     * @param dish
     * @return
     */
    public int insertDishData(Dish dish) {
        return dishMapper.insert(dish);
    }

    /**
     * 根据id更新
     */
    public int upDataUserMassageById( Dish dish) {
        return dishMapper.updateById(dish);
    }

    /**
     * 根据id删除
     */
    public int deleteUserMassageById(Dish dish) {
        return dishMapper.deleteById(dish);
    }
}
