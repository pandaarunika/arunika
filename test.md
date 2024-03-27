import pandas as pd
import glob

# Path to the directory containing CSV files
csv_files_path = 'path_to_directory/*.csv'

# List to store DataFrames for each CSV file
dfs = []

# List of values to filter by in the 2nd or 3rd column
filter_values = ['value1', 'value2', 'value3']  # Update with your desired values

# Read each CSV file, filter rows, select columns, and append to dfs list
for file in glob.glob(csv_files_path):
    df = pd.read_csv(file)
    filtered_df = df[df['column2'].isin(filter_values) | df['column3'].isin(filter_values)]
    selected_columns = filtered_df.iloc[:, [0, 2, 3]]  # Selecting 1st, 3rd, and 4th columns
    dfs.append(selected_columns)

# Concatenate all DataFrames in dfs list into a single DataFrame
result = pd.concat(dfs, ignore_index=True)

# Save the final result to a CSV file with headers
result.to_csv('output.csv', index=False)

# Print confirmation message
print("Final result saved to output.csv")
