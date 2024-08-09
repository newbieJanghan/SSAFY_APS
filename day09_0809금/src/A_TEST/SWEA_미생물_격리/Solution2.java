package 미생물_격리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        next: for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 박스크기
            int time = sc.nextInt(); // 시간
            int dif = sc.nextInt(); // 종류
            int sum = 0;
            int[][] arr = new int[dif][4]; // [종류][i, j, cnt, way]

            for (int i = 0; i < dif; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < 2 * N - 2; i++) {
                time--;
                for (int j = 0; j < dif; j++) {
                    if (arr[j][3] == 1) {
                        if (arr[j][0] == 0) {
                            arr[j][3] = 2;
                            arr[j][0]++;
                        } else {
                            arr[j][0]--;
                        }
                    } else if (arr[j][3] == 2) {
                        if (arr[j][0] == N - 1) {
                            arr[j][3] = 1;
                            arr[j][0]--;
                        } else {
                            arr[j][0]++;
                        }

                    } else if (arr[j][3] == 3) {
                        if (arr[j][1] == 0) {
                            arr[j][3] = 4;
                            arr[j][1]++;
                        } else {
                            arr[j][1]--;
                        }
                    } else if (arr[j][3] == 4) {
                        if (arr[j][1] == N - 1) {
                            arr[j][3] = 3;
                            arr[j][1]--;
                        } else {
                            arr[j][1]++;
                        }

                    }
                    if (arr[j][0] == 0 || arr[j][0] == N - 1 || arr[j][1] == 0 || arr[j][1] == N - 1) {
                        arr[j][2] /= 2;
                    }
                }

                for (int j = 0; j < dif; j++) {
                    if (arr[j][2] == 0)
                        continue;
                    List<Integer> list = new ArrayList<>();
                    int a = arr[j][0];
                    int b = arr[j][1];
                    list.add(j);
                    for (int k = j + 1; k < dif; k++) {
                        if (arr[k][2] == 0)
                            continue;
                        if (arr[k][0] == a && arr[k][1] == b) {
                            list.add(k);
                        }
                    }
                    int maxIdx = j;
                    for (int k = 0; k < list.size(); k++) {
                        if (arr[list.get(k)][2] > arr[maxIdx][2])
                            maxIdx = list.get(k);
                    }
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k) != maxIdx) {
                            arr[maxIdx][2] += arr[list.get(k)][2];
                            arr[list.get(k)][2] = 0;
                        }
                    }

                }
                if (time == 0) {
                    for (int j = 0; j < dif; j++) {
                        sum += arr[j][2];
                    }
                    System.out.println("#" + tc + " " + sum);
                    continue next;
                }
            }
            int dieCnt = time / (N - 1);
            for (int i = 0; i < dieCnt; i++) {
                for (int j = 0; j < dif; j++) {
                    arr[j][2] /= 2;
                }
            }

            time = time % (N - 1);
            for (int i = 0; i < time; i++) {
                for (int j = 0; j < dif; j++) {
                    if (arr[j][3] == 1) {
                        if (arr[j][0] == 0) {
                            arr[j][3] = 2;
                            arr[j][0]++;
                        } else {
                            arr[j][0]--;
                        }
                    } else if (arr[j][3] == 2) {
                        if (arr[j][0] == N - 1) {
                            arr[j][3] = 1;
                            arr[j][0]--;
                        } else {
                            arr[j][0]++;
                        }

                    } else if (arr[j][3] == 3) {
                        if (arr[j][1] == 0) {
                            arr[j][3] = 4;
                            arr[j][1]++;
                        } else {
                            arr[j][1]--;
                        }
                    } else if (arr[j][3] == 4) {
                        if (arr[j][1] == N - 1) {
                            arr[j][3] = 3;
                            arr[j][1]--;
                        } else {
                            arr[j][1]++;
                        }

                    }
                    if (arr[j][0] == 0 || arr[j][0] == N - 1 || arr[j][1] == 0 || arr[j][1] == N - 1) {
                        arr[j][2] /= 2;
                    }
                }

            }

            for (int j = 0; j < dif; j++) {
                sum += arr[j][2];
            }
            System.out.println("#" + tc + " " + sum);

        }
    }

}
