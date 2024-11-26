package com.gvc.thinktank_dev.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Value("${aws.region}")
    private String awsRegion;

    private static final Logger logger = LoggerFactory.getLogger(AWSConfig.class);

    @Bean
    public AmazonS3 createS3Instance() {
        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder
                .standard()
                .withRegion(awsRegion)
                .withCredentials(new DefaultAWSCredentialsProviderChain());

        // Log informações do builder
        AWSCredentialsProvider credentialsProvider = builder.getCredentials();
        logger.info("AWS Region: {}", awsRegion);
        logger.info("AWS Credentials Provider: {}", credentialsProvider.getClass().getName());

        // Testa as credenciais chamando 'getCredentials()'
        try {
            logger.info("AWS Access Key ID: {}", credentialsProvider.getCredentials().getAWSAccessKeyId());
        } catch (Exception e) {
            logger.error("Error fetching AWS credentials: {}", e.getMessage(), e);
        }

        return builder.build();
    }

}
