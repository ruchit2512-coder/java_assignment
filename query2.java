// Hour of the day when the calls are longest:
// Use the SQL function HOUR() to extract the hour of the day from the start time of each call.
// Group the calls by hour, and use SUM() to find the total duration of the calls in each hour.
// Select the hour with the highest total duration.

//connecting to the database
String url = "jdbc:mysql://<hostname>:<port>/<database>";
String username = "<username>";
String password = "<password>";
Connection connection = DriverManager.getConnection(url, username, password);

String query = "SELECT HOUR(start_time) as hour, SUM(duration) as duration FROM call_data GROUP BY hour ORDER BY duration DESC LIMIT 1";
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(query);

while (resultSet.next()) {
    int hour = resultSet.getInt("hour");
    int duration = resultSet.getInt("duration");
    System.out.println("Hour of the day when the calls are longest: " + hour + " with total duration of " + duration + " seconds");
}
