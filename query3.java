// Day of the week when the call volume is highest:
// Use the SQL function DAYNAME() to extract the day of the week from the start time of each call.
// Group the calls by day of the week, and use COUNT() to find the number of calls on each day.
// Select the day of the week with the highest number of calls.


//connecting to the database
String url = "jdbc:mysql://<hostname>:<port>/<database>";
String username = "<username>";
String password = "<password>";
Connection connection = DriverManager.getConnection(url, username, password);

String query = "SELECT DAYNAME(start_time) as day, COUNT(*) as count FROM call_data GROUP BY day ORDER BY count DESC LIMIT 1";
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(query);

while (resultSet.next()) {
    String day = resultSet.getString("day");
    int count = resultSet.getInt("count");
    System.out.println("Day of the week when the call volume is highest: " + day + " with " + count + " calls");
}
