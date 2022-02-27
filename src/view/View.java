package view;

import model.Coordinate;

import java.io.*;
import java.util.List;

import static util.Util.padIntegerLeft;
import static util.Util.padStringLeft;

public class View {

    private final BufferedWriter bw;
    private final BufferedReader br;

    public View(BufferedWriter bw, BufferedReader br) {
        this.bw = bw;
        this.br = br;
    }

    public String getUserInput() throws IOException {
        String userInput = "";
        bw.write("좌표를 입력하세요.\n");
        bw.flush();
        userInput = br.readLine();
        //closeBuffer();
        return userInput;
    }

    public void print(String str) throws IOException {
        bw.append(str);
        bw.flush();
    }

    public void printPlane(List<Coordinate> coordinateList) throws IOException {
        for(int i=24 ; i>=0 ; i--) {
            for(int j=0 ; j<=24 ; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                if(i==0) {
                    if(j==0) {
                        print("  + ");
                        continue;
                    }
                    System.out.print("——");
                    continue;
                }
                if(j==0&&i>0) {
                    if(i%2==0) {
                        print(padIntegerLeft(i, 2));
                    }else {
                        print(padStringLeft(" ", 2));
                    }
                    print("|");
                }
                if(coordinateList.contains(coordinate)) {
                    print(padStringLeft("★", 2));
                }else {
                    print(padStringLeft(" ", 2));
                }
            }
            print("\n");
        }
        for(int i = 0 ; i <= 24 ; i ++) {
            if(i==0) {
                print(" 0  ");
            }
            else if(i%2==0) {
                print(padIntegerLeft(i, 2));
            }else {
                print(padStringLeft(" ", 2));
            }
        }
    }

    public void closeBuffer() throws IOException {
        br.close();
        bw.close();
    }
}
