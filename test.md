import pymysql.cursors

# Connection parameters
host = 'your_host'
database = 'your_database'
user = 'your_username'
passwd = 'your_password'

# Kerberos configuration
krb5_conf = '/path/to/your/krb5.conf'
krb5_ccache = '/path/to/your/krb5cc_cache'

try:
    # Connect to the database using Kerberos authentication
    conn = pymysql.connect(host=host,
                           database=database,
                           user=user,
                           password=passwd,
                           charset='utf8mb4',
                           cursorclass=pymysql.cursors.DictCursor,
                           kerberos_service_name='mysql',
                           kerberos_host_name=host,
                           kerberos_service_host=host,
                           kerberos_ccname=krb5_ccache,
                           kerberos_config=krb5_conf)

    # Use the connection
    with conn.cursor() as cursor:
        # Example query
        sql = "SELECT * FROM your_table"
        cursor.execute(sql)
        results = cursor.fetchall()
        for row in results:
            print(row)

finally:
    # Close the connection
    conn.close()
