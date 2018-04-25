package com.boot.es.mybootes.ESSearch

/**
 * elastic search静态常量
 *
 * @author liyang
 */
/**
 * es支持的最大结果数
 */
const val ES_MAX_SIZE = 1000
/**
 * 类目下route_ids分割符
 */
const val SPLIT_TAG = "&"
/**
 * 分词匹配字段
 */
const val MATCH_FIELD = "name";
/**
 * 全文匹配字段（采用了elastic search raw机制，名称name已经分词，增加name.raw是未分词的名称）
 */
const val FULL_MATCH_FIELD = "name.raw"
/**
 * 搜索引擎库商品索引名称
 */
const val ES_INLIFE_ITEM_INDEX = "cityindex"
/**
 * 搜索引擎库商品类型名称
 */
const val ES_INLIFE_ITEM_TYPE = "city"
/**
 * 搜索引擎库类目索引名称
 */
const val ES_INLIFE_ITEM_CATEGORY_INDEX = "index_ytx_inlife_item_category"
/**
 * 搜索引擎库类目类型名称
 */
const val ES_INLIFE_ITEM_CATEGORY_TYPE = "type_ytx_inlife_item_category"
/**
 * 搜索引擎库品牌索引名称
 */
const val ES_INLIFE_BRAND_INDEX = "index_ytx_inlife_brand"
/**
 * 搜索引擎库品牌索引名称
 */
const val ES_INLIFE_BRAND_TYPE = "type_ytx_inlife_brand"