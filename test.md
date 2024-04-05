import csv
import os

def count_distinct_rejection_reasons():
    distinct_rejection_reasons = {}
    current_directory = os.getcwd()

    # Loop through all files in the current directory
    for file_name in os.listdir(current_directory):
        if file_name.endswith('.csv'):
            file_path = os.path.join(current_directory, file_name)
            
            # Open each CSV file and read RejectionReason column
            with open(file_path, 'r', newline='', encoding='utf-8') as csvfile:
                reader = csv.DictReader(csvfile)
                for row in reader:
                    rejection_reason = row.get('RejectionReason')
                    if rejection_reason:
                        # Increment count for each distinct rejection reason
                        distinct_rejection_reasons[rejection_reason] = distinct_rejection_reasons.get(rejection_reason, 0) + 1

    return distinct_rejection_reasons

# Get distinct rejection reasons and their counts
distinct_rejection_reasons = count_distinct_rejection_reasons()

# Print the distinct rejection reasons and their counts
for reason, count in distinct_rejection_reasons.items():
    print(f"Rejection Reason: {reason}, Count: {count}")
