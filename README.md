# AcousticSensing
The Acoustic Sensing application is built upon the Client-Server architecture. The Client side, which is the Android application is simply an App that utilizes the signal sent through the microphone and capture the reflected signal for further processing. On the other hand, the Server side, written in Matlab, is responsible for constructing the signal, passing it to the client side for sensing, receiving the reflected signal captured by the phone's speaker, and perform signal processing.  
  
In terms of the communication between the phone and the server, the TCP/IP appraoch is utilized. There are various open source java WebSocket on GitHub, and even for Matlab Server.  
As documented on Github, the MatlabWebSocket is a library built on the Java-WebSocket. It requires pre-defined java library in Matlab static class path. More information and the Latest Released Package can be found [here](https://github.com/jebej/MatlabWebSocket).  
For the Web Socket on Android, as mentioned, the Java-WebSocket is a java implementation of the websocket protocol. The well-known org.java_websocket.server.WebSocketServer abstract class implements both the client and the server side, which the client side is extended in this project. The latest package of the Java-WebSocket can be found [here](https://github.com/TooTallNate/Java-WebSocket).  
  
Another lightweight web socket targeting Android application is proposed [here](https://github.com/gusavila92/java-android-websocket-client).  
  
The current implementation is for remote mode. To be more specific, it requires a seperate server for the aforementioned functions. One of the goal is to implement stand-alone mode in the future.  
