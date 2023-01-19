// Hour of the day when the call volume is highest:
// Use the SQL function HOUR() to extract the hour of the day from the start time of each call.
// Group the calls by hour, and use COUNT() to find the number of calls in each hour.
// Select the hour with the highest number of calls.

//connecting to the database
String url = "jdbc:mysql://<hostname>:<port>/<database>";
String username = "<username>";
String password = "<password>";
Connection connection = DriverManager.getConnection(url, username, password);

String query = "SELECT HOUR(start_time) as hour, COUNT(*) as count FROM call_data GROUP BY hour ORDER BY count DESC LIMIT 1";
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(query);

while (resultSet.next()) {
    int hour = resultSet.getInt("hour");
    int count = resultSet.getInt("count");
    System.out.println("Hour of the day when the call volume is highest: " + hour + " with " + count + " calls");
}
