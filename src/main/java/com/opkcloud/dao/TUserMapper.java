package com.opkcloud.dao;

import com.opkcloud.model.TUser;
import com.opkcloud.model.TUserExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2019/6/14
 * @Description: com.opkcloud.dao
 * @version: 1.0
 */
public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}
