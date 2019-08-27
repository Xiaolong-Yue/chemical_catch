package com.example.util

import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import org.omg.CORBA.NameValuePair
import java.nio.charset.Charset
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.HttpHost
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.HttpUriRequest

object Kit {

    @Throws(Exception::class)
    fun sendRequest(url: String): String {
        val httpClient = HttpClients.createDefault()
        val httpGet = HttpGet(url)
        var content = ""
        try {
            val response = httpClient.execute(httpGet as HttpUriRequest?)
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
        val proxy = HttpHost("47.104.182.149", 16816, "http")
        val requestConfig = RequestConfig.custom().setProxy(proxy).build()
        val httpPost = HttpPost(url)
//        pairList.add(BasicNameValuePair("f", "plist"))
//        pairList.add(BasicNameValuePair("type", "word"))
        httpPost.addHeader("Cookie", "Qs_lvt_56176=1566448872%2C1566542838%2C1566785621%2C1566867925; Qs_pv_56176=1114001584193571600%2C3059331864525677600%2C958320994154887300%2C2410354792356996600%2C720203014476048000; Hm_lvt_f27a00454fe3332070be8b71a0c64602=1566448873,1566785622,1566867926; Hm_lvt_581f7711e663e3f8f681a6c26d63b804=1566448873,1566785622,1566867926; SESSION_LOGIN_USERNAME=15615125129; SESSION_LOGIN_PASSWORD=cd265e88a1d7aa9141f55560cf879b45; JSESSIONID=8E37BC006FE5F45FFDBE8B536DDA3BAB; mediav=%7B%22eid%22%3A%22105583%22%2C%22ep%22%3A%22%22%2C%22vid%22%3A%22LMRMfqzlwr%3A%5ESnFu0F%5Bc%22%2C%22ctn%22%3A%22%22%7D; Hm_lpvt_581f7711e663e3f8f681a6c26d63b804=1566869058; Hm_lpvt_f27a00454fe3332070be8b71a0c64602=1566869058")
        httpPost.entity = UrlEncodedFormEntity(pairList, Charset.defaultCharset())
        httpPost.config = requestConfig
        val response = httpClient.execute(httpPost)
        val content = EntityUtils.toString(response.entity, "UTF-8")
        response.close()
        httpClient.close()
        return content
    }
}
