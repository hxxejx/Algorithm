package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 t
 * 2. 메모리크기m 프로그램코드의크기c 입력의크기i
 * 3. 프로그램
 * 4. 프로그램의입력
 * 출력
 * 1. 프로그램종료 Terminates 무한루프 Loops 어느부분이 무한 루프인지 숫자로 출력
 * 조건
 * 1. - 포인터가 가리키는 수를 1 감소 + 1 증가
 * 2. < 왼쪽 > 오른쪽 범위를 벗어나면 반대쪽으로 넘어감
 * 3. [ 포인터의 값이 0이라면 ]으로 점프
 * 4. ] 포인터의 값이 0이 아니라면 [으로 점프
 * 5. . 포인터가 가리키는 수 출력 >> 무시
 * 6. , 문자를 읽고 포인터가 가리키는 곳에 저장 입력의 마지막인 경우 255 저장
 */
public class g1_3954_인터프리터2 {
	static int Sm;
    static int Sc;
    static int Si;
    static String programCode;
    static String inputCode;
    static int pointerPos;
    static int inputPos;
    static int[] arr;
    static int[] bracket;
    static int pid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            Sm = Integer.parseInt(st.nextToken()); // 배열의 크기
            Sc = Integer.parseInt(st.nextToken()); // 명령어의 길이
            Si = Integer.parseInt(st.nextToken()); // input의 길이

            programCode = br.readLine();
            inputCode = br.readLine();

            arr = new int[Sm];
            pointerPos = 0; // 포인터가 가리키는 위치.
            inputPos = 0; // inputCode의 현재 입력받아야하는 위치.

            Stack<Integer> stack = new Stack<>();
            bracket = new int[Sc]; // 서로 연결되어있는 괄호의 위치.

            for (int i = 0; i < Sc; i++) {
                char c = programCode.charAt(i);

                if (c == '[') {
                    stack.push(i);
                } else if (c == ']') { // 닫는 괄호와 여는 괄호를 서로 연결시켜 줌.
                    int temp = stack.peek();
                    bracket[i] = temp; // 여는 괄호에는 닫는 괄호의 위치를
                    bracket[temp] = i; // 닫는 괄호에는 여는 괄호의 위치를 저장함.
                    stack.pop();
                }
            }

            pid = 0; // 특정 명령어를 읽은 위치.
            int cnt = 0; // 반복 횟수.
            while (cnt <= 50000000 && pid < Sc) {
                ++cnt;
                doStep();
            }

            if (pid == Sc) { // 해당 명령어를 모두 읽어들임.
                ans.append("Terminates\n");
            } else { // 도중에 무한루프가 발생.
                // 일단 50000000번만큼 이동한 위치를 기억해 둔 상태에서
                // 50000000번만큼 다시 명령어를 읽어 들임.
                // 그때, 최대 위치가 닫는 괄호의 위치이고
                // 최소 위치는 여는 괄호의 위치 - 1임.

                int maxpid = pid; // 닫는 괄호의 위치
                int minpid = pid; // 여는 괄호의 위치

                while (cnt-- > 0) {
                    doStep();
                    maxpid = Math.max(maxpid, pid);
                    minpid = Math.min(minpid, pid);
                }
                ans.append("Loops " + (minpid - 1) + " " + maxpid + "\n");
            }
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void doStep() {
        char c = programCode.charAt(pid);

        switch (c) {
            case '-':
                arr[pointerPos] = (arr[pointerPos] - 1) < 0 ? 255 : (arr[pointerPos] - 1);
                break;
            case '+':
                arr[pointerPos] = (arr[pointerPos] + 1) > 255 ? 0 : (arr[pointerPos] + 1);
                break;
            case '<':
                pointerPos = (pointerPos - 1) == -1 ? Sm - 1 : (pointerPos - 1);
                break;
            case '>':
                pointerPos = (pointerPos + 1) == Sm ? 0 : (pointerPos + 1);
                break;
            case '[':
                if (arr[pointerPos] == 0) {
                    pid = bracket[pid]; // 현재 위치를 닫는 괄호의 위치로 점프함.
                }
                break;
            case ']':
                if (arr[pointerPos] != 0) {
                    pid = bracket[pid]; // 현재 위치를 여는 괄호의 위치로 점프함.
                }
                break;
            case '.':
                break;
            case ',':
                arr[pointerPos] = (inputPos == Si) ? 255 : inputCode.charAt(inputPos++);
        }
        pid++;
    }
}
