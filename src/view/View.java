package view;

import model.Coordinate;

import java.io.*;
import java.util.List;

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

    public void printResult(double distance) throws IOException {
        bw.append("두 점 사이 거리는 ");
        bw.append(distance+"");
        bw.flush();
        //closeBuffer();
    }

    public void printError(String errorMessage) throws IOException {
        bw.write(errorMessage);
        bw.flush();
    }

    private void closeBuffer() throws IOException {
        br.close();
        bw.close();
    }
}
