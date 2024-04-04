import boto3
import pandas as pd

def read_data_from_s3(bucket_name, folder_prefix, column_name):
    # Connect to S3
    s3 = boto3.client('s3')

    # List objects in the specified folder
    objects = s3.list_objects_v2(Bucket=bucket_name, Prefix=folder_prefix)

    # Extract filenames from the objects
    filenames = []
    if 'Contents' in objects:
        for obj in objects['Contents']:
            filename = obj['Key'].split('/')[-1]  # Extract filename from the full object key
            filenames.append(filename)

    # Read data from files and extract filenames from the specified column
    filenames_from_data = []
    for filename in filenames:
        # Download file from S3
        obj = s3.get_object(Bucket=bucket_name, Key=folder_prefix + filename)
        file_content = obj['Body'].read().decode('utf-8')

        # Assuming data is in CSV format, you can modify accordingly
        df = pd.read_csv(file_content)

        # Extract filenames from the specified column
        filenames_from_data.extend(df[column_name].tolist())

    return filenames_from_data

# Example usage
bucket_name = 'your-bucket-name'
folder_prefix = 'Reject/'
column_name = 'FileName'
filenames = read_data_from_s3(bucket_name, folder_prefix, column_name)
print("Filenames:", filenames)
