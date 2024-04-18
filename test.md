import pandas as pd

def iterate_and_store(csv_file):
    # Read the CSV file
    df = pd.read_csv(csv_file)

    # Create a list to store the values for each row
    row_values = []

    # Iterate through each row
    for index, row in df.iterrows():
        # Create a dictionary to store column values for the current row
        row_data = {}
        for column in df.columns:
            row_data[column] = row[column]
        # Append the dictionary to the list
        row_values.append(row_data)

    return row_values

# Replace 'filename.csv' with the path to your CSV file
csv_file = 'filename.csv'

row_values = iterate_and_store(csv_file)
print(row_values)
