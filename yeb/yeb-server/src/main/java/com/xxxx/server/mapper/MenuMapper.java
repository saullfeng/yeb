package com.xxxx.server.mapper;

import com.xxxx.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author solfeng
 * @since 2021-07-07
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 根据用户ID获取菜单
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 获取所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
