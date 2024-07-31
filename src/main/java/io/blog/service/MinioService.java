package io.blog.service;

import io.blog.util.MinioConfig;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

@Service
public class MinioService {
    private final MinioClient minioClient;
    private final String bucketName;

    @Autowired
    public MinioService(MinioConfig configProperties) {
        this.minioClient = MinioClient.builder()
                .endpoint(configProperties.getUrl())
                .credentials(configProperties.getAccessKey(),
                        configProperties.getSecretKey())
                .build();
        this.bucketName = configProperties.getBucketName();
    }

    public String uploadFile(MultipartFile file)
            throws IOException, ServerException, InsufficientDataException,
            ErrorResponseException, NoSuchAlgorithmException, InternalException,
            InvalidKeyException, InvalidResponseException, XmlParserException {
        String fileName = System.currentTimeMillis() + "-"
                + file.getOriginalFilename();
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );
        return fileName;
    }

    public String getFileUrl(String fileName) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(bucketName)
                        .object(fileName)
                        .expiry(2, TimeUnit.HOURS) // URL expires in 2 hours
                        .build()
        );
    }
}
