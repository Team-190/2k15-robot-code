void mpinit(){
  if(!sd.begin(SD_SEL, SPI_HALF_SPEED)) sd.initErrorHalt(); // Initialize SD card
  MP3player.begin(); // Initialize MP3 Player

  MP3player.setVolume(0x00, 0x00); // Set volume
}

void play(byte t){
  MP3player.stopTrack();
   char name[] = "track001.mp3";
   sprintf(name, "track%03d.mp3", t);
   MP3player.playMP3(name);
}

