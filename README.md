# Weather11
220103356
220103356

Use the Application:
Enter the name of the city for which you want to get weather information in the text field. Click the "Узнать погоду" button.Weather information for the entered city will be displayed on the screen.

Explain HelloApplication.java start(Stage primaryStage): This method sets up the JavaFX stage, loads the FXML file (hello-view.fxml), and initializes the UI components. HelloController.java initialize(): 
This method is called when the FXML elements are loaded. It sets up the event handler for the "Узнать погоду" button. When clicked, it retrieves the city name from the text field, makes an API request to 
OpenWeatherMap, and updates the UI with the weather information.

getUrlContent(String urlAddress): This method takes a URL address as input, makes an HTTP GET request to the provided URL, and returns the response content as a string. 
It handles HTTP connections and error handling.

Task Solution UI Design: The FXML file (hello-view.fxml) defines the layout of the user interface, including text fields, buttons, and text elements. 
It provides a user-friendly way to enter the city name and display weather information.

API Integration: The application integrates with the OpenWeatherMap API to fetch weather data. It constructs the API URL based on the user-entered city, makes an HTTP request, 
and parses the JSON response to extract weather details.
