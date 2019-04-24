package com.imsystem.mapper;

import com.imsystem.domain.Supplier;
import com.imsystem.domain.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
	
	int updateBalanceJia(Supplier supper);
	
	int updateBalancejian(Supplier supper);
	
	List<Supplier> querySupplierByPage(@Param("content") String content,@Param("zero") Double zero);
	
	int updateSupplier(Supplier sObj);
	
	int deleteSupplier(String id);
	
	List<Supplier> selectAllSupplier();
	
    int countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(String id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

	List<Supplier> querySupplier_yByStore(@Param("sid") String sid); 
}