import pandas as pd
import glob

# Path to the directory containing CSV files
csv_files_path = 'path_to_directory/*.csv'

# List to store DataFrames for each CSV file
dfs = []

# Read each CSV file, select columns, and append to dfs list
for file in glob.glob(csv_files_path):
    df = pd.read_csv(file)
    selected_columns = df.iloc[:, [0, 2, 3]]  # Selecting 1st, 3rd, and 4th columns
    dfs.append(selected_columns)

# Concatenate all DataFrames in dfs list into a single DataFrame
result = pd.concat(dfs, ignore_index=True)

# Print the resulting DataFrame
print(result)
