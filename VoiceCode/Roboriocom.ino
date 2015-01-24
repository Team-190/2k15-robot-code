#define address 2
byte cmd;
void roboinit(){
  Wire.begin(address);
 Wire.onReceive(recieve); 
}
void recieve(int numbytes){
cmd = Wire.read();
Serial.println(cmd);
play(cmd);
}

