package com.ld.codeGenerate.service;

import java.util.List;

import com.ld.codeGenerate.pojo.BaseMetaData;


/**
 * Table meta info
 * @author Cruz
 * @version 1.0
 * @param <BaseMetaData>
 */
public interface DatabaseMetaDataService {

	List<BaseMetaData> select(String tableName);
}
