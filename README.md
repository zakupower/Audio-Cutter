
# Audio Cutter 
<img width="100" height="100" alt="alt text" src="https://raw.githubusercontent.com/zakupower/Audio-Cutter/master/ico3.png">

An application that creates cuts from an audio file (only wav atm). Uses [JAudio](http://jaudio.sourceforge.net/) for the audio processing.
Uses a simple UI created with javafx(fxml).

![alt text](https://raw.githubusercontent.com/zakupower/Audio-Cutter/master/Capture3.PNG)

## Classes:
* Main - starts the application and loads the fxml
* Controller - controls the UI
* Cut - data class for cuts
* AudioCutter - interface for audio cutters
* WavCutter - implementation for the AudioCutter interface
* AudioFile - separates the external lib from the app
* AudioFileSaver - used to save all the cuts




## TO DO
- [x] Extract file save from WavCutter
- [x] Separate JAudio from the app
- [x] Create checks for Cut class constructor
- [x] Change how the UI looks
- [x] Create an icon for the app
- [ ] Convert from minutes in format 1:23 from and to fields
- [ ] Do proper unit tests
- [ ] Add a loading bar


