import boto3
from boto3.dynamodb.conditions import Key
import json

def query_dynamodb(created_dt, source):
    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table('your_table_name')  # Replace 'your_table_name' with your actual DynamoDB table name

    response = table.scan(
        FilterExpression=Key('CreatedDt').eq(created_dt) & Key('Source').eq(source)
    )

    filtered_records = []
    for item in response['Items']:
        file_dtl = json.loads(item['FileDtl'])
        if file_dtl.get('Validation_Rejected', {}).get('N', 0) > 0 and item.get('Status') == 'Validation_Processed':
         cob_dt = item.get('Cob_dt')
            formatted_cob_dt = cob_dt.strftime('%Y-%m-%d') if cob_dt else None
            item['Source'] = f"{item['Source']}_{formatted_cob_dt}" if formatted_cob_dt else item['Source']
            filtered_records.append(item)

    return filtered_records

# Example usage:
created_dt = '2024-04-05'
source = 'your_source_value'
filtered_records = query_dynamodb(created_dt, source)

for record in filtered_records:
    print(record['Source'])  # Get the Source column detail for the filtered records
