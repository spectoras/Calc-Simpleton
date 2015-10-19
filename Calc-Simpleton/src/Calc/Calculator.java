/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KuroiTenshi
 */
public class Calculator {
    Scanner sc = new Scanner(System.in);
    List<Integer> x = new ArrayList();
    private static List<ExecutableCommand> execCommands = new ArrayList();
    
    public void openCalculator() {
        boolean flag = true;
        String inputId = "+";
        System.out.println("Give the numbers, type ; to chooce function");
        do {
            String y = sc.next();
            if (y.equals(";")) {
                flag = false;
            } else {
                if (isInt(y)){
                    x.add(Integer.parseInt(y));                    
                }else{
                    System.out.println("give an integer");
                }
            }
        }while(flag);
        
        flag = true;
        do {
            System.out.println("Give an operator (+,-,*,/");
            String y = sc.next();
            if (y.equals("+") || y.equals("-") || y.equals("*") || y.equals("/")) {
                inputId = y;
                flag = false;
            }            
        }while(flag);
        
        flag = true;
        for(ExecutableCommand vLookUp:execCommands) {
            if (vLookUp.identifier().equals(inputId)){
                flag = vLookUp.execCommand(x);
            }            
        }
        
        if(flag = true) {
            System.out.println("an error occured. command not found");
        }
    }
    
    private boolean isInt(String str){
        int i = 0;
        int tempnum = 0;

        while( i < str.length()) {
            tempnum = str.charAt(i++) - '0';
            if (tempnum > 9) {
                return false;
            }
        }

        return true;
    }
    
    public static void registerCommand(ExecutableCommand newCommand) {
        execCommands.add(newCommand);
    }
}
