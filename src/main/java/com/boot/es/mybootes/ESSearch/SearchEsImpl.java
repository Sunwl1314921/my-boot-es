package com.boot.es.mybootes.ESSearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository("SearchEsImpl")
public class SearchEsImpl implements SearchEs {

    /**
     * 搜索引擎库产品索引名称
     */
    protected final static String ES_ITEM_INDEX = "cityindex";
    /**
     * 搜索引擎库产品类型名称
     */
    protected final static String ES_ITEM_TYPE = "city";

    /**
     * 全文匹配字段
     */
    protected static final String FULL_MATCH_FIELD = "description";
    /**
     * 分词匹配字段
     */
    protected static final String MATCH_FIELD = "cityname";

    protected ObjectMapper objectMapper = new ObjectMapper();

    public List<City> searchItemList(String keyword, String idKey, int id,
                                     int keywordQueryIndex, String sort, String sortType,
                                     int pageNum, int pageSize) {

        TransportClient client = ESClientSingleton.get();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(ES_ITEM_INDEX).setTypes(ES_ITEM_TYPE)
                .setFrom((pageNum - 1) * pageSize)
                .setSize(pageSize);
        // 指定字段返回
        String[] includes = {"id", "city_name", "province", "description"};
        searchRequestBuilder.setFetchSource(includes, null);
        // 组装查询
        BoolQueryBuilder boolQueryBuilder = createQueryBuilder(keyword, idKey, id, keywordQueryIndex);

        // 设置查询条件
        searchRequestBuilder.setQuery(boolQueryBuilder);
        // 创建排序规则
        SortBuilder sortBuilder = createSortBuilder(sort, sortType);
        // 设置排序规则
        searchRequestBuilder.addSort(sortBuilder);

        //String matchField = keywordQueryIndex == KeywordQueryEnum.FULL_TEXT_MATCH.getIndex() ? FULL_MATCH_FIELD : MATCH_FIELD;
        //boolean isKeywordQuery = !Strings.isNullOrEmpty(keyword);
        //if (isKeywordQuery) {
        //    // 高亮显示关键字
        //    HighlightBuilder highlightBuilder = new HighlightBuilder();
        //    highlightBuilder.field(matchField);
        //    searchRequestBuilder.highlighter(highlightBuilder);
        //}
        // 开始执行查询
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        // 解析结果集
        List<City> items = parseItemResult(searchHits);



        return items;
    }

    /**
     * 解析商品查询结果
     *
     * @param searchHits     命中结果
     */
    // private List<City> parseItemResult(SearchHits searchHits, boolean isKeywordQuery, String matchField) {
    private List<City> parseItemResult(SearchHits searchHits) {
        List<City> items = new ArrayList<>();
        for (SearchHit hit : searchHits.getHits()) {
            String json = hit.getSourceAsString();
            City item;

            try {
                item = objectMapper.readValue(json, City.class);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("数据映射失败!" + e);
                continue;
            }

            //if (isKeywordQuery) {
            //    // 关键字高亮显示
            //    HighlightField highlightField = hit.getHighlightFields().get(matchField);
            //    String highName = item.getCityname();
            //    if (highlightField != null) {
            //        highName = highlightField.getFragments()[0].toString();
            //    }
            //    item.setHighName(highName);
            //} else {
            //    item.setHighName(item.getCityname());
            //}
            items.add(item);
        }
        return items;
    }

    /**
     * 根据查询条件，构造查询器
     *
     * @param keyword           关键字
     * @param idKey             匹配名称, id
     * @param keywordQueryIndex 关键字查询规则，参考枚举 KeywordQueryEnum
     * @return 查询器
     */
    protected BoolQueryBuilder createQueryBuilder(String keyword, String idKey, int id, int keywordQueryIndex) {
        // 组装查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 关键字查询, 此处采用全字段匹配的方案
        if (!Strings.isNullOrEmpty(keyword)) {
            boolQueryBuilder.must(createKeywordQueryBuilder(keyword, keywordQueryIndex));
        }
        /*
            idKey查询，可 或匹配名称, id
         */
        if (!Strings.isNullOrEmpty(idKey)) {
            BoolQueryBuilder idKeyBoolQueryBuilder = QueryBuilders.boolQuery();
            idKeyBoolQueryBuilder.must(createKeywordQueryBuilder(keyword, keywordQueryIndex));
            // id term查询, 先判断是否为纯数字
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(idKey);
            if (isNum.matches()) {
                QueryBuilder queryBuilder = QueryBuilders.termQuery("id", idKey);
                idKeyBoolQueryBuilder.should(queryBuilder);
            }
            boolQueryBuilder.must(idKeyBoolQueryBuilder);
        }
        // id
        if (id != 0) {
            QueryBuilder queryBuilder = QueryBuilders.termQuery("id", id);
            boolQueryBuilder.must(queryBuilder);
        }

        // 限制商品状态
        //QueryBuilder statusQueryBuilder = QueryBuilders.termQuery("status", 1);
        //boolQueryBuilder.must(statusQueryBuilder);
        //// 限制商品删除状态
        //QueryBuilder deletedQueryBuilder = QueryBuilders.termQuery("deleted", 0);
        //boolQueryBuilder.must(deletedQueryBuilder);

        return boolQueryBuilder;
    }

    /**
     * 根据关键字查询规则，返回相应的文本查询器
     *
     * @param keyword           关键字
     * @param keywordQueryIndex 查询规则
     * @return 文本查询器
     */
    private QueryBuilder createKeywordQueryBuilder(String keyword, int keywordQueryIndex) {

        MatchQueryBuilder queryBuilder;
        if (keywordQueryIndex == KeywordQueryEnum.FULL_TEXT_MATCH.getIndex()) {
            queryBuilder = QueryBuilders.matchQuery(FULL_MATCH_FIELD, keyword);
            queryBuilder.operator(Operator.AND);
        } else if (keywordQueryIndex == KeywordQueryEnum.FULL_TERM_MATCH.getIndex()) {
            queryBuilder = QueryBuilders.matchQuery(MATCH_FIELD, keyword);
            queryBuilder.operator(Operator.AND);
        } else {
            queryBuilder = QueryBuilders.matchQuery(MATCH_FIELD, keyword);
            queryBuilder.operator(Operator.OR);
        }
        return queryBuilder;
    }

    /**
     * 创建排序器
     *
     * @param sort     排序
     * @param sortType 排序类型
     * @return sortBuilder 排序创建器
     */
    private SortBuilder createSortBuilder(String sort, String sortType) {

        // 排序: default(默认) ,fresh(上新), soldNum(销量), price(商品最终价格)
        SortBuilder sortBuilder;
        //if ("fresh".equals(sort)) {
        //    sortBuilder = SortBuilders.fieldSort("onShelvesNew");
        //} else if ("soldNum".equals(sort)) {
        //    sortBuilder = SortBuilders.fieldSort("soldNum");
        //} else if ("price".equals(sort)) {
        //    sortBuilder = SortBuilders.fieldSort("saleLowPrice");
        //} else {
        //    String scriptStr = "doc['clickCount'].value + doc['soldNum'].value";
        //    sortBuilder = SortBuilders.scriptSort(new Script(scriptStr), ScriptSortBuilder.ScriptSortType.NUMBER);
        //}

        sortBuilder = SortBuilders.fieldSort(sort);
        // 排序类型
        sortBuilder.order(SortOrder.fromString(sortType));
        return sortBuilder;
    }


    public static void main(String[] args) {
        String str="sadasd";
        boolean isWord=str.matches("[a-zA-Z]+");
        System.out.println(isWord);
    }
}