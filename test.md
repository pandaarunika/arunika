import jaydebeapi

def connect_to_oracle_kerberos(driver_path, class_name, url, principal, keytab_path):
    conn = None
    try:
        conn = jaydebeapi.connect(
            class_name,
            url,
            {'principal': principal, 'keytab': keytab_path},
            driver_path,
        )
        print("Connected to Oracle database using Kerberos authentication")
    except Exception as e:
        print(f"Error connecting to Oracle database: {e}")
    return conn

# Example usage
driver_path = '/path/to/oracle_jdbc_driver.jar'
class_name = 'oracle.jdbc.OracleDriver'
url = 'jdbc:oracle:thin:@//your_oracle_server:1521/your_service_name'
principal = 'your_principal@YOUR.REALM'
keytab_path = '/path/to/your/keytab.keytab'

connection = connect_to_oracle_kerberos(driver_path, class_name, url, principal, keytab_path)
if connection:
    # Perform database operations here
    cursor = connection.cursor()
    cursor.execute("SELECT * FROM your_table")
    rows = cursor.fetchall()
    for row in rows:
        print(row)
    connection.close()
