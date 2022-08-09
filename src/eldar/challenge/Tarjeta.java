package eldar.challenge;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Tarjeta {
    private String marca;
    private String cardholder;
    private String numTarjeta;
    private String fechaVenc;
    private int mesVenc;
    private int añoVenc;
    

    //Constructor

    public Tarjeta(String marca, String cardholder, String numTarjeta, int mesVenc, int añoVenc) {
        this.marca = marca;
        this.cardholder = cardholder;
        this.numTarjeta = numTarjeta;
        while (mesVenc > 12 || mesVenc < 0) {            
            mesVenc = Integer.parseInt(JOptionPane.showInputDialog("El numero de mes ingresado no es compatible intente nuevamente"));
        }
        this.mesVenc = mesVenc;
        this.añoVenc = añoVenc;
        this.fechaVenc = mesVenc + "/" + añoVenc;
    }
    
    
    //Getters

    public String getMarca() {
        return marca;
    }

    public String getCardholder() {
        return cardholder;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public int getMesVenc() {
        return mesVenc;
    }

    public int getAñoVenc() {
        return añoVenc;
    }

    public String getFechaVenc() {
        return fechaVenc;
    }
    
    
    
    //Setters

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setMesVenc(int mesVenc) {
        this.mesVenc = mesVenc;
    }

    public void setAñoVenc(int añoVenc) {
        this.añoVenc = añoVenc;
    }

    public void setFechaVenc(String fechaVenc) {
        this.fechaVenc = fechaVenc;
    }
    
    

    //Metodos
    public String obtenerDatos(){
        String datos = "Nombre: " + getCardholder() +
                "\nMarca: " + getMarca() +
                "\nNumero: " + getNumTarjeta() +
                "\nFecha de Vencimiento: " + getFechaVenc();
        
        return datos;
    }
    
    
    public String validarTransaccion(int monto){
        if(monto < 1000){
            return "La transaccion es valida";
        }else if(monto < 0){
            return "El monto no puede ser menor a 0";
        }else{
            return "La transaccion no es valida segun el monto ingresado";
        }
    }
    
    
    public String validarVencimiento(){
        Calendar cal= Calendar.getInstance();
        int añoAct = cal.get(Calendar.YEAR) % 100;
        int mesAct = cal.get(Calendar.MONTH) + 1;
                
        if(this.añoVenc >= añoAct && this.mesVenc >= mesAct){
            return "El vencimiento es valido";
        }else{
            return "La tarjeta esta vencida";
        } 
    }
    
    
    public String compararTarjetas(Tarjeta tar2){
        String comparacion;
        
        if(this.getMarca().equals(tar2.getMarca())){
            comparacion = "La marca es igual en ambas tarjetas";
        }else{
            comparacion = "La marca es distinta";
        }
        
        if(this.getCardholder().equals(tar2.getCardholder())){
            comparacion = comparacion + "\nEl nombre es igual en ambas tarjetas";
        }else{
            comparacion = comparacion + "\nEl nombre es distinto";
        }
        
        if(this.getNumTarjeta().equals(tar2.getNumTarjeta())){
            comparacion = comparacion + "\nEl numero es igual en ambas tarjetas";
        }else{
            comparacion = comparacion +"\nEl numero es distinto";
        }
        
        if(this.getFechaVenc().equals(tar2.getFechaVenc())){
            comparacion = comparacion + "\nLa fecha de vencimiento es igual en ambas tarjetas";
        }else{
            comparacion = comparacion + "\nLa fecha de vencimiento es distinta";
        }
        
        return  comparacion;
    }
    
    
    public String calcularTasa(){
        double tasa = 0;
        
        Calendar cal= Calendar.getInstance();
        int añoAct = cal.get(Calendar.YEAR) % 100;
        int mesAct = cal.get(Calendar.MONTH) + 1;
        int diaAct = cal.get(Calendar.DAY_OF_MONTH);
        
        if("visa".equals(this.marca)){
            tasa = (double) añoAct/mesAct;
        }else if("nara".equals(this.marca)){
            tasa = (double) diaAct * 0.5;
        }else if("amex".equals(this.marca)){
            tasa = (double) mesAct * 0.1;
        }
        
        if(0.3 <= tasa && tasa <= 5){
            return "La tasa por el servicio en tarjetas " + this.marca + " es de " + tasa + "%";
        }else{
            return "La marca indicada en la tarjeta no es valida";
        }
    }
    
    
    
    public static void main(String[] args) {
        Tarjeta tarjeta1 = new Tarjeta("visa", "Omar Gongora", "1234 1234 1234 1234",2 , 22);
        Tarjeta tarjeta2 = new Tarjeta("nara", "Pepe gomez", "5353 1235 5435 9128",9 , 21);
        Tarjeta tarjeta3 = new Tarjeta("amex", "susana calventos", "1234 1234 1234 1234", 1, 24);
        
        System.out.println(tarjeta1.obtenerDatos());
        
        System.out.println(tarjeta1.validarTransaccion(10000));
    
        System.out.println(tarjeta2.validarVencimiento());
    
        System.out.println(tarjeta3.compararTarjetas(tarjeta1));
        
        System.out.println(tarjeta3.calcularTasa());
        
        
    }
    
    
}
