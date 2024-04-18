import pandas as pd

def add_string_column(csv_file, column_name):
    # Read the CSV file
    df = pd.read_csv(csv_file)

    # Create the new column by concatenating 'name' with the value from the specified column
    df['new_column'] = 'name' + df[column_name].astype(str)

    # Write the updated DataFrame back to the same CSV file
    df.to_csv(csv_file, index=False)

# Replace 'filename.csv' with the path to your CSV file and 'column_name' with the name of the column containing the values
csv_file = 'filename.csv'
column_name = 'your_column_name'

add_string_column(csv_file, column_name)
