# Audio Cutter 
An application that creates cuts from an audio file (only wav atm). Uses [JAudio](http://jaudio.sourceforge.net/) for the audio processing.
Uses a simple interface created with javafx(fxml). The package "audio" is the one created by me.

![alt text](https://raw.githubusercontent.com/zakupower/Audio-Cutter/master/ico3.png)

![alt text](https://raw.githubusercontent.com/zakupower/Audio-Cutter/master/Capture2.PNG)
## Classes:
* Main - starts the application and loads the fxml
* Controller - controls the UI
* Cut - data class for cuts
* AudioCutter - interface for audio cutters
* WavCutter - implementation for the AudioCutter interface



## TO DO
- [x] Extract file save from WavCutter
- [x] Separate JAudio from the app
- [x] Create checks for Cut class constructor
- [ ] Do proper unit tests
- [ ] Add a loading bar
- [x] Create an icon for the app
- [ ] Change how the UI looks

