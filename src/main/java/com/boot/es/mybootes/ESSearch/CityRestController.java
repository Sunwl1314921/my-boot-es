package com.boot.es.mybootes.ESSearch;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Controller
public class CityRestController {

    @Autowired
    private SearchEs test;



    /**
     * 查询操作
     *  根据name搜索 searchType匹配方式 全文匹配或者部分词项匹配
     * @param name       查询关键字
     * @param searchType 查询方式
     * @return 结果集
     * @see KeywordQueryEnum
     */
    @RequestMapping("/{name}/{searchType}")
    public String test(@PathVariable("name") String name, @PathVariable("searchType") Integer searchType) {
        return test.searchItemList(
                name, "", 0, searchType,
                "id", "DESC", 1, 10).toString();
    }

    /**
     * es-api的方法学习：
     * 1.prepareIndex方法：索引数据到ElasticSearch
     */
    @RequestMapping("/add")
    public void test() throws IOException, InterruptedException, ExecutionException {
        //启动Client
        TransportClient client = ESClientSingleton.get();
        //执行操作
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //数据
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder()
                .startObject()
                .field("user", "sunwenlong")
                .field("age", "26")
                .field("sex", "is one boy hahaha哈")
                .field("insert_time", sdf.format(new Date()))
                .endObject();
        //1.prepareIndex方法：索引数据到ElasticSearch 新建index-test 索引  type-user类型
        IndexResponse response = client.prepareIndex("index-test", "type-user", "1")
                .setSource(jsonBuilder).get();

        //关闭es
        //closeEs(client);

        String _index = response.getIndex();
        String _type = response.getType();
        String _id = response.getId();
        long _version = response.getVersion();
        System.out.println(_index + " " + _type + " " + _id + " " + _version);
    }

    /**
     * 查找数据 查找id为1的数据
     * 2.prepareGet方法:获取信息
     */
    @RequestMapping("/select")
    public String get() {
        //启动Client
        TransportClient client = ESClientSingleton.get();
        GetResponse getResponse = client.prepareGet("test_index_city", "test_type_city", "5").get();

        System.out.println(getResponse.getSourceAsString());
        //关闭es
        // closeEs(client);
        return "数据：" + getResponse.getSourceAsString();
    }

    /**
     * 删除数据 删除id=1的数据
     * 3.prepareDelete方法：删除信息
     */
    @RequestMapping("delete")
    public String delete() {
        //启动Client
        TransportClient client = ESClientSingleton.get();
        DeleteResponse deleteResponse = client.prepareDelete("index-test", "type-user", "1").get();
        System.out.println(deleteResponse.status());
        //关闭es
        //closeEs(client);
        return "删除成功";
    }

    /**
     * 删除索引库 包括数据
     */
    @RequestMapping("/deleteIndex/{indexName}")
    public String deleteIndex(@PathVariable("indexName") String indexName) {
        //启动Client
        TransportClient client = ESClientSingleton.get();
        try {
            if (!isIndexExists(indexName)) {
                System.out.println(indexName + " not exists");
            } else {

                DeleteIndexResponse dResponse = client.admin().indices().prepareDelete(indexName)
                        .execute().actionGet();
                if (dResponse.isAcknowledged()) {
                    System.out.println("delete index " + indexName + "  successfully!");
                } else {
                    System.out.println("Fail to delete index " + indexName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //closeEs(client);
        }

        return "删除索引成功";
    }

    // 判断索引是否存在 传入参数为索引库名称
    private static boolean isIndexExists(String indexName) {
        boolean flag = false;
        try {
            //启动Client
            TransportClient client = ESClientSingleton.get();

            IndicesExistsRequest inExistsRequest = new IndicesExistsRequest(indexName);

            IndicesExistsResponse inExistsResponse = client.admin().indices()
                    .exists(inExistsRequest).actionGet();

            if (inExistsResponse.isExists()) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 修改数据
     * 4.update方法：更新信息
     * 4.1 upsert：在使用update方法时：
     * a:针对文档不存在的情况时，做出index数据的操作,update无效；
     * b:如果文档存在，那么index数据操作无效，update有效；
     */
    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") String id) throws Exception {
        //启动Client
        TransportClient client = ESClientSingleton.get();
        //4.update方法：更新信息
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("index-test");
        updateRequest.type("type-user");
        updateRequest.id(id);
        updateRequest.doc(XContentFactory.jsonBuilder().startObject().field("age", "music").endObject());
        UpdateResponse updateResponse = client.update(updateRequest).get();
        System.out.println(updateResponse.status());
        //update方法： 可以为已有的文档添加新的字段
        UpdateResponse updateResponse2 = client.prepareUpdate("index-test", "type-user", id)
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("interest2", "reading")
                        .endObject()).get();
        System.out.println(updateResponse2.status());
        //4.1 upsert：在使用update方法时，
        // a:针对文档不存在的情况时，做出index数据的操作,update无效；
        // b:如果文档存在，那么index数据操作无效，update有效；
        //先构建一个IndexRequest
        IndexRequest indexRequest = new IndexRequest("index-test", "type-user", id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        indexRequest.source(XContentFactory.jsonBuilder()
                .startObject()
                .field("user", "yuchen2")
                .field("interest", "eating")
                .field("insert_time", sdf.format(new Date()))
                .endObject());
        //再构建一个UpdateRequest，并用IndexRequest关联
        UpdateRequest updateRequest3 = new UpdateRequest("index-test", "type-user", id);
        updateRequest3.doc(XContentFactory.jsonBuilder()
                .startObject()
                .field("interest2", "love")
                .endObject()
        ).upsert(indexRequest);
        client.update(updateRequest3).get();

        //关闭es
        //closeEs(client);
        return "修改成功";
    }

    /**
     * 关闭es
     *
     * @param client 链接
     */
    private void closeEs(TransportClient client) {
        if (client != null) {
            client.close();
        }
    }
}
