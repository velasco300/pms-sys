package com.zzz.pms.pmssys.dao;

import com.zzz.pms.pmssys.entity.Verifycode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VerifycodeDao extends BaseDao<Verifycode, Long> {

    public List<Verifycode> findByCodeTypeAndReceiverOrderByCreateTimeDesc(Integer codeType, String receiver);

    @Query(value = "select new map(id as id, codeNumber as codeNumber, createTime as createTime) from Verifycode where codeType = ?1 and receiver = ?2 order by createTime desc")
    public List<Map<String, Object>> listByparams(Integer codeType, String receiver);
}
