import pyodbc

def connect_to_mysql_kerberos(server, database, principal):
    conn_str = (
        "DRIVER={MySQL ODBC 8.0 Unicode Driver};"
        f"SERVER={server};"
        f"DATABASE={database};"
        "OPTION=3;"
        "KERBEROS_SERVICE_PRINCIPAL_NAME=" + principal + ";"
        "AuthenticationMethod=1;"
    )

    try:
        conn = pyodbc.connect(conn_str)
        print("Connected to MySQL database using Kerberos authentication")
        return conn
    except pyodbc.Error as e:
        print(f"Error connecting to MySQL database: {e}")
        return None

# Example usage
server_name = "your_mysql_server"
database_name = "your_database"
principal_name = "your_principal"

connection = connect_to_mysql_kerberos(server_name, database_name, principal_name)
if connection:
    # Perform database operations here
    cursor = connection.cursor()
    cursor.execute("SELECT * FROM your_table")
    rows = cursor.fetchall()
    for row in rows:
        print(row)
    connection.close()
