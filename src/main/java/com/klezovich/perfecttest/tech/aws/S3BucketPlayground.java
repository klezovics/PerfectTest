package com.klezovich.perfecttest.tech.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

//@Component
@Log
public class S3BucketPlayground implements CommandLineRunner {

    @Value("${aws.key}")
    private String key;

    @Value("${aws.secret}")
    private String secret;

    private final String bucketName = "magic-bucket-123";
    private final String filePath = "C:\\Users\\klezo\\Desktop\\p1.jpg";

    @Override
    public void run(String... args) throws Exception {
        var credentials = new BasicAWSCredentials(key, secret);
        var client = getClient(credentials);
        listBuckets(client);
        putObject(client);
    }

    private void putObject(AmazonS3 client) {
        var result = client.putObject(
                bucketName,
                "p1.png",
                new File(filePath)
        );
        log.info(result.toString());
    }

    private void listBuckets(AmazonS3 client) {
        log.info(key);
        log.info(secret);

        List<Bucket> buckets = client.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }
    }

    private AmazonS3 getClient(AWSCredentials credentials) {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.EU_CENTRAL_1)
                .build();
    }
}
