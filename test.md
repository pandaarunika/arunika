import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.Date;

public class S3Example {

    public static void main(String[] args) {
        String accessKey = "YOUR_ACCESS_KEY";
        String secretKey = "YOUR_SECRET_KEY";
        String region = "YOUR_REGION"; // e.g., us-east-1
        String bucketName = "appid_pay";
        String folderName = "REJECT/";
        Date modifiedDate = new Date(); // Set your desired modified date here

        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("https://s3." + region + ".amazonaws.com", region))
                .build();

        ListObjectsV2Request request = new ListObjectsV2Request()
                .withBucketName(bucketName)
                .withPrefix(folderName);

        ListObjectsV2Result result = s3Client.listObjectsV2(request);

        for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
            if (objectSummary.getLastModified().equals(modifiedDate)) {
                System.out.println("Object Key: " + objectSummary.getKey());
                // Fetch other details or process the object as needed
            }
        }
    }
}
