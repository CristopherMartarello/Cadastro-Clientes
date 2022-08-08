
package trabalho_final_funções;

import java.util.Scanner;


public class Trabalho_final_funções {
    static Scanner input = new Scanner(System.in);
    
    
    public static void menu(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("I - Incluir Cliente");
        System.out.println("C - Consultar Cliente");
        System.out.println("A - Alterar Cliente");
        System.out.println("L - Lista Cliente");
        System.out.println("S - Sair");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public static String selecionarOpcao(){
        String opcao;
        String opcaoUpper;
        System.out.print("Escolha uma opção -> ");
        opcao = input.nextLine();
        opcaoUpper = opcao.toUpperCase();
        
        switch (opcaoUpper) {
            case "I":
                System.out.println("Você escolheu incluir clientes...");
                break;
            case "C":
                System.out.println("Você escolheu consultar clientes...");
                break;
            case "A":
                System.out.println("Você escolheu alterar clientes...");
                break;
            case "E":
                System.out.println("Você escolheu exlcuir clientes...");
                break;
            case "L":
                System.out.println("Você escolheu listar clientes...");
                break;
            case "S":
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha uma opção válida!");
        }
        
        return opcaoUpper;
    }
    
    public static void incluirClientes(String[] nome, String[] cpf, String[] data, int i){   
        System.out.print("Digite o nome do cliente ["+i+"]: ");
        nome[i] = input.nextLine();
        System.out.print("Digite o cpf do usuário ["+i+"]: ");
        cpf[i] = input.nextLine();
        System.out.print("Digite a data de nascimento do usuário ["+i+"]: ");
        data[i] = input.nextLine();
           
    }
    
    public static void consultarClientes(String[] nome ,String[] cpf, String[] data, int i){
        String cpfConsulta = "";
        int contInvalido = 0;
        System.out.print("Digite o CPF da pessoa a ser consultada: ");
        cpfConsulta = input.nextLine();
        
        for(i = 0; i < cpf.length; i++) {
            if(cpfConsulta.equalsIgnoreCase(cpf[i])){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Nome: " + nome[i]);
                System.out.println("Data de Nascimento: " + data[i]);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                break;
            }else{
                contInvalido++;
            }
        }
        
        if(contInvalido == cpf.length){
            System.out.println("Usuario inexistente!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    
    public static void excluirClientes(String[] nome, String[] cpf, String[] data, int i){
        String cpfConsulta = "";
        System.out.println("Digite o CPF do cliente a ser excluido: ");
        cpfConsulta = input.nextLine();
        
        for(i = 0; i < cpf.length; i++) {
            if(cpfConsulta.equalsIgnoreCase(cpf[i])){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Nome: " + nome[i]);
                System.out.println("Data de Nascimento: " + data[i]);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                break;
            }
        }
        System.out.println("Você deseja excluir o cliente? (sim/nao)");
        String escolha = input.nextLine();
        if(escolha.equalsIgnoreCase("sim")){
            System.out.println("Exluindo cliente...");
            for(i = 0; i < cpf.length; i++){
                if(cpfConsulta.equalsIgnoreCase(cpf[i])){
                nome[i] = null;
                data[i] = null;
                cpf[i] = null;
                break;
                }
            }
        }else{
            System.out.println("Exclusao cancelada.");
        }
        
        for(int j = 0; j < 10; j++) {
            if(nome [i] == null){
                nome[i] = nome [i+1];
                nome[i+1] = null;
                data[i] = data[i+1];
                data[i+1] = null;
                cpf[i] = cpf[i+1];
                cpf[i+1] = null;
            }
        }
    }
    
    public static void listarClientes(String[] nome, String[] cpf, String[] data, int i){
        for(i = 0; i < cpf.length; i++){
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println(i + " Nome: " + nome[i]);
            System.out.println(" Data de nascimento: " + data[i]);
            System.out.println(" CPF: " + cpf[i]);
            System.out.println("~~~~~~~~~~~~~~~~~~~");
        }
    }
    
    public static void main(String[] args){
        menu();
        String opcao = selecionarOpcao();
        int i = 0;
        String[] nome = new String[5];
        String[] cpf = new String[5];
        String[] data = new String[5];
        
        while(!(opcao.equalsIgnoreCase("S"))){
            if(opcao.equalsIgnoreCase("I")){
                incluirClientes(nome, cpf, data, i);
                i++;
            }else if(opcao.equalsIgnoreCase("C")){
                consultarClientes(nome, cpf, data, i);
            }else if(opcao.equalsIgnoreCase("E")){
                excluirClientes(nome, cpf, data, i);
            }else if(opcao.equalsIgnoreCase("L")){
                listarClientes(nome, cpf, data, i);
            }
            opcao = selecionarOpcao();
        }
    }  
}
