# Audio Cutter 
An application that creates cuts from an audio file (only wav atm). Uses [JAudio](http://jaudio.sourceforge.net/) for the audio processing.
Uses a simple interface created with javafx(fxml). The package "audio" is the one created by me.

## Classes:
* Main - starts the application and loads the fxml
* Controller - controls the UI
* Cut - data class for cuts
* AudioCutter - interface for audio cutters
* WavCutter - implementation for the AudioCutter interface

![alt text](https://raw.githubusercontent.com/zakupower/Audio-Cutter/master/Capture.PNG)

## TO DO
- [ ] Extract file save from WavCutter
- [ ] Create checks for Cut class constructor
- [ ] Do proper unit tests
