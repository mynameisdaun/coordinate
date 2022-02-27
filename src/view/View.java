package view;

import model.Point;

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
        bw.write("좌표를 입력하세요.\n");
        bw.flush();
        return br.readLine();
    }

    public void print(String str) throws IOException {
        bw.append(str);
        bw.flush();
    }

    public void printPlane(List<Point> pointList) throws IOException {
        for(int y=24;y>=0;y--) {
            for(int x=0;x<=24;x++) {
                Point point = new Point(x, y);
                if(pointList.contains(point)) {
                    printSpecialCharacter();
                    continue;
                }
                if(y==0) {
                    printXAxis(x);
                    continue;
                }
                if(x==0) {
                    printYAxis(y);
                    continue;
                }
                printEmptySpace();
            }
            print("\n");
        }
        printXAxisIndex();
    }

    private void printXAxisIndex() throws IOException {
        print(" 0 ");
        for(int x=1;x<=24;x++) {
            if(x%2==0) {
                print(padIntegerLeft(x, 2));
                continue;
            }
            print(padStringLeft(" ", 2));
        }
        print("\n\n");
    }

    private void printSpecialCharacter() throws IOException {
        print(padStringLeft("●", 2));
    }

    private void printEmptySpace() throws IOException {
        print(padStringLeft(" ", 2));
    }

    private void printYAxis(int i) throws IOException {
        if(i%2==0) {
            print(padStringLeft(i+"|", 3));
            return;
        }
        print(padStringLeft(" |", 3));
    }

    private void printXAxis(int j) throws IOException {
        if(j==0) {
            print(padStringLeft(" +", 3));
            return;
        }
        print("——");
        return;
    }

    public void closeBuffer() throws IOException {
        br.close();
        bw.close();
    }
}
