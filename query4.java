// Day of the week when the calls are longest:
// Use the SQL function DAYNAME() to extract the day of the week from the start time of each call.
// Group the calls by day of the week, and use SUM() to find the total duration of the calls on each day.
// Select the day of the week with the highest total duration.

//connecting to the database
String url = "jdbc:mysql://<hostname>:<port>/<database>";
String username = "<username>";
String password = "<password>";
Connection connection = DriverManager.getConnection(url, username, password);

String query = "SELECT DAYNAME(start_time) as day, SUM(duration) as duration FROM call_data GROUP BY day ORDER BY duration DESC LIMIT 1";
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(query);

while (resultSet.next()) {
    String day = resultSet.getString("day");
    int duration = resultSet.getInt("duration");
    System.out.println("Day of the week when the calls are longest: " + day + " with total duration of " + duration + " seconds");
}
