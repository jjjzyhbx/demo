package com.Chlin.blog.service.impl;

import com.Chlin.blog.dao.DishDao;
import com.Chlin.blog.entity.Dish;
import com.Chlin.blog.mapper.DishMapper;
import com.Chlin.blog.service.DishService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    private DishDao dishDao=DishDao.getInstance();


    /**
     * 插入一条菜单数据
     * @param dish
     * @return
     */
    @Override
    public int insertNewDish(Dish dish) {
        dishDao.setDishMapper(this.getBaseMapper());
        System.out.println(dishDao);
        dish.setCreateTime(new Date());
        dish.setUpdateTime(new Date());
       return dishDao.insertDishData(dish);
//        return this.getBaseMapper().insert(dish);
    }

    /**
     * 插入一条
     * @param entity
     * @return
     */
    @Override
    public boolean save(Dish entity) {
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return super.save(entity);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Dish> list() {
        return super.list();
    }

    /**
     * 通过id查询
     * @param idList
     * @return
     */
    @Override
    public List<Dish> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    /**
     * 构造条件查询
     * @param queryWrapper
     * @return
     */
    @Override
    public List<Dish> list(Wrapper<Dish> queryWrapper) {
        return super.list(queryWrapper);
    }

    /**
     * 根据名字或者根据价格查询
     * @param dish
     * @return
     */
    @Override
    public List<Dish> listByEntity(Dish dish) {
        QueryWrapper<Dish> wrapper = new QueryWrapper<>();
        if(dish.getName() != null){
        wrapper.like("name",dish.getName());
        }
        if(dish.getPrice()!=null) {
            wrapper.like("price", dish.getPrice());
        }
        return list(wrapper);
    }

    @Override
    public Dish getOne(Wrapper<Dish> queryWrapper) {
        return super.getOne(queryWrapper);
    }

    @Override
    public Dish getById(Serializable id) {
        return super.getById(id);
    }

    /**
     * 根据名字或者根据价格查询
     * @param dish
     * @return
     */
    @Override
    public Dish listByEntityID(Dish dish) {
        QueryWrapper<Dish> wrapper = new QueryWrapper<>();
            wrapper.like("id",dish.getId());
        return getOne(wrapper);
    }

    @Override
    public boolean update(Dish entity, Wrapper<Dish> updateWrapper) {
        entity.setUpdateTime(new Date());
        return super.update(entity, updateWrapper);
    }

//    @Override
//    public boolean updateBatchById(Collection<Dish> entityList) {
//        /*更新时间
//         */
//        return super.updateBatchById(entityList);
//    }
    // 在Service中添加方法

    /**
     * 根据id，批量跟新
     * @param dishList
     * @return
     */
    @Override
    public boolean updateBatchByDishList(List<Dish> dishList){

        // 设置更新时间
        dishList.forEach(dish -> {
            dish.setUpdateTime(new Date());
        });

        // 调用父类批量更新方法
        return super.updateBatchById(dishList);

    }

    /**
     * 根据id更新
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(Dish entity) {
        entity.setUpdateTime(new Date());
        return super.updateById(entity);
    }

    /**
     * 根据id删除
     * @param entity
     * @return
     */
    @Override
    public boolean removeById(Dish entity) {
        return super.removeById(entity);
    }

    /**
     * 根据id批量删除
     * @param list
     * @param useFill
     * @return
     */
    @Override
    public boolean removeByIds(Collection<?> list, boolean useFill) {
        return super.removeByIds(list, useFill);
    }
}
