package naum.asafov.com.romantoint;

public class Main {
    public static void main(String[] args) {
        int num = 1994;
        String answer = intToRoman(num);
        System.out.println(answer);
    }

    private static String intToRoman(int num){
        if (num==0 || num>=4000){
            return null;
        }

        int[] numbers;

        numbers = splitNumbers(num);
        for (int i=numbers.length-1; i>=0;i--){
            if (numbers[i]!=0){
                System.out.println(numbers[i]);
            }
        }

        StringBuilder str = new StringBuilder();
        int x = 0;
        int y = 0;
        for (int i=numbers.length-1; i>=0;i--){
            x = numbers[i];
            if (numbers[i]!=0){
                if (x > 99 && x <1000){
                    if (x==100){
                        str.append("C");
                    }else if (x==500){
                        str.append("D");
                    }else if (x==400){
                        str.append("CD");
                    }else if (x==900){
                        str.append("CM");
                    }else if (x<400){
                        y = x/100;
                        while (y!=0){
                            str.append("C");
                            y--;
                        }
                    }else if (x>500){
                        y = x/100;
                        y = y - 5;
                        str.append("D");
                        while (y!=0){
                            str.append("C");
                            y--;
                        }
                    }
                }else if (x >999 && x<4000){
                    y = x/1000;
                    while (y!=0){
                        str.append("M");
                        y--;
                    }
                }else if (x>9 && x<100){
                    if (x==10){
                        str.append("X");
                    }else if (x==40){
                        str.append("XL");
                    }else if (x==50){
                        str.append("L");
                    }else if (x==90){
                        str.append("XC");
                    }else if (x<40){
                        y = x/10;
                        while (y!=0){
                            str.append("X");
                            y--;
                        }
                    }else if (x>50){
                        y = x/10;
                        y = y - 5;
                        str.append("L");
                        while (y!=0){
                            str.append("X");
                            y--;
                        }
                    }
                }else if (x>0 && x<10){
                    if (x==4){
                        str.append("IV");
                    }else if (x==5){
                        str.append("V");
                    }else if (x==9){
                        str.append("IX");
                    }else if (x<4){
                        y = x;
                        while (y!=0){
                            str.append("I");
                            y--;
                        }
                    }else if (x>5){
                        y = x;
                        y = y - 5;
                        str.append("V");
                        while (y!=0){
                            str.append("I");
                            y--;
                        }
                    }
                }
            }
        }
        return str.toString();
    }

    private static int[] splitNumbers(int num){
        int i = 0;
        int y = 1;
        int[] numbers = new int[4];

        while (num!=0){
            int x = num%10;
            x = x*y;
            numbers[i] = x;
            num = num/10;
            i++;
            y = y * 10;
        }

        return numbers;
    }
}
