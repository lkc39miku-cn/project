package org.example.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

public class OssClient {
    public static OSS getOssClient() {
        String endpoint = "yourEndpoint";
        String accessKeyId = "yourAccessKeyId";
        String accessKeySecret = "yourAccessKeySecret";
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    public static void shutdown(OSS oss) {
        oss.shutdown();
    }
}
