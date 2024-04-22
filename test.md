from bs4 import BeautifulSoup
import csv

def html_to_csv(html_content, csv_file_path):
    # Parse HTML content
   from bs4 import BeautifulSoup
import csv

def html_file_to_csv(html_file_path, csv_file_path):
    # Read the HTML file
    with open(html_file_path, 'r') as html_file:
        html_content = html_file.read()
    
    # Parse the HTML content using BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')

    # Locate the table you want to extract data from
    # You may need to customize this to locate the correct table(s) based on the structure of your HTML
    table = soup.find('table')

    # Prepare CSV file for writing
    with open(csv_file_path, 'w', newline='') as csvfile:
        csv_writer = csv.writer(csvfile)

        # Write table headers (if available)
        headers = [header.text for header in table.find_all('th')]
        if headers:
            csv_writer.writerow(headers)

        # Write table rows
        for row in table.find_all('tr'):
            row_data = [cell.text for cell in row.find_all(['td', 'th'])]
            if row_data:  # Only write rows with data
                csv_writer.writerow(row_data)

# Example usage
html_file_path = 'input.html'  #


    # Locate the table you want to extract data from
    table = soup.find('table')

    # Prepare CSV file for writing
    with open(csv_file_path, 'w', newline='') as csvfile:
        csv_writer = csv.writer(csvfile)

        # Write table headers
        headers = [header.text for header in table.find_all('th')]
        csv_writer.writerow(headers)

        # Write table rows
        for row in table.find_all('tr'):
            row_data = [cell.text for cell in row.find_all(['td', 'th'])]
            csv_writer.writerow(row_data)

# Example usage
html_content = """
<!-- Your Thymeleaf-generated HTML content here -->
"""
csv_file_path = 'output.csv'  # The path to the CSV file you want to save

html_to_csv(html_content, csv_file_path)
