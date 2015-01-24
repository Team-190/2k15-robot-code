#include <Wire.h>
#include <SPI.h>
#include <SdFat.h>             // SdFat Libraries
#include <SdFatUtil.h>
#include <SFEMP3Shield.h>   
SFEMP3Shield MP3player;
SdFat sd;
void setup(){
Serial.begin(9600);
roboinit();
mpinit();
}

void loop(){ 
}

