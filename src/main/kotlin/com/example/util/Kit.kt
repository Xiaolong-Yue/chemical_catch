package com.example.util

import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import org.omg.CORBA.NameValuePair
import java.nio.charset.Charset

object Kit {

    @Throws(Exception::class)
    fun sendRequest(url: String): String {
        val httpClient = HttpClients.createDefault()
        val httpGet = HttpGet(url)
        var content = ""
        try {
            val response = httpClient.execute(httpGet)
            content = EntityUtils.toString(response.entity, "UTF-8")
            response.close()
            httpClient.close()
        } catch (exp: Exception) {

        }

        return content
    }

    @Throws(Exception::class)
    fun postRequest(url: String, pairList: ArrayList<BasicNameValuePair>): String {
        val httpClient = HttpClients.createDefault()
        val httpPost = HttpPost(url)
//        pairList.add(BasicNameValuePair("f", "plist"))
//        pairList.add(BasicNameValuePair("type", "word"))
        httpPost.addHeader("Cookie", "JSESSIONID=71EC9A261F66F01859BDDBDA29C5F8E6; Qs_lvt_56176=1566448872; Qs_pv_56176=4218948666408735000%2C4398872970285031400%2C4381712557310873600%2C2202059588098944300%2C2219800150222790400; mediav=%7B%22eid%22%3A%22105583%22%2C%22ep%22%3A%22%22%2C%22vid%22%3A%22LMRMfqzlwr%3Ahi%5BQkC%23uv%22%2C%22ctn%22%3A%22%22%7D; Hm_lvt_f27a00454fe3332070be8b71a0c64602=1566448873; Hm_lpvt_f27a00454fe3332070be8b71a0c64602=1566456331; Hm_lvt_581f7711e663e3f8f681a6c26d63b804=1566448873; Hm_lpvt_581f7711e663e3f8f681a6c26d63b804=1566456331")
        httpPost.entity = UrlEncodedFormEntity(pairList, Charset.defaultCharset())
        val response = httpClient.execute(httpPost)
        val content = EntityUtils.toString(response.entity, "UTF-8")
        response.close()
        httpClient.close()
        return content
    }
}
