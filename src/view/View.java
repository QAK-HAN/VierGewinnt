package view;
import processing.core.PApplet;

    public class View extends PApplet {
        public static void main(String[] args) {
            PApplet.main(View.class);
        }
        public int width = 1080;
        public int height = 720;
        public void settings(){

            size(width, height);
        }

        public void setup() {
            background(0);
            rect((float) (width*0.2), (float) (height*0.2),0,width, height);
            System.out.print((width*0.2));
            System.out.print((height*0.2));

        }

        public void draw(){
        }

        public void keyPressed() {
            if(key=='1') {
                exit();
            }
        }


    }

